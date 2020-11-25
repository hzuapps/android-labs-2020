# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

##  二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

## 三、实验步骤

1. 在主界面activity_main.xml中,选择 Design 界面；
2. 在Layouts拉一个垂直的LinearLayout，作为一个大布局；
3. 在大布局中嵌入一个水平的LinearLayout；
4. 将两个Button按钮嵌入。

![实验四图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab4(1).PNG)

activity_main.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903129Activity">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical"
            android:paddingLeft="16dp"
            android:paddingRight="16dp">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:background="@drawable/js"
                    android:orientation="horizontal"
                    android:paddingLeft="16dp"
                    android:paddingRight="16dp">

                        <Button
                            android:id="@+id/button_operation"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginLeft="50dp"
                            android:layout_marginTop="600dp"
                            android:text="普通运算" />

                        <Button
                            android:id="@+id/button_shift"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginLeft="60dp"
                            android:layout_marginTop="600dp"
                            android:text="进制换算" />
                </LinearLayout>
        </LinearLayout>


</androidx.constraintlayout.widget.ConstraintLayout>
```
1. 在activity_operation.xml界面中,选择 Design 界面；
2. 在Layouts拉一个垂直的LinearLayout，作为一个大布局；
3. 将TextView和Button分别嵌入。

![实验四图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab4(2).PNG)

activity_operation.xml如下

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".OperationActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:paddingLeft="16dp"
        android:paddingRight="16dp">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="普通运算"
            android:textAppearance="@style/TextAppearance.AppCompat.Display1" />

        <Button
            android:id="@+id/button_back"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="100dp"
            android:layout_marginTop="10dp"
            android:text="返回" />

    </LinearLayout>


</androidx.constraintlayout.widget.ConstraintLayout>
```
1. 在activity_shift.xml界面中,选择 Design 界面；
2. 在Layouts拉一个垂直的LinearLayout，作为一个大布局；
3. 在大布局中嵌入两个水平的LinearLayout，和两个按钮；
4. 分别在两个水平的LinearLayout中嵌入TextView和EditText。

![实验四图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab4(3).PNG)

activity_shift.xml如下:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:visibility="visible"
    tools:context=".ShiftActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:paddingTop="16dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/sjz"
                android:textAppearance="@style/TextAppearance.AppCompat.Display1" />

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="@string/sza" />

        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_marginTop="16dp">

            <TextView
                android:id="@+id/textView3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="@string/ejz"
                android:textAppearance="@style/TextAppearance.AppCompat.Display1" />

            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:hint="@string/szb" />

        </LinearLayout>

        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="确定"
            android:layout_marginTop="16dp"/>

        <Button
            android:id="@+id/button_back2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginLeft="100dp"
            android:layout_marginTop="10dp"
            android:text="返回" />

    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

## 四、实验结果及截图


![实验四图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab2(1).PNG)

![实验四图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab2(2).PNG)

![实验四图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab2(3).PNG)


## 五、实验心得
本次实现主要实现界面布局，并且完善界面点击操作事件，也添加了一些可输入边框，使界面更加丰富。