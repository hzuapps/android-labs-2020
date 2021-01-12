# 实验六：Android网络编程
## 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法

## 二、实验内容
1. 从网络下载一个文件（图片、MP3、MP4）
2. 保存到手机，在应用中使用文件
3. 将应用运行结果截图

## 三、实验步骤
1. 首先在网络上寻找与选题相关的图片，复制图片链接
2. 在activity_install.xml中利用之前设置的ImageView控件，用于放置之后从网络中传来的图片
```
    <ImageView
            android:id="@+id/photo"
            android:layout_width="126dp"
            android:layout_height="160dp"
            android:layout_marginLeft="5dp"
            android:layout_marginTop="50dp"/>
            <!--android:src="@drawable/logo"-->
```
3. 添加网络下载相关的依赖包
```
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
```
4. 在AndroidManifest中配置允许与互联网连接的权限
```
     <uses-permission android:name="android.permission.INTERNET"/>
```

5. 获取网络图片url，用Glide.load加载该网络图片进入该布局
```
       //获取网络图片url，用Glide.load加载该网络图片进入该布局
        ImageView img = (ImageView) findViewById(R.id.photo);
        Glide.with(this).load("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/news/crop=4,12,1254,753;w=638/sign=984a2d9c0df41bd5ce1cb2b46ceeadfa/7a899e510fb30f24a7f326b4cb95d143ad4b0318.jpg").into(img);
```

## 四、实验结果
![实验结果](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab6.png)

## 五、实验心得
本次实验内容是Android网络编程，主要学习了如何从网络下载一个图片，且在应用中使用图片。切勿忽略在AndroidManifest中配置允许与互联网连接的权限，否则会报错。
