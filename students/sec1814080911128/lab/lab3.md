# 实验三
## 一、实验目标 #

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容 #

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤 #

1. 在界面显示图片及按钮
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:tools="http://schemas.android.com/tools"
    tools:context=".MainActivity">

	 <Button
        android:layout_width="300dp"
        android:layout_height="450dp"
        android:text="按钮1" />
    <Button
        android:layout_width="200dp"
        android:layout_height="210dp"
        android:text="按钮2" />
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/bg"/>
</RelativeLayout>
```
2. 点击按钮进行跳转
```java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		final Sec1814080911128Activity thisActivity =this;
        myBtn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBtn_one.setText("按钮1已被点击，即将跳转");
				Intent intent =new Intent(thisActivity,NewsInfoActivity.class);
				thisActivity.startActivity(intent);
            }
        });
        myBtn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBtn_two.setText("按钮2已被点击，不跳转");
            }
        });
    }
```
3. 跳转结果
```java
package edu.hzuapps.myapplication;


import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/*
* 一个Activity代表一个页面
* */
public class MainActivity extends AppCompatActivity {

    /*
    * 当Activity第一次启动的时候执行
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        * 加载一个页面，页面内容来自于activity_main
        * */
        setContentView(R.layout.activity_main);
        //找到相关控件
        final TextView textView = (TextView)findViewById (R.id.tv);
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.rdg);
        //通过radiogroup来判断我们点击的是男还是女
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rbtn) {
                    textView.setText("你选择的是男");
                }else {
                    textView.setText("你选择的是女");
                }
            }
        });
    }
}
```

## 四、实验结果 #

![logo](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab3-1.png)
![跳转结果](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab3-2.png)
## 五、实验心得 #
通过本次实验，了解了Android应用中各种资源的概念与使用，掌握了在Android应用中使用图片等资源的方法。