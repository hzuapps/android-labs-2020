# 实验三

## 一、实验目标

1.了解Android应用中各种资源的概念与使用方法；

2.掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

1.在界面上显示至少一张图片（按照自己的题目添加）；

2.提交res/drawable及图片使用的代码；

3.提交res/values, res/layout等其他代码；

4.将应用运行结果截图，放到实验报告中；

5.点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

1.将图片放到res下的drawable文件夹

2. 在splash_activity.xml插入启动页面的图片

```
    <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/infomationbackground" />
```

6. 打开另外一个Activity

```
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.video);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Net1814080903310Activity.this,PlayVideo18148080903310Activity.class);
                startActivity(intent);
            }
        });

        button1 = (Button)findViewById(R.id.info);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903310Activity.this,Information1814080903310Activity.class);
                startActivity(intent);
            }
        });
```

## 四、实验结果

```
activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:id="@+id/linearLayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <Button
            android:id="@+id/info"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="我的" />

        <Button
            android:id="@+id/video"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="视频" />

        <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/infomationbackground" />
    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

```
Net1814080903310Activity

package edu.hzuapps.androidlabs.students.net1814080903310;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import edu.hzuapps.androidlabs.R;

public class Net1814080903310Activity extends AppCompatActivity {
    Button button = null;
    Button button1 =null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.video);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Net1814080903310Activity.this,PlayVideo18148080903310Activity.class);
                startActivity(intent);
            }
        });

        button1 = (Button)findViewById(R.id.info);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903310Activity.this,Information1814080903310Activity.class);
                startActivity(intent);
            }
        });
    }
}
```

## 五、实验心得
这次实验在主页上添加了一张图片，并且点击主页的按钮进行跳转。
实验结果图片：
https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/labs3.png
