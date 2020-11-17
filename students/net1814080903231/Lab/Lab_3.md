#  实验二

## 一、实验目标

- 了解Android应用中各种资源的概念与使用方法；
- 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

- 添加图片；
- 在界面上显示至少一张图片。

## 三、实验步骤

- 将图片保存到res/drawable,注意要用小写英文命名；

  ![image](https://raw.githubusercontent.com/Cai-J/android-labs-2020/master/students/net1814080903231/Lab/lab_3_1.png)

- 在XML文件中添加ImageView组件来使用图片

```java
<ImageView
        android:id="@+id/imageView"
        android:layout_width="91dp"
        android:layout_height="101dp"
        android:layout_marginTop="60dp"
        android:layout_marginEnd="60dp"
        android:src="@drawable/timg"></ImageView>
```



## 四、实验结果

![image](https://raw.githubusercontent.com/Cai-J/android-labs-2020/master/students/net1814080903231/Lab/lab_3_2.png)

## 五、心得体会

本次实验主要是图片的置入，通过置入图片增强APP的易用性，挺重要的功能。
