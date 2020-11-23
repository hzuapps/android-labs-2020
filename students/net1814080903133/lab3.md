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

将图片放到项目中的 src/main/res/drawable 中。

在library_item.xml,添加TextView，如下：

```xml
<ImageView
	android:id="@+id/bookImage"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:contentDescription="@string/app_name"
    android:src="@drawable/book"
    android:scaleType="fitXY" />
```

## 四、实验结果及截图

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab2(1).jpg" alt="添加图片效果" style="zoom:25%;" />

## 五、实验心得

本次实验就是引入一个图片，如在ImageView等标签使用就使用到src属性，TextView等标签使用background属性设置，这是一个很简单的步骤。点击跳转功能在实验二已经贴出来。