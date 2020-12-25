# 实验三

## 一、实验目标

1、了解Android应用中各种资源的概念与使用方法；

2、掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

1、添加图片（按照自己的题目添加）；

2、在界面上显示至少一张图片。

## 三、实验步骤

1、将图片保存到res/drawable,注意要用小写英文命名；

2、在XML文件中添加ImageView组件来使用图片

## 四、实验结果

activity_net1814080903302.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903302Activity">

    <Button
        android:id="@+id/startluyin"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="开始录音"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.153"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.929" />

    <Button
        android:id="@+id/luyinline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="录音列表"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.829"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.929" />

    <ImageView
        android:layout_width="70dp"
        android:layout_height="90dp"
        android:src="@drawable/luyinji"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.266"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.137" />

    <TextView
        android:layout_width="98dp"
        android:layout_height="81dp"
        android:text="录音机"
        android:textSize="32dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.626"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.172" />
</androidx.constraintlayout.widget.ConstraintLayout> 
```

![插入图片后](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab3.jpg)

## 五、实验心得

这次实验主要是在实验二的基础上加上一个图片，并在.xml文件上添加image代码，实验难度不大。我做的录音机只要加一个录音机相关的logo就行了，无需添加其余图片。
