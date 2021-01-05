package edu.hzuapps.androidlabs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vorlonsoft.android.http.AsyncHttpClient;
import com.vorlonsoft.android.http.AsyncHttpResponseHandler;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

import cz.msebera.android.httpclient.Header;
import edu.hzuapps.androidlabs.entity.User;
import edu.hzuapps.androidlabs.utils.JsonParse;


public class AccountActivity extends AppCompatActivity {

    public static final String JSON_URL = "http://10.0.2.2:8080/user.json";
    public static final int CODE = 100005;
    public static final int SERVER_ERROR = 100006;

    private User user;

    private ImageView mImgUrl;
    private TextView textView_name;
    private TextView textView_sex;
    private TextView textView_age;
    private TextView textView_occupation;
    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        init();

        mImgUrl = (ImageView) findViewById(R.id.img_url);
        myHandler = new MyHandler(this);

        // 获取json数据
        getUser(JSON_URL);
    }

    // 初始化组件
    public void init(){
        textView_name = findViewById(R.id.name);
        textView_sex = findViewById(R.id.sex);
        textView_age = findViewById(R.id.age);
        textView_occupation = findViewById(R.id.occupation);
    }

    public void getUser(String path){
        // 创建请求实例
        AsyncHttpClient client = new AsyncHttpClient();
        System.out.println("=============");
        client.get(path, new AsyncHttpResponseHandler() {
            // 请求成功
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] bytes) {
                System.out.println("-----------------------------");
                // 调用JsonParase工具解析JSON文件
                try {
                    String json = new String(bytes,"utf-8");
                    user = JsonParse.getUser(json);
                    if(user == null){
                        Toast.makeText(AccountActivity.this,"解析失败",Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(AccountActivity.this,"解析成功",Toast.LENGTH_SHORT).show();
                        // 显示图像
                        new Thread() {
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    Thread.sleep(10);

                                    getUrlimg(user.getAvator());

                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }.start();

                        // 显示数据
                        textView_name.setText(user.getName());
                        textView_sex.setText(user.getSex());
                        textView_age.setText(user.getAge());
                        textView_occupation.setText(user.getOccupation());
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            // 勤请求失败
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(AccountActivity.this,"请求失败",Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void getUrlimg(String path) {
        //把传过来的路径转成URL
        try {
            URL url = new URL(path);
            //获取连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //使用GET方法访问网络
            connection.setRequestMethod("GET");
            //超时时间为10秒
            connection.setConnectTimeout(10000);
            //获取返回码
            int code = connection.getResponseCode();
            if (code == 200) {
                InputStream inputStream = connection.getInputStream();
                //使用工厂把网络的输入流生产Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                //利用Message把图片发给Handler
                Message msg = Message.obtain();
                msg.obj = bitmap;
                msg.what = CODE;
                myHandler.sendMessage(msg);
                inputStream.close();
            } else {
                //服务启发生错误
                myHandler.sendEmptyMessage(SERVER_ERROR);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取连接
    }

    public static class MyHandler extends Handler {
        final WeakReference<AccountActivity> weakReference;

        public MyHandler(AccountActivity activity) {
            this.weakReference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            AccountActivity activity = weakReference.get();

            switch (msg.what) {
                case CODE:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    activity.mImgUrl.setImageBitmap(bitmap);
                    break;
                case SERVER_ERROR:
                    Toast.makeText(activity, "网络异常", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    }
}
