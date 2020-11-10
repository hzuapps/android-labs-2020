# 实验三

## 一、实验要求

- 了解Android应用中各种资源的概念与使用方法；
- 掌握在Android应用中使用图片等资源的方法；

## 二、实验内容

- 在界面中显示至少一张图片；
- 提交res/drawable及图片使用的代码；
- 提交res/values, res/layout等其他代码；


## 三、实验步骤

- 将图片下载到Android项目的app\src\main\res\drawable中；
- 在需要添加图片的界面xml文件中使用ImageView控件添加图片，用`android:src="@drawable/"`可导入已经保存在drawable中的图片，适当调整位置及大小；
- 具体代码如下:

```
<ImageView
        android:layout_width="128dp"
        android:layout_height="122dp"
        android:layout_above="@id/textView"
        android:layout_centerHorizontal="true"
        android:layout_marginStart="95dp"
        android:layout_marginLeft="95dp"
        android:layout_marginTop="34dp"
        android:layout_marginEnd="95dp"
        android:layout_marginRight="95dp"
        android:layout_marginBottom="2dp"
        android:src="@drawable/logo"
        />
```
- 使用Git提交图片及代码；

## 四、实验结果

![实验截图](https://github.com/Dwweryu/android-labs-2020/blob/master/students/net1814080903204/Lab3.png)

## 五、实验心得

- 第三次实验相较于前两个实验比较简单，只需要将图片保存到正确的位置并引用它即可成功显示在界面上，并且只要求显示在界面上就可以，不需在界面布局上过多考虑，因此很快就能完成。

