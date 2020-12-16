# 实验六 Android网络编程

## 一、实验目标

1. 掌握Android网络访问方法；

2. 理解XML和JSON表示数据的方法。

## 二、实验内容

1. 在个人目录中创建一个表示数据的XML或JSON文件；

2. 数据文件代码提交之后从GitHub获取文件URL；

3. 在应用中通过网络编程访问GitHub的数据文件；

4. 在应用中解析并显示文件所包含的数据；

5. 将应用运行结果截图。

## 三、实验步骤

1. 在AndroidManifest.xml中添加网络权限
```xml
    <uses-permission android:name="android.permission.INTERNET"></uses-permission>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"
        tools:ignore="WrongManifestParent" />

```
2. 创建HttpClientUIActivity和对于的activity_http_client.xml，使获取的数值可视化
3. 通过HttpClientUIActivity中getGitHubIssues()方法来获取数值。
```java
 private String getGitHubIssues() {
    ...
 }
```
4. 访问网络要放在独立的线程中
```java
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork()
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
                .penaltyLog().penaltyDeath().build());

```
## 四、实验结果
![lab6](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab6.png)

## 五、实验心得
  这次实验是安卓的网络编程，实验内容需要去理解安卓网络编程的原理，遇到的困难是不能在主线程中去访问网络，所以需要去创立独立的线程去进行访问操作，还需要在AndroidManifest.xml添加好相应的权限。

