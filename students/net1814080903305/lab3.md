# 实验三
## 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容
1. 修改Activity对应的布局文件；
2. 实现在Activity中显示图片资源；

## 三、实验步骤
1. 根据选定题目选取一张图片命名为 time.jpg 放入res/drawable中给activity_main.xml中使用
2. 将activity_main.xml原本的两个按钮格局设置成相对布局
3. 在activity_main.xml添加图片
```java
<ImageView
    android:id="@+id/imageView"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:srcCompat="@drawable/time"
    tools:layout_editor_absoluteX="0dp"
    tools:layout_editor_absoluteY="0dp" />
```

## 四、实验结果
![实验三结果截图](https://raw.githubusercontent.com/bakamaid777/android-labs-2020/master/students/net1814080903305/lab3.png)

## 五、实验心得
通过本次实验了解Android应用中各种资源的概念与使用方法，掌握在Android应用中使用图片等资源的方法。
