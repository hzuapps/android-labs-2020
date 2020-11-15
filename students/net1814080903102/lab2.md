# 实验二 Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 创建自己的安卓项目选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤

1. 创建 3 个 Activity<br>
    主界面Activity：Net1814080903102Activity.java<br>
    添加课程Activity：AddClassActivity.java<br>
    课表设计Activity：SettingActivity.java<br>

![Activity](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/20201111092756.png)

2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转

    在 Net1814080903102Activity.java 添加按钮点击事件处理，实现跳转其他Activity

![OnClick事件](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/20201111092938.png)

## 四、实验结果

![界面截图](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/20201111093135.png)

![提交结果](https://raw.githubusercontent.com/Thisko/Figure-bed/master/img/20201111090742.png)

## 五、实验心得
  本次实验在一些细节方面出现了问题，在类的命名上没有使用驼峰命名。在实验内容方面，是通过findVidwById找到按键，让创建点击事件，通过Intent方法进行Activity之间的跳转。
