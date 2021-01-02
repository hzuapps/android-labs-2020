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
&emsp; 2.在activity_linear_list.xml文件中配置相对布局代码，根据规格发表自己的动态。  
&emsp; 代码示例：
~~~
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp" >
    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="reminder" />

    <Spinner
        android:id="@+id/dates"
        android:layout_width="264dp"
        android:layout_height="69dp"
        android:layout_below="@id/name"
        android:layout_alignParentLeft="true"
        android:layout_marginLeft="37dp"
        android:layout_marginTop="600dp"
        android:layout_marginRight="16dp"
        android:layout_toLeftOf="@+id/times" />

    <Spinner
        android:id="@id/times"
        android:layout_width="123dp"
        android:layout_height="35dp"
        android:layout_below="@id/name"
        android:layout_alignParentRight="true"
        android:layout_marginTop="585dp"
        android:layout_marginRight="7dp"
        android:entries="@array/medal" />

    <Button
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/times"
        android:layout_alignParentRight="true"
        android:layout_marginTop="4dp"
        android:layout_marginRight="31dp"
        android:text="done" />


</RelativeLayout>
~~~
## 四、实验结果
![lab4](https://raw.githubusercontent.com/Hacker-LAM/android-labs-2020/master/students/net1814080903304/lab4.jpg)

## 五、实验心得
&emsp; 在本次实验界面设计编程，在认识了使用各个布局后的界面，另外根据自己项目的需要选择了相对布局，在实验过程中遇到了布局内大小超出边界、重叠等问题，在经过修改对应的配置信息解决了问题。
