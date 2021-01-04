# 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法
# 二、实验内容
1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。
# 三、实验步骤
1. 在activity_edit.xml中设置ImageView控件，以放置之后从网络中传来的图片；
```
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/imageback"
        android:scaleType="centerCrop">
    </ImageView>
```
2. 添加网络下载相关的依赖包；
```
/****添加依赖*****/
    implementation 'com.github.bumptech.glide:glide:4.11.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.11.0'
```
3. 获取网络图片url，用Glide.load加载该网络图片进入该布局；
```
    ImageView mIg = (ImageView) findViewById(R.id.imageback);
    mIg.setAlpha(80);
    Glide.with(this).load("https://p1.ssl.qhimgs1.com/sdr/400__/t0106390b4760abe341.jpg").into(mIg);
```
4. 在AndroidManifest中配置允许与互联网连接的权限
```
    <uses-permission android:name="android.permission.INTERNET" />
    <!--它可以监听用户的连接状态并在用户重新连接到网络时重启之前失败的请求-->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
# 四、实验结果
![result6picture](https://raw.githubusercontent.com/JieBro333/android-labs-2020/1d0c33d74da0a049af166cb3cb0cd7bdc5dc3042/students/net1814080903220/lab6result.png)
# 五、实验心得
  这次实验掌握了如何从网络上下载图片保存到手机，在没配置接入互联网的权限时，一直报错，于是我去网上查找了些资料，才看到原来是需要在AndroidManifest里配置好相关权限，才可以运行，这让我明白了安卓中一些功能必须要给权限才可以实现，总的来说，这个操作比较简单，多加练习，熟能生巧很重要。
