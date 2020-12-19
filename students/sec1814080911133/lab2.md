# 实验二

## 一、实验目标

1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；

2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；

3.将标题设置为自己的学号+对应的功能或题目；

4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。


## 二、实验内容

1.创建自己的安卓项目题目————健康助手

2.根据自选题在Android Studio中创建4个Activity，分别为Sec1814080911133Activity、KnwActivity、TemActivity

3.实现一个Activity与另一个Activity之间的跳转（显式或隐式）


##  三、实验步骤

先在Sec1814080911133Activity中：

package edu.hzuapps.androidlabs.sec1814080911133;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class Sec1814080911133Activity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Button Tem = (Button)findViewById(R.id.button);
            Tem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Sec1814080911133Activity.this,TemActivity.class);
                    startActivity(intent);
                }
            });

            Button Knw = (Button)findViewById(R.id.button2);
            Knw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Sec1814080911133Activity.this,KnwActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
然后在对应的activity_main.xml文件里面:

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Sec1814080911133Activity">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="100dp"
        android:layout_marginLeft="100dp"
        android:layout_marginTop="236dp"
        android:background="@android:color/transparent"
        android:text="Tem"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="236dp"
        android:layout_marginEnd="116dp"
        android:layout_marginRight="116dp"
        android:background="@android:color/transparent"
        android:text="Knw"
        android:textSize="14sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/main"
        android:scaleType="fitXY"
        android:text="健康助手"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>


 ## 四、实验结果

![实验2图片]
https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab2_res.png
## 五、实验心得

   这次实验中我们接触了更多跟Android开发相关的知识，在这次实验中先是在Issues中创建自己的选题，根据自选题目，编写一个或多个Activity
，将标题设置为自己的学号+对应的功能或题目，并根据自己选择的题目实现Activity中导航、调用等功能（选做），一开始不会做，后面在同学的帮助下，完成了此次实验。