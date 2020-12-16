# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

#  二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

# 三、实验步骤

1. activity_remind.xml采用RelativeLayout布局
        
```
    <RelativeLayout
        android:layout_height="50dp"
        android:layout_width="match_parent"
        android:layout_marginTop="0dp"
        android:background="#000">
    </RelativeLayout>
    <LinearLayout
        android:layout_height="wrap_content"
        android:layout_width="match_parent"
        android:layout_marginTop="50dp"
        android:orientation="vertical"
        android:background="#FFF">
        <ListView
            android:id="@+id/mainuserlist"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:scrollbarSize="10dp"
            android:scrollbarStyle="outsideOverlay" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_alignParentTop="true"
        android:background="@color/colorPrimary">
    </LinearLayout>     
```
2. activity_set.xml采用LinearLayout布局

```
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_alignParentTop="true"
        android:background="@color/colorPrimary">
    </LinearLayout>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:hint="@string/set_event" />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:hint="@string/set_time" />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        android:gravity="top"
        android:hint="@string/event" />
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="@string/done" />
    <Button
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="@string/cancel" />
    </LinearLayout>
```

# 四、实验结果

![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/4-1.jpg)


![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/4-2.jpg)


![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/4-3.jpg)


![实验截图](https://github.com/H-ao-max/android-labs-2020/blob/master/students/net1814080903137/实验报告截图/4.jpg)


# 五、实验心得
这一次实验学习了几种主要的布局，根据需要，我选择了线性布局与相对布局。布局的学习比之前的知识有趣一些，但同时调试的时候，微微的差别需要调试挺举久的。