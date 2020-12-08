# 一、实验目的

1. 根据选题要求设计界面布局及控件使用  
2. 布局xml及界面控制操作代码提交并截图  
3. 将应用运行结果截图  

# 二、实验内容

1. 使用一种布局方式设计界面  
2. 通过控件ID获取界面对象，执行相关操作  
3. 实现界面控件的事件处理  
4. 操作之后，切换到第二个界面  

# 三、实验步骤

1.创建activity_collection.xml、activity_play.xml、activity_search.xml界面文件
2.用 LinearLayout线性布局设计有关界面
```
<LinearLayout
        android:id="@+id/linearLayout1"
        android:layout_width="0dp"
        android:layout_height="73dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent">

        <TextView
            android:id="@+id/textView2"
            android:layout_width="114dp"
            android:layout_height="73dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="消息"
            android:textSize="30sp" />

        <TextView
            android:id="@+id/textView3"
            android:layout_width="114dp"
            android:layout_height="73dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="联系人"
            android:textSize="30sp" />

        <TextView
            android:id="@+id/textView4"
            android:layout_width="114dp"
            android:layout_height="73dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="看点"
            android:textSize="30sp" />

        <TextView
            android:id="@+id/textView5"
            android:layout_width="114dp"
            android:layout_height="73dp"
            android:layout_weight="1"
            android:gravity="center"
            android:text="动态"
            android:textSize="30sp" />

    </LinearLayout>
```
3.调试CollectionActivity.java、PlayActivity.java、SearchActivity.javad的页面按钮转跳是否正常运转

# 四、实验结果

![实验四图片](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy2.2.PNG)
![实验四图片](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy2.1.PNG)

# 五、实验心得

设计布局和在java中的方式差不多，比较轻松地完成本次实验。
