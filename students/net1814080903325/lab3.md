# 实验三
## 一、实验目标
了解Android应用中各种资源的概念与使用方法；

掌握在Android应用中使用图片等资源的方法
## 二、实验内容
 在现在Activity中显示图片资源；
## 三、实验步骤
根据选定题目选取一张图片命名为 icon3.jpeg 放入res/drawable中给activity.net1814080903325.xml中使用

在activity.net1814080903325.xml添加图片
```java
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/icon3" />
```
## 四、实验结果
![实验三结果截图](https://raw.githubusercontent.com/HuaStarOS/android-labs-2020/master/students/net1814080903325/lab3.jpg)

## 五、实验心得
本次实验是在Android中对资源在xml上的使用，成功显示图片.
