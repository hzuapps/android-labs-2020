# 实验四

## 一、实验目标
- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图。
## 二、实验内容
- 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。  
LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)
- 通过控件ID获取界面对象，执行相关操作：
```xml
android:id="@+id/my_button"
```
```Java
findViewById(R.id.my_button);
```
实现界面控件的事件处理，例如点击按钮：
```java
public class MainActivity extends Activity  implements OnClickListener {    
    // ......   
    @Override    
    public void onClick(View v) { 
    // ......
```
操作之后，切换到你的第二个界面。
## 三、实验步骤
1. 根据选题确定所需的页面，依据我的课题目前创建了5个页面，在此前实验中有提及。
2. 学习本节知识后对此前页面进行布局设计，大多数使用了LinearLayout。  
其中有些页面使用布局嵌套，例如：  
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="fill_parent"
    android:layout_height="match_parent"
//......

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="79dp"
        android:layout_weight="0.28">
//......
```
3. 根据我的需求，在页面布局下添加按钮与其他组件  
添加按钮，例如：  
```xml
<Button
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_gravity="right"
            android:layout_weight="1"
            android:text="@string/yes"
            android:backgroundTint="#50b35a" />
```  
添加图片框，例如：  
```xml
<ImageView
        android:layout_width="match_parent"
        android:layout_height="380dp"
        android:src="@drawable/main"
        />
```  
添加输入框，例如：
```xml
<EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/placename" />
```
添加ListView，例如：
```xml
<ListView
        android:id="@+id/mobile_list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" >
</ListView>
```
4. 对按钮或各组件添加点击事件等，在此前实验已经实现，此次报告不再赘述

## 四、实验结果
![lab4](raw.githubusercontent.com/tangcongbaobing/android-labs-2020/master/students/sec1814080911210/lab4.PNG)  
![lab4(2)](raw.githubusercontent.com/tangcongbaobing/android-labs-2020/master/students/sec1814080911210/lab4(2).PNG)
## 五、实验心得
本次实验主要学习了布局，其中有线性布局、相对布局、适配器等，根据我的课题以及我个人对知识的掌握程度，我大部分页面选择了线性布局进行页面设计。
总体而言，线性布局还是比较简单的，容易上手。此外，在本节课的学习过程中还学会了EditText组件的使用，正好能满足我课题的功能需求，于是便在此次设计中使用了该组件，
效果较符合预期，更加完备的功能还需要在接下来的课程学习中不断完善。
