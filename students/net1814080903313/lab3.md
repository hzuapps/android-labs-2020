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

2.在相应layout的xml文件中实现导入图片，代码如下

```
<ImageView
        android:id="@+id/tet_1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@drawable/img1"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />
```    
# 四、实验结果
![实验截图](https://github.com/rsdczhs/android-labs-2020/blob/master/students/net1814080903313/lab03img.png)

# 五、实验心d得
这次实验是往自己的项目中加入图片，我通过向布局文件中建立ImageView的方式来引用图片，并且将该图片在主程序中设置成了启动动画。
