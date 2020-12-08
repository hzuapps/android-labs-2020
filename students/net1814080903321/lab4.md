# 实验四：Android界面设计编程

## 一、实验目标

- 根据选题要求设计界面布局及控件使用
- 布局xml及界面控制操作代码提交并截图
- 将应用运行结果截图

##  二、实验内容
- 使用一种布局方式设计界面
- 通过控件ID获取界面对象，执行相关操作
```
// XML
android:id="@+id/button1"
// Java
findViewById(R.id.button1);
```

- 实现界面控件的事件处理
- 操作之后，切换到第二个界面

## 三、实验步骤

- 进入主界面activity_net1814080903321.xml
- 界面使用ConstraintLayout（约束布局）
- 嵌入Button按钮，并设置文字
- 在design界面拖动进行一些格式的设置

activity_net1814080903321.xml如下

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903321Activity">

    <TextView
        android:id="@+id/head"
        android:layout_width="422dp"
        android:layout_height="738dp"
        android:background="#55B0ED"
        android:gravity="center"
        android:textAllCaps="false"
        android:textColor="#FFFFFF"
        android:textColorHighlight="#323232"
        android:textColorHint="#600000"
        android:textSize="36sp"
        android:textStyle="italic"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="150dp"
        android:layout_height="51dp"
        android:layout_marginStart="132dp"
        android:layout_marginLeft="132dp"
        android:layout_marginTop="32dp"
        android:gravity="center"
        android:text="欢迎使用"
        android:textColor="#FFFFFF"
        android:textSize="30sp"
        android:textStyle="bold"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView15" />

    <TextView
        android:id="@+id/textView15"
        android:layout_width="200dp"
        android:layout_height="62dp"
        android:layout_marginStart="107dp"
        android:layout_marginLeft="107dp"
        android:layout_marginTop="140dp"
        android:gravity="center"
        android:text="易速达"
        android:textAllCaps="false"
        android:textColor="#FFFFFF"
        android:textSize="36sp"
        android:textStyle="bold|italic"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/head" />

    <Button
        android:id="@+id/button1"
        android:layout_width="200dp"
        android:layout_height="63dp"
        android:layout_marginStart="107dp"
        android:layout_marginLeft="107dp"
        android:layout_marginTop="40dp"
        android:background="#FFFFFF"
        android:text="我要点餐"
        android:textColor="#55B0ED"
        android:textSize="36sp"
        android:textStyle="bold"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

- 进入activity_show.xml；
- 设置好界面文字
- 嵌入4个ImageButton并加入图片
- 在design界面拖动进行一些格式的设置并预览

activity_show.xml如下

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapp.androidlabs.net1814080903321.ShowActivity">

    <TextView
        android:id="@+id/head2"
        android:layout_width="411dp"
        android:layout_height="46dp"
        android:background="#55B0ED"
        android:gravity="center"
        android:text="易速达"
        android:textAllCaps="false"
        android:textColor="#FFFFFF"
        android:textColorHighlight="#323232"
        android:textColorHint="#600000"
        android:textSize="36sp"
        android:textStyle="italic"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView2"
        android:layout_width="255dp"
        android:layout_height="39dp"
        android:gravity="center|top"
        android:text="益禾烤奶"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/kaonai"
        app:layout_constraintTop_toBottomOf="@+id/textView3" />

    <ImageButton
        android:id="@+id/fan"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/kaonai"
        app:srcCompat="@drawable/zhujiaofan" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="411dp"
        android:layout_height="30dp"
        android:background="#C6C4C4"
        android:gravity="center"
        android:text="请点击图片选择规格"
        android:textColor="#FFFFFF"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/head2" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="123dp"
        android:layout_height="45dp"
        android:text="月售200份"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="@+id/textView2"
        app:layout_constraintTop_toBottomOf="@+id/textView2" />

    <TextView
        android:id="@+id/textView5"
        android:layout_width="94dp"
        android:layout_height="37dp"
        android:layout_marginTop="4dp"
        android:text="￥8"
        android:textColor="#DA1010"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/kaonai"
        app:layout_constraintTop_toBottomOf="@+id/textView4" />

    <ImageButton
        android:id="@+id/kaonai"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3"
        app:srcCompat="@drawable/kaonai" />

    <ImageButton
        android:id="@+id/roujuan"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/fan"
        app:srcCompat="@drawable/jiroujuan" />

    <ImageButton
        android:id="@+id/hanbao"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:scaleType="centerCrop"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/roujuan"
        app:srcCompat="@drawable/jituibao" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="255dp"
        android:layout_height="39dp"
        android:layout_marginTop="24dp"
        android:gravity="center"
        android:text="隆江猪脚饭"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/fan"
        app:layout_constraintTop_toBottomOf="@+id/textView5" />

    <TextView
        android:id="@+id/textView9"
        android:layout_width="123dp"
        android:layout_height="45dp"
        android:text="月售1000份"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/fan"
        app:layout_constraintTop_toBottomOf="@+id/textView6" />

    <TextView
        android:id="@+id/textView12"
        android:layout_width="94dp"
        android:layout_height="37dp"
        android:text="￥8"
        android:textColor="#DA1010"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/roujuan"
        app:layout_constraintTop_toBottomOf="@+id/textView10" />

    <TextView
        android:id="@+id/textView14"
        android:layout_width="94dp"
        android:layout_height="37dp"
        android:text="￥12"
        android:textColor="#DA1010"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/fan"
        app:layout_constraintTop_toBottomOf="@+id/textView9" />

    <TextView
        android:id="@+id/textView13"
        android:layout_width="94dp"
        android:layout_height="37dp"
        android:text="￥16"
        android:textColor="#DA1010"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/hanbao"
        app:layout_constraintTop_toBottomOf="@+id/textView11" />

    <TextView
        android:id="@+id/textView10"
        android:layout_width="123dp"
        android:layout_height="45dp"
        android:text="月售500份"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/roujuan"
        app:layout_constraintTop_toBottomOf="@+id/textView7" />

    <TextView
        android:id="@+id/textView11"
        android:layout_width="123dp"
        android:layout_height="45dp"
        android:text="月售2000份"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/hanbao"
        app:layout_constraintTop_toBottomOf="@+id/textView8" />

    <TextView
        android:id="@+id/textView7"
        android:layout_width="255dp"
        android:layout_height="39dp"
        android:layout_marginStart="4dp"
        android:layout_marginLeft="4dp"
        android:layout_marginTop="28dp"
        android:gravity="center"
        android:text="辣味鸡肉卷"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/roujuan"
        app:layout_constraintTop_toBottomOf="@+id/textView14" />

    <TextView
        android:id="@+id/textView8"
        android:layout_width="255dp"
        android:layout_height="39dp"
        android:layout_marginStart="4dp"
        android:layout_marginLeft="4dp"
        android:layout_marginTop="28dp"
        android:gravity="center"
        android:text="香辣鸡腿堡"
        android:textSize="24sp"
        app:layout_constraintStart_toEndOf="@+id/hanbao"
        app:layout_constraintTop_toBottomOf="@+id/textView12" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

