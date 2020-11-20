# 一、实验目标

 1.了解Android应用中各种资源的概念与使用方法；  
 2.掌握在Android应用中使用图片等资源的方法。

# 二、实验内容 
1.在界面上显示至少一张图片（按照自己的题目添加）；  
2.提交res/drawable及图片使用的代码；  
3.提交res/values, res/layout等其他代码；  
4.将应用运行结果截图，放到实验报告中；  
5.点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤  
1.寻找与自己项目相适应的照片下载下来；  
2.把照片放在项目的drawable目录下；    
3.在对应的配置文件中增加有关图片的代码，并且根据需求更改图片的规格使之与app相适应  
```   
<androidx.constraintlayout.widget.ConstraintLayout tools:context=".Net1814080903223Activity"   
android:background="@drawable/tupian1"   
android:layout_height="match_parent"   
android:layout_width="match_parent"   
xmlns:tools="http://schemas.android.com/tools"   
xmlns:app="http://schemas.android.com/apk/res-auto"   
xmlns:android="http://schemas.android.com/apk/res/android">  

<Button android:background="@drawable/tupian101"   
android:layout_height="90dp"   
android:layout_width="146dp"   
app:layout_constraintTop_toTopOf="parent"   
app:layout_constraintStart_toStartOf="parent"   
app:layout_constraintEnd_toEndOf="parent"   
android:textSize="30dp"   
android:text="PLAY"  
android:layout_marginTop="192dp"   
android:id="@+id/btn"/>  

<Button android:background="@drawable/tupian101"   
android:layout_height="90dp"   
android:layout_width="146dp"   
app:layout_constraintTop_toTopOf="parent"   
app:layout_constraintStart_toStartOf="parent"   
app:layout_constraintEnd_toEndOf="parent"   
android:textSize="30dp"   
android:text="VIEWANDMODIFY"   
android:layout_marginTop="392dp"   
android:id="@+id/btn2"/>  

<TextView android:background="@drawable/tupian102"   
android:layout_height="54dp"   
android:layout_width="370dp"   
app:layout_constraintTop_toTopOf="parent"   
app:layout_constraintStart_toStartOf="parent"   
app:layout_constraintEnd_toEndOf="parent"   
android:textSize="30dp" android:text="欢迎进入猜拳游戏"   
android:layout_marginTop="24dp"   
android:id="@+id/textView6"   
app:layout_constraintHorizontal_bias="0.457"/>  
```   
# 四、实验结果
！[实验结果]（https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan301.jpg）  
！[实验结果]（https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan302.jpg）  
！[实验结果]（https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan303.jpg）
# 五、实验心得
本次实验学会了如何在设置背景图片等操作，不仅在界面背景设置了图片，在按钮中也设置了背景图片显得更明显和美观，实验过程中遇到了图片大小不匹配等问题，在同学的帮助下，我在配置信息上进行相应的更改。
