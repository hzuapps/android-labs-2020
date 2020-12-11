# 实验三

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容

1. 在自选题目项目中添加图片；
2. 使用显示

## 三、实验步骤
1. 打开Android Studio，在代码目录Sec1814080911106\app\src\main\res\drawable下放置图片：background.png

2. layout中对图片进行引用

```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Sec1814080911106Activity"
    >

    <TextView
        android:id="@+id/notification_background"
        android:layout_width="417dp"
        android:layout_height="733dp"
        android:drawableTop="@drawable/background" />

    <Button
        android:id="@+id/button_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="View"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="158dp"
        tools:layout_editor_absoluteY="237dp" />

    <Button
        android:id="@+id/button_edit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Edit"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="158dp"
        tools:layout_editor_absoluteY="317dp" />

</androidx.constraintlayout.widget.ConstraintLayout> 
```

## 四、实验结果

![实验结果](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/lab3.png)


## 五、实验心得
  通过本次实验，我学习了如何在Android APP上配置相关的布局资源， 掌握在Android应用中使用图片等资源的方法，并在实验中，为自己的APP添加了自己的背景图片。
