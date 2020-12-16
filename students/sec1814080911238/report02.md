# 实验二 Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 创建自己的安卓项目选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤

1. 打开Android Studio，在Sec1814080911238\app\src\main\java\edu\hzuapps\androidlabs\sec1814080911238下新建 3 个 Activity<br>
    + app首页Activity：Sec1814080911238Activity.java<br>
    + 录入单词页面Activity：RememberActivity.java<br>
    + 背单词页面Activity：InputActivity.java<br>


2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转

    在 Sec1814080911238Activity.java 添加按钮点击事件处理,分别跳转到RememberActivity.java和InputActivity.java，实现Activity之间的跳转
```java
package edu.hzuapps.androidlabs.sec1814080911238;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sec1814080911238Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911238_activity);
        final Activity thisActivity = this;
        Button btnOpen = (Button) findViewById(R.id.button1);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,RememberActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        Button btnOpen2 = (Button) findViewById(R.id.button2);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,InputActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
```

## 四、实验结果

![实验结果](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab2-1.png?raw=true)

## 五、实验心得
本次实验，第一次接触到了Android页面之间的一个简单的跳转，在做实验的过程中，按照老师给的示例页面的跳转实现比较容易，但在实现排班布局的时候发现了自己的不足，期待下节课老师给我们讲解如何在Android上进行排版布局。
