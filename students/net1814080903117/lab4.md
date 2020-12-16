# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

## 二、实验内容

1. 使用其中一种布局方式，**设计所选题目的界面**，建议用LinearLayout。

   * LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)

## 三、实验步骤

在activity_net1814080903117.xml中,选择 Design 界面，在Layouts拉一个垂直的LinearLayout，作为一个大布局，然后在大布局中放一个水平的LinearLayout,其余两个xml类似。

![实验四图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab4(1).png)

activity_net1814080903117.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903117Activity"
    android:background="@drawable/bg">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="358dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <Button
            android:id="@+id/up_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="上传文件"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="70dp"/>

        <Button
            android:id="@+id/down_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="下载文件"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="85dp"/>
    </LinearLayout>

</LinearLayout>
```

activity_download.xml ：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".DownloadActivity">

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/download"
        android:text="  文件下载"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="724dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="6dp">

        <Button
            android:id="@+id/down_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="文件下载"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="90dp"/>

        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="50dp"
            android:text="返回" />
    </LinearLayout>

</LinearLayout>
```

activity_upload.xml:

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".UploadActivity">

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/upload"
        android:text="  文件上传"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="724dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="6dp">

        <Button
            android:id="@+id/up_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="文件上传"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="90dp"/>

        <Button
            android:id="@+id/main_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="50dp"
            android:text="返回" />
    </LinearLayout>


</LinearLayout>
```

## 四、实验结果及截图

![实验四图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab4(2).png)

![实验四图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab2(1).png)

![实验四图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab2(2).png)

![实验四图片](https://github.com/Cloudtq/android-labs-2020/raw/master/students/net1814080903117/lab2(3).png)