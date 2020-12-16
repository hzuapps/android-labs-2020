# 实验六：Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

## 三、实验步骤

1. 在 AndroidManifest.xml 上添加网络权限
```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

2. 请求和获取url信息
```
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
```
    
3.  getGitHubIssues()函数实现
```
private String getGitHubIssues() {
        String gitApi = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
        //gitApi = "https://www.baidu.com";
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
```

4. 设置按钮和文本
```
 <Button
        android:id="@+id/button_get_issues"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Get GitHub Issues"/>

    <EditText
        android:id="@+id/first_node_number"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

5. 解决主线程不能联网的问题

在onCreate方法中加入
```
StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
```

## 四、实验结果及截图

![lab6.1](https://raw.githubusercontent.com/huanxuaner/android-labs-2020/master/students/net1814080903109/6.1.PNG)
![lab6.2](https://raw.githubusercontent.com/huanxuaner/android-labs-2020/master/students/net1814080903109/6.2.PNG)

## 五、实验心得

  我的项目因为没有用到网络功能，所以这次实验主要使用老师给的练习。做网络功能最重要的两步是权限获取和合法联网。在实验过程中我了解到，项目运行时在主线程实现联网功能会报错，所以要用创建子线程或步骤四的方式解决这个问题。
