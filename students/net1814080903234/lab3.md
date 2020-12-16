# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法
# 二、实验内容
1. 在自选题目项目中添加图片；
2. 使用显示
# 三、实验步骤
1. 准备一张或多张命好名字的图片，名字不要有中文；
2. 放入res/drawable文件目录下；
3. 在布局背景background中使用@drawable/图片名字引用该图片；
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapp.androidlabs.net1814080903234.Net1814080903234Activity"
    android:orientation="vertical"
    android:background="@drawable/background">
```
# 四、实验结果
 ![lan3_png](https://raw.githubusercontent.com/jun-stack/android-labs-2020/master/students/net1814080903234/lab3.png)
# 五、实验心得
 此次实验较为简单，在实验过程没有遇到问题，可以快速完成。
