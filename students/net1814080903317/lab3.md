# 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤



​	1.编写xml布局，分为两个，一个是主布局，另外一个是RecycleView适配器的布局；代码如下：

```xml
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="50dp">
    <ImageView
        android:id="@+id/foundit_main_back_iv"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:src="@mipmap/back"
        android:padding="5dp"
        android:layout_alignParentLeft="true"
        android:layout_centerVertical="true"
        android:layout_marginTop="2.5dp"
        android:layout_marginBottom="2.5dp"/>
    <TextView
        android:id="@+id/foundit_main_icon_tv"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_toRightOf="@id/foundit_main_back_iv"
        android:text="失物招领"
        android:textSize="18sp"
        android:textColor="@android:color/black"
        android:layout_marginLeft="8dp"
        android:gravity="center"
        />

    <ImageView
        android:id="@+id/foundit_main_my_iv"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:layout_alignParentRight="true"
        android:layout_centerVertical="true"
        android:layout_marginRight="12dp"
        android:padding="5dp"
        android:src="@mipmap/my" />
</RelativeLayout>
```

主页面全局使用线性布局，顶部导航栏使用相对布局，左边是返回上一级的图标，然后是这一页面的标题，最右边是失物招领的个人页面的图标。左右两边均缩进12dp，然后垂直居中。

```xml
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="50dp"
    android:layout_marginLeft="12dp"
    android:layout_marginRight="12dp">
    <ImageView
        android:id="@+id/item_foundit_headphoto_iv"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:src="@mipmap/headphoto"
        android:layout_centerVertical="true"/>
    <TextView
        android:id="@+id/item_foundit_nickname_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="烟花易冷"
        android:textSize="16sp"
        android:textColor="@color/colorPrimary"
        android:layout_toRightOf="@id/item_foundit_headphoto_iv"
        android:layout_marginLeft="12dp"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"/>

    <TextView
        android:id="@+id/item_foundit_type_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:text="寻  物"
        android:padding="4dp"
        android:layout_marginRight="10dp"
        android:textSize="14sp"
        android:textColor="@android:color/holo_orange_light"
        android:layout_centerVertical="true"
        android:layout_toLeftOf="@id/item_foundit_connectionta_tv"
        android:background="@drawable/shape_foundit_type"
        />
    <TextView
        android:id="@+id/item_foundit_connectionta_tv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:layout_alignParentRight="true"
        android:background="@drawable/shape_foundit_connection"
        android:text="联系 TA"
        android:textColor="@color/colorPrimary"
        android:textSize="14sp"
        android:layout_centerVertical="true"
        android:padding="5dp"/>

</RelativeLayout>
<TextView
    android:id="@+id/item_foundit_content_tv"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginLeft="12dp"
    android:layout_marginRight="12dp"
    android:text="半个月上花800块一个月租了一个80平米的房子，花了3500块装修成地中海风格的，现在看起来贼舒服。在这边工作打算长住了。"
    />

<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/item_foundit_picrecyclerview"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="5dp"
    android:layout_marginLeft="12dp"
    android:layout_marginRight="12dp"/>
<RelativeLayout
    android:layout_width="match_parent"
    android:layout_height="30dp"
    android:layout_marginRight="12dp"
    android:layout_marginLeft="12dp"
    android:layout_marginTop="8dp">
    <TextView
        android:id="@+id/item_foundit_publictime_tv"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:text="5小时前"
        android:textSize="12sp"
        android:textColor="@android:color/darker_gray"
        android:layout_alignParentLeft="true"
        android:layout_centerVertical="true"
        android:gravity="center"/>
    <ImageView
        android:id="@+id/item_foundit_comment_iv"
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:src="@mipmap/comment"
        android:padding="5dp"
        android:layout_alignParentRight="true"
        android:layout_centerVertical="true"/>
</RelativeLayout>
<androidx.swiperefreshlayout.widget.SwipeRefreshLayout
    android:id="@+id/item_foundit_refresh_layout"
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/item_foundit_comment_recyclerview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginLeft="12dp"
        android:layout_marginRight="12dp"
        android:layout_marginTop="5dp"
        />
</androidx.swiperefreshlayout.widget.SwipeRefreshLayout>
```

RecycleView适配器布局，整体使用垂直线性布局，左右缩进12dp，分为四部分。第一部分采用相对布局为头像、昵称、状态以及联系ta；第二部分是失物招领的具体内容；第三部分采用是时间和评论图标；第四部分是图片展示区域，同样为一个RecyclerView。



# 四、实验结果

   ！![图片2](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/lab2-1.png?raw=true)



# 五、实验心得体会

这次的实验难度不大，主要是设计布局，布局一开始设计也是挺迷的，总之，这个需要多练习，多参考别人的代码，多去看一下其他App，说不定你的灵感就来了。