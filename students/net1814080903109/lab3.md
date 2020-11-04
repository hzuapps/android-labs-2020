
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
1. 将需要导入的图片保存到res/drawable路径中；
2. 在layout的xml文件中用ImagView导入图片作为背景：
```
<ImageView
        android:src="@drawable/图片名"/>
```

# 四、实验结果
![lab3_main](https://raw.githubusercontent.com/huanxuaner/android-labs-2020/master/students/net1814080903109/lab3_main.PNG)
![lab3_Lighten](https://raw.githubusercontent.com/huanxuaner/android-labs-2020/master/students/net1814080903109/lab3_Lighten.PNG)
![lab3_TurnoffScreen](https://raw.githubusercontent.com/huanxuaner/android-labs-2020/master/students/net1814080903109/lab3_TurnoffScreen.PNG)

# 五、实验心得
这次实验难度较浅，在界面视图中插入图片的操作简单易懂，主要是将图片设置为最底层不会覆盖其他控件较麻烦。
