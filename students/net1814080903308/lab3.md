# 一、实验目的
1.了解Android应用中各种资源的概念与使用方法  
2.掌握在Android应用中使用图片等资源的方法  
# 二、实验内容
1.在界面上显示至少一张图片（按照自己的题目添加）  
2.提交res/drawable及图片使用的代码  
3.提交res/values, res/layout等其他代码  
4.将应用运行结果截图，放到实验报告中  
5.点击图片（或按钮）时，打开另一个Activity
# 三、实验步骤
1.将目标图片保存到本地Android studio的 res/drawable路径中  

2.在相应layout的xml文件中设置ImageView的app:srcCompat属性实现导入图片，代码如下

```<ImageView
     android:id="@+id/imageView7"
     android:layout_width="wrap_content"
     android:layout_height="wrap_content"
     app:layout_constraintBottom_toBottomOf="parent"
     app:layout_constraintEnd_toEndOf="parent"
     app:layout_constraintHorizontal_bias="0.51"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="parent"
     app:layout_constraintVertical_bias="0.449"
     app:srcCompat="@drawable/bg"
     android:contentDescription="TODO" 
  />
```    
# 四、实验结果
!

# 五、实验心得
这次实验我们实现了导入图片到视图中，先将目的图片放入android studio的res/drawable文件夹中，然后在ImageView中实现导入图片显示。 这次实验难度不是很大，关于图片还有一些其他的操作等着我们自己去学习和探索。
