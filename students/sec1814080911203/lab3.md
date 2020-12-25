# 实验三
## 一、实验要求
  &emsp;&emsp;1.了解Android应用中各种资源的概念与使用方法；  
  &emsp;&emsp;2.掌握在Android应用中使用图片等资源的方法；
## 二、实验内容
  &emsp;&emsp;1.在界面中显示至少一张图片；  
  &emsp;&emsp;2.提交res/drawable及图片使用的代码；  
  &emsp;&emsp;3.提交res/values, res/layout等其他代码；
## 三、实验步骤
1.将图片下载到Android项目的app\src\main\res\drawable中；  
2.在需要添加图片的界面xml文件中使用ImageView控件添加图片，用android:src="@drawable/"可导入已经保存在drawable中的图片，适当调整位置及大小；  
3.具体代码如下:
  android:background="@drawable/mainbackgroup"
    
4.使用Git工具提交图片及代码
## 四、实验图片
https://raw.githubusercontent.com/CYJ13824255375/android-labs-2020/master/students/sec1814080911203/lab3.PNG
## 五、实验心得
这个实验比较简单，只需要插入图片，很显然比较容易完成。这个实验先把图片放到drawable文件夹中，然后在activity_main.xml中写代码就好了。
