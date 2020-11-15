# 一、实验目标
根据选题要求设计界面布局及控件使用；
布局xml及界面控制操作代码提交并截图；
将应用运行结果截图。
# 二、实验内容
使用一种布局方式设计界面；
通过控件ID获取界面对象，执行相关操作：
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
实现界面控件的事件处理;
操作之后，切换到第二个界面。
# 三、实验步骤
1. 根据自己项目设置了LinearLayout
2. 在LinearLayout中使用了嵌套
```java
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical"
    android:background="@drawable/second_2">

    <LinearLayout

        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingTop="10dp"
            android:text="#添加话题#"
            android:textSize="18sp" />
        <EditText
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
        android:hint="请输入你要发表的吐槽或提出的建议" />

    <Button
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="发送" />
</LinearLayout>
```
# 四、实验结果
![lab4](https://raw.githubusercontent.com/ccc2020916/android-labs-2020/master/students/net1814080903132/lab4.png)
# 五、实验心得
