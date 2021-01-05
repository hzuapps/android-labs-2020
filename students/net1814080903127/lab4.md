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
1. 根据自己的项目，尝试在activity_remind.xml中使用线性布局
2. 设置orientation属性和嵌套使用线性布局使界面看起来更合理
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical" >

    <LinearLayout
        android:id="@+id/date"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingTop="10dp"
            android:text="选择日期"
            android:textSize="18sp" />
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#ededed"
            android:padding="8dp"
            android:textSize="18sp" />
    </LinearLayout>

    <LinearLayout
        android:id="@+id/time"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingTop="10dp"
            android:text="选择时间"
            android:textSize="18sp" />
        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#ededed"
            android:padding="8dp"
            android:textSize="18sp" />
    </LinearLayout>


    <EditText
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="@string/message" />

    <Button
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="@string/add_remind" />
</LinearLayout>
```
# 四、实验结果
![lab4](https://github.com/cxcx75/android-labs-2020/blob/master/students/net1814080903127/lab4.png)

# 五、实验心得
本次实验主要学习了布局的使用，刚开始设置线性布局的时候发现组件都是垂直放置的，后来改成水平就好看多了。
