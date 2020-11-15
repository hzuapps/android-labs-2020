# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验内容
1. 在主页界面上添加一张背景图片
2. 提交res/drawable及图片使用的代码
3. 提交res/values, res/layout等其他代码
4. 将应用运行结果截图，放到实验报告中
5. 点击或按钮时，打开另一个Activity

# 三、实验步骤
1. 将要用的图片存到res/drawable中，记得图片命名要用小写；
2. 可以在XML文件中添加ImageView等组件来使用图片，我没有实用这组件，选择直接将图片设为主界面背景
```xml
 android:background="@drawable/home_backgroud"
```
3. 若想点击图片可以实现跳转功能，可以在对应的Activity中使用Intent以及startActivity方法来实现

# 四、实验结果
![背景图片](https://github.com/tiamo669/android-labs-2020/blob/master/students/net1814080903303/second_1.jpg)
![跳转界面](https://raw.githubusercontent.com/tiamo669/android-labs-2020/master/students/net1814080903303/third_1.jpg)
# 五、实验心得
  本次实验主要是要掌握如何在Android应用中调用各种资源，对于我个人的项目来说这次是调用图片资源。这个操作相对来说是比较简单的。一般来说，
图片文件都是放在drawable下面，然后布局文件可以从drawable引入图片。
