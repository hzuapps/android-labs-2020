# 实验三

## 一、实验目标 

1. 了解Android应用中各种资源的概念与使用方法
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容 

1. 在界面上显示至少一张图片（按照自己的题目添加）
2. 提交res/drawable及图片使用的代码
3. 将应用运行结果截图

## 三、实验步骤 

1. 将要导入的图片放入res资源中的drawable中

2. 在layout对应的xml文件中使用ImageView对图片进行导入
```xml
<ImageView
    android:id="@+id/tp"
    android:layout_width="45dp"
    android:layout_height="50dp"
    android:src="@drawable/music"
    >
</ImageView>
```

## 四、实验结果 

![图片插入代码](https://github.com/yesijie0216/android-labs-2020/blob/master/students/net1814080903136/image3.JPG)
![图片文件](https://github.com/yesijie0216/android-labs-2020/blob/master/students/net1814080903136/src/main/res/drawable/music.jpg)


# 五、实验心得 
本次实验掌握了如何插入图片以及图片的命名格式，注意避免中文和大写字母。
