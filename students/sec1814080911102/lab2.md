# 实验二 Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues/39 ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 创建自己的安卓项目选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤

1. 打开Android Studio，在Sec1814080911102\app\src\main\java\edu\hzuapps\androidlabs\sec1814080911102下新建 3 个 Activity<br>
    + app首页Activity：Sec1814080911102Activity.java<br>
    + 待办事项界面Activity：ListActivity.java<br>
    + 专注计时界面Activity：ClockActivity.java<br>


2. 在 Sec1814080911102Activity.java 添加按钮点击事件处理,分别跳转到ListActivity.java和ClockActivity.java，实现Activity之间的跳转
```java
package edu.hzuapps.androidlabs.sec1814080911102;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911102Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sec1814080911102Activity thisActivity = this;

        Button listBtn = (Button) findViewById(R.id.button_list);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ListActivity.class);
                startActivity(intent);
            }
        });

        Button clockBtn = (Button) findViewById(R.id.button_clock);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ClockActivity.class);
                startActivity(intent);
            }
        });
    }
}
```

## 四、实验结果

+ 按钮<br>
![lab2按钮](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab2%E6%8C%89%E9%92%AE.PNG)

+ 专注计时页面<br>
![lab2专注计时页面](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab2%E4%B8%93%E6%B3%A8%E8%AE%A1%E6%97%B6%E9%A1%B5%E9%9D%A2.PNG)

+ 待办事项页面<br>
![lab2待办事项页面](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab2%E5%BE%85%E5%8A%9E%E4%BA%8B%E9%A1%B9%E9%A1%B5%E9%9D%A2.PNG)


## 五、实验心得
通过本次实验，我学会了如何在多个Android页面之间设置一个简单的跳转，通过按钮的设置、按钮点击事件的设置可以达到这样的效果，其中按钮点击事件的设置需要花点功夫研究，界面、按钮的排版也还有进步空间。
