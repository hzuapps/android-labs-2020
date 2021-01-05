# 实验四

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；

2. 布局xml及界面控制操作代码提交并截图；

3. 将应用运行结果截图。

   

## 二、实验内容

​	1.使用一种布局方式设计界面；

​	2.通过控件ID获取界面对象，执行相关操作：

```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```

​	3.实现界面控件的事件处理，例如点击按钮：

```
public class MainActivity extends Activity  implements OnClickListener {    
    // ......   
    @Override    
    public void onClick(View v) { 
    // ......
```

​	4.操作之后，切换到第二个界面。



## 三、实验步骤

1.主页面设置了二个按钮，分别代表了二个功能，关卡开始，道具；

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".sec1814080911236Activity"
    android:background="@drawable/bg">

    <LinearLayout
        android:layout_width="409dp"
        android:layout_height="358dp"
        android:orientation="horizontal"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp">

        <Button
            android:id="@+id/props_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="道具"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="70dp"/>

        <Button
            android:id="@+id/checkpoint_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="关卡开始"
            android:layout_marginTop="300dp"
            android:layout_marginLeft="85dp"/>
    </LinearLayout>

</LinearLayout>
```

2.道具界面使用了线性布局，并进行了相应的配置；

```
<LinearLayout
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools"
android:layout_width="match_parent"
android:layout_height="match_parent"
android:orientation="vertical"
tools:context=".BuyActivity">
<ListView
    android:id="@+id/mobile_list"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    >
</ListView>
</LinearLayout>
```



## 四、实验结果

[![实验截图](https://github.com/zhanglinfeng1234/android-labs-2020/blob/master/students/sec1814080911236/4.lab.png)

## 五、实验心得

​        本次实验主要是实现界面控件的事件处理，比如点击按钮和通过控件ID获取界面对象，执行相关的操作，在此次实验中我使用了Linerlayout布局方法，主要是这种布局方法比较容易理解和实现。