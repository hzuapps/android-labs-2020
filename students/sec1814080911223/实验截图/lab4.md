# 实验四 Android界面设计编程

## 一、实验要求

- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图；

## 二、实验内容

- 在所学的几种布局方式中选择RelativeLayout设计界面；
- 通过findViewById获取界面对象，执行相关操作；
- 实现界面控件的事件处理；


## 三、实验步骤
1. APP首页使用RelativeLayout进行布局，在RelativeLayout容器中，通过设置layout_height、layout_marginTop、layout_marginBottom、gravity等，来进行组件首页组件布局
```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".KaiActivity">

    <Button
        android:id="@+id/button_begin"
        android:layout_width="137dp"
        android:layout_height="80dp"
        android:layout_centerInParent="true"
        android:drawableTop="@drawable/begin"
        tools:layout_editor_absoluteX="132dp"
        tools:layout_editor_absoluteY="313dp" />

    <TextView
        android:id="@+id/kai"
        android:layout_width="wrap_content"
        android:drawableTop="@drawable/kai"
        android:layout_height="wrap_content"
        tools:ignore="MissingConstraints" />
</RelativeLayout>
```

2. 在主界面中会有跳转页面到activity_kai.xml
``` java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".KaiActivity">

    <Button
        android:id="@+id/button_fen"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:layout_centerVertical="true"
        android:drawableLeft="@drawable/again"
/>

    <TextView
        android:id="@+id/beijing_2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/beijing"
        tools:ignore="MissingConstraints"/>
</RelativeLayout>
```


## 四、实验结果
![lab4](https://github.com/1814080911223/android-labs-2020/blob/master/students/sec1814080911223/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/lab4%E6%88%AA%E5%9B%BE.PNG)


## 五、实验心得
 本次实验，对APP的整体页面的布局做了一个合理美观的布局，刚开始使用LinearLayout布局时无法把button居中，使用RelativeLayout后再次使用
 android:layout_centerInParent="true"和android:layout_centerVertical="true"便能够使得button居中。
