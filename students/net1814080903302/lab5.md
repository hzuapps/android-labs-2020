# 实验五

## 一、实验目标

1、了解Andoid的存储手段

2、掌握Android的文件存储

3、掌握Android的数据库存储

## 二、实验内容

1、将应用产生的数据保存到文件存储中；

2、文件存储方式：内部；

3、将运行结果截图。

## 三、实验步骤

1、主界面采用LinearLayout布局，主要设置了两个按钮；

2、按钮添加事件监听器实现界面跳转；

3、录音机的全部界面采用约束布局；

## 四、实验结果

activity_net1814080903302.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903302Activity"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:gravity="center">

        <ImageView
            android:layout_width="70dp"
            android:layout_height="90dp"
            android:src="@drawable/luyinji" />

        <TextView
            android:layout_width="98dp"
            android:layout_height="81dp"
            android:layout_marginTop="20dp"
            android:text="录音机"
            android:textSize="32dp" />
    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="bottom">

        <Button
            android:id="@+id/startluyin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="20dp"
            android:text="开始录音" />

        <Button
            android:id="@+id/luyinline"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="20dp"
            android:text="录音列表" />

        <Button
            android:id="@+id/lab5"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="20dp"
            android:text="实验5"/>
    </LinearLayout>

</LinearLayout>
```

lab5_activity.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Net1814080903302Activity">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="保存录音"
        android:layout_gravity="center"
        android:textSize="30dp"/>
    <EditText
        android:id="@+id/titles"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text=""/>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="bottom">
        <Button
            android:id="@+id/baocun"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="50dp"
            android:onClick="save"
            android:text="保存"/>
        <Button
            android:id="@+id/quxiao"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="50dp"
            android:text="取消"/>
    </LinearLayout>

</LinearLayout>
```

Lab5.java
```
package edu.hzuapps.myapplication0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Lab5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lab5_activity);
    }

    public void save(View view) {
        String filename = "myfile";
        String string = "Hello world!";
        File file = new File(getFilesDir(), filename);
        FileOutputStream outputStream;
        try {
            file.createNewFile();
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

![实验五截图](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab5.jpg）

## 五、实验心得
这次实验对我来说非常难，虽然我参考了老师和别的同学的代码和网上的相关代码试图模仿来做，但和我做的内容差距很大，而且我Java基础差，所以这次实验没运行成功，不过以后需要改进一下。
