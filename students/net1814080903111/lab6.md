# 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

# 二、实验内容
1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。
# 三、实验步骤
1.在AndroidManifest.xml添加
```
<uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
2.创建HttpClientUIActivity和activity_http_client.xml
3.HttpClientUIActivity的主要代码：
```
 private String getGitHubIssues() {
        String gitApi = "https://api.github.com/repos/hzuapps/android-labs-2020/issues";
        //gitApi = "https://www.baidu.com";
        URL url = null;
        String jsonText = null;
        try {
            url = new URL(gitApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.connect();
            System.out.println("连接成功");
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
 4.在Oncreate函数中加入
 ```
 if (android.os.Build.VERSION.SDK_INT > 9) {     //使用限制模式解决网络阻塞
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
 ```
# 四、实验结果
![lab6_1](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab6_1.png)
![lab6_2](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab6_2.png)
# 五、实验心得
这次实验主要了解了如何从github中提取文件url和访问github的数据文件
