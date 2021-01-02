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

2. Net1814080903310Activity.java (首页、LAUNCHER、主活动)：Net1814080903310Activity.java

3.功能1Activity.java：Information1814080903310Activity

4.功能2Activity.java：PlayVideo18148080903310Activity

## 四、实验结果

```
Net1814080903310Activity.java

package edu.hzuapps.androidlabs.students.net1814080903310;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903310Activity extends AppCompatActivity {

    //@Override
    protected void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.see);
        final Net1814080903310Activity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, Information1814080903310Activity.class);
                _this.startActivity(intent);
            }
        });
    }

    private void startActivity(Intent intent) {
    }
}
```

```
AndroidManifest.xml

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".students.net1814080903310.PlayVideo18148080903310Activity"></activity>
        <activity android:name=".students.net1814080903310.Information1814080903310Activity" />
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

Information1814080903310Activity

package edu.hzuapps.androidlabs.students.net1814080903310;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Information1814080903310Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1814080903310);
    }
}
```

```
PlayVideo18148080903310Activity

package edu.hzuapps.androidlabs.students.net1814080903310;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PlayVideo18148080903310Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first18148080903310);
    }
}
```

## 五、实验心得
这次实验做的是在Activity上添加按钮，来实现Activity之间的跳转。就是在app里面点击按钮来实现页面跳转。
实验结果图片：
https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/labs2.png
