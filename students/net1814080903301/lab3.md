# 实验三：Android资源使用编程

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验要求

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

1. 将图片保存到res/drawable,并用小写英文命名

2. 在 activity_select.xml,添加 一个存放图片的，如下：

```xml
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:src="@drawable/myimage"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

## 四、实验结果

![实验三图片](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/3.jpg)

## 五、实验心得

这次实验比起前面的实验，难度不大，只需要在想要插入图片的界面上添加好图片就可以了，图片的一些属性可以在xml文档中进行设置。注意好存放图片时一定要注意是小写。
