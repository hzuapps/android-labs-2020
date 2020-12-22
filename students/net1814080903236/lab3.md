# 实验三 Android资源使用编程
## 一、实验目标
1.了解Android应用中各种资源的概念与使用方法；  
2.掌握在Android应用中使用图片等资源的方法。
## 二、实验内容
1.在界面上显示至少一张图片（按照自己的题目添加);  
2.提交res/drawable及图片使用的代码；  
3.提交res/values, res/layout等其他代码；  
4.将应用运行结果截图，放到实验报告中;  
5.点击图片（或按钮）时，打开另一个Activity。 
## 三、实验步骤
1.根据自己的选题选择两张图片，首页图片存放在students/net1814080903236/app/src/main/res/drawable/main.jpg，提醒页面图片存放在students/net1814080903236/app/src/main/res/drawable/remind.jpg
2.在首页布局activity_main.xml中使用<ImageView>添加主页图片   
```
<ImageView
        android:id="@+id/imageView3"
        android:layout_width="match_parent"
        android:layout_height="448dp"
        app:srcCompat="@drawable/main" />
```
3.在提醒布局activity_remind.xml中使用<ImageView>添加提醒界面图片  
```  
<ImageView
        android:id="@+id/imageView"
        android:layout_width="match_parent"
        android:layout_height="385dp"
        app:srcCompat="@drawable/remind" />
```
4.首页布局activity_main.xml中添加按钮  
```  
<Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="160dp"
        android:text="开始进入" />
```
5.利用Git相关命令提交图片文件和布局代码并发Pull Request
## 四、实验结果
## 五、实验心得体会
这次实验学习了如何添加图片，并在自己设计的界面上使用图片，还有结合按钮实现Activity的跳转，另外在实验过程中也学习了一点布局的相关知识，在这里我采用了<LinearLayout>布局，感觉在使用上它比较方便，也容易理解各部分之间的关系，后面还再好好学习，让我的界面看起来比较丰富一点吧。
