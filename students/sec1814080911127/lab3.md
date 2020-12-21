# 实验三：Android资源使用编程
## 一、实验目标
- 了解Android应用中各种资源的概念与使用方法
- 掌握在Android应用中使用图片等资源的方法
## 二、实验要求
- 在界面上显示至少一张图片（按照自己的题目添加）
- 提交res/drawable及图片使用的代码
- 提交res/values, res/layout等其他代码
- 将应用运行结果截图，放到实验报告中
## 三、实验步骤
- 将图片保存到res/drawable,并用小写英文命名blackground
- 在 activity_main.xml,添加背景图片，如下
```
   <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapps.androidlabs.Sec1814080911127Activity"
    android:background="@drawable/backgroud">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Sort"
        tools:layout_editor_absoluteY="-2dp"
        tools:layout_editor_absoluteX="-4dp" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Add"
        tools:layout_editor_absoluteX="267dp"
        tools:layout_editor_absoluteY="421dp" />

</LinearLayout>
```

## 四、实验结果

![首页]()  


## 五、实验心得
这次实验比起前面的实验，难度不大，只需要在首页上增加背景图片，图片名字需要小写。
