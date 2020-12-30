# 实验四
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容
1. 修改Activity对应的布局文件；
2. 在非主界面设置布局以及内容；

## 三、实验步骤
1. 将activity_player.xml中的布局进行修改，在相对布局中进行多个相对布局嵌套
```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:background="#FFFFFF"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/track_title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="40dp"
        android:layout_marginRight="20dp"
        android:ellipsize="end"
        android:gravity="center"
        android:maxLines="1"
        android:text="这是标题"
        android:textSize="20sp" />

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/track_pager_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@id/track_title"
        android:layout_marginTop="35dp"
        android:layout_marginBottom="90dp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:orientation="vertical">

        <!--进度条和时间-->
        <RelativeLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <TextView
                android:id="@+id/current_position"
                android:layout_width="50dp"
                android:layout_height="wrap_content"
                android:layout_centerVertical="true"
                android:gravity="center"
                android:text="00:00"
                android:textSize="16sp" />

            <SeekBar
                android:id="@+id/track_seek_bar"
                style="@style/Widget.AppCompat.ProgressBar.Horizontal"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_centerInParent="true"
                android:maxHeight="1dp"
                android:progressDrawable="@drawable/bg_adjust_seek_bar"
                android:thumb="@drawable/seekbar_thumb"
                android:layout_marginLeft="50dp"
                android:layout_marginRight="50dp" />

            <TextView
                android:id="@+id/track_duration"
                android:layout_width="50dp"
                android:layout_height="wrap_content"
                android:layout_alignParentRight="true"
                android:layout_centerVertical="true"
                android:gravity="center"
                android:text="00:00"
                android:textSize="16sp" />

        </RelativeLayout>

        <!--播放控制-->
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:layout_marginBottom="16dp"
            android:gravity="center_vertical"
            android:orientation="horizontal">

            <ImageView
                android:id="@+id/player_mode_switch_btn"
                android:layout_width="0dp"
                android:layout_height="20dp"
                android:layout_weight="1"
                android:src="@drawable/selector_player_play_mode_list" />

            <ImageView
                android:id="@+id/play_pre"
                android:layout_width="0dp"
                android:layout_height="20dp"
                android:layout_weight="1"
                android:src="@mipmap/previous_press" />

            <ImageView
                android:id="@+id/play_or_pause_btn"
                android:layout_width="0dp"
                android:layout_height="35dp"
                android:layout_weight="1"
                android:src="@drawable/selector_player_play" />

            <ImageView
                android:id="@+id/play_next"
                android:layout_width="0dp"
                android:layout_height="20dp"
                android:layout_weight="1"
                android:src="@drawable/selector_player_next" />

            <ImageView
                android:id="@+id/player_list"
                android:layout_width="0dp"
                android:layout_height="20dp"
                android:layout_weight="1"
                android:src="@drawable/selector_player_play_list" />

        </LinearLayout>
    </LinearLayout>

</RelativeLayout>
```

## 四、实验结果
![实验四结果截图](https://raw.githubusercontent.com/HuaStarOS/android-labs-2020/master/students/net1814080903325/lab4.jpg)

## 五、实验心得
实验四主要是熟悉对Android布局的使用，本次实验是在线性布局中嵌套多个相对布局，在相对布局中显示文本信息
