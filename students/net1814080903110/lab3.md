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
android:background="@drawable/bg"

```

# 四、实验结果
![lab3](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab3.png)

# 五、实验心得
学习了如何设置背景图片，刚开始遇到了设置图片后app闪退的问题，是因为图片的分辨率太大与虚拟机不适配导致的，在对图片进行裁剪后成功运行。若需要再对图片进行调整，可以利用imageview来进行设置。
