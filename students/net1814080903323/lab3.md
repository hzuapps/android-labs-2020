# 实验三：Android资源使用编程
## 一、实验目标
- 了解Android应用中各种资源的概念与使用方法；
- 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容
- 在界面上显示至少一张图片（按照自己的题目添加）；
- 提交res/drawable及图片使用的代码；
- 提交res/values, res/layout等其他代码；
- 将应用运行结果截图，放到实验报告中；
- 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤
- 在res/drawable目录中放入图片(bg.jpg)；
- 在主界面上添加ImageView组件，通过ImageView组件实现在主界面上展示图片;
- 在主界面的xml文件上对ImageView组件进行配置；
- 设计方法实现界面的跳转，然后在按钮上应用该方法。
```java
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="194dp"
        android:layout_height="355dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="10dp"
        android:src="@drawable/cat1"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="194dp"
        android:layout_height="355dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="205dp"
        android:src="@drawable/cat2"
        app:layout_constraintStart_toEndOf="@+id/imageView"
        app:layout_constraintTop_toTopOf="@+id/imageView"
        tools:ignore="MissingConstraints" />

    <ImageView
        android:layout_width="194dp"
        android:layout_height="355dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="205dp"
        android:src="@drawable/cat3"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/imageView2"
        tools:ignore="MissingConstraints" />
```

## 四、实验结果
![图片](https://github.com/joshua-ben/android-labs-2020/blob/master/students/net1814080903323/test3.jpg)

## 五、实验心得
  这次实验的主要任务是在主界面上添加图片，使用具有添加图片功能的组件ImageView来实现在主界面添加图片，并且在主界面的xml文件上对组件ImageView进行配置。
