# 实验二

## 一、实验目标

1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；

2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；

3.将标题设置为自己的学号+对应的功能或题目；

4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1.创建自己的安卓项目选题；

2.根据自选题在Android Studio中创建一个或多个Activity；

3.实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤

1. 创建 2-3 个 Activity

2. Net1814080903304Activity.java (首页、LAUNCHER、主活动)：Net1814080903213Activity.java

3.功能1Activity.java：Funtion_Next.java

4.功能2Activity.java：Funtion_Setting.java

## 四、实验结果
Net1814080903304Activity.java
~~~
package hzu.android.labs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903304Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Net1814080903304Activity thisActivity = this;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,funtion_next.class);
                startActivity(intent);
            }
        });


        final Net1814080903304Activity funtion_settingActivity = this;

        Button button12 = findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(funtion_settingActivity,funtion_setting.class);
                startActivity(intent);
            }
        });


    }

~~~
AndroidManifest.xml
~~~
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="hzu.android.labs">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".funtion_setting"></activity>
        <activity android:name=".funtion_next" />
        <activity android:name=".Net1814080903304Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
~~~
Funtion_Next.java 
~~~
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtion_next);

        final Funtion_Next thisActivity = this;

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Net1814080903304Activity.class);
                startActivity(intent);
            }
        });

~~~
Funtion_Setting.java 
~~~
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtion_setting);

        final Funtion_Setting thisActivity = this;

        Button button13 = findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Net1814080903304Activity.class);
                startActivity(intent);
            }
        });
~~~

## 五、实验心得
	本次实验是主要进行的是，通过按钮这个组件实现界面跳转，在上课的时候有进行过实验展示，所以课后花费时间花费较少，也能够做出来。
