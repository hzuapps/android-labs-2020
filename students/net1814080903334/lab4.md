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
1. APP首页actvity_main.xml使用LinearLayout进行布局，在LinearLayout容器中，包含一个imageview控件，三个button控件分别链接三个页面，通过设置layout_height、layout_width、layout_marginTop、layout_gravity等，来进行组件首页组件布局
```activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903334Activity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageButton
        android:id="@+id/imageButton8"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:src="@drawable/zhuye"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="132dp"
        android:text="A共享"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```



## 四、实验结果
- 首页
![首页](https://github.com/book-ccr/android-labs-2020/blob/master/students/net1814080903334/AD2.png)

- 主界面
![主界面](https://github.com/book-ccr/android-labs-2020/blob/master/students/net1814080903334/AD5.png)

## 五、实验心得
 这是Android的第四次实验，主要是学习应用各种布局，从而使建立起来的app整体看起来相对美观，也加深了对app整体布局的认识以及部件的设置的应用。
