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

在activity_brouse.xml,添加TextView，如下：

```xml
    <TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="500dp"
        android:drawableTop="@drawable/pic"

        />
```

在 activity_main.xml添加TextView，如下：

```xml
   <TextView
            android:id="@+id/textview_01"
            android:layout_width="509dp"
            android:layout_height="wrap_content"
            android:drawableTop="@drawable/indexp"
            android:scaleType="centerInside"

            />
```



## 四、实验结果及截图

![实验三图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.1.png)


![实验三图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.2.png)


![实验三图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.3.png)

## 五、实验心得

本次实验的内容是在自己创建的界面中加入图片，主要是在xml文件中用<TextView>实现，这次实验总体来说没什么问题，可以较快完成。