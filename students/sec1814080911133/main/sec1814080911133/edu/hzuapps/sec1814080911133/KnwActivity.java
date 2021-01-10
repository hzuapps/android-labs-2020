package edu.hzuapps.androidlabs.sec1814080911133;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sec1814080911133.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;


public class KnwActivity extends AppCompatActivity {
    String s=("咳嗽或打喷嚏时使用纸巾盖住口鼻,"+"\n"+"不要吃野味,"+"\n"+ "久坐电脑要常吃苹果,"+"\n"+ "咀嚼芝麻可止反酸");
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knw);

        Button 返回 = (Button)findViewById(R.id.button3);
        返回.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(KnwActivity.this,Sec1814080911133Activity.class);
                startActivity(intent);
            }
        });

        textView3 = findViewById(R.id.textView);


                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            String jsonText = getGitHubIssues();
                            if (jsonText != null) {
                                try {
                                    JSONArray jsonArr = new JSONArray(jsonText);
                                    JSONObject jsonObj = (JSONObject) jsonArr.get(1);
                                    textView3.setText("TITLE = " + jsonObj.getString("title")+"\n"+s);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
                }

    private String getGitHubIssues() {
        String gitApi = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
        URL url = null;
        String jsonText = null;
        try {
            url = new URL(gitApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer mm = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = URLDecoder.decode(lines, "utf-8");
                mm.append(lines);
            }
            System.out.println(mm);
            jsonText = mm.toString();
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonText;
    }

}