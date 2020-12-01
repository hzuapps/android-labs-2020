# 实验六 Android网络编程

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

1. 在AndroidManifest.xml中添加user-permission

```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```

2. 创建HttpClientActivity类，用于进行网络编程测试；

3. 通过HttpClientActivity类中的getGitHubIssues方法获取url并建立连接，再通过BufferedReader读取文件信息；
  
  核心代码：
  ```
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  
  BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
  ```
4. HttpClientActivity类onCreate方法再接收返回的数值并显示出来。

  核心代码：
  ```
  String jsonText = getGitHubIssues();
  ```
  
# 四、实验结果

![avatar](/students/net1814080903226/Lab6-1.png)

# 五、实验心得
　　本次实验内容是关于Android网络编程。创建了一个HttpClientActivity类用于建立网络连接、接收数据，以及反馈信息。总的来说就是，先通过一个gitApi来创立url连接，然后再使用url来建立网络连接。建立完连接后，使用BufferedReader来读取信息，最后将读取的信息返回给oncreate的方法调用处，再进行处理显示。实验复杂度不高，但要理解网络编程的基本原理，才能比较顺利完成此实验。

