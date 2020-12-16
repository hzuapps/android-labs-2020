package edu.hzuapps.androidlabs.net1814080903137;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

import edu.hzuapps.androidlabs.R;

public class HttpClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);

        ((Button) findViewById(R.id.button_get_issues)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String jsonText = getGitHubIssues();
                        if (jsonText != null) {
                            try {
                                JSONArray jsonArr = new JSONArray(jsonText);
                                JSONObject jsonObj = (JSONObject) jsonArr.get(1);
                                int number = jsonObj.getInt("number");
                                System.out.println("NUMBER = " + number);
                                //((EditText) thisActivity.findViewById(R.id.first_node_number)).setText(Integer.toString(number));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                thread.start();
            }
        });
    }

    private String getGitHubIssues() {
        String gitApi = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
        //gitApi = "https://www.baidu.com";
        URL url = null;
        String jsonText = null;
        try {
            url = new URL(gitApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // HttpClient
            // OKHttp
            //connection.setDoOutput(true);
            //connection.setDoInput(true);
            //connection.setRequestMethod("POST");
            //connection.setUseCaches(false);
            //connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = URLDecoder.decode(lines, "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            jsonText = sb.toString();
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
