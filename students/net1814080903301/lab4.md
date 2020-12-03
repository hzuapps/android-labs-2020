# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

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

1. 进入主界面activity_main.xml；
2. 使用LinearLayout，作为一个大布局；
3. 在大布局中嵌入一个水平的LinearLayout；
4. 将两个Button按钮嵌入。

activity_main.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903301Activity">

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
    	    android:id="@+id/button_open1"
 	    android:layout_width="399dp"
     	    android:layout_height="63dp"
	    android:text="@string/Select"
	    app:layout_constraintBottom_toTopOf="@+id/button_open2"
	    app:layout_constraintEnd_toEndOf="parent"
	    app:layout_constraintHorizontal_bias="0.031"
	    app:layout_constraintStart_toStartOf="parent"
	    app:layout_constraintTop_toTopOf="parent" />

	 <Button
	    android:id="@+id/button_open2"
	    android:layout_width="402dp"
	    android:layout_height="71dp"
	    android:text="@string/Book"
	    app:layout_constraintBottom_toBottomOf="parent"
	    app:layout_constraintStart_toStartOf="parent"
	   app:layout_constraintTop_toBottomOf="@+id/button_open1"
	   app:layout_constraintVertical_bias="0.0" />
                </LinearLayout>
        </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```
1. 进入activity_book.xml；
2. 写好要加入的那个文本框以及一个提交预约按钮
3. 在design界面拖动进行一些格式的设置

activity_book.xml如下

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapps.net1814080903301.BookActivity">

    <EditText
        android:id="@+id/editText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="13dp"
        android:hint="@string/boyphone"
        app:layout_constraintBottom_toTopOf="@+id/editText2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText6" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="7dp"
        android:hint="@string/girlphone"
        app:layout_constraintBottom_toTopOf="@+id/editText5"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />

    <EditText
        android:id="@+id/editText3"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="12dp"
        android:hint="@string/boyname"
        app:layout_constraintBottom_toTopOf="@+id/editText6"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText4" />

    <EditText
        android:id="@+id/editText4"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="7dp"
        android:hint="@string/weedingday"
        app:layout_constraintBottom_toTopOf="@+id/editText3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText5"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginBottom="360dp"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="@string/message"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText2" />

    <EditText
        android:id="@+id/editText6"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="@string/girlname"
        app:layout_constraintBottom_toTopOf="@+id/editText"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText3" />

    <Button
        android:id="@+id/button"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        android:text="@string/book"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText5" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

1. 进入activity_select.xml；
2. 写好自己设计好的界面，一个图片背景，一个开始查询的按钮。
3. 进入design界面预览样式，如何进行修改。

activity_select.xml如下:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapps.net1814080903301.SelectActivity">

    <Button
        android:id="@+id/button2"
        android:layout_width="420dp"
        android:layout_height="70dp"
        android:layout_marginTop="510dp"
        android:text="@string/select"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:src="@drawable/myimage"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

## 四、实验结果及截图

![实验四图片](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/4.jpg)

## 五、实验心得
本次实现主要实现界面布局，并且完善界面点击操作事件，添加了一些可输入的文本框，使界面更加丰富。比起之前的实验而言内容多了一点。
