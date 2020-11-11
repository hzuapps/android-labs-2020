# 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验要求

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤

1. 找到相应的图片，修改为png格式，放在drawable目录下。
2. 在相应的xml下添加代码（app:srcCompat="@drawable/title"设置显示的图片）

```xml
<ImageView
        android:id="@+id/imageView"
        android:layout_width="186dp"
        android:layout_height="162dp"
        android:layout_marginTop="100dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/title" />
```

# 四、实验结果

![lab3-image1](lab3-image1.png)

# 五、实验心得

学习了如何引用资源文件，在这里的图片不仅需要放到drawable文件夹下，还要使用全英文命名，同时只能使用小写字母，app:srcCompat="@drawable/title"可以设置ImageView的内容。