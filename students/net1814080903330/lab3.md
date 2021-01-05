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

1.将目标图片timg保存到本地Android studio的 res/drawable路径中  

2.在相应layout的xml文件中利用android:background导入图片timg，代码如下

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/timg"
    android:orientation="vertical"
    tools:context=".Net1814080903330Activity">
```    

# 四、实验结果



# 五、实验心得

导入图片之前先将目的图片timg放入res/drawable文件夹中，然后在中LinearLayout实现导入图片显示。实验总体没有难度，后面尝试把功能补充完整。
