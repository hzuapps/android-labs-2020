# 实验二 Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues/76 ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 创建自己的安卓项目选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤

1. 打开Android Studio，在Net1814080903334\app\src\main\java\edu.hzuapps.androidlabs.net1814080903334下新建 2 个 Activity<br>
    + app首页Activity：Net1814080903334Activity.java<br>
    + 主界面Activity：Win2Activity.java<br>


2. 在 Net1814080903334Activity.java 添加按钮点击事件处理,跳转到Win2Activity.java，实现Activity之间的跳转
```java
package edu.hzuapps.androidlabs.net1814080903334;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903334Activity extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.win2_button);
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Net1814080903334Activity.this , Win2Activity.class);
            startActivity(intent);
    }
});
    }
}

package edu.hzuapps.androidlabs.net1814080903334;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Win2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win2);
    }
}
```

## 四、实验结果

+ <br>
![主界面](https://github.com/book-ccr/android-labs-2020/blob/master/students/net1814080903334/AD2.png)

+ <br>
![跳转界面](https://github.com/book-ccr/android-labs-2020/blob/master/students/net1814080903334/AD4.png)


## 五、实验心得
这是Android的第二次实验，实验的主要内容是让我们在Android的页面上设置一个简单的跳转。我是通过按钮的形式，点击按钮触发事件从而达到跳转的效果。感觉达到了最基本的实验要求但设置的界面还可以调整很多。
