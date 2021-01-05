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

1. 打开Android Studio，在Sec1814080911106\app\src\main\java\edu\hzuapps\androidlabs\sec1814080911106下新建 2 个 Activity<br>
    + app首页Activity：Sec1814080911106Activity.java<br>
    + 图片编辑页面Activity：EditActivity.java<br>


2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转

    在 Sec1814080911106Activity.java 添加按钮点击事件处理,跳转到EditActivity.java，实现Activity之间的跳转
    
```java
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
    public static void main(String[] args) {	public class Sec1814080911106Activity extends AppCompatActivity {
        System.out.println("hello world");	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Sec1814080911106Activity thisActivity = this;

        Button listBtn = (Button) findViewById(R.id.button_view);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,PictureActivity.class);
                startActivity(intent);
            }
        });

        Button clockBtn = (Button) findViewById(R.id.button_edit);
        clockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,EditActivity.class);
                startActivity(intent);
            }
        });
```

## 四、实验结果

![实验结果](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/lab2.png)

## 五、实验心得
通过本次实验，我学习了在Android项目中创建Activity，并且利用按键实现Android页面之间的一个简单跳转，在实验过程中，遇到了一点小问题，但通过查看老师给的相关教程，成功完成了实验。
