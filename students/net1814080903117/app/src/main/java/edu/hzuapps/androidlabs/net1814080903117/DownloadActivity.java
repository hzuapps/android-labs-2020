package edu.hzuapps.androidlabs.net1814080903117;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.FutureTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DownloadActivity extends AppCompatActivity {

    private Button btnOpen1;
    private Button downloadbtn;
    private EditText downText;
    private Handler handler;
    private List<String> filenameList;
    private String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        permissionFile();
        setContentView(R.layout.activity_download);

        btnOpen1 = findViewById(R.id.main_btn);
        downloadbtn = findViewById(R.id.down_btn);
        downText = findViewById(R.id.downloadText);
        setListener();

        Drawable drawable = getResources().getDrawable(R.drawable.download);
        drawable.setBounds(0,0,200,200);
        TextView textview = findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);

    }

    private void setListener(){
        DownloadActivity.OnClick onClick = new DownloadActivity.OnClick();
        btnOpen1.setOnClickListener(onClick);
        downloadbtn.setOnClickListener(onClick);
        downText.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.main_btn:
                    intent = new Intent(DownloadActivity.this, Net1814080903117Activity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.down_btn:
                    filename = downText.getText().toString();
                    File file = downloadFile(filename);
                    showMessage(file!=null?"下载成功":"下载失败");
                    break;
                case R.id.downloadText:
                    getFilesName();
                    break;
            }
        }

    }


    public File downloadFile(String filename){

        OkHttpClient okHttpClient = new OkHttpClient();

        if(filename==null||filename.isEmpty()){
            return null;
        }

        RequestBody body = new MultipartBody.Builder().addFormDataPart("filename",filename).build();

        FutureTask<File> task = new FutureTask<File>(()->{
            ResponseBody responseBody = okHttpClient.newCall(
                    new Request.Builder().post(body).url("http://10.0.2.2:8080/download").build()).execute().body();
            if(responseBody != null){
                if(getExternalFilesDir(null)!=null){
                    String filePath = getExternalFilesDir(null).toString();
                    File file = new File(getExternalFilesDir(null).toString()+"/"+filename);
                    try (
                            InputStream inputStream = responseBody.byteStream();
                            FileOutputStream outputStream = new FileOutputStream(file)
                    ){
                        byte[] b = new byte[1024];
                        int length;
                        if((length = inputStream.read(b))!=-1){
                            outputStream.write(b,0,length);
                            while( (length=inputStream.read(b)) != -1 ){
                                outputStream.write(b,0,length);
                            }
                            return file;
                        }else{
                            file.delete();
                            return null;
                        }
                    }
                }

            }
            return null;
        });
        try {
            new Thread(task).start();
            return task.get();
        }catch (Exception e) {
            return null;
        }
    }

    public void getFilesName(){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://10.0.2.2:8080/getFilesName").build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (response.isSuccessful()){
                    String str = response.body().string();
                    List<String> list = JSONObject.parseArray(str,String.class);
                    Message msg = new Message();
                    msg.obj = list;
                    handler.sendMessage(msg);
                }
            }
        });

        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                filenameList = (List<String>) msg.obj;
                showListPopulWindow();

            }
        };

    }

    private void showListPopulWindow() {
        String[] list = filenameList.toArray(new String[filenameList.size()]);
        final ListPopupWindow listPopupWindow;
        listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list));//用android内置布局，或设计自己的样式
        listPopupWindow.setAnchorView(downText);//以哪个控件为基准，在该处以mEditText为基准
        listPopupWindow.setModal(true);

        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {//设置项点击监听
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                downText.setText(list[i]);//把选择的选项内容展示在EditText上
                listPopupWindow.dismiss();//如果已经选择了，隐藏起来
            }
        });
        listPopupWindow.show();//把ListPopWindow展示出来
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