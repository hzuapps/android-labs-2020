# 实验二：Android组件编程

## 一、实验要求

1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3.将标题设置为自己的学号+对应的功能或题目；
4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

## 三、实验步骤


创建 Sec1814080911133Activity、KnwActivity、TemActivity；
在布局文件中创建 Button 组件；
为 Button 添加点击事件处理；
通过 Sec1814080911133Activity 实现界面跳转

```java
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
```

```java
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
```

```java
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
```



将创建的 Activity 注册到 AndroidManifest.xml 中；

```<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Sec1814080911133Activity">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="100dp"
        android:layout_marginLeft="100dp"
        android:layout_marginTop="236dp"
        android:background="@android:color/transparent"
        android:text="Tem"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="236dp"
        android:layout_marginEnd="116dp"
        android:layout_marginRight="116dp"
        android:background="@android:color/transparent"
        android:text="Knw"
        android:textSize="14sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/main"
        android:scaleType="fitXY"
        android:text="健康助手"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## 四、实验结果及截图

![实验2图片]https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab2_res.png


## 五、实验心得

本次实验主要的内容是做跳转的按钮，通过创建了项目，在项目中创建各个功能的activity，并且实现了跳转逻辑，通过findViewById()获得按钮，使用按钮onclick方法触发跳转，感觉挺有趣的。