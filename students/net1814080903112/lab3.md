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

 1. 创建图标资源
2. 在activity_net1814080903112.xml中引入图片资源并指定跳转方式
3. 提交文件

 ``` xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903112Activity">

     <Button
        android:id="@+id/rankButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="分数排行"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/gameButton" />

     <Button
        android:id="@+id/gameButton"
        android:layout_width="92dp"
        android:layout_height="57dp"
        android:layout_marginTop="20dp"
        android:text="开始游戏"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

     <ImageView
        android:id="@+id/imageView"
        android:layout_width="291dp"
        android:layout_height="328dp"
        android:layout_marginTop="100dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/poker" />
</androidx.constraintlayout.widget.ConstraintLayout> 
 ```

 ## 四、实验结果

 ![result](D:\android-labs-2020\students\net1814080903112\3.png)

 ## 五、实验心得

 本次实验是Android资源使用编程。主要是添加图片，不过在加入图片时要将图片放入res/drawable中。在点击按钮时可以打开另一个activity。