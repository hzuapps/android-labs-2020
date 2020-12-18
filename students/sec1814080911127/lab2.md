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

1. 打开Android Studio，在Sec1814080911127\app\src\main\java\edu\hzuapps\androidlabs\sec1814080911127下新建 3 个 Activity<br>
    + app首页Activity：Sec1814080911127Activity.java<br>
    + 搜索页面Activity:SearchActivity.java<br>
    + 添加页面Activity:AddActivity.java<br>

2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转

    在 Sec1814080911127Activity.java 添加按钮点击事件处理,跳转到SearchActivity.java，AddActivity.java，实现Activity之间的跳转

```java
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911127Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911127);

        Button addButton = (Button) findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sec1814080911127Activity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        Button searchButton = (Button) findViewById(R.id.button2);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sec1814080911127Activity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

    }
}
```
## 四、实验结果
![实验结果](https://github.com/Dokemg/android-labs-2020/blob/master/students/sec1814080911127/lab2.PNG)
## 五、实验心得
通过本次实验，学习了在Android项目中创建Activity，并且利用按键实现Android页面之间的一个简单跳转。
