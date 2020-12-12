# 实验六

## 一.实验目的

掌握Android网络访问方法；

## 二.实验内容

1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。

## 三.实验步骤

1. 在AndroidManifest.xml中添加user-permission，使得安卓应用程序获得网络权限权限；

> AndroidManifest.xml

```java
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.sec1814080911238">
    <uses-permission android:name="android.permission.INTERNET"/>
    ...
</manifest>
```

2. 创建DownloadActivity类和download_activity.xml文件，用来实现网络请求和下载图片后用来显示的页面，在这里用来下载四六级必考词汇的图片；



3. 获取httpurlconnection，通过httpurlconnection实例化后，设置请求方式为 `get` 方式，设置超时时间和服务器返回的状态码；

> 网络请求核心代码

```java
 // 获取访问图片的路径
String path = "https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab6.jpg?raw=true";
//第一次访问 联网获取数据
System.out.println("第一次访问连接网络");
// 创建url对象
URL url = new URL(path);
// 获取httpurlconnection
HttpURLConnection conn =  (HttpURLConnection) url.openConnection();
// 设置请求的方式
conn.setRequestMethod("GET");
// 设置超时时间
conn.setConnectTimeout(5000);
// 获取服务器返回的状态码
int code = conn.getResponseCode();
```



4. 通过上一步骤获取的网络请求得到的图片数据，使用 `FileOutputStream` 类做图片缓存，在通过位图工厂 获取bitmap，最后使用  `setImageBitmap` 将图片渲染到 `ImageView` 容器中；

> 图片渲染核心代码

```java
// 获取图片的数据  不管是什么数据(txt文本 图片数据 )都是以流的形式返回
InputStream in = conn.getInputStream();
// 缓存图片   谷歌给我们提供了一个缓存目录
FileOutputStream fos = new FileOutputStream(file);
int  len = -1;
byte[] buffer = new byte[1024];//1kb
while((len=in.read(buffer))!=-1){
    fos.write(buffer, 0, len);
}
fos.close();
in.close();
// 通过位图工厂获取bitmap(bitmap)
final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
// 这句api不管你在什么位置上调用 action都运行在UI线程里
runOnUiThread(new Runnable() {
    public void run() {
        // run方法一定执行在UI线程里
        // 把bitmap显示到iv上
        iv.setImageBitmap(bitmap);
    }
});
```



## 四.实验截图

![网络图片下载显示](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab6-1.png?raw=true)

## 五.实验心得

  此次实验，是关于网络编程的，这也是我第一次自己接触这方面的东西，从Android如何网络连接，到如何获取数据，再到数据的呈现，每一步完成的都是十分艰辛，但这种艰辛也让我的编程水平得到了提升，收获了知识和快乐。
