# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法
# 二、实验内容
1. 在自选题目项目中添加图片；
2. 使用显示
# 三、实验步骤
1. 准备一张命好名字的图片；
2. 放入res/drawable文件目录下；
3. 在对应功能的layout下引用该图片名称
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="15dp"
    tools:context=".Net1814080903220MainActivity"
    android:background="@drawable/bird">  //主页界面放置app背景图片
```
# 四、实验结果
![lab3result](https://raw.githubusercontent.com/JieBro333/android-labs-2020/master/students/net1814080903220/lab3result.jpg)
# 五、实验心得
此次实验了解了Android应用中使用图片的方法，实验比较简单，注意好图片命名不要用中文，其它没什么问题。
