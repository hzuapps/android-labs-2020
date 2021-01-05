package edu.hzuapps.androidlabs.sec1814080911219;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;



public class Sec1814080911219Activity extends AppCompatActivity {
    final Activity thisActivity=this;
    static final String ID = "id";
    TextView tv;
    public static String path="1";//文件路径
    Socket client;
    DataInputStream in;
    DataOutputStream out;
    String massage=null;
    private Handler handler = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        verifyStoragePermissions(this);//动态申请存储权限
        Button button1=(Button)findViewById(R.id.button_cipherupload);
        Button button2=(Button)findViewById(R.id.button_showfilelist);
        //页面跳转
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(thisActivity,ShowfilelistActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        //调用系统文件管理器
        Button btn = (Button) findViewById(R.id.select_file);
        tv = (TextView) findViewById(R.id.tv);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);
            }
        });
        //设置用户名
        Button log_button=(Button) findViewById(R.id.login);
        final EditText log_name=(EditText) findViewById(R.id.login_name);
        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=log_name.getText().toString();
                setting_loginname(username);
                log_name.setText(null);
            }
        });
        //密文上传
        Button cipher_load=(Button) findViewById(R.id.button_cipherupload);
        cipher_load.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(path.equals("1"))
                {
                    AlertDialog alertDialog1 = new AlertDialog.Builder(thisActivity)
                            .setTitle("警告")//标题
                            .setMessage("请选择文件！")//内容
                            .create();
                    alertDialog1.show();
                }
                else{
                    Intent intent=new Intent(thisActivity,CipheruploadActivity.class);
                    thisActivity.startActivity(intent);
                    cipherupload_log(path);
                    Filepath.path=path;
                    path="1";

                }
            }
        });
    }
    //调用系统文件管理器各函数
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                path = uri.getPath();
                tv.setText(path);
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
                return;
            }
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                path = getPath(this, uri);
                tv.setText(path);
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
            } else {
                path = getRealPathFromURI(uri);
                tv.setText(path);
                Toast.makeText(Sec1814080911219Activity.this, path, Toast.LENGTH_SHORT).show();
            }
        }
    }
    public String getRealPathFromURI(Uri contentUri) {
        String res = null;
        String[] proj = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if(null!=cursor&&cursor.moveToFirst()){;
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
            cursor.close();
        }
        return res;
    }
    @SuppressLint("NewApi")
    public String getPath(final Context context, final Uri uri) {
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            }
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }
    public String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }
    public boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }
    public boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }
    public boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
    //动态申请系统存储空间权限
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            "android.permission.READ_EXTERNAL_STORAGE",
            "android.permission.WRITE_EXTERNAL_STORAGE" };
    public static void verifyStoragePermissions(Activity activity) {
        try {
            int permission = ActivityCompat.checkSelfPermission(activity,
                    "android.permission.WRITE_EXTERNAL_STORAGE");
            if (permission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(activity, PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //设置偏好-实现登陆用户名
    public void setting_loginname(String username){
        SharedPreferences settings = thisActivity.getSharedPreferences("Username",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(ID,username);
        editor.commit();
    }
    //获取偏好设置中的用户名
    public String getusername(){
        SharedPreferences settings = thisActivity.getSharedPreferences("Username",Context.MODE_PRIVATE);
        String user=settings.getString(ID,"");
        return user;
    }
    //获取系统时间
    public String getsystime(){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date=sDateFormat.format(new java.util.Date());;
        return date;
    }
    //编写日志文件
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void log(String date, String username, String log_path, String log_kind){
        File file=new File("/storage/emulated/0/",log_kind);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileInputStream fileInputStream=new FileInputStream(file);
            StringBuilder stringBuilder = new StringBuilder();
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            String result = stringBuilder.toString();//读上次记录的内容
            FileOutputStream fileOutputStream=new FileOutputStream(file);//获取文件的字符流
            fileOutputStream.write((result+date+" "+username+" "+log_path).getBytes());//将输入框内容写入文件
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //加密上传文件的日志文件
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void cipherupload_log(String log_path){
        String date=getsystime();//获取系统时间
        String username=getusername();
        if(username.equals(null)){
            Toast toast=Toast.makeText(thisActivity,"请输入登陆名",Toast.LENGTH_SHORT);
            toast.show();
        }
        else {
            log(date,username,log_path,"cipherupload_log.txt");
        }
    }

}