# 实验六

## 一、实验目标

1. 解决主界面设计得不合理的问题
2. 对主界面进行美化以及完善

## 二、实验内容

1. 在LinearLayout中嵌套使用RelativeLayout重新对界面设计布局
2. 对layout中的代码进行修改，调整字体大小以及背景颜色等

## 三、实验步骤
1. 在activity_net1814080903318.xml文件中修改代码对主界面进行设计和美化
```
<LinearLayout

<RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <Button
            android:id="@+id/button"
            android:layout_width="274dp"
            android:layout_height="194dp"
            android:layout_marginLeft="67dp"
            android:layout_marginTop="300dp"
            android:background="@color/colorAccent"

            android:text="录屏"
            android:textAllCaps="false"
            android:textColor="@android:color/background_light"
            android:textSize="50dp"
            android:textStyle="bold" />

        <Button
            android:id="@+id/button2"
            android:layout_width="274dp"
            android:layout_height="197dp"
            android:layout_marginLeft="67dp"
            android:layout_marginTop="520dp"
            android:background="@color/colorAccent"
            android:text="我的"
            android:textColor="@android:color/background_light"
            android:textSize="50dp"
            android:textStyle="bold" />

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="410dp"
            android:layout_height="274dp"
            android:layout_marginLeft="0dp"
            android:layout_marginTop="0dp"
            app:srcCompat="@drawable/logo" />
    </RelativeLayout>

</LinearLayout>
```
 ## 四、实验结果 
![界面截图](https://raw.githubusercontent.com/HChan-X/android-labs-2020/master/students/net1814080903318/6.jpg)
## 五、心得体会
  这次的实验的内容是网络编程，但是我这个不需要用到相应的功能，这次实验就用来解决之前的界面设计问题。之前布局使用的是linearlayout，导致有些东西显示不出来，这次在linearlayout中嵌入了relativelayout，解决了显示不完全的问题，再通过修改字体大小颜色以及组件的背景颜色来美化整个界面。
