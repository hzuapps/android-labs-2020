# 实验三：

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）
2. 提交res/drawable及图片使用的代码
3. 提交res/values, res/layout等其他代码
4. 将应用运行结果截图，放到实验报告中
5. 点击图片（或按钮）时，打开另一个Activity

## 三、实验步骤

1. 将目标图片保存到本地Android studio的 res/drawable路径中；
2. 在主页面activity_sec1814080911234.xml中将bg1设为背景，代码为：
 ```
 <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/bg1" />
 ```
3. 在功能页 activity_show.xml 中将bp3设为背景，代码如下：
 ```
<ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/bp3"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp"
        tools:ignore="MissingConstraints" />
 ```
4. 在功能页 activity_voice.xml 中将bg4设为背景，代码如下：
 ```
     <ImageView
        android:id="@+id/imageView3"
        android:layout_width="368dp"
        android:layout_height="495dp"
        app:srcCompat="@drawable/bg4"
        tools:layout_editor_absoluteX="8dp"
        tools:layout_editor_absoluteY="8dp"
        tools:ignore="ContentDescription" />
 ```
## 四、实验结果

 ![实验三图1](https://github.com/hzuapps/android-labs-2020/blob/master/students/sec1814080911139/bg1.png?raw=true)；
 ![实验三图2](https://github.com/hzuapps/android-labs-2020/blob/master/students/sec1814080911139/bg4.jpg?raw=true)；
 ![实验三图3](https://github.com/hzuapps/android-labs-2020/blob/master/students/sec1814080911139/bg2.png?raw=true)；

## 五、实验心得体会

本次实验是了解Android应用中各种资源的概念与使用方法，以及掌握在Android应用中使用图片等资源的方法。通过本次实验，掌握了添加图片的几种方法，特别是ImageView，以及学会了图片的属性配置等等。
