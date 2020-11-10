
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤

1. 将需要导入的图片保存到res/drawable路径中；

2. 在layout的xml文件中设置`ImageView`的`app:srcCompat`属性来导入图片作为View的背景：

   ```xml
       <ImageView
           android:id="@+id/lendMap"
           android:layout_width="108dp"
           android:layout_height="100dp"
           app:layout_constraintEnd_toEndOf="parent"
           app:layout_constraintTop_toTopOf="parent"
           app:srcCompat="@drawable/map_icon" />
   ```



# 四、实验结果

![实验截图](https://raw.githubusercontent.com/luo-2/android-labs-2020/master/students/net1814080903205/lab3.png)

# 五、实验心得

  这次实验比较简单，只需要建立一个view就行了，通过这次实验，了解Android应用中各种资源的概念与使用方法，掌握在Android应用中使用图片等资源的方法
