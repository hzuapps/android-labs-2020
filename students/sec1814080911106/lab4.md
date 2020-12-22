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
1. APP首页使用LinearLayout进行布局，在LinearLayout容器中，通过设置layout_height、android:layout_width、layout_marginTop、layout_marginBottom、gravity等，来进行组件首页组件布局

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    tools:context=".Sec1814080911106Activity"
    android:background="@drawable/background_white"
    android:orientation="vertical">


    <ImageView
        android:layout_width="390dp"
        android:layout_height="400dp"
        android:layout_weight="1"
        android:background="@android:color/black"
        android:layout_marginLeft="10dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="图片信息"
        android:layout_gravity="center"
        android:padding="10dp"/>


    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_gravity="center">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="上一张"
            />
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="下一张"
            />

    </LinearLayout>



    <LinearLayout
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_gravity="center"
    android:layout_weight="1">

        <Button
            android:id="@+id/button_picture"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:background="@drawable/button_view"
            android:text="照   片"
            android:layout_gravity="bottom"
            tools:ignore="MissingConstraints"
            />

        <Button
        android:id="@+id/button_edit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        android:layout_marginLeft="20dp"
        android:layout_weight="1"
        android:background="@drawable/button_view"
        android:text="编   辑"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/button_photograph"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="bottom"
        android:layout_marginLeft="20dp"
        android:background="@drawable/button_view"
        android:text="相   册"
        tools:ignore="MissingConstraints"
        android:layout_weight="1"/>
</LinearLayout>



</LinearLayout>
```
2. 同时在App首页引入了ImageView容器，用于图片的显示。

```java
    <ImageView
        android:layout_width="390dp"
        android:layout_height="400dp"
        android:layout_weight="1"
        android:background="@android:color/black"
        android:layout_marginLeft="10dp"/>
```


## 四、实验结果
![首页](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/lab4-1.png)
![编辑页](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/lab4-2.png)


## 五、实验心得
 通过本次实验，我学习了界面布局及控件使用，同时对APP的布局做了一次较大的修改，同时自习了组件的封装和组件与组件之间的调用，并且对图片的显示有了初步的了解。
