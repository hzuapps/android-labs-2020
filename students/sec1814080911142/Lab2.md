# 实验二

## 一、实验目标

1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；

2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；

3.将标题设置为自己的学号+对应的功能或题目；

4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。


## 二、实验内容

1.创建自己的安卓项目题目————自动贩卖机

2.根据自选题在Android Studio中创建3个Activity，分别为Sec1814080911142Activity、PaymentActivity、RegisterActivity

3.实现一个Activity与另一个Activity之间的跳转（显式或隐式）


 ## 三、实验步骤

先在Sec1814080911142Activity中：

package edu.hzuapps.androidlabs.sec1814080911142;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class sec1814080911142Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final sec1814080911142Activity thisActivity= this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOpen1 = (Button) findViewById(R.id.button);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(String.valueOf(thisActivity.Register.class));
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.button2);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Payment.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }
} 
然后在对应的activity_main.xml文件里面:

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.sec1814080911142">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Register"/>
        <activity android:name=".Payment"/>
        <activity android:name=".sec1814080911142Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest> 
    

##  四、实验结果

![实验2图片]https://raw.githubusercontent.com/lxp99/android-labs-2020/master/students/sec1814080911142/lab2图片.png

## 五、实验心得

   这次实验中我们接触了更多跟Android开发相关的知识，我觉得这是我们真正意义上进入Android的学习，在这次实验中我们先是要在github平台上确定自己的
选题，并简单说明自己选题的功能，老师先帮我们看我们选题合不合格，然后决定通不通过，作为初次接触GitHub和Android，不仅是我，同学们也是遇到了很多
问题，一开始就总是碰壁，不过我们有建群，通过在群里询问老师和同学，以及在网上查询相关资料，终于将实验完成了，真的很感谢老师和同学的帮忙！
