# 实验二

## 一、实验目标

1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；

2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；

3.将标题设置为自己的学号+对应的功能或题目；

4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。


## 二、实验内容

1.创建自己的安卓项目题目————健康助手

2.根据自选题在Android Studio中创建3个Activity，分别为Sec1814080911133Activity、KnwActivity、TemActivity

3.实现一个Activity与另一个Activity之间的跳转（显式或隐式）

##  三、实验步骤

1.Sec1814080911133Activity：
package edu.hzuapps.androidlabs.sec1814080911133;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
public class Sec1814080911133Activity extends AppCompatActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
Button Tem = (Button)findViewById(R.id.button);
Tem.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent intent = new Intent(Sec1814080911133Activity.this,TemActivity.class);
startActivity(intent);
}
});
Button Knw = (Button)findViewById(R.id.button2);
Knw.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
Intent intent = new Intent(Sec1814080911133Activity.this,KnwActivity.class);
startActivity(intent);
}
});
}
}

2.KnwActivity:
package edu.hzuapps.androidlabs.sec1814080911133;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KnwActivity extends AppCompatActivity{
@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_knw);

Button返回=(Button)findViewById(R.id.button3);
返回.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View view){
Intent intent=new Intent(KnwActivity.this,Sec1814080911133Activity.class);
startActivity(intent);
}
});
}
}

3.TemActivity:
package edu.hzuapps.androidlabs.sec1814080911133;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TemActivity extends AppCompatActivity{
@Override
protected void onCreate(Bundle savedInstanceState){
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_tem);

Button点击记录=(Button)findViewById(R.id.button4);
点击记录.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View view){
Intent intent=new Intent(TemActivity.this,TActivity.class);
startActivity(intent);
}
});
Button返回=(Button)findViewById(R.id.button5);
返回.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View view){
Intent intent=new Intent(TemActivity.this,Sec1814080911133Activity.class);
startActivity(intent);
}
});

Button查看记录=(Button)findViewById(R.id.button8);
查看记录.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View view){
Intent intent=new Intent(TemActivity.this,T2Activity.class);
startActivity(intent);
}
});
}
}

 ## 四、实验结果

![实验2图片]
https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab2_res.png
## 五、实验心得

   这次实验中我们接触了更多跟Android开发相关的知识，在这次实验中先是在Issues中创建自己的选题，根据自选题目，编写一个或多个Activity
，将标题设置为自己的学号+对应的功能或题目，并根据自己选择的题目实现Activity中导航、调用等功能（选做），一开始不会做，后面在同学的帮助下，完成了此次实验。