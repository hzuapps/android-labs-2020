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

![实验三图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab3(2).PNG)

2. 在 activity_main.xml,添加 background 如下：

```
android:background="@drawable/js"
```

## 四、实验结果

![实验三图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab3(1).PNG)

## 五、实验心得

通过本次学会了如何在activity中插入图片，并且通过在xml中设置属性来改变图片，比较简单。