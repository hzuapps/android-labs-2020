# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

## 二、实验内容

1. 使用其中一种布局方式，**设计所选题目的界面**，建议用LinearLayout。

   * LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)

## 三、实验步骤

在各个xml文件中修改自己的布局，以达到想要的效果。
activity_main.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"

    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <Button
        android:id="@+id/btn_textview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="作业发布"
        />

    <Button
        android:id="@+id/btn_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="作业提交"
        />

    <Button
        android:id="@+id/btn_imge"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textColor="#FF0000"
        android:text="作业图片"
        />
</LinearLayout>
```

activity_net1814080903329.xml ：

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"

    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    >


    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="作业发布:"
        />


    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="作业标题:"
   />

    <EditText
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="center"
        android:hint="内容"
        />

    <LinearLayout
       android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_gravity="right"
            android:layout_weight="1"
            android:text="发布"/>

        <Button
            android:id="@+id/button_open"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_gravity="right"
            android:text="@string/button_delete"
            />



    </LinearLayout>


</LinearLayout>

```

activity_homework_manger.xml:

```xml


<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"

    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp"
    android:orientation="vertical">
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="作业提交:"
        />


    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="作业标题:"
        />

    <EditText
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="center"
        android:hint="作业解答"
        />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_gravity="right"
            android:layout_weight="1"
            android:text="提交"/>

        <Button
            android:id="@+id/button_open"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_gravity="right"
            android:text="@string/button_delete"
            />



    </LinearLayout>


</LinearLayout>



```

## 四、实验结果及截图

![实验四图片](https://github.com/2950743175/android-labs-2020/blob/master/students/net1814080903329/lab4.PNG)



## 五、 实验心得
本次实验做的是布局设计，本来我用的是ConstraintLayout，但是老师说最好用LinearLayout，网上的教程也说用ConstraintLayout对于团队合作不好用，所以就就用LinearLayout布局进行了实验。
