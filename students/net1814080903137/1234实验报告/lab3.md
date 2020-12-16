# 实验三

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

1. 找到需要的图片，命名不出现大写字母，放在res/drawable目录下；


![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/3-1.jpg)

2. 在res/layout目录下的.xml文件显示图片
```xml
<TextView
        android:id="@+id/textView_"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/loge"
        app:layout_constraintHorizontal_bias="0.495"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteY="105dp" />
```
## 四、实验结果


![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/4-1.jpg)


![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/3.jpg)


## 五、实验心得
这一次实验学习了如何去引用资源，通过这次实验我明白了如何在自己在项目中添加图片以及在layout文件下如何使用图片。

