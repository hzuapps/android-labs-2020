# 实验三

# 一、实验目的

1.了解Android应用中各种资源的概念与使用方法  
2.掌握在Android应用中使用图片等资源的方法

# 二、实验内容

1.在界面上显示至少一张图片（按照自己的题目添加）  
2.提交res/drawable及图片使用的代码  
3.提交res/values, res/layout等其他代码  
4.将应用运行结果截图，放到实验报告中  
5.点击图片（或按钮）时，打开另一个Activity

## 三、实验步骤

1. 将图片保存到res/drawable,并用小写英文命名

2. 在 activity_select.xml,添加 一个存放图片的，如下：

```
<ImageView
        android:id="@+id/imageView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:srcCompat="@drawable/nlyr" />
```

## 四、实验结果

![实验三图片](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy3.1.PNG)

## 五、实验心得

通过这次实验我学会了使用android studio来设置背景图片，以及界面跳转的功能。
