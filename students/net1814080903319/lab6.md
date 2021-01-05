# 实验六
## 一、实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法；

## 二、实验内容
1. 修改主界面对应xml的布局内容；
2. 在全局配置中加入权限标签连接网络；

## 三、实验步骤
1. 在manifests下的配置文件AndroidManifest.xml加入一条权限标签;
```xml
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
2. 在主界面Java文件Net1814080903319MainActivity.java中检查网络状态；
```java
ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
```
3. 修改activity_net1814080903319.xml的内容布局用于显示主界面传回的网络连接状况

## 四、实验结果
![网络检查显示截图](https://raw.githubusercontent.com/Basr-suer/android-labs-2020/master/students/net1814080903319/lab6.jpg)

## 五、实验心得
实验通过添加权限的定义实现允许程序访问有关GSM网络信息的功能，能够判断当前程序访问的网络是什么类型的
