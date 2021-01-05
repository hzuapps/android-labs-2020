package edu.hzuapps.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShareActivity extends AppCompatActivity {

    private Button download;
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        iv = (ImageView) findViewById(R.id.img);

        findViewById(R.id.text_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.text_button:
                        Intent intent = new Intent(ShareActivity.this,TextActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        //接收文字
        Intent intent = getIntent();
        if(intent !=null){
            String string_share = intent.getStringExtra("mstring_share");
            setTitle(string_share);
        }
    }

    /**
     * 实现下载图片
     * @param v
     */
    // 点击按钮查看指定路径的源码
    public void click(View v) {
        new Thread(){public void run() {
            try {
                //获取访问图片的路径
                String path = "https://gitee.com/linzisong/wx-jf/raw/master/assets/image.jpg";
                File  file = new File(getCacheDir(),Base64.encodeToString(path.getBytes(), Base64.DEFAULT));
                if (file.exists()&& file.length()>0) {
                    //使用缓存图片
                    System.out.println("使用缓存图片 ");
                    final Bitmap cacheBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                    runOnUiThread(new Runnable() {
                        public void run() {
                            iv.setImageBitmap(cacheBitmap);
                        }
                    });
                }else{
                    //第一次访问联网获取数据
                    System.out.println("第一次访问连接网络");
                    URL url = new URL(path);
                    HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
                    //设置请求的方式
                    conn.setRequestMethod("GET");
                    //设置超时时间
                    conn.setConnectTimeout(5000);
                    //获取服务器返回的状态码
                    int code = conn.getResponseCode();
                    if (code == 200) {
                        //获取图片的数据，以流的形式返回
                        InputStream in = conn.getInputStream();
                        //缓存图片
                        FileOutputStream fos = new FileOutputStream(file);
                        int  len = -1;
                        byte[] buffer = new byte[1024];
                        while((len=in.read(buffer))!=-1){
                            fos.write(buffer, 0, len);
                        }
                        fos.close();
                        in.close();
                        //获取bitmap
                        final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                        runOnUiThread(new Runnable() {
                            public void run() {
                                //把bitmap显示到iv上
                                iv.setImageBitmap(bitmap);
                            }
                        });

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };}.start();

    }
}
