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

1. 创建HttpClientActivity类，用于进行网络编程测试；
2. 通过HttpClientActivity类中的getGitHubIssues方法获取url并建立连接，再通过BufferedReader读取文件信息；

核心代码：

```
HttpURLConnection connection = (HttpURLConnection) url.openConnection();

BufferedReader reader = new BufferedReader(new
                  InputStreamReader(connection.getInputStream()));
```

1. HttpClientActivity类onCreate方法再接收返回的数值并显示出来。 核心代码：

```
String jsonText = getGitHubIssues();
```

# 四、实验结果

[![lab06-1](https://github.com/zm-w/android-labs-2020/blob/master/students/net1814080903141/lab6-1.png)

# 五、实验心得

这一次实验内容是关于Android网络编程，难度比以往的实验增加了不小。由于我的APP没有应用到这一块知识点，因此根据老师提供的代码进行了实验。实验创建了网络连接类HttpClientActivity，对数据进行交互等操作。