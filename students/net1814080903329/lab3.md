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

在activity_main.xml,添加Button，如下：

```xml
   <Button
        android:id="@+id/btn_imge"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textColor="#FF0000"
        android:text="作业图片"
        />
```

在 picture.xml添加ImageView，如下：

```xml
    <ImageView
        android:id="@+id/iv_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:background="#FF9900"
        android:src="@drawable/zuoye"
        android:scaleType="fitXY"
        />
```



## 四、实验结果及截图

![实验三图片](https://github.com/2950743175/android-labs-2020/blob/master/students/net1814080903329/lab3.PNG)




## 五、实验心得

本次实验的内容我是创建了一个按钮，通过点击按钮跳转图片页面，这次实验总体来说没什么问题，可以较快完成。
