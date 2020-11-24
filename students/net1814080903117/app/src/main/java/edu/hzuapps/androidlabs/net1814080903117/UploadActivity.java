package edu.hzuapps.androidlabs.net1814080903117;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.FutureTask;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class UploadActivity extends AppCompatActivity  {

    private Button btnOpen;
    private Button uploadbtn;
    private TextView uploadfile;
    private String path;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        permissionFile();
        setContentView(R.layout.activity_upload);

        btnOpen = findViewById(R.id.main_btn);
        uploadbtn = findViewById(R.id.up_btn);
        uploadfile = findViewById(R.id.uploadText);
        setListener();


        Drawable drawable = getResources().getDrawable(R.drawable.upload);
        drawable.setBounds(0,0,200,200);
        TextView textview = findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }


    private void setListener(){
        OnClick onClick = new OnClick();
        btnOpen.setOnClickListener(onClick);
        uploadbtn.setOnClickListener(onClick);
        uploadfile.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.main_btn:
                    intent = new Intent(UploadActivity.this, Net1814080903117Activity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.up_btn:
                    boolean b = uploadFile(path,file.getName());
                    showMessage(b?"上传成功":"上传失败");
                    break;
                case R.id.uploadText:
                    //打开文件管理器选择文件
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                    //设置你要打开文件的类型
                    intent.setType("*/*");
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    startActivityForResult(intent,1);
                    break;
            }
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();

            //兼容各个版本获取文件路径
            if ("file".equalsIgnoreCase(uri.getScheme())) {   //使用第三方打开
                path = uri.getPath();
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(this, path, Toast.LENGTH_SHORT).show();
                return;
            }

            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.KITKAT) { //4.4以上版本
                uri.getScheme();
                path = getPath(this,uri);
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(this, path , Toast.LENGTH_SHORT).show();
            }else{                                                  //4.4以下版本
                path = getRealPathFromURI(uri);
                file = new File(path);
                uploadfile.setText(file.getName());
                Toast.makeText(UploadActivity.this,path,Toast.LENGTH_SHORT).show();
            }
        }
    }

    public String getRealPathFromURI(Uri contentUri){
        String res = null;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri,proj,null,null,null);
        if(null!=cursor&&cursor.moveToFirst()){
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            res = cursor.getString(column_index);
            cursor.close();
        }
        return res;
    }

    /*
     * @SuppressLint("NewApi")  屏蔽新API才能使用的方法报的错误
     * 解析获取路径
     * */
    @SuppressLint("NewApi")
    public String getPath(final Context context, final Uri uri){

        final boolean isKitKat = Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT;

        //DocumentProvider
        if(isKitKat && DocumentsContract.isDocumentUri(context,uri)){
            //ExternalStorageProvider
            if(isExternalStorageDocument(uri)){
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split =docId.split(":");
                final String type = split[0];

                if("primary".equalsIgnoreCase(type)){
                    return Environment.getExternalStorageDirectory()+"/"+split[1];
                }
            }

            //DownloadsProvider
            else if (isDownloadsDocument(uri)){

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"),Long.valueOf(id));
                return getDataColumn(context,contentUri,null,null);
            }

            //MediaProvider
            else if(isMediaDocument(uri)){

                final String docId = DocumentsContract.getDocumentId(uri);
                final String [] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if("image".equals(type)){
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                }else if("video".equals(type)){
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                }else if("audio".equals(type)){
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};

                return getDataColumn(context,contentUri,selection,selectionArgs);
            }
        }

        //MediaStore(and general)
        else if("content".equalsIgnoreCase(uri.getScheme())){
            return getDataColumn(context,uri,null,null);
        }

        //File
        else if("file".equalsIgnoreCase(uri.getScheme())){
            return uri.getPath();
        }

        return null;

    }


    public String getDataColumn(Context context,Uri uri,String selection,String[] selectionArgs){

        Cursor cursor = null;
        final String column = "_data";
        final String [] projection = {column};

        try {
            cursor = context.getContentResolver().query(uri,projection,selection,selectionArgs,null);
            if(cursor!=null&&cursor.moveToFirst()){
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        }finally {
            if(cursor!=null){
                cursor.close();
            }
        }
        return null;

    }


    public boolean isExternalStorageDocument(Uri uri){
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public boolean isDownloadsDocument(Uri uri){
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public boolean isMediaDocument(Uri uri){
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public boolean uploadFile(String path,String filename){
        File uploadfile = new File(path);
        if(path.isEmpty()||!uploadfile.exists())
            return false;
        try {
            InputStream inputStream = new FileInputStream(uploadfile);

            if(getExternalFilesDir(null)!=null){
                String filePath = getExternalFilesDir(null).toString();
                File downloadfile = new File(getExternalFilesDir(null).toString()+"/"+filename);
                FileOutputStream outputStream = new FileOutputStream(downloadfile);
                byte[] b = new byte[1024];
                int length;
                if((length = inputStream.read(b))!=-1){
                    outputStream.write(b,0,length);
                    while( (length=inputStream.read(b)) != -1 ){
                        outputStream.write(b,0,length);
                    }
                }else{
                    file.delete();
                }

            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void showMessage(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    //申请权限
    private void permissionFile(){
        String[] permission = new String[]{
                "android.permission.READ_EXTERNAL_STORAGE",
                "android.permission.WRITE_EXTERNAL_STORAGE"
        }; //申请所需要的权限

        if(ActivityCompat.checkSelfPermission(this,permission[0])!= PackageManager.PERMISSION_GRANTED
                ||
                ActivityCompat.checkSelfPermission(this,permission[1])!=PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this,permission,1);   //申请权限
        }
    }
}