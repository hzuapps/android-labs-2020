# 一、实验目的
1.根据选题要求设计界面布局及控件使用  
2.布局xml及界面控制操作代码提交并截图  
3.将应用运行结果截图  
# 二、实验内容
1.使用一种布局方式设计界面  
2.通过控件ID获取界面对象，执行相关操作  
3.实现界面控件的事件处理  
# 三、实验步骤
创建constraintlayout布局的页面

~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical" >
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="200dp"
        android:src="@drawable/logo3"
        />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="65dp"
        android:layout_marginTop="30dp"
        android:textSize="30dp"
        android:hint="@string/tile" />

    <EditText
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="top"
        android:textSize="30dp"
        android:hint="@string/message" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textSize="20dp"
            android:text="@string/state" />
        <Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:textSize="20dp"
            android:text="@string/send" />
    </LinearLayout>

</LinearLayout>
~~~

# 四、实验结果
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/sy4-1.PNG?raw=true)  
!(https://github.com/Json-xl/android-labs-2020/blob/master/students/net1814080903308/sy/sy4-2.PNG?raw=true)

# 五、实验心得
这次实验主要学习使用线性布局，以及设计功能界面，在之前实验的基础上完善页面，很快就完成了，不过还不是最终成功，之后应该会继续修改
