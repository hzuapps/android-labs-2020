# 实验四
## 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。
## 二、实验内容
1. 选择布局方式布局界面中的控件；
2. 通过控件ID获取界面对象，执行相关操作；
3. 完善选题功能，实现界面控件的事件处理。
## 三、实验步骤
1. 在主界面中使用LinearLayout布局，布局两个按钮的位置；
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal" >

    <Button android:id="@+id/add"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="添加课程"
        android:layout_marginTop="600dp"
        android:layout_marginLeft="40dp"

        />
    <Button android:id="@+id/delete"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="删除课程"
        android:layout_marginTop="600dp"
        android:layout_marginLeft="140dp"
        />

</LinearLayout>
```
2. 在课程列表界面中使用RelativeLayout布局
```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:paddingTop="20dp"
    >
    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/reminder" />
    <Spinner
        android:id="@+id/dates"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/name"
        android:layout_alignParentLeft="true"
        android:layout_toLeftOf="@+id/times"
        />
    <Spinner
        android:id="@id/times"
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/name"
        android:layout_alignParentRight="true"

        />
    <Button
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/times"
        android:layout_alignParentRight="true"
        android:text="@string/done" />
</RelativeLayout>

```
## 四、实验结果
![](https://github.com/xukaiyue131/android-labs-2020/blob/master/students/net1814080903114/lab4.png)
![](https://github.com/xukaiyue131/android-labs-2020/blob/master/students/net1814080903114/lab5.png)
## 五、实验心得体会
通过本次实验掌握了线性布局和相对布局两种布局方式，解决了排版问题，使页面更加的美观
