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
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Sec1814080911133Activity">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="100dp"
        android:layout_marginLeft="100dp"
        android:layout_marginTop="236dp"
        android:background="@android:color/transparent"
        android:text="Tem"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="236dp"
        android:layout_marginEnd="116dp"
        android:layout_marginRight="116dp"
        android:background="@android:color/transparent"
        android:text="Knw"
        android:textSize="14sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/main"
        android:scaleType="fitXY"
        android:text="健康助手"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

2. 在主界面中会有跳转页面到activity_knw.xml
``` java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="16dp"
        android:text="返回"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:background="@android:color/transparent"/>

    <TextView
        android:id="@+id/Textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/knw"
        android:scaleType="fitXY"
        android:text="小知识"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

2. 在主界面中还有跳转页面到activity_tem.xml
``` java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">


    <ImageView
        android:id="@+id/imageView1"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/tem"
        android:scaleType="fitXY"/>

    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="164dp"
        android:layout_marginLeft="164dp"
        android:layout_marginTop="256dp"
        android:background="@android:color/transparent"
        android:text="点击记录"
        android:textSize="24sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="@android:color/transparent"
        android:text="返回"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />


    <Button
        android:id="@+id/button8"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="164dp"
        android:layout_marginLeft="164dp"
        android:layout_marginTop="336dp"
        android:background="@android:color/transparent"
        android:text="查看记录"
        android:textSize="24sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
```
3.在activity点击记录会跳转到activity_t.xml
``` java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/tem"
    android:orientation="vertical">


    <Button
        android:id="@+id/button7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="返回"
        android:background="@android:color/transparent"/>

    <EditText
        android:id="@+id/editName"
        android:layout_width="119dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:gravity="center_horizontal"
        android:layout_marginTop="180dp"
        android:hint="请输入姓名"
        android:textSize="16sp"
        tools:ignore="MissingConstraints" />

    <EditText
        android:id="@+id/editTem"
        android:layout_width="116dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:gravity="center_horizontal"
        android:hint="请输入体温"
        android:textSize="16sp"
        app:layout_constraintTop_toBottomOf="@+id/editName"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/btn1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:background="@android:color/transparent"
        android:onClick="btn1Click"
        android:text="存储"
        android:textSize="18sp"
        app:layout_constraintTop_toBottomOf="@+id/editTem"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/btn2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:background="@android:color/transparent"
        android:onClick="btn2Click"
        android:text="显示"
        android:textSize="18sp"
        app:layout_constraintTop_toBottomOf="@+id/btn1" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_weight="1"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/txt1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center|top"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:text="输入的姓名"
            android:textSize="18sp" />

        <TextView
            android:id="@+id/txt2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="top|center"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:text="输入的体温"
            android:textSize="18sp" />


        <EditText
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            />

    </LinearLayout>
</LinearLayout>
```

## 四、实验结果
![lab4](https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab4_1.png)


## 五、实验心得
 本次实验，对APP的整体页面的布局做了一个合理美观的布局，在实验中有使用过RelativeLayout，但是在学会了其他的布局后，我选择了在某些界面使用RelativeLayout布局，但是大部分的界面都使用ConstraintLayout布局。