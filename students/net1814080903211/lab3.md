# 实验三：Android资源使用编程

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验要求

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

1. 创建图标资源ic_baseline_account_circle_256
2. 在activity_main.xml中引入图片资源并指定跳转方式
3. 提交文件

``` xml
 <TextView
     android:id="@+id/text_home"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:onClick="jumpToProfile"
     android:textAlignment="center"
     android:textSize="20sp"
     app:drawableTopCompat="@drawable/ic_baseline_account_circle_256"
     app:layout_constraintBottom_toBottomOf="parent"
     app:layout_constraintEnd_toEndOf="parent"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="parent" />
```

## 四、实验结果

![result](https://raw.githubusercontent.com/Xterisk/android-labs-2020/master/students/net1814080903211/lab3.png)

## 五、实验心得

本次实验比较简单，就加入了一张图片和指定它的行为。
