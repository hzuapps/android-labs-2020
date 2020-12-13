# 实验三

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容

1. 在自选题目项目中添加图片；
2. 使用显示

## 三、实验步骤

1. 在drawable中加入图片资源'zhuye.png';  
2. 在activity_main.xml中添加代码
```  
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
```
## 四、实验结果

+ <br>
![主页](https://github.com/book-ccr/android-labs-2020/blob/master/students/net1814080903334/AD2.png)

## 五、实验心得
这是Android的第三次实验，主要是添加app的背景图片使app有一定的观赏性。这次实验让我学会了如何使用ImageView添加图片，也发现了许多功能。
