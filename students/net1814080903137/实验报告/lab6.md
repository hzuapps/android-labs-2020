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


![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/6.JPG)

# 五、实验心得
这一次实验内容是关于Android网络编程，难度比以往的实验增加了不小。理解网络编程的基本原理之后，明白这一次的实验是先创建网络连接类HttpClientActivity，对数据进行交互等操作。