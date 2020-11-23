# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验内容
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤
1. 把图片下载到drawable文件夹目录下，命名为logo.png
2. 在Android studio中的activity_net1814080903239.xml引用图片
``` 
 <ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="198dp"
        android:contentDescription="@string/pc"
        app:srcCompat="@drawable/logo1" />
``` 
3. 运行显示

# 四、实验结果
![实验三截图](https://raw.githubusercontent.com/Joanwjk/android-labs-2020/master/students/net1814080903239/sy3.png)
# 五、实验心得
这次实验是学会添加图片，在界面中显示出来,添加图片比较简单，但是在添加的过程中遇到了图片显示不出来的问题，是图片属性设置的问题，图片太大了会显示不全。
