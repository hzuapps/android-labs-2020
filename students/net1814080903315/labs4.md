# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

##  二、实验内容
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

## 三、实验步骤

1. 进入主界面activity_main.xml；
2. 使用LinearLayout布局；
3. 写好三个个Button按钮，分别对应三个功能。

activity_main.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903315Activity">


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal"
            android:background="@drawable/tuku"
            tools:layout_editor_absoluteX="150dp"
            tools:layout_editor_absoluteY="267dp">



            <Button
                android:id="@+id/button_open1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="储存图片"
                android:layout_gravity="bottom"
                android:layout_weight="1" />

            <Button
                android:id="@+id/button_open2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="分类图片"
                android:layout_gravity="bottom"
                android:layout_marginLeft="20dp"
                android:layout_weight="1" />

            <Button
                android:id="@+id/button_open3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="查看图片"
                android:layout_gravity="bottom"
                android:layout_marginLeft="20dp"
                android:layout_weight="1"
               />

        </LinearLayout>



</androidx.constraintlayout.widget.ConstraintLayout>
```
1. 进入activity_save.xml；
2. 使用的是Constraintlayout布局；
3. 写好一个要创建的可编辑的要创建的相册名文本编辑框，外加1个相册名的创建按钮和一个相册名的删除按钮；
4. 写好一个返回主页的按钮；
5. 写好一个保存图片的按钮和删除图片的按钮。

activity_save.xml如下

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SaveActivity">


    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="-115dp"
        tools:layout_editor_absoluteY="0dp">


        <Button
            android:id="@+id/create_picturename"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/create_picturename"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.965"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.127"
            tools:ignore="MissingConstraints" />

        <Button
            android:id="@+id/delete_picturename"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/detele_picturename"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.965"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.238"
            tools:ignore="MissingConstraints" />

        <Button
            android:id="@+id/save"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/save"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.128"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.976"
            tools:ignore="MissingConstraints" />

        <Button
            android:id="@+id/delete_picture"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/delete_picture"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.871"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.976"
            tools:ignore="MissingConstraints" />

        <Button
            android:id="@+id/back"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/save_back"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.95"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.043"
            tools:ignore="MissingConstraints" />

        <EditText
            android:id="@+id/input_create_picture"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="@string/input_create_picturename"
            android:ems="10"
            android:inputType="textEmailAddress"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.333"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.142"
            android:importantForAutofill="no"
            tools:ignore="LabelFor" />

    </androidx.constraintlayout.widget.ConstraintLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

1. 进入activity_seek.xml；
2. 使用Linearlayout布局；
3. 设计一个搜索框，进行的是图片信息名搜索，来查找图片；
4. 写好一个返回主页的按钮。

activity_seek.xml如下:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SeekActivity">


   <LinearLayout

        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
        <!-- 顶一个SearchView -->
        <SearchView
            android:id="@+id/seek"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:iconifiedByDefault="false"
            android:queryHint="请输入搜索内容"/>
        <!-- 为SearchView定义自动补齐的ListView-->

        <ListView
            android:id="@+id/listview"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1">

        </ListView>
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

1. 进入activity_sorted.xml；
2. 使用的是Constraintlayout布局；
3. 写好一个要创建的可编辑的要分入的相册名文本编辑框，以及分入按钮；
4. 写好一个返回主页的按钮。

activity_sorted.xml如下:

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SortedActivity">


    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="-115dp"
        tools:layout_editor_absoluteY="0dp">

        <Button
            android:id="@+id/save"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="bottom"
            android:layout_weight="1"
            android:text="@string/sorted"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.498"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.976"
            tools:ignore="MissingConstraints" />



        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/sorted_back"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.949"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.023" />

        <EditText
            android:id="@+id/picturename"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:hint="@string/input_picturename"
            android:ems="10"
            android:inputType="textEmailAddress"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.482"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            app:layout_constraintVertical_bias="0.276"
            tools:ignore="LabelFor"
            android:importantForAutofill="no" />


    </androidx.constraintlayout.widget.ConstraintLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```
## 四、实验结果及截图

![实验四图片](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/4.jpg)

## 五、实验心得
本次实现主要实现界面布局，并且完善界面点击操作事件，添加了一些可输入的文本框，使界面更加丰富，学到了三种布局，我在这次实验使用了两种布局，一个是linearlayout，另外一个是constraintlayout，学到了非常多的东西。
