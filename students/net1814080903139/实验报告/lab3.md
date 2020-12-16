# 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；

# 三、实验步骤

1. 把图片.png文件放入res\drawable目录下
2. 在layout\activity_main.xml中添加使用图片资源的代码

```
<ImageView
        android:layout_width="match_content"
        android:layout_height="wrap_content"
        android:src="@drawable/clock"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="116dp"
        tools:layout_editor_absoluteY="222dp" />
```



# 四、实验结果

![Lab3](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/实验报告图片/lab3.PNG)

# 五、实验心得

这次实验学习了如何使用图片资源， 实验过程中，运行在虚拟机上后，图片的位置不是自己预设的结果，尝试了改变图片大小、调整水平或垂直距离都没办法改变，最后改变布局方式得以解决。