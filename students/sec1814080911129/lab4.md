# 实验四

## 一、实验目标

1、根据选题要求设计界面布局及控件使用；

2、布局xml及界面控制操作代码提交并截图；

3、将应用运行结果截图。

## 二、实验内容

1、使用一种布局方式设计界面；

2、通过控件ID获取界面对象，执行相关操作：

3、实现界面控件的事件处理;

4、操作之后，切换到第二个界面。

## 三、实验步骤

1、主界面采用LinearLayout布局，主要设置了两个按钮；

2、按钮添加事件监听器实现界面跳转；



## 四、实验结果

activity_main.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Sec1814080911129Activity">

    <LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="409dp"
        android:layout_height="354dp"
        android:layout_marginStart="1dp"
        android:layout_marginTop="4dp"
        android:layout_marginEnd="1dp"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView">

        <Button
            android:id="@+id/taxB"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="tax" />

        <Button
            android:id="@+id/tranB"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="tran" />
    </LinearLayout>

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

</androidx.constraintlayout.widget.ConstraintLayout>
```

tax.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/q20201122173515"
        tools:layout_editor_absoluteX="16dp"
        tools:layout_editor_absoluteY="579dp" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Tax"
        tools:layout_editor_absoluteX="31dp"
        tools:layout_editor_absoluteY="30dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

tran.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/q20201122173515"
        tools:layout_editor_absoluteX="7dp"
        tools:layout_editor_absoluteY="646dp" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="TextView"
        tools:layout_editor_absoluteX="40dp"
        tools:layout_editor_absoluteY="104dp" />
</androidx.constraintlayout.widget.ConstraintLayout>
```


![主页](https://github.com/hzuapps/android-labs-2020/blob/master/students/sec1814080911129/lab4.png)

![切换页面](https://github.com/hzuapps/android-labs-2020/blob/master/students/sec1814080911129/Sec1814080911129.png)

## 五、实验心得

这次实验主要是把布局改为相对布局和约束布局，难度不是很大，但设置了布局后界面会乱，需要再设置一个约束布局，调整相应的位置，使显示的界面和之前差不多。