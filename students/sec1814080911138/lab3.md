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
1、在界面中显示图片  
```
<ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/yz1"
        tools:layout_editor_absoluteX="26dp"
        tools:layout_editor_absoluteY="26dp" />
```
实验截图  
![avatar](https://github.com/1814080911138/android-labs-2020/blob/master/students/sec1814080911138/3.jpg)  

2、在界面中显示图片  
```
 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android
    android:orientation="vertical""
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp"
    android:background="@drawable/yz2">
```
实验截图  
![avatar](https://github.com/1814080911138/android-labs-2020/blob/master/students/sec1814080911138/4.png)  

## 四、实验心得  
 本次实验是本学期移动应用开发的第三次实验课，初步学会了Android应用中使用图片等资源的方法。
