# 实验三

## 一、实验目标

1.	了解Android应用中各种资源的概念与使用方法；
2.	掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

1. 将自己选题要用到的图片放到Android工程中；
2. 选择合适的方法，使图片显示在自己选题项目所需要的界面中； 
3. 提交res/drawable及图片使用的代码。

## 三、实验步骤

1.	在网上搜集选题相关的图片并下载；

2.	把自己选题项目要用到的图片放到Android项目的res/drawable目录下；
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/3/32.png)

3.	用在XML文件中指定属性值让Android在TextView中显示图片。
```
<RelativeLayout
        android:id="@+id/Net1814080903140_bottom_layout"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_alignParentBottom="true">
        <ImageView
            android:id="@+id/Net1814080903140_iv_add"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:src="@drawable/icon_add"/>
        <ImageView
            android:id="@+id/Net1814080903140_iv_more"
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:src="@drawable/icon_more"
            android:layout_alignParentRight="true"/>
        <LinearLayout
            android:id="@+id/Net1814080903140_layout_point"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="horizontal"
            android:layout_centerInParent="true">
        </LinearLayout>
    </RelativeLayout>
</RelativeLayout>
```	
![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/3/33.png)

## 四、实验结果

![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/3/result1.PNG)

## 五、实验心得

   此次实验让我认识到了在Android项目中如何去使用图片等资源的方法，让自己选题项目要用到的图片展示在界面中，实验本身并不难，但就要找到合适的图片就有点难找。