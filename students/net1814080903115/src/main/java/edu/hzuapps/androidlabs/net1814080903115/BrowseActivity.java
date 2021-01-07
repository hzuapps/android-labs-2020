package edu.hzuapps.androidlabs.net1814080903115;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.textclassifier.ConversationActions;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BrowseActivity extends AppCompatActivity {
    private TextView textView;
    public String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brouse);

        textView = findViewById(R.id.tv_show);
        //设置一下最多能显示几行
        textView.setMaxLines(16);
        //一定要设置文本的移动方式
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        getSyn("http://10.0.2.2:8080/NEWS");
        //getJson();
    }
    public void getJson() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //你的URL
                    String url_s = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
                    URL url = new URL(url_s);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //设置连接属性。不喜欢的话直接默认也阔以
                    conn.setConnectTimeout(5000);//设置超时
                    conn.setUseCaches(false);//数据不多不用缓存了

                    //这里连接了
                    conn.connect();
                    //这里才真正获取到了数据
                    InputStream inputStream = conn.getInputStream();
                    InputStreamReader input = new InputStreamReader(inputStream);
                    BufferedReader buffer = new BufferedReader(input);
                    if (conn.getResponseCode() == 200) {//200意味着返回的是"OK"
                        String inputLine;
                        StringBuffer resultData = new StringBuffer();//StringBuffer字符串拼接很快
                        while ((inputLine = buffer.readLine()) != null) {
                            resultData.append(inputLine);
                        }
                        text = resultData.toString();
                        Log.v("out---------------->", text);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public void getSyn(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //创建OkHttpClient对象
                    OkHttpClient client = new OkHttpClient();
                    //创建Request
                    Request request = new Request.Builder()
                            .url(url)//访问连接
                            .get()
                            .build();
                    //创建Call对象
                    Call call = client.newCall(request);
                    //通过execute()方法获得请求响应的Response对象
                    Response response = call.execute();
                    if (response.isSuccessful()) {
                        //处理网络请求的响应，处理UI需要在UI线程中处理
                        text=response.body().string();
                        textView = findViewById(R.id.tv_show);
                        textView.setText(text);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void parseJson() {
        try {
            text = "{\n" +
                    "\"data\": "+text+"}";
            //这里的text就是上边获取到的数据，一个String.
            JSONObject jsonObject = new JSONObject(text);

            // getJSONArray中的参数就是你想要分析的JSON的键
            JSONArray jsonDatas = jsonObject.getJSONArray("data");
            int length = jsonDatas.length();
            String test;
            for (int i = 0; i < length; i++) {
                JSONObject person = jsonDatas.getJSONObject(i);
                test = person.getString("id");
                Log.v("out---------------->", i + "---------------" + test);
                textView = findViewById(R.id.tv_show);
                textView.setText(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}