- 进入activity_store.xml
- 加入4张图片
- 嵌入4个Button并设置文字
- 进入design界面预览样式，进行位置调整

activity_store.xml如下

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".StoreActivity">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".StoreActivity"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="0dp">

        <TextView
            android:id="@+id/head3"
            android:layout_width="411dp"
            android:layout_height="46dp"
            android:background="#55B0ED"
            android:gravity="center"
            android:text="易速达"
            android:textAllCaps="false"
            android:textColor="#FFFFFF"
            android:textColorHighlight="#323232"
            android:textColorHint="#600000"
            android:textSize="36sp"
            android:textStyle="italic"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <ImageView
            android:id="@+id/imageView1"
            android:layout_width="195dp"
            android:layout_height="164dp"
            android:layout_marginStart="8dp"
            android:layout_marginLeft="8dp"
            android:src="@drawable/yihetang"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/head3"
            tools:ignore="MissingConstraints" />

        <Button
            android:id="@+id/button1"
            android:layout_width="195dp"
            android:layout_height="55dp"
            android:background="#DCE8F8"
            android:text="益禾堂"
            android:textSize="24sp"
            app:layout_constraintStart_toStartOf="@+id/imageView1"
            app:layout_constraintTop_toBottomOf="@+id/imageView1"
            tools:ignore="DuplicateIds,MissingConstraints,UnknownId" />

        <ImageView
            android:id="@+id/imageView3"
            android:layout_width="195dp"
            android:layout_height="164dp"
            android:layout_marginStart="8dp"
            android:layout_marginLeft="8dp"
            android:src="@drawable/maidanglao"
            app:layout_constraintStart_toEndOf="@+id/imageView"
            app:layout_constraintTop_toBottomOf="@+id/button2" />

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="195dp"
            android:layout_height="164dp"
            android:layout_marginStart="8dp"
            android:layout_marginLeft="8dp"
            android:src="@drawable/zhujiaofan"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/button1" />

        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="195dp"
            android:layout_height="164dp"
            android:layout_marginStart="8dp"
            android:layout_marginLeft="8dp"
            android:src="@drawable/hualaishi"
            app:layout_constraintStart_toEndOf="@+id/imageView1"
            app:layout_constraintTop_toBottomOf="@+id/head3" />

        <Button
            android:id="@+id/button2"
            android:layout_width="195dp"
            android:layout_height="55dp"
            android:background="#DCE8F8"
            android:text="华莱士"
            android:textSize="24sp"
            app:layout_constraintStart_toStartOf="@+id/imageView2"
            app:layout_constraintTop_toBottomOf="@+id/imageView2" />

        <Button
            android:id="@+id/button3"
            android:layout_width="195dp"
            android:layout_height="55dp"
            android:background="#DCE8F8"
            android:text="猪脚饭"
            android:textSize="24sp"
            app:layout_constraintStart_toStartOf="@+id/imageView"
            app:layout_constraintTop_toBottomOf="@+id/imageView" />

        <Button
            android:id="@+id/button4"
            android:layout_width="195dp"
            android:layout_height="55dp"
            android:background="#DCE8F8"
            android:text="麦当劳"
            android:textSize="24sp"
            app:layout_constraintStart_toStartOf="@+id/imageView3"
            app:layout_constraintTop_toBottomOf="@+id/imageView3" />

    </androidx.constraintlayout.widget.ConstraintLayout>


</androidx.constraintlayout.widget.ConstraintLayout>
```

## 四、实验结果

![应用首页](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/4.jpg)  
图1.应用运行结果：首页截图

![Store页面](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/4.jpg)  
图2.应用运行结果：商店页面（Store）截图

![Show页面](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/4.jpg)  
图3.应用运行结果：菜单页面（Show）截图

![代码提交](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/4.jpg)  
图4.提交代码，老师合并之后截图

## 五、实验心得
本次实现主要使用约束布局实现界面布局，并且完善界面点击操作事件，添加了一些图片按钮，对界面进行美化，使界面更加丰富。比起之前的实验而言内容多了一点。
