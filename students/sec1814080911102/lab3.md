# 实验三

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法

## 二、实验内容

1. 在自选题目项目中添加图片；
2. 使用显示

## 三、实验步骤

1. 在drawable中加入图片资源'homepage_clock.jpg';  
2. 在activity_main.xml中添加代码
```
    <ImageView                                                   
        android:id="@+id/imageView"                              
        android:layout_width="0dp"                               
        android:layout_height="0dp"                              
        android:layout_marginStart="42dp"                        
        android:layout_marginTop="152dp"                         
        android:layout_marginEnd="42dp"                          
        android:layout_marginBottom="67dp"                       
        app:layout_constraintBottom_toTopOf="@+id/button_list"   
        app:layout_constraintEnd_toEndOf="parent"                
        app:layout_constraintStart_toStartOf="parent"            
        app:layout_constraintTop_toTopOf="parent"                
        app:srcCompat="@drawable/homepage_clock"                 
        tools:ignore="MissingConstraints" />                     
```
## 四、实验结果

![lab3主页截图](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab3%E4%B8%BB%E7%95%8C%E9%9D%A2.PNG)

## 五、实验心得
  通过这次实验，我学会了如何通过TextView或ImageView添加图片，达到美化app界面的效果。此外添加的图片资源还能添加动作，达到类似按钮的效果。
　
