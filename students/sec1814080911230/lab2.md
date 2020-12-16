# 实验二

## 一、实验目标

1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；

2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；

3.将标题设置为自己的学号+对应的功能或题目；

4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。


## 二、实验内容

1.创建自己的安卓项目题目————打字游戏

2.根据自选题在Android Studio中创建3个Activity，分别为Sec1814080911230Activity、StartGameActivity、RankActivity

3.实现一个Activity与另一个Activity之间的跳转（显式或隐式）


## 三、实验步骤

先在Sec1814080911230Activity中：

package edu.hzuapps.androidlabs.sec1814080911230;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import edu.hzuapps.androidlabs.sec1814080911230.R;
public class Sec1814080911230Activity extends AppCompatActivity {

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

然后在对应的activity_main.xml文件里面:

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="100dp"
    android:paddingRight="100dp"
    android:orientation="vertical"
    android:paddingTop="230dp"
    >

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    <Button
        android:id="@+id/button1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Start Game"
        android:background="#00000000"
        android:textColor="@android:color/holo_red_dark"
        />
    <Button
        android:id="@+id/button2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Rank"
        android:background="#00000000"
        android:textColor="@android:color/holo_red_dark"
        />
</LinearLayout>

    />

    ></RelativeLayout>
    

## 四、实验结果

![lab2.1](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab2%20%E6%88%AA%E5%9B%BE1.png)
![lab2.2](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab2%20%E6%88%AA%E5%9B%BE2.png)


## 五、实验心得

  这次实验比实验一复杂一些，开始接触到写代码了，实验中给我的app加了两个按钮触发键，能进行跳转，这个是本次实验最重要的一环，其中app里面的布局是下一次实验的内容，
在本次中也有给我的按钮进行了一些简单布局。
