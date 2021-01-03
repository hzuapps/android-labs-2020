# 实验三
## 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤
1. 在res/drawable目录中放入图片(bg.jpg)；
2. 在主界面上添加ImageView组件，通过ImageView组件实现在主界面上展示图片;
3. 在主界面的xml文件上对ImageView组件进行配置；
4. 设计方法实现界面的跳转，然后在按钮上应用该方法。
```java
  <ImageView
        android:id="@+id/imageView"
        android:layout_width="406dp"
        android:layout_height="92dp"
        android:layout_marginStart="1dp"
        app:layout_constraintEnd_toStartOf="@+id/linearLayout"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/q20201122173515" />
```

## 四、实验结果
![图片](https://github.com/wolkenthrut7/android-labs-2020/blob/master/students/sec1814080911129/Sec1814080911129.png)

## 五、实验心得
  这次实验的主要任务是在主界面上添加图片，使用具有添加图片功能的组件ImageView来实现在主界面添加图片，并且在主界面的xml文件上对组件ImageView进行配置。