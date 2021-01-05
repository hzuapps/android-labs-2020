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
2. 在activity_net1814080903126.xml中引入图片资源并指定跳转方式
3. 提交文件

    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".Net1814080903126Activity">
    <Button
        android:id="@+id/newGameButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="开始游戏"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />
    
    <Button
        android:id="@+id/continueGameButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="继续游戏"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.501"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/newGameButton" />
    
    <Button
        android:id="@+id/scoreButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="分数榜单"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/continueGameButton" />
    
    <ImageView
        android:id="@+id/imageView"
        android:layout_width="218dp"
        android:layout_height="263dp"
        android:layout_marginTop="80dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/boom" />
</androidx.constraintlayout.widget.ConstraintLayout> 

 ## 四、实验结果

![](D:\android-labs-2020\students\net1814080903126\image\3.png)

 ## 五、实验心得

本次实验实现了照片的插入，根据课堂知识便可完成。