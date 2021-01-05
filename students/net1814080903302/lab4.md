# 实验四

## 一、实验目标

1、根据选题要求设计界面布局及控件使用；

2、布局xml及界面控制操作代码提交并截图；

3、将应用运行结果截图。

## 二、实验内容

1、使用一种布局方式设计界面；

2、通过控件ID获取界面对象，执行相关操作：

3、实现界面控件的事件处理;

4、操作之后，切换到第二个界面。

## 三、实验步骤

1、主界面采用LinearLayout布局，主要设置了两个按钮；

2、按钮添加事件监听器实现界面跳转；

3、录音机的全部界面采用约束布局；

## 四、实验结果

activity_net1814080903302.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903302Activity"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:gravity="center">

        <ImageView
            android:layout_width="70dp"
            android:layout_height="90dp"
            android:src="@drawable/luyinji" />

        <TextView
            android:layout_width="98dp"
            android:layout_height="81dp"
            android:layout_marginTop="20dp"
            android:text="录音机"
            android:textSize="32dp" />
    </LinearLayout>


    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="bottom">

        <Button
            android:id="@+id/startluyin"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="65dp"
            android:text="开始录音" />

        <Button
            android:id="@+id/luyinline"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="65dp"
            android:text="录音列表" />
    </LinearLayout>

</LinearLayout>
```

recording_line_activity.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="bottom"
    tools:context=".Net1814080903302Activity">

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="暂停录音"
        android:layout_marginLeft="65dp"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="停止录音"
        android:layout_marginLeft="65dp"/>

</LinearLayout>
```

start_recording_activity.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Net1814080903302Activity">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="已保存的录音:"
        android:textSize="25dp"
        android:textColor="@android:color/black" />

    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="left"
        android:textSize="25dp"
        android:text="录音1" />
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="left"
        android:textSize="25dp"
        android:text="录音2" />

</LinearLayout>
```
![初始界面](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab4_1.jpg)

![点击开始后](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab4_2.jpg)

![进入录音列表](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab4_3.jpg)

## 五、实验心得

这次实验主要是把布局改为相对布局和约束布局，难度不是很大，但设置了布局后界面会乱，需要再设置一个约束布局，调整相应的位置，使显示的界面和之前差不多。
