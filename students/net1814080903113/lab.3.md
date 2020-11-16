# 一、实验目标

 1. 了解Android应用中各种资源的概念与使用方法；
 2. 掌握在Android应用中使用图片等资源的方法。

 # 二、实验要求

 1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

 # 三、实验步骤

 1. 找到相应的图片，修改为png格式，放在drawable目录下。
 2. 在相应的xml下添加代码

 ```xml
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903113PhotoIntroActivity"
    android:background="@drawable/aqua4">

```

 # 四、实验结果

 ![截图](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test3.png)

 # 五、实验心得

 通过本次实验，学会了资源的引用和相关函数的设置。图片放在drawable文件内，值得注意的是图片的命名必须全小写，否则会出现错误。
