# 实验二 Android组件编程

## 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

## 二、实验内容

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 三、实验步骤

1. 打开Android Studio，在Net1814080903135\app\src\main\java\edu\hzuapps\androidlabs\net1814080903135下新建2个 Activity
    + 查询界面Activity：Queryinterface1814080903135Activity.java <br>
    + 买票界面Activity：Buyingtickets1814080903135Activity.java <br>


2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转

    在 Net1814080903135Activity.java 添加按钮点击事件处理,跳转到Buyingtickets1814080903135Activity.java，实现Activity之间的跳转

```java
package edu.hzuapps.androidlabs.net1814080903135;

import androidx.appcompat.app.AppCompatActivity;
    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;

public class Net1814080903135Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        final Net1814080903135Activity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, Buyingtickets1814080903135Activity.class);
                _this.startActivity(intent);
            }
        });
    }
}
```
## 四、实验结果
![实验结果](https://github.com/clinying/android-labs-2020/blob/master/students/net1814080903135/lab2-1.png)
![实验结果](https://github.com/clinying/android-labs-2020/blob/master/students/net1814080903135/lab2-2.png)
## 五、实验心得
通过本次实验，学习了在Android项目中创建Activity，并且利用按键实现Android页面之间一个简单跳转，在实验过程中，遇到了一点问题，但通过查看老师给的相关教程，成功完成了实验。
