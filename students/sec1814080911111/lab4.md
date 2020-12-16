# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

# 二、实验内容

1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理;

# 三、实验步骤

1. 主界面采用LinearLayout布局，设置两个按钮,显示一张图片；
```java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Sec1814080911111Activity">
    
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:layout_gravity="top"
        android:src="@drawable/image" />
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:text="Thanks To Use!" />
    <Button
        android:id="@+id/timer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:text="计时器" />
    <Button
        android:id="@+id/countDown"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:text="倒计时" />
</LinearLayout>
```
2. 在Timer功能界面同样采用LinearLayout布局，添加一个Chronometer控件作为计时器
```java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".TimerActivity" >

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="计时器"
        android:textSize="50dp"
        android:layout_marginTop="200dp"
        android:layout_gravity="center_horizontal"
        />

    <Chronometer
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:textSize="30dp"
        />

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <Button
        android:id="@+id/startTime"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_vertical"
        android:layout_weight="1"
        android:text="开始计时" />

    <Button
        android:id="@+id/stopTime"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_vertical"
        android:layout_weight="1"
        android:text="停止计时" />
</LinearLayout>

</LinearLayout>
```

# 四、实验结果

![主界面](https://github.com/holenchan/android-labs-2020/blob/master/students/sec1814080911111/lab4.png)

# 五、实验心得体会
这次实验主要是界面的设计，使用了EditText、Chronometer来完善各个功能界面，各个界面仍然需要进一步改善，并对功能进行完善。
