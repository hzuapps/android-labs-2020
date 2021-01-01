# 实验四
## 一、实验目标
&emsp; 1.根据选题要求设计界面布局及控件使用；  
&emsp; 2.布局xml及界面控制操作代码提交并截图；  
&emsp; 3.将应用运行结果截图。  

## 二、实验内容
&emsp; 1.使用其中一种布局方式，设计所选题目的界面；  
&emsp; 2.通过控件ID获取界面对象，执行相关操作：  
&emsp; // XML  
&emsp; android:id="@+id/my_button"  
&emsp; // Java  
&emsp; findViewById(R.id.my_button);

&emsp; 3.实现界面控件的事件处理；  
&emsp; 4.操作之后，切换到你的第二个界面。  

## 三、实验步骤
&emsp; 1.根据项目需求选择使用相对布局方式。   
&emsp; 2.在activity_select_room.xml文件中配置相对布局代码，根据规格发表自己的动态。  
&emsp; 代码示例：
~~~
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical"
>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/select_day" />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/select_time" />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/classroomNo" />
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
        android:text="@string/send" />
</LinearLayout>
~~~
## 四、实验结果
![lab4](https://raw.githubusercontent.com/Dynasty011/android-labs-2020/master/students/net1814080903322/lab4.PNG)

## 五、实验心得
&emsp; 在本次实验界面设计编程，在实验过程中遇到了布局内大小超出边界、重叠等问题，在经过修改对应的配置信息解决了问题。
