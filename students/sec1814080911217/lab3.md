# 实验三
## 一、实验目标
1.了解Android应用中各种资源的概念与使用方法  
2.掌握在Android应用中使用图片等资源的方法
## 二、实验内容
1.在自选题目项目中添加图片；  
2.使用显示
## 三、实验步骤
1.将zhuye.jpg放入res/drawable中。  
2.在功能主界面activity_main.xml上设置zhuye.jpg为背景，且布置好各个组件的布局。  
```
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Sec1814080911217Activity"
    android:orientation="vertical"
    android:background="@drawable/zhuye"
    >

    <Button
        android:id="@+id/button_earn_activity"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="85dp"
        android:layout_marginTop="100dp"
        android:layout_weight="0"
        android:textSize="50sp"
        android:background="#00000000"
        android:textColor="@android:color/black"
        android:text="赚取积分" />
    <Button
        android:id="@+id/button_exchange_activity"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="85sp"
        android:layout_marginTop="100dp"
        android:layout_weight="0"
        android:textSize="50sp"
        android:background="#00000000"
        android:textColor="@android:color/black"
        android:text="兑换积分" />
    <Button
        android:id="@+id/record"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="85sp"
        android:layout_marginTop="100dp"
        android:layout_weight="0"
        android:textSize="50sp"
        android:background="#00000000"
        android:textColor="@android:color/black"
        android:text="积分记录" />


</LinearLayout>
```
## 四、实验结果
![result](https://raw.githubusercontent.com/1364480222/android-labs-2020/master/students/sec1814080911217/lab3.PNG)
## 五、实验心得
这一次实验主要是学习使用图片资源，将符合自己app的图片设置为背景。并将主界面的组件布局的相对好看。整体来说比较简单。
