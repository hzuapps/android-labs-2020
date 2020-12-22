package edu.hzuapps.androidlabs.sec1814080911106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpPictureActivity extends AppCompatActivity {
    private final static String TAG = "IcsTestActivity";
    private final static String ALBUM_PATH
            = Environment.getExternalStorageDirectory() + "/download/";
    private ImageView mImageView;
    private Button mBtnSave;
    private ProgressDialog mSaveDialog = null;
    private Bitmap mBitmap;
    private String mFileName;
    private String mSaveMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_picture);
        checkNeedPermissions();

        mImageView = (ImageView)findViewById(R.id.imgSource);
        mBtnSave = (Button)findViewById(R.id.btnSave);

        new Thread(connectNet).start();

        // 下载图片
        mBtnSave.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                mSaveDialog = ProgressDialog.show(httpPictureActivity.this, "保存图片", "图片正在保存中，请稍等...", true);
                new Thread(saveFileRunnable).start();
            }
        });
    }


    //从服务器获取图片
    public byte[] getImage(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream inStream = conn.getInputStream();
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            return readStream(inStream);
        }
        return null;
    }

    public InputStream getImageStream(String path) throws Exception{
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
            return conn.getInputStream();
        }
        return null;
    }

    public static byte[] readStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1){
            outStream.write(buffer, 0, len);
        }
        outStream.close();
        inStream.close();
        return outStream.toByteArray();
    }

//保存图片
    public void saveFile(Bitmap bm, String fileName) throws IOException {
        File dirFile = new File(ALBUM_PATH);
        if(!dirFile.exists()){
            dirFile.mkdir();
        }
        File myCaptureFile = new File(ALBUM_PATH + fileName);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
    }

    private Runnable saveFileRunnable = new Runnable(){
        @Override
        public void run() {
            try {
                saveFile(mBitmap, mFileName);
                mSaveMessage = "图片保存成功！";
            } catch (IOException e) {
                mSaveMessage = "图片保存失败！";
                e.printStackTrace();
            }
            messageHandler.sendMessage(messageHandler.obtainMessage());
        }

    };

    private Handler messageHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            mSaveDialog.dismiss();
            Log.d(TAG, mSaveMessage);
            Toast.makeText(httpPictureActivity.this, mSaveMessage, Toast.LENGTH_SHORT).show();
        }
    };

//在子线程中连接到网络
    private Runnable connectNet = new Runnable(){
        @Override
        public void run() {
            try {
                String filePath = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2340248841,3306479965&fm=26&gp=0.jpg";
                mFileName = "test3.jpg";
                //取得InputStream，直接从InputStream生成bitmap
                mBitmap = BitmapFactory.decodeStream(getImageStream(filePath));
                // 发送消息，通知handler在主线程中更新UI
                connectHanlder.sendEmptyMessage(0);
                Log.d(TAG, "set image ...");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    };

    private Handler connectHanlder = new Handler() {
        @Override

        public void handleMessage(Message msg) {

            Log.d(TAG, "display image");
            // 更新UI，显示图片
            if (mBitmap != null) {
                mImageView.setImageBitmap(mBitmap);// display image
            }
        }
    };


    public void checkNeedPermissions(){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //多个权限一起申请
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, 1);
        }
    }

}
