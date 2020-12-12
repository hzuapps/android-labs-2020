# 实验三：Android资源使用编程
## 一、实验目标
- 了解Android应用中各种资源的概念与使用方法
- 掌握在Android应用中使用图片等资源的方法
## 二、实验要求
- 在界面上显示至少一张图片（按照自己的题目添加）
- 提交res/drawable及图片使用的代码
- 提交res/values, res/layout等其他代码
- 将应用运行结果截图，放到实验报告中
- 点击图片（或按钮）时，打开另一个Activity
## 三、实验步骤
- 将图片保存到res/drawable,并用小写英文命名
- 在 activity_main.xml,添加一个按钮存和一张图片，如下
```xml
    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="180dp"
        android:text="Button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="248dp"
        android:src="@drawable/sence1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"></ImageView>
```

## 四、实验结果
 
![首页](https://github.com/eason89/android-labs-2020/blob/master/students/net1814080903332/3.PNG)  
应用运行结果：首页（Net1814080903332Activity）添加图片和按钮截图

![点击按钮跳转](https://github.com/eason89/android-labs-2020/blob/master/students/net1814080903332/2.PNG)  
应用运行结果：点击按钮后跳转到景点选择页面（SelectTravelPlace）

## 五、实验心得
这次实验比起前面的实验，难度不大，只需要在想要插入图片的界面上添加好图片就可以了，图片的一些属性可以在xml文档中进行设置。注意好存放图片时一定要注意是小写。
