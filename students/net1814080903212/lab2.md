# 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

# 二、实验内容

1. 创建自己的安卓项目选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）

# 三、实验步骤

1. 在issues中创建记账助手的自选题。
2. 使用Android Studio，在java包中创建三个功能Activity，分别为：Net1814080903212Activity.java、AccountBook.java、Accounting.java。
3. 在主页Net1814080903212Activity的xml文件中放置两个按钮，一个命名为“打开账本”用于打开记账本，一个命名为“记录账本”用于记账。
4. 在账本AccountBook的xml文件中放置一个按钮，命名为“返回主页”，用于返回app首页。
5. 在记账页面Accounting的xml文件中放置一个按钮，命名为“查看账本”，用于查看账本明细。
6. 使用findViewById方法引用布局文件中的对应按钮，使得在写.java的按钮时能与布局文件里的一致。
7. 设置每个按钮的点击事件。
8. 创建intent跳转对象，使用显式方法Intent(源Activity.this,目标Activity.class)。
9. startActivity(intent)实现点击跳转。

# 四、实验结果

![result](https://raw.githubusercontent.com/Unknowuse/android-labs-2020/master/students/net1814080903212/lab2result1.png)
![result](https://raw.githubusercontent.com/Unknowuse/android-labs-2020/master/students/net1814080903212/lab2result2.png)
![result](https://raw.githubusercontent.com/Unknowuse/android-labs-2020/master/students/net1814080903212/lab2result3.png)

# 五、实验心得

这次实验我选择了一个自己平时会用到的记账功能，来作为项目的题目进行学习开发。本次实验中我学会了如何添加按钮绑定事件来进行跳转页面，是一个不小的收获。
