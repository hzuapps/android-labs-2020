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
    xmlns:tools="http://schemas.android.com/tools"
    android:paddingLeft="0dp"
    android:paddingRight="16dp"
    android:orientation="vertical">

        <TextView
            android:id="@+id/textview_01"
            android:layout_width="509dp"
            android:layout_height="wrap_content"
            android:drawableTop="@drawable/indexp"
            android:scaleType="centerInside"

            />

        <Button
            android:id="@+id/button_browse"
            android:layout_width="171dp"
            android:layout_height="53dp"
            android:text="浏览"
            android:layout_marginLeft="126dp"
            android:layout_marginTop="50dp"
             />

        <Button
            android:id="@+id/button_play"
            android:layout_width="171dp"
            android:layout_height="54dp"
            android:text="播放"
            android:layout_marginLeft="126dp"
            android:layout_marginTop="100dp"
            />
</LinearLayout>
```

activity_brouse.xml ：

```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="730dp"
xmlns:tools="http://schemas.android.com/tools"
android:paddingLeft="16dp"
android:paddingRight="16dp"
android:orientation="vertical"
    tools:layout_editor_absoluteX="1dp"
    tools:layout_editor_absoluteY="6dp">>

    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="500dp"
        android:drawableTop="@drawable/pic"

        />
    <Button
        android:id="@+id/button_back"
        android:layout_width="wrap_content"
        android:layout_height="50dp"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="45dp"
        android:text="返回"
        tools:layout_editor_absoluteX="150dp"
        tools:layout_editor_absoluteY="261dp" />
</LinearLayout>


```

activity_play.xml:

```xml


<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="match_parent"
xmlns:tools="http://schemas.android.com/tools"
android:paddingLeft="16dp"
android:paddingRight="16dp"
android:orientation="vertical">

    <Button
        android:id="@+id/button_back"
        android:layout_width="wrap_content"
        android:layout_height="50dp"
        android:layout_marginLeft="140dp"
        android:layout_marginTop="545dp"
        android:text="返回"
        tools:layout_editor_absoluteX="150dp"
        tools:layout_editor_absoluteY="261dp" />

</LinearLayout>
```

## 四、实验结果及截图

![实验四图片](https://github.com/1CHONG/android-labs-2020/blob/master/students/net1814080903115/lab4.png)

![实验四图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.1.png)

![实验四图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.2.png)

![实验四图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.3.png)

## 五、 实验心得
本次实验做的是布局设计，本来我用的是ConstraintLayout，但是老师说最好用LinearLayout，我就把代码都改了一下，前前后后调了好久，最后基本达到自己想要的效果。