package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnectionActivity extends AppCompatActivity {
        private TextView tvResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connection);
        initView(); //初始化视图
    }
    private void initView(){
        tvResponse=findViewById(R.id.tv_response_url);
    }

    /**
     * 向网络发出请求
     * @param view
     */
    public void sendRequestWithHttpURLConnection(View view) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    HttpURLConnection connection= null;
                    BufferedReader reader = null;

                    try {
                        URL url = new URL("https://www.github.com");
                         //获取
                        connection = (HttpURLConnection) url.openConnection();
                       //使用GET方法访问网络
                        connection.setRequestMethod("GET");
                        connection.setConnectTimeout(5000);
                        connection.setReadTimeout(5000);
                       InputStream in = connection.getInputStream();
                            reader = new BufferedReader(new InputStreamReader(in));

                        StringBuilder response = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            response.append(line);
                        }
                        showResponse(response.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (reader != null) {
                            try {
                                reader.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (connection != null) {
                            connection.disconnect();
                        }
                    }
                }
            }).start();
        }

    public void showResponse(final String response){
    runOnUiThread(new Runnable() {
        @Override
        public void run() {
            tvResponse.setText(response);
        }
    });

    }
}