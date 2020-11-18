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

1. 将logo.jpg，放在drawable-v24目录下。

   ![lab3-1](https://github.com/zm-w/android-labs-2020/blob/master/students/net1814080903141/实验结果截图/lab3-1.png)

2. 在activity_net1814080903141.xml中创建ImageView并引入logo.jpg

   ```java
   <ImageView
           android:id="@+id/imageView"
           android:layout_width="165dp"
           android:layout_height="149dp"
           android:layout_marginStart="123dp"
           android:layout_marginLeft="123dp"
           android:layout_marginTop="126dp"
           android:layout_marginEnd="123dp"
           android:layout_marginRight="123dp"
           android:layout_marginBottom="30dp"
           android:contentDescription="@string/todo"
           android:src="@drawable/logo"
           app:layout_constraintBottom_toTopOf="@+id/GameButton"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintStart_toStartOf="parent"
           app:layout_constraintTop_toTopOf="parent"
           tools:ignore="MissingConstraints" />
   ```

3. 运行界面查看图片显示结果


# 四、实验结果

![lab3-2](https://github.com/zm-w/android-labs-2020/blob/master/students/net1814080903141/实验结果截图/lab3-2.png)

# 五、实验心得

本次实验添加及使用了图片，在运行界面时图片一直出在左上角，修改不了图片的位置，后面才发现是没有设置图片间距的原因。