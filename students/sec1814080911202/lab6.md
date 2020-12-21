# 一、实验目的

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

>注意：选择实现的功能，一定要跟你的选题相关！

# 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

>提示：获取GitHub文件URL的方法是，打开文件，再点击Raw按钮。

# 三、实验步骤

1. 在AndroidManifest.xml中添加：
```xml
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.INTERNET" />

    <activity android:name=".HttpClientActivity" />
```

2. 新建activity_http_client.xml，以下是主要代码:
```xml
    <Button
        android:id="@+id/button_get_issues"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Get GitHub Issues"/>
```

3. 新建HttpClientActivity.java，实现获取url并操作xml，以下是主要代码：
```java
public class HttpClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_client);

        final HttpClientActivity thisActivity = this;

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

                                System.out.println("TITLE = " + jsonObj.getString("title"));
                                System.out.println("NUMBER = " + jsonObj.getInt("number"));
                                System.out.println("USER = " + jsonObj.getJSONObject("user").getString("login"));

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


# 四、实验结果

![lab6](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab6.png)

# 五、实验心得

本次实验是android网络编程，实验内容是访问并获取xml文件，然后对xml文件进行解析，实验要注意的点就是需要在AndroidManifest.xml给相应的网络权限，并且有时候github这个api链接不上需要多次尝试。通过本次实验，了解了android的基本网络编程，学会了访问url以及用JSONObject和JSONArray操作解析xml。
