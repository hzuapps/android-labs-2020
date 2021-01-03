# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

## 二、实验内容

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。r

   * LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)
   * 本实验使用了LinearLayout

## 三、实验步骤

在sec_1814080911224_activity.xml中,选择 LinearLayout界面，在Layouts拉一个垂直的LinearLayout，作为一个大布局，然后在大布局中放一个水平的LinearLayout,其余两个xml类似。

sec_1814080911224_activity.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".sec1814080911224Activity"
    android:background="@drawable/background">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="358dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <Button
            android:id="@+id/draw_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="洗牌"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="40dp"/>

        <Button
            android:id="@+id/shuffle_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="比大小"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="80dp"/>
    </LinearLayout>

</LinearLayout>
```

activity_draw.xml代码如下 ：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ShuffleActivity">

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/draw"
        android:paddingLeft="0dp"
        android:paddingTop="0dp"
        android:text="  洗牌" />

    <LinearLayout
        android:layout_width="500dp"
        android:layout_height="724dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="6dp">

        <Button
            android:id="@+id/draw_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="洗牌"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="40dp"/>

        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="80dp"
            android:text="返回" />
    </LinearLayout>

</LinearLayout>
```

activity_shuffle.xml代码如下:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ShuffleActivity">

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/shuffle"
        android:text="比大小"
        android:paddingLeft="0dp"
        android:paddingTop="0dp"/>

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="724dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="6dp">

        <Button
            android:id="@+id/shuffle_btn_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="比大小"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="40dp"/>

        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="80dp"
            android:text="返回" />
    </LinearLayout>


</LinearLayout>
```

## 四、实验结果及截图

![tp1](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab4.PNG)

![tp2](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab4-1.PNG)

![tp3](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab4-2.PNG)



## 五、实验心得

本次实验使用了LinearLayout布局，在上次实验的基础将图片及按钮进行了匹配，使得页面更加好看。