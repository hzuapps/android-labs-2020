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

![实验三图片](https://github.com/SaTarU1IX/android-labs-2020/blob/master/students/net1808081001120/picture1.jpg)
![实验三图片](https://github.com/SaTarU1IX/android-labs-2020/blob/master/students/net1808081001120/picture2.jpg)

2. 在 activity_net1808081001120.xml,分别添加 TextView 和 ImagView :

```
android:text="首页"
```

```
android:src="@drawable/picture1"
```


在 activity_personview.xml,添加 ImagView :
```
android:src="@drawable/picture2"
```

## 四、实验结果

![实验三图片](https://github.com/SaTarU1IX/android-labs-2020/blob/master/students/net1808081001120/lab-3(1).png)
![实验三图片](https://github.com/SaTarU1IX/android-labs-2020/blob/master/students/net1808081001120/lab-3(2).png)

## 五、实验心得

通过本次学会了如何在activity中插入图片，并且通过在xml中设置属性来改变图片。
