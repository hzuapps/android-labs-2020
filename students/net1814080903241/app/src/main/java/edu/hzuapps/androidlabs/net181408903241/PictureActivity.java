package edu.hzuapps.androidlabs.net181408903241;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


class PictureActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int DOWNLOAD_CODE = 10001;
    public static final int DOWNLOAD_FAIL = 300;
    public static final int CONNECT_TIMEOUT = 2000;
    private ImageView image_download;
    private Button btn_download;

    private Handler handler;

    private String path="https://img2.mukewang.com/5adfee7f0001cbb906000338-240-135.jpg";

    private int fileLength;

    private Bitmap mBitmap;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initialView();

        btn_download.setOnClickListener(this);

        //接收子线程的消息
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what){
                    case DOWNLOAD_CODE:
                        /*
                         * 更新UI
                         * 提取消息中的bitmap,并设置ImageView
                         * */
                        Bitmap bitmap=(Bitmap) msg.obj;
                        if (bitmap!=null){
                            image_download.setImageBitmap(bitmap);//disPlay image
                        }
                        break;
                    case DOWNLOAD_FAIL:
                        Toast.makeText(PictureActivity.this,"下载失败",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };

    }

    //初始化控件
    public void initialView(){
        btn_download=findViewById(R.id.btn_download);
        image_download=findViewById(R.id.image_download);
    }

    //按钮点击
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_download:
                //开启线程
                new Thread(new GetPictThread(handler,path)).start();
                break;
        }
    }


    //自定义GetPictThread类实现Runnable类
    public class GetPictThread implements Runnable{
        //定义handler和path
        public Handler handler;
        public String path;

        //带参构造
        public GetPictThread(Handler handler, String path) {
            this.handler = handler;
            this.path = path;
        }

        //在run方法中实现图片下载
        @Override
        public void run() {
            //通过Get方法请求获取网络图片
            try {
                URL url=new URL(path);
                HttpURLConnection connection=(HttpURLConnection) url.openConnection();

                //设置请求方式
                connection.setRequestMethod("GET");
                //设置超时时间
                connection.setConnectTimeout(30*1000);
                //发起连接
                connection.connect();

                //获取状态码
                int requestCode=connection.getResponseCode();
                System.out.println(requestCode);

                if (requestCode==HttpURLConnection.HTTP_OK){
                    /*
                     * 1.获得文件长度
                     * 2.通过缓冲输入流
                     * 3.将输入流转换成字节数组
                     * 4.将字节数组转换成位图
                     * */
                    fileLength=connection.getContentLength();

                    InputStream is=new BufferedInputStream(connection.getInputStream());

                    //获取到字节数组
                    byte[] arr=streamToArr(is);

                    //将字节数组转换成位图
                    mBitmap= BitmapFactory.decodeByteArray(arr,0,arr.length);
                    SavaImage(mBitmap, getExternalFilesDir(null).toString()+"/Test");
                    Log.d("Saveimage", "run: " +getExternalFilesDir(null).toString()+"/Test");
                    //Toast.makeText(getBaseContext(), "图片保存", Toast.LENGTH_SHORT).show();

                    /*
                     * 下载完成后将消息发送出去
                     * 通知主线程，更新UI
                     * */
                    Message message=Message.obtain();
                    message.what=DOWNLOAD_CODE;
                    message.obj=mBitmap;
                    handler.sendMessage(message);

                }else {
                    Log.e("TAG", "run:error "+requestCode);
                }
            }catch (MalformedURLException e){
                e.printStackTrace();
                handler.sendEmptyMessage(DOWNLOAD_FAIL);
            }catch (IOException e){
                e.printStackTrace();
                handler.sendEmptyMessage(DOWNLOAD_FAIL);
            }
        }
    }

    //将输入流转换成字节数组
    public byte[] streamToArr(InputStream inputStream){

        try {
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            byte[] buffer=new byte[1024];
            int len;

            while ((len=inputStream.read(buffer))!=-1){
                baos.write(buffer,0,len);
            }

            //关闭输出流
            baos.close();
            //关闭输入流
            inputStream.close();
            //返回字节数组
            return baos.toByteArray();
        }catch (IOException e){
            e.printStackTrace();
            //若失败，则返回空
            return null;
        }
    }

    /**
     * 保存位图到本地
     * @param bitmap
     * @param path 本地路径
     * @return void
     */
    public void SavaImage(Bitmap bitmap, String path){
        File file=new File(path);
        FileOutputStream fileOutputStream=null;
        //文件夹不存在，则创建它
        if(!file.exists()){
            file.mkdir();
        }
        try {
            fileOutputStream=new FileOutputStream(path+"/"+System.currentTimeMillis()+".png");
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fileOutputStream);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

