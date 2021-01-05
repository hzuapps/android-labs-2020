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

1、调整了主页main_activity按钮的位置、大小、颜色

```java
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"

<Button
android:id="@+id/button1"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Start Game"
android:background="#00000000"
android:textColor="@android:color/holo_red_dark"
/>

<Button
android:id="@+id/button2"
android:layout_width="match_parent"
android:layout_height="wrap_content"
android:text="Rank"
android:background="#00000000"
android:textColor="@android:color/holo_red_dark"
/>

```

2、主页main_activity加了一张背景图片

```java

android:background="@drawable/background"

```

## 四、实验结果

![lab4](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab4.png)

## 五、实验心得

  本次实验主要是对主界面以及跳转界面的控件进行调整，使得整个app外观更好看一些，大部分都是在xml文件里进行操作的，以及对布局有了一个认识，我在使用中主要还是使用的是相对布局和线性布局。
