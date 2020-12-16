# 实验三、Android资源使用编程
## 一、实验目标
1、了解Android应用中各种资源的概念与使用方法；  
2、掌握在Android应用中使用图片等资源的方法。
## 二、实验要求
1、在界面上显示至少一张图片（按照自己的题目添加）；   
2、提交res/drawable及图片使用的代码；  
3、提交res/values, res/layout等其他代码；   
4、将应用运行结果截图，放到实验报告中；   
5、点击图片（或按钮）时，打开另一个Activity。  
## 三、实验步骤 
1、准备一张或多张命好名字不带中文的图片；放入res/drawable文件目录下；   
2、在布局背景background中使用@drawable/图片名字引用该图片  
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903224activity"
    android:background="@drawable/use1">
```
## 四、实验结果

## 五、实验心得体会
本次试验是到现在为止较为简单的实验，没有遇到多大困难，只要注意照片的大小以及不带中文即可。
