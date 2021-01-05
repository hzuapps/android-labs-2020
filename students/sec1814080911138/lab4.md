# 实验四
## 一、实验目标		
1、根据选题要求设计界面布局及控件使用；  
2、布局xml及界面控制操作代码提交并截图；  
3、将应用运行结果截图。（不要做登录注册！）    

## 二、实验要求	
1、使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。  
LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)  
2、通过控件ID获取界面对象，执行相关操作；  
3、实现界面控件的事件处理，例如点击按钮；  
4、操作之后，切换到你的第二个界面。    

## 三、实验步骤	
1、activity_chart.xml    
```
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ChartActivity">
```  

```
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="10dp"
        android:background="@drawable/yz2">  

 <lecho.lib.hellocharts.view.LineChartView>/*首先我们先往项目里添加一个画折线图需要的依赖包hellocharts-library-1.5.8.jar */
        android:id="@+id/chart"
        android:padding="20dp"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:ignore="MissingClass" />
        tools:ignore="MissingClass" >
     </lecho.lib.hellocharts.view.LineChartView >

  </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>

```
实验截图：
![avatar](https://github.com/1814080911138/android-labs-2020/blob/master/students/sec1814080911138/7.png)  

2、activity_about.xml   
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AboutActivity">

    </androidx.constraintlayout.widget.ConstraintLayout>
```
实验截图：
![avatar](https://github.com/1814080911138/android-labs-2020/blob/master/students/sec1814080911138/5.png)  


3、activity_sec1814080911138.xml   
```
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Sec1814080911138Activity">

</androidx.constraintlayout.widget.ConstraintLayout>
```
实验截图：
![avatar](https://github.com/1814080911138/android-labs-2020/blob/master/students/sec1814080911138/6.png)  

## 四、实验心得
 本次实验是本学期移动应用开发的第四次实验课，初步学会了Android界面设计编程，学会设计界面布局及控件的使用。
