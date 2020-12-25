# 实验三
## 一、实验目标		
1、了解Android应用中各种资源的概念与使用方法；  
2、掌握在Android应用中使用图片等资源的方法。  

## 二、实验要求	
1、界面上显示至少一张图片（按照自己的题目添加）；  
2、提交res/drawable及图片使用的代码；  
3、提交res/values, res/layout等其他代码；  
4、将应用运行结果截图，放到实验报告中；  
5、点击图片（或按钮）时，打开另一个Activity    

## 三、实验步骤	
1、在res/drawable/下载图片myimage.png
2、在activity_main.xml界面中显示图片（把图片设置为背景图片）
   命令为android:background="@drawable/myimage"，具体代码如下图：
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".sec1814080911142Activity"
   android:background="@drawable/myimage">
   ```
   实验截图
   ![png1](https://github.com/lxp99/android-labs-2020/blob/master/students/sec1814080911142/myimage.png)

## 四、实验心得  
这次试验我们学习了将在我们写的Android下添加图片，通过学习，我们可以通过多种方式添加图片，我选择将图片添加为背景图片，使用在开头布局下面写android:background="@drawable/myimage"得到实验结果。
