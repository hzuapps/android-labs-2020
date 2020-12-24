# 实验三


## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

1. 在界面上显示至少一张图片；
2. 点击图片（或按钮）时，打开另一个Activity。


## 三、实验步骤

1.先将背景图放在drawable里面

2.在activity_main.xml里插入背景图

  ```java
<RelativeLayout 
android:background="@drawable/background" 
android:paddingTop="230dp" 
android:orientation="vertical" 
android:paddingRight="100dp" 
android:paddingLeft="100dp" 
android:layout_height="match_parent" 
android:layout_width="match_parent" 
xmlns:android="http://schemas.android.com/apk/res/android">


<LinearLayout 
android:orientation="vertical" 
android:layout_height="match_parent" 
android:layout_width="match_parent">

<Button 
android:background="#00000000" 
android:layout_height="wrap_content" 
android:layout_width="match_parent" 
android:textColor="@android:color/holo_red_dark" 
android:text="Start Game" 
android:id="@+id/button1"/>

<Button
android:background="#00000000" 
android:layout_height="wrap_content" 
android:layout_width="match_parent" 
android:textColor="@android:color/holo_red_dark" 
android:text="Rank" android:id="@+id/button2"/>

</LinearLayout>

</RelativeLayout>
  
3.在activity_rank.xml里面插入背景图

  ```java
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/rank_backgroud"
    >
    <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </ListView>


</LinearLayout>

4、实现跳转

  ```java
  package edu.hzuapps.androidlabs.sec1814080911230;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.hzuapps.androidlabs.sec1814080911230.R;
public class Sec1814080911230Activity extends AppCompatActivity  {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final Activity thisActivity = this;
            Button btnOpen = (Button) findViewById(R.id.button1);
            View view = findViewById(R.id.button1);
            btnOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(thisActivity, StartGameActivity.class);
                    thisActivity.startActivity(intent);
                    //thisActivity.startActivityForResult(intent, 2016);
                }
            });

            Button btnOpen1 = (Button) findViewById(R.id.button2);
            View view1 = findViewById(R.id.button2);
            btnOpen1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    Intent intent = new Intent(thisActivity, RankActivity.class);
                    thisActivity.startActivity(intent);
                    //thisActivity.startActivityForResult(intent, 2016);
                }
            });

        }
    }


## 四、实验结果
![主界面](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab3(1).png)
![rank界面](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab3(2).png)
  
  
## 五、实验心得体会
  本次实验主要是给界面加了背景图，然后调整了一下按钮的位置，让整体界面更加美观舒服，包括跳转后的界面也插入了背景图。

