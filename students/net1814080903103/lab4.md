# 实验四
## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容

1. 选择布局方式布局界面中的控件；
2. 通过控件ID获取界面对象，执行相关操作；
3. 完善选题功能，实现界面控件的事件处理。

## 三、实验步骤

1. 在主界面中使用LinearLayout布局，布局两个按钮的位置；
```xml
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:orientation="vertical">

    <TextView
        android:id="@+id/clock_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableBottom="@drawable/clock" />


    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:orientation="horizontal">

    <Button
        android:id="@+id/button_clock"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="设置闹钟"
        android:layout_marginLeft="50dp"
        android:layout_marginTop="100dp"/>

    <Button
        android:id="@+id/button_reckon"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="计时"
        android:layout_marginLeft="60dp"
        android:layout_marginTop="100dp"/>
        </LinearLayout>
    </LinearLayout>
```
2. 在activity_clock.xml中使用LinearLayout，布局一个图片，设置按钮位置；
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:orientation="vertical"
        android:background="@drawable/timg">

    <Button
        android:id="@+id/clock_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="添加闹钟"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="300dp"/>

    <Button
        android:id="@+id/return_button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="返回"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="70dp"/>
    </LinearLayout>
```
3. 在activity_reckon.xml中使用LinearLayout，设置按钮位置。
```xml
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:orientation="vertical"
        android:background="@drawable/reckon">

    <Button
        android:id="@+id/start_btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="开始计时"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="300dp"/>

    <Button
        android:id="@+id/return_btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="返回"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="70dp" />
    </LinearLayout>
```
## 四、实验结果

![主界面](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab2.png)
![次界面](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab3.png)
![次界面](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab4.png)

## 五、实验心得体会
本次实验学会了关于线性布局以及相对布局的知识，并且再实验中运用这方面的知识和显示出自己想要的效果。
