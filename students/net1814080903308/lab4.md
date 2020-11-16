# 一、实验目的
1.根据选题要求设计界面布局及控件使用  
2.布局xml及界面控制操作代码提交并截图  
3.将应用运行结果截图  
# 二、实验内容
1.使用一种布局方式设计界面  
2.通过控件ID获取界面对象，执行相关操作  
3.实现界面控件的事件处理  
4.操作之后，切换到第二个界面  
# 三、实验步骤
创建constraintlayout布局的页面，实现自己的三到四个功能
'''
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical"
    android:background="@color/color2">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="歌曲名/歌手"
        android:textSize="30dp"
        android:background="@color/color3"
        android:layout_marginTop="10dp"
        />

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/p3" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="100dp">
        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/smenu"
            android:textSize="20dp" />

        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textSize="20dp"
            android:text="@string/open" />
        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textSize="20dp"
            android:text="@string/next" />
    </LinearLayout>

</LinearLayout>
'''

# 四、实验结果
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/sy4-1.PNG?raw=true)
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/sy4-2.PNG?raw=true)

# 五、实验心得
这次实验主要学习使用线性布局，以及设计功能界面，在之前实验的基础上完善页面，很快就完成了，不过还不是最终成功，之后应该会继续修改
