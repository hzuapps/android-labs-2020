# 实验三
## 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容
1. 修改Activity对应的布局文件；
2. 实现在Activity中显示图片资源；

## 三、实验步骤
1. 根据选定题目选取一张图片命名为 theone.png 放入res/drawable中给activity.net1814080903319.xml中使用
2. 将activity.net1814080903319.xml原本的两个按钮格局设置成相对布局
3. 在activity.net1814080903319.xml添加图片
```java
<ImageView
    android:layout_width="match_parent"
    android:layout_height="200dp"
    android:src="@drawable/theone"/>
```

## 四、实验结果
![实验三结果截图](https://raw.githubusercontent.com/Basr-suer/android-labs-2020/master/students/net1814080903319/lab3.jpg)

## 五、实验心得
本次实验是在Android中对资源在xml上的使用，成功显示图片，以及在线性布局中嵌套一个相对布局中显示按钮
