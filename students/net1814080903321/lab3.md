# 实验三：Android资源使用编程

## 一、实验目标

- 了解Android应用中各种资源的概念与使用方法
- 掌握在Android应用中使用图片等资源的方法

## 二、实验要求

- 在界面上显示至少一张图片（按照自己的题目添加）
- 提交res/drawable及图片使用的代码
- 提交res/values, res/layout等其他代码
- 将应用运行结果截图，放到实验报告中
- 点击图片（或按钮）时，打开另一个Activity

## 三、实验步骤

- 将图片保存到res/drawable,并用小写英文命名

- 在 activity_store.xml,添加一个按钮存和一张图片，如下

```xml
    <ImageView
        android:layout_width="207dp"
        android:layout_height="164dp"
        android:layout_marginTop="8dp"
        android:src="@drawable/yihetang"
        app:layout_constraintTop_toBottomOf="@+id/head3"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="-1dp" />
        
     <Button
        android:id="@+id/button1"
        android:layout_width="207dp"
        android:layout_height="55dp"
        android:background="#FFFFFF"
        android:text="益禾堂"
        android:textSize="24sp"
        tools:ignore="MissingConstraints,UnknownId"
        tools:layout_editor_absoluteX="-1dp"
        tools:layout_editor_absoluteY="227dp" />
```

## 四、实验结果

![Store页面](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/3.jpg)  
应用运行结果：Store页面添加图片和按钮截图

## 五、实验心得

这次实验比起前面的实验，难度不大，只需要在想要插入图片的界面上添加好图片就可以了，图片的一些属性可以在xml文档中进行设置。注意好存放图片时一定要注意是小写。
