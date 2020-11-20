# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

# 二、实验内容

1. 用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：

```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```

1. 实现界面控件的事件处理;
2. 操作之后，切换到第二个界面。

# 三、实验步骤

1. 根据自己项目设置了Fragment界面布局

   以下是部分代码：

   ```java
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:orientation="vertical">
      
       <!--1. 存放四个Fragment-->
       <FrameLayout
           android:id="@+id/content"
           android:layout_width="match_parent"
           android:layout_height="0dp"
           android:layout_weight="1"></FrameLayout>
       <!--2. 底部的四个选项菜单-->
       <LinearLayout
           android:layout_width="match_parent"
           android:layout_height="60dp"
           android:background="#F3EDED"
           android:baselineAligned="false">
           <!--四个部分都一样：ImageView + TextView-->
           <RelativeLayout
               android:id="@+id/first_layout"
               android:layout_width="0dp"
               android:layout_height="match_parent"
               android:layout_weight="1">
               <LinearLayout
                   android:layout_width="match_parent"
                   android:layout_height="wrap_content"
                   android:layout_centerVertical="true"
                   android:orientation="vertical">
                   <ImageView
                       android:id="@+id/first_image"
                       android:layout_width="wrap_content"
                       android:layout_height="wrap_content"
                       android:layout_gravity="center_horizontal"
                       android:src="@drawable/clock"
                       android:contentDescription="@string/todo" />
                   <TextView
                       android:id="@+id/first_text"
                       android:layout_width="wrap_content"
                       android:layout_height="wrap_content"
                       android:layout_gravity="center_horizontal"
                       android:layout_marginTop="5dp"
                       android:text="@string/time"
                       android:textColor="#7597B3" />
               </LinearLayout>
           </RelativeLayout>
       </LinearLayout>
   </LinearLayout>
   
   ```

   

2. 根据选题所需的功能设置对应4个的界面文件，以time.xml为例。

   ```java
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
       android:layout_width="match_parent"
       android:layout_height="match_parent"
       android:gravity="center"
       android:background="@color/lightyellow"
       android:orientation="vertical">
       <TextView
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"
           android:text="@string/first"
           android:textSize="22sp"/>
   </LinearLayout>
   ```

3.修改MainActivity.java以及4个功能类，实现Activity跳转。

4.优化背景颜色以及按键图标。

```java
android:background="@color/lightyellow"
    
android:src="@drawable/clock"
```

# 四、实验结果

![1](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/实验报告图片/lab4_1.PNG)![3](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/实验报告图片/lab4_2.PNG)

![3](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/实验报告图片/lab4_3.PNG)![4](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/实验报告图片/lab4_4.PNG)



![5](![3](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/实验报告图片/\lab3.PNG)

# 五、实验心得体会

这次实验我刚开始使用的控件是Tabhost ，后来因发现控件已经被弃用，操作起来有些困难，所以我改用了Fragment界面布局。

