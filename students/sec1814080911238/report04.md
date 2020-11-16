# 实验四 Android界面设计编程

## 一、实验要求

- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图；

## 二、实验内容

- 在所学的几种布局方式中自行选择设计界面；
- 通过findViewById获取界面对象，执行相关操作；
- 实现界面控件的事件处理；


## 三、实验步骤
1. APP首页使用LinearLayout进行布局，在LinearLayout容器中，通过设置layout_height、layout_marginTop、layout_marginBottom、gravity等，来进行组件首页组件布局
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/mini_home"
    tools:context=".Sec1814080911238Activity"
    android:orientation="vertical">
    <TextView
        android:id="@+id/textView"
        android:layout_width="fill_parent"
        android:layout_height="30dp"
        android:layout_marginTop="240dp"
        android:layout_marginBottom="0dp"
        android:gravity="center"
        android:text="\@Author：毛毛" />
    <Button
        android:id="@+id/button1"
        android:layout_width="280dp"
        android:layout_height="50dp"
        android:layout_gravity="center"
        android:layout_marginTop="40dp"
        android:background="@color/btnColor"
        android:text="开始背单词"
        android:textColor="@color/textColor"/>
    <Button
        android:id="@+id/button2"
        android:layout_width="280dp"
        android:layout_height="50dp"
        android:layout_gravity="center"
        android:layout_marginTop="30dp"
        android:background="@color/btnColor"
        android:text="录入单词"
        android:textColor="@color/textColor" />
</LinearLayout>
```

2. 在背单词列表中，用到了列表，将页面中的列表以单个组件的形式封装成一个新的组件list_item.xml
``` java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="wrap_content"
    >
        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical">
            <TextView
                android:id="@+id/textView1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="left"
                android:text="卤蛋"
                android:textSize="20sp" />
            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginBottom="10dp"
                android:text="Marinated Egg"
                android:textSize="16sp" />
        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
            <Button
                android:id="@+id/button"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="right"
                android:background="@color/btnColor"
                android:text="记住了" />
        </LinearLayout>
</LinearLayout>
```

3. 使用ScrollView容器，包裹列表，实现滚动效果
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg">
    <ScrollView
        android:id="@+id/vertical_scroll_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
            <include layout="@layout/list_item" />
        </LinearLayout
    </ScrollView>
</LinearLayout>
```
       

## 四、实验结果
![首页](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab4-1.png?raw=true)
![背单词列表页](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab4-2.png?raw=true)
![录入单词页](https://github.com/Arlene238/android-labs-2020/blob/master/students/sec1814080911238/lab4-3.png?raw=true)

## 五、实验心得
 本次实验，对APP的整体页面的布局做了一个合理美观的布局，同时自主学习了组件的封装和组件与组件之间的调用，对ScrollView滚动容器也有了很好的理解。
