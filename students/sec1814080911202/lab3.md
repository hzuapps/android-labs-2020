# 一、实验报告

1. 了解Android应用中各种资源的概念与使用方法
2. 掌握在Android应用中使用图片等资源的方法

# 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）
2. 提交res/drawable及图片使用的代码
3. 提交res/values, res/layout等其他代码
4. 将应用运行结果截图，放到实验报告中
5. 点击图片（或按钮）时，打开另一个Activity

# 三、实验步骤

1. 将目标图片保存到本地Android studio的 res/drawable路径中

2. 在相应layout的xml文件中设置`ImageView`的`app:srcCompat`属性实现导入图片，代码如下
```xml
    <!-- 顶部栏 惠州学院图书馆字样图片 -->
    <ImageView
        android:id="@+id/imageview_hzu_library1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/hzu_library1"/>


    <!-- book1 内网安全攻防 -->
    <ImageView
        android:id="@+id/imageview_lan_sec_awd"
        android:layout_width="wrap_content"
        android:layout_height="200dp"
        android:src="@drawable/lan_sec_awd"/>

    <!-- book2 web安全攻防 -->
    <ImageView
        android:id="@+id/imageview_web_sec_awd"
        android:layout_width="wrap_content"
        android:layout_height="200dp"
        android:src="@drawable/web_sec_awd"/>
```


# 四、实验结果

![lab3](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab3.png)

# 五、实验心得

本次实验是了解Android应用中各种资源的概念与使用方法，以及掌握在Android应用中使用图片等资源的方法。通过本次实验，掌握了添加图片的几种方法，特别是ImageView，以及学会了图片的属性配置等等。
