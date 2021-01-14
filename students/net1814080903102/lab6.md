# 实验六 Android网络编程

## 一、实验目标


1.掌握Android的网络访问方法；

2.理解XML和JSON表示数据的方法。

## 二、实验内容



1.在个人目录中创建一个表示数据的XML或JSON文件；

2.数据文件代码提交之后从GitHub获取文件URL；

3.在应用中通过网络编程访问GitHub的数据文件；

4.在应用中解析并显示文件所包含的数据；

5.将应用运行结果截图。 

## 三、实验步骤


1.创建activity_http_client.xml

activity_http_client.xml代码：

 ```xml
  
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="edu.hzuapps.androidlabs.examples.HttpClientActivity">

    <Button
        android:id="@+id/button_get_issues"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Get GitHub Issues"/>

    <EditText
        android:id="@+id/first_node_number"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />

</LinearLayout>
 ```
2.创建HttpClientActivity.java

HttpClientActivity.java代码：

```java
package edu.hzuapps.androidlabs.examples;

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
```
3.创建HttpClientUIActivity.java

HttpClientUIActivity.java代码：

```java
package edu.hzuapps.androidlabs.examples;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

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

public class HttpClientUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);

        final HttpClientUIActivity thisActivity = this;

        ((Button) findViewById(R.id.button_get_issues)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String jsonText = getGitHubIssues();
                        if (jsonText != null) {
                            try {
                                JSONArray jsonArr = new JSONArray(jsonText);
                                JSONObject jsonObj = (JSONObject) jsonArr.get(1);
                                int number = jsonObj.getInt("number");
                                System.out.println("NUMBER = " + number);
                                ((EditText) thisActivity.findViewById(R.id.first_node_number)) //
                                        .setText(Integer.toString(number));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
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
```





## 四、运行结果及截图


[![lab6](https://s3.ax1x.com/2021/01/14/saeGut.png)](https://imgchr.com/i/saeGut)









## 五、实验心得

通过本次的实验，我学习到了如何在Android设备中使用网络编程，获取Json文件。

