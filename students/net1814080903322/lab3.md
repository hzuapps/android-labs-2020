# 实验三
## 一、实验要求
  &emsp;&emsp;1.了解Android应用中各种资源的概念与使用方法；  
  &emsp;&emsp;2.掌握在Android应用中使用图片等资源的方法；
## 二、实验内容
  &emsp;&emsp;1.在界面中显示至少一张图片；  
  &emsp;&emsp;2.提交res/drawable及图片使用的代码；  
  &emsp;&emsp;3.提交res/values, res/layout等其他代码；
## 三、实验步骤
&emsp;&emsp;1.将图片下载到Android项目的app\src\main\res\drawable中；  
&emsp;&emsp;2.在需要添加图片的界面xml文件中使用ImageView控件添加图片，用android:src="@drawable/"可导入已经保存在drawable中的图片，适当调整位置及大小；  
&emsp;&emsp;3.具体代码如下:

     <ImageView
        android:id="@+id/imageView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:src="@drawable/classroom_picture"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"></ImageView>
&emsp;&emsp;4.使用Git工具提交图片及代码

## 四、实验心得
&emsp;&emsp;第三次实验是往app里插入图片，需在配置文件xml中进行配置和将图片放到相对应的位置，而且命名要求是全部都要小写，不能够出现大写字母，实验还是比较简单，能够顺利完成。
