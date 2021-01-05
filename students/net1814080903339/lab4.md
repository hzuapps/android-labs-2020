# 实验四 
  ## 一、实验目标 
  1. 根据选题要求设计界面布局及控件使用； 
  2. 布局xml及界面控制操作代码提交并截图； 
  3. 将应用运行结果截图。 

   ## 二、实验内容 
  1. 使用一种布局方式设计界面； 
  2. 通过控件ID获取界面对象，执行相关操作： 
  3. 实现界面控件的事件处理; 
  4. 操作之后，切换到第二个界面。 

   ## 三、实验步骤 
   1.主页面设置了三个按钮，分别代表了三个功能，错题归纳、书城购买、课程观看；
```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903339Activity">
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="423dp"
        android:layout_height="732dp"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="435dp"
        android:src="@drawable/bg"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.785"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/button2"
        app:layout_constraintVertical_bias="0.571" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="122dp"
        android:layout_marginLeft="122dp"
        android:layout_marginTop="50dp"
        android:layout_marginEnd="201dp"
        android:layout_marginRight="201dp"
        android:layout_marginBottom="21dp"
        android:onClick="onClickWatching"
        android:text="课程"
        app:layout_constraintBottom_toTopOf="@+id/button2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="122dp"
        android:layout_marginLeft="122dp"
        android:layout_marginTop="21dp"
        android:layout_marginEnd="201dp"
        android:layout_marginRight="201dp"
        android:layout_marginBottom="25dp"
        android:onClick="onClickConclude"
        android:text="归纳"
        app:layout_constraintBottom_toTopOf="@+id/button3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="122dp"
        android:layout_marginLeft="122dp"
        android:layout_marginTop="14dp"
        android:layout_marginEnd="201dp"
        android:layout_marginRight="201dp"
        android:layout_marginBottom="17dp"
        android:onClick="onClickBuy"
        android:text="书城"
        app:layout_constraintBottom_toTopOf="@+id/imageView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button2" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

  2.商城购买界面使用了线性布局，并进行了相应的配置；
```java
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
tools:context=".BuyActivity">

<ListView
    android:id="@+id/mobile_list"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    >
</ListView>

</LinearLayout>
```
3.错题归纳和课程观看页面也同样设置了线性布局和对其进行了相应的配置。

   ## 四、实验结果 
  ![实验截图](https://raw.githubusercontent.com/39-chen/android-labs-2020/master/students/net1814080903339/4.jpg)

   ## 五、实验心得 
  本次实验主要是对界面的布局进行设计，线性布局比较容易理解和实现，app三个的界面都设置了线性布局。
