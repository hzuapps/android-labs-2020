# 实验三

## 一、实验目标
- 了解Android应用中各种资源的概念与使用方法
- 掌握在Android应用中使用图片等资源的方法
## 二、实验内容
- 在界面上显示至少一张图片
- 提交res/drawable及图片使用的代码
- 提交res/values, res/layout等其他代码
- 将应用运行结果截图，放到实验报告中
- 点击图片（或按钮）时，打开另一个Activity
## 三、实验步骤
1. 将所要添加的图片用英文小写命名（带含义）放入项目目录的res/drawable，我添加的是主页背景图index.jpg
2. 在主页面activity_sec1814080911234.xml中将index设为背景，代码为： 

```xml
    <LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    tools:context=".Sec1814080911234Activity"
    android:background="@drawable/index"
    >
```


## 四、实验结果
![lab3](raw.githubusercontent.com/1728799039/android-labs-2020/master/students/sec1814080911234/lab3.png)
## 五、实验心得
本次实验是在界面上至少显示一张图片，我做的是在主页加了一张背景图index，将图片放入drawable文件夹中，在activity_sec1814080911234.xml中用做背景就可以，还是比较容易的。
