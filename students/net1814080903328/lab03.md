# 实验三 
  ## 一、实验目标 
  1. 了解Android应用中各种资源的概念与使用方法； 
  2. 掌握在Android应用中使用图片等资源的方法。 

   ## 二、实验内容 
  1. 在界面上显示至少一张图片（按照自己的题目添加）； 
  2. 提交res/drawable及图片使用的代码； 
  3. 提交res/values, res/layout等其他代码； 
  4. 将应用运行结果截图，放到实验报告中； 

   ## 三、实验步骤 
  1. 将图片放到项目的 drawable 文件夹下；
  2. 在activity_main.xml等需要添加图片的xml文件中添加<ImageView>代码将图片放入首界面
   ```xml
   <ImageView
        android:id="@+id/imageView5"
        android:layout_width="189dp"
        android:layout_height="262dp"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="20dp"
        android:contentDescription="TODO"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.47"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@+id/guideline4"
        app:srcCompat="@drawable/abc" />
   ```
  ## 四、实验结果 
 ![添加图片](https://raw.githubusercontent.com/Garfield-zheng/android-labs-2020/master/students/net1814080903328/AddImage.PNG)

   ## 五、实验心得 
  在本次实验中学习到如何将图片插入到界面中，对项目进行美观设计。
