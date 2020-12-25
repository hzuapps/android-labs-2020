# 实验二：Android组件编程

## 一、实验要求

1. 在Issues中创建自己的选题：[https://github.com/hzuapps/android-labs-2020/issues](https://github.com/hzuapps/android-labs-2020/issues) ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

## 三、实验步骤


创建 MainActivity(主界面)、QueryFuntion(处理垃圾查询的界面)

在布局文件中创建 Button 组件；

为 Button 添加点击事件处理；

通过 startActivity(Intent) 实现界面跳转



```java
package edu.hzuapps.androidlabs.net1814080903313;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903313Activity extends AppCompatActivity {
    private Button mBtA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtA2 = findViewById(R.id.button);
        mBtA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903313Activity.this,Activity2.class);
                startActivity(intent);
            }
        });
    }
}
```

```java
package edu.hzuapps.androidlabs.net1814080903313;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QueryFunction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }
}
```



将创建的 Activity 注册到 AndroidManifest.xml 中；

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.net1814080903313">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Activity2"></activity>
        <activity android:name=".Net1814080903313Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
© 2020 GitHub, Inc.
```

## 四、实验结果及截图




## 五、实验心得
  本次实验主要是创建一个按钮，并通过点击该按钮来实现页面跳转的功能，主要过程是，先在主布局文件中创建一个按钮，并配置好按钮的样式，然后在主界面的Java代码中获取按钮对象，并创建一个意图，重写
按钮对象的onclilk方法:调用startActivity方法并传入一个intent对象，从而完成按钮跳转的功能。
