# 实验二：

## 一、实验目标

1. 在Issues中创建自己的选题；
2. 根据自选题目，创建2-3个与自己选题有关的Activity;
3. 将标题设置为自己的学号+对应的功能;
4. 实现Activity间的跳转.

## 二、实验内容

1. 根据自己的选题功能，创建 2-3 个 Activity：
   Sec1814080911234Activity.java (首页、LAUNCHER、主活动)  
   功能1Activity.java  
   功能2Activity.java2.在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
3. 在Sec1814080911139Activity.java 添加按钮点击事件处理，实现页面的跳转。

## 三、实验步骤

1. 创建选题：语音阅读器 ；
2. 创建三个 Activity 分别是：
   Sec1814080911139Activity.java (首页）
   ShowActivity.java  
   VoiceActivity.java 
3. 在activity_sec1814080911234.xml上添加两个按钮，代码如下：
 ```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.k00.androidlabs.Sec1814080911139Acitivity">

    <Button
        android:id="@+id/bt1"
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:text="查看小说"/>


    <Button
        android:id="@+id/bt2"
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:text="开始阅读"
        android:layout_alignParentTop="true"
        android:layout_alignParentRight="true"
        android:layout_alignParentEnd="true" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="45dp"
        android:layout_below="@+id/bt2"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="205dp"
        android:text="A reader machine"
        android:textSize="20sp"
        android:textColor="#5e9cff"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:srcCompat="@drawable/bg1" />

</RelativeLayout>

 ```
4. 在Sec1814080911239Activity.java为按扭添加点击事件实现跳转，部分代码如下：
 ```
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911139_acitivity);
        final Activity thisActivity = this;

        Button bt1 = (Button) findViewById(R.id.bt1);

        View view1 = findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, ShowActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        Button bt2 = (Button) findViewById(R.id.bt2);

        View view2 = findViewById(R.id.bt2);

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, VoiceActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
 ```
## 四、实验结果

 ![实验二图1](https://github.com/xxak11234/android-labs-2020/blob/master/students/sec1814080911139/pt3.jpg?raw=true)；
 ![实验二图2](https://github.com/xxak11234/android-labs-2020/blob/master/students/sec1814080911139/pt4.jpg?raw=true)；
 ![实验二图3](https://github.com/xxak11234/android-labs-2020/blob/master/students/sec1814080911139/pt5.jpg?raw=true)；

## 五、实验心得体会

从本次的实验开始，我们就要给自己所确定的选题进行页面、功能等的添加，并且通过后续的一个个实验逐渐的完善自己的app。而实验二需要我们实现的就是在首页创建按钮并实现点击后跳转到其他页面，总的来说理解起来是比较简单的，用于实现的代码量也不多。
