# 实验六
## 一、实验目标

1. 掌握Android网络访问方法； 
2. 理解XML和JSON表示数据的方法

## 二、实验内容

1.	从网络下载一个文件（图片、MP3、MP4）；
2.	保存到手机，在应用中使用文件；
3.	将应用运行结果截图。

## 三、实验步骤

1.在 AndroidManifest.xml 上添加网络权限
```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
2.请求和获取url信息
```xml
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
3.getGitHubIssues()函数实现
```xml
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
4.	设置按钮和文本
```xml
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
5.	解决主线程不能联网的问题
在onCreate方法中加入
```xml
StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());

```
## 四、实验结果

![主界面](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab6.png)

## 五、实验心得体会
这次实验没有用到网络的功能，所以用的老师的例子。通过这次实验我了解了android是如何进行联网及访问其他网络的，但是再做的时候有些地方还是不太懂原理，后面勉强做出来。
