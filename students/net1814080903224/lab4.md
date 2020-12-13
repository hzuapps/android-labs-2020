# 实验四、Android界面设计编程
## 一、实验目标
1、根据选题要求设计界面布局及控件使用；   
2、布局xml及界面控制操作代码提交并截图；   
3、将应用运行结果截图。
## 二、实验内容
1、在自选题目项目中添加图片；
2、使用显示
## 三、实验步骤
1、准备一张或多张命好名字的图片，名字不要有中文；
2、放入res/drawable文件目录下；
3、在布局背景background中使用@drawable/图片名字引用该图片
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/use1"
    tools:context=".Net1814080903224activity">


    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.073" />

    <Button
        android:id="@+id/recommend"
        android:layout_width="175dp"
        android:layout_height="81dp"
        android:layout_alignParentLeft="true"
        android:layout_marginLeft="262dp"
        android:text="@string/rec" />

    <Button
        android:id="@+id/care1"
        android:layout_width="147dp"
        android:layout_height="82dp"
        android:layout_alignParentright="true"
        android:text="@string/care1"

        tools:text="注意事项" />


</RelativeLayout>
```
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".RecommendActivity">

    <Button
        android:id="@+id/reback"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="left"
        android:text="返回">
    </Button>
        <ListView
            android:id="@+id/mobile_list"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">
        </ListView>
    </LinearLayout>

```
## 四、实验结果

## 五、实验心得体会
