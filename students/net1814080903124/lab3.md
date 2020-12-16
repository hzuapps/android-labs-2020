# 实验三
## 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤
1. 将要用的图片存到res/drawable中，记得图片名字要小写；
2. 可以在XML文件中添加TextView，ImageView等组件来使用图片，由于我没有使用这些组件，所以我直接将图片设为界面背景
```xml
android:background="@drawable/main_background"
```
3. 若想点击图片可以实现跳转功能，可以在对应的Activity中使用Intent以及startActivity方法来实现。
## 四、实验结果
![添加图片](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab3_1.png)
![使用图片](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab3_2.png)
![实现跳转](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab3_3.png)

## 五、实验心得
本次实验添加及使用了图片，为项目的界面添加了一点色彩，逐渐变化成一个完整的项目
