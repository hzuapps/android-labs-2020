# 实验三
## 1.实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 2.实验内容
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 3.实验步骤
1. 在res/drawable目录中放入图片(logo.jpg)；
2. 在主界面上添加ImageView组件，通过ImageView组件实现在主界面上展示图片;
3. 在主界面的xml文件上对ImageView组件进行配置；
4. 设计方法实现界面的跳转，然后在按钮上应用该方法。
```java
    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/bg"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

```
## 4.实验结果
![截图](https://github.com/88hua/android-labs-2020/blob/master/students/net1814080903340/test02.JPG)

## 5.实验心得
本次实验我在我项目的主界面上添加了图片，使用具有添加图片功能的组件ImageView来实现在主界面添加图片，并且在主界面的xml文件上对组件ImageView进行配置。
