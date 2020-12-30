# 实验四 Android界面设计编程

## 一、实验要求

- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图；

## 二、实验内容

- 在所学的几种布局方式中自行选择设计界面；
- 通过findViewById获取界面对象，执行相关操作；
- 实现界面控件的事件处理；


## 三、实验步骤
1. APP首页使用RelativeLayout与LinearLayout进行布局，通过设置layout_height、layout_width、layout_weight等，来进行组件首页组件布局

```java
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="5dp"
    tools:context=".Sec1814080911127Activity"
    android:background="@drawable/background">

    <LinearLayout
        android:id="@+id/topbar"
        android:orientation="horizontal"
        android:padding="5dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <TextView
            android:id="@+id/path"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="path:"/>

    </LinearLayout>
    <ListView
        android:id="@+id/list"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"
        android:background="#f0f0f0"
        android:cacheColorHint="#00000000"
        android:layout_alignParentBottom="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        android:layout_below="@+id/topbar" />

    <TextView
        android:id="@+id/tv_info"
        android:text="NULL"
        android:textSize="22sp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:visibility="gone"
        />


</RelativeLayout>
```
2. 目录也使用RelativeLayout与LinearLayout进行布局。

```java
   <?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="60dp"
    android:padding="5dp" >
    
    <ImageView 
        android:id="@+id/icon"
        android:layout_width="48dp"
        android:layout_height="48dp"
        android:src="@drawable/folder"
        android:layout_centerVertical="true"
        />
    <ImageView
        android:id="@+id/play"
        android:layout_width="48dp"
        android:layout_height="48dp"
        android:src="@drawable/app_info_video_play_d"
        android:layout_centerVertical="true"
        android:visibility="gone"
        />

    <LinearLayout 
        android:id="@+id/text"
        android:layout_width="fill_parent"
        android:layout_height="48dp"
        android:layout_centerVertical="true"
        android:layout_toRightOf="@id/icon"
        android:layout_marginLeft="5dp"
        android:orientation="vertical"
        >
        <TextView
            android:id="@+id/name"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="user"
            android:textColor="#000"
            android:textSize="16sp"
            android:ellipsize="end"
		    android:singleLine="true"
		    android:layout_marginTop="2dp"
            />
        <TextView
            android:id="@+id/path"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="path"
            android:textColor="#9f9f9f"
            android:textSize="14sp"
            android:ellipsize="start"
            android:singleLine="true"
            android:layout_marginTop="2dp"
            android:visibility="gone"
            />
        <TextView 
            android:id="@+id/desc"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="2020-12-24 10:06"
            android:textColor="#9f9f9f"
            android:textSize="14sp"
            android:ellipsize="end"
		    android:singleLine="true"
		    android:layout_marginTop="2dp"
            />
        
    </LinearLayout>
    

</RelativeLayout>
```


## 四、实验结果
![首页](https://github.com/Dokemg/android-labs-2020/blob/master/students/sec1814080911127/lab4_1.png)
![目录页](https://github.com/Dokemg/android-labs-2020/blob/master/students/sec1814080911127/lab4_2.png)


## 五、实验心得
 通过本次实验，我学习了界面布局及控件使用，同时对组件布局进行了修改，原本搜索按键的页面改到首页上方，修改了目录的布局。
