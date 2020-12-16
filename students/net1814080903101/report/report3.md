# 实验三 Android资源使用编程



## 一、实验目标

​	1.了解Android应用中各种资源的概念与使用方法；

​	2.掌握Android应用中使用图片等资源的方法。

## 二、实验内容

​	1.在自选题目项目中添加图片；

​	2.在界面上显示至少一张的图片。

## 三、实验步骤

​	1.设置背景图片

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/test"
    tools:context=".Net1814080903101Activity">
```

​		使用了android:backgroud=“图片路径”的描述文本，为APP添加背景图片。

​	2.控件显示图片

```xml
<ImageView
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_marginTop="160dp"
        android:src="@drawable/title"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

​		使用ImageView作为图片显示的容器，在里面添加描述android:src=“图片路径”，为该容器添加图片，进行显示。

​	3.activity_net1814080903101.xml全代码

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/test"
    tools:context=".Net1814080903101Activity">

    <Button
        android:id="@+id/button_add"
        android:layout_width="126dp"
        android:layout_height="70dp"
        android:layout_marginBottom="90dp"
        android:text="开始游戏"
        android:textSize="60px"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

    <ImageView
        android:layout_width="200dp"
        android:layout_height="200dp"
        android:layout_marginTop="160dp"
        android:src="@drawable/title"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

​		

## 四、实验结果

![插入图片效果](picture/export.png)

## 五、心得体会

​		这次实验关于安卓项目中资源的使用，重点学习了图片的使用，使用imageview控件以及xml中的src描述可以实现，使界面更加的美观。

