# 一、实验目标 #

1. 掌握Android网络访问方法
2. 理解XML和JSON表示数据的方法

# 二、实验内容 #

1. 在Github的个人目录中创建JSON或XML数据文件
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 通过Android网络编程读取该JSON或XML文件
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

# 三、实验步骤 #

1. 创建HttpClientActivity用于测试网络编程

2. 在HttpClientActivity写入以下代码

   ```java
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
        String gitApi = "https://www.baidu.com";
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




# 四、实验结果 #

![lab6]((https://github.com/wuuuxj/android-labs-2020/tree/master/students/sec1814080911205/lab6.png))


# 五、实验心得 #

通过本次实验我学会了安卓文件下载功能
