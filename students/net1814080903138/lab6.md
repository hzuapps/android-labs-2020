# 实验六
## 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容
1. 从GitHub获取文件URL；
2. 在应用中通过网络编程访问GitHub的数据文件；
3. 在应用中解析并显示文件所包含的数据；
4. 将应用运行结果截图。

## 三、实验步骤
1. 在AndroidManifest.xml中添加网络权限；
```xml
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
2. 创建HttpClientUIActivity；
3. 创建activity_http_client.xml，其中一个按钮和一个textview；
4. 通过getGitHubIssues()方法来获取数值；```
5. 添加关于线程监控和关于虚拟机的策略。
```java
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());
```

## 四、实验结果
![lab6](https://github.com/hzuapps/android-labs-2020/blob/f8769126f1b58defa9500b0bd8964d8eb2abc979/students/net1814080903138/lab6.png)

## 五、实验心得
本次实验关于网络编程，学习了网络访问的方法，关于线程监控和关于虚拟机的策略。通过按钮下载JSON文件。