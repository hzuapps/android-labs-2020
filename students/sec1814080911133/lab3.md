# 实验三：Android资源使用编程

## 一、实验目的

1.了解Android应用中各种资源的概念与使用方法；
2.掌握在Android应用中使用图片等资源的方法。

## 二、实验要求
1.在界面上显示至少一张图片；
2.提交res/drawable及图片使用的代码；
3.提交res/values, res/layout等其他代码；
4.将应用运行结果截图，放到实验报告中；
5.点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

1. 将图片放到项目中的 src/main/res/drawable 中。

2. 在activity_main.xml,添加TextView，如下：

```
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
```

3. 在 activity_knw.xml添加TextView，如下：

```
    <TextView
        android:id="@+id/Textview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/knw"
        android:scaleType="fitXY"
        android:text="小知识"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

4. 在 activity_tem.xml,添加 InamgeView 如下：

```
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
```

5. 运行显示

## 四、实验结果及截图

![tp1](https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab3_1.png)


![tp2](hhttps://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab3_2.png)


![tp3](https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab3_3.png)

## 五、实验心得
​       通过本次实验，自己的摸索成功在activity中插入图片，在界面上显示了三张图片。掌握了通过在xml中设置样式和布局，在此次实验中插入图片并不是特别难，但是需要我们去调配合适的界面，调整参数。