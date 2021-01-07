# 实验六：Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

```
注意：选择实现的功能，一定要跟你的选题相关！
```

## 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 三、实验步骤

1. 在 build.gradle 上导入依赖
```java
 implementation 'com.squareup.okhttp3:okhttp:3.14.2'
 implementation 'com.squareup.okio:okio:1.17.4'
```
2. 在 AndroidManifest.xml 上添加网络权限

```xml
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

3. 对 BrowseActivity.java 进行修改

```java
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
```



## 四、实验结果及截图

![实验6图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab6_2.png)

![实验6图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab6.png)

## 五、实验心得

这次实验主要是让我们掌握Android网络访问方法，理解XML和JSON表示数据的方法。这次实验有一个需要注意的点是首先要在配置启动网络权限，否则发送不了请求，然后实验过程中我自己写了一个json文件，然后发现我一直获取不到文件的值，但是老师给的json文件链接我就可以获取到，后来发现老师给的那个是api接口的地址，最后我用安卓模拟器模拟发送给本地电脑请求，应该使用地址10.0.2.2这个ip获取我自己写的内容。
