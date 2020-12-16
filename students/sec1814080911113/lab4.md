# 实验四 Android界面设计编程

## 一、实验要求

+ 根据选题要求设计界面布局及控件使用；
+ 布局xml及界面控制操作代码提交并截图；
+ 将应用运行结果截图。

## 二、实验内容

+ 使用一种布局方式，设计界面，在这里我选择了constrainlayout（约束布局）；
+ 通过控件ID获取界面对象，执行相关操作；
+ 实现界面控件的事件处理，例如点击按钮。

## 三、实验步骤

1. 在activity_main.xml中设置首页，首页使用constrainlayout布局，设置layout_width，layout_height，gravity等等来设置页面布局。

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Sec1814080911113Activity">

    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:shadowColor="@color/black"
        android:text="本地音乐"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.05"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.023" />


    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="分享"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.95"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.036" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="下一曲"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.965"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.856" />

    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="暂停播放"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.856"
         />

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="上一曲"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.049"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.856" />

    <ImageView
        android:layout_width="171dp"
        android:layout_height="147dp"
        android:foregroundGravity="center"
        android:src="@drawable/qqmusic"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.193" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

2. 设置我的音乐界面，在mymusic_activity.xml中设置页面布局

```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">


    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="进入本地音乐界面"
        android:textSize="24dp"
        tools:layout_editor_absoluteX="100dp"
        tools:layout_editor_absoluteY="333dp"
        />


</androidx.constraintlayout.widget.ConstraintLayout>
```

3. 通过控件ID来获取界面对象并执行相关操作，并实现控件事件的处理，例如点击按钮等。

在Sec1814080911113Activity.java中加入以下内容

```
package edu.hzuapps.androidlabs.sec1814080911113;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class Sec1814080911113Activity extends AppCompatActivity {
    private Button button;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        Intent intent = new Intent(Sec1814080911113Activity.this, MymusicActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.button2:
                        Intent intent1 = new Intent(Sec1814080911113Activity.this, ShareActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.button3:
                        break;
                    case R.id.button4:
                        break;
                }
            }
        };

        button =findViewById(R.id.button1);
        button.setOnClickListener(onClickListener);

        button =findViewById(R.id.button2);
        button.setOnClickListener(onClickListener);

        button =findViewById(R.id.button3);
        button.setOnClickListener(onClickListener);

        button =findViewById(R.id.button4);
        button.setOnClickListener(onClickListener);


    }
}
```

## 四、实验结果

<img src="https://github.com/BlaiseChin/android-labs-2020/blob/master/students/sec1814080911113/lab4/localmusic.PNG">

<img src="https://github.com/BlaiseChin/android-labs-2020/blob/master/students/sec1814080911113/lab4/main.PNG">

## 五、实验心得
本次实验为Android中的界面设计编程，通过本次实验对布局的学习，我学会了几种布局及其概念和使用方法，使得我的APP更加完美和美观了。
