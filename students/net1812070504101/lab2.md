# 实验二:Android 组件编程

## 一.实验要求
在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；  
根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；  
将标题设置为自己的学号+对应的功能或题目；  
根据自己选择的题目实现Activity中导航、调用等功能（选做）。  

## 二.实验内容
1. 根据选题功能创建相应的Activity
2. 编写Activity 对应的布局文件
3. 实现页面之间的跳转  


## 三.实验步骤
1.创建主界面，考勤界面  
2.添加页面组件Button  
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1812070504101Activity"
    android:background="@mipmap/bg"
    >

    <Button
        android:id="@+id/btnStastic"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        android:text="统计"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.081"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.851" />

    <Button
        android:id="@+id/btnCheck"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        android:text="考勤"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.908"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.851" />


</androidx.constraintlayout.widget.ConstraintLayout>
```
3.为组件添加事件处理，实现页面跳转  
```
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class Net1812070504101Activity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=findViewById(R.id.btnStastic);
        btn2=findViewById(R.id.btnCheck);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               Intent i =new Intent( Net1812070504101Activity.this, StatisticActivity.class);
               startActivity(i);
            }
       });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i =new Intent( Net1812070504101Activity.this, CheckActivity.class);
                startActivity(i);
            }
        });
    }
}
```
```
package edu.hzuapp.androidlabs.net1812070504101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
    }
}
```
```
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StatisticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
    }
}
```


## 四.实验结果


## 五.实验心得

本次实验开始使用 android实现一些较为简单的功能，在项目中创建选题相关的activity文件，通过findViewById()获得按钮，  
使用按钮onclick方法触发跳转，实验难度不大。

