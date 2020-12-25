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
		
1. 将图片保存到res/drawable
		
![实验3图片](https://raw.githubusercontent.com/momingyu1/android-labs-2020/master/students/net1814080903342/logo.jpeg)
		
2. 在 activity_net1814080903342.xml 添加 ImageView 组件，实现代码如下：
		
```
<ImageView
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        android:src="@drawable/logo"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />
```
		
## 四、实验结果
		
![实验3结果截图](https://raw.githubusercontent.com/momingyu1/android-labs-2020/master/students/net1814080903342/lab3.jpg)
		
## 五、实验心得
		
经过本次实验，学会了如何在界面显示图片，设置其属性等。
