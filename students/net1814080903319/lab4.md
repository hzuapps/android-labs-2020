# 实验四
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容
1. 修改Activity对应的布局文件；
2. 在非主界面设置布局以及内容；

## 三、实验步骤
1. 根据选定题目选取一张图片命名为 qingtian.png 放入res/drawable中给activity.read.xml使用
2. 将activity.net1814080903319.xml中的布局进行修改，在线性布局中进行多个相对布局嵌套
3. 编写activity.read.xml文件，在activity.read.xml添加图片
```java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="最新"
        android:textSize="30sp"
        android:layout_marginTop="10dp"
        android:layout_marginLeft="180dp"
        android:textColor="#F394E0"/>
    <View
        android:layout_marginLeft="100dp"
        android:layout_marginRight="100dp"
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:background="#D5D0D0"
        android:layout_marginTop="2dp"/>
    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginLeft="12dp"
        android:layout_marginRight="12dp">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="夏天的风"
            android:textSize="16sp"
            android:textColor="#F394E0"
            android:layout_marginLeft="12dp"
            android:layout_centerHorizontal="false"
            android:layout_centerVertical="true"/>
    </RelativeLayout>
</LinearLayout>
```

## 四、实验结果
![实验四主界面结果截图](https://raw.githubusercontent.com/Basr-suer/android-labs-2020/master/students/net1814080903319/lab4.1.jpg)
![实验四阅读界面结果截图](https://raw.githubusercontent.com/Basr-suer/android-labs-2020/master/students/net1814080903319/lab4.2.jpg)

## 五、实验心得
实验四主要是熟悉对Android布局的使用，本次实验是在线性布局中嵌套多个相对布局，在相对布局中显示文本信息
