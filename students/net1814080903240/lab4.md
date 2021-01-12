# 实验四：Android界面设计编程
## 一、实验目标
1.	根据选题要求设计界面布局及控件使用
2.	布局xml及界面控制操作代码提交并截图
3.	将应用运行结果截图

## 二、实验内容
1.	在所学的几种布局方式中自行选择设计界面
2.	通过控件ID获取界面对象，执行相关操作
3.	实现界面控件的事件处理

## 三、实验步骤
1.	在自选题中参照的APP中截取所需要的图标，或者在阿里图标库中选取相符的图标
2.	为界面选取合适的布局，activity_main.xml（选取ConstraintLayout布局），activity_install.xml（选取RelativeLayout布局和选取LinearLayout布局）， 
activity_binding.xml（选取Gridview控件），activity_evaluate.xml（选取LinearLayout布局），根据需求选择控件使之与项目功能相适应
- activity_main.xml
```
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".BindingActivity">

    <Button
        android:id="@+id/button_main"
        android:layout_width="410dp"
        android:layout_height="50dp"
        android:text="@string/main_name"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.885"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.004" />

    <Button
        android:id="@+id/install"
        android:layout_width="120dp"
        android:layout_height="45dp"
        android:text="@string/main1_name"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.054"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.44" />

    <Button
        android:id="@+id/binding"
        android:layout_width="120dp"
        android:layout_height="45dp"
        android:text="@string/main2_name"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.44" />

    <Button
        android:id="@+id/comment"
        android:layout_width="120dp"
        android:layout_height="45dp"
        android:text="@string/main3_name"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.945"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.44" />

    <TextView
        android:layout_width="210dp"
        android:layout_height="21dp"
        android:text="使用海尔智家，开启智慧生活!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.577"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.998" />

    <ImageView
        android:id="@+id/imageView2"
        android:layout_width="429dp"
        android:layout_height="116dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.108"
        app:srcCompat="@drawable/logo2" />

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="481dp"
        android:layout_height="146dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.941"
        app:srcCompat="@drawable/main1" />

    <ImageView
        android:id="@+id/imageView3"
        android:layout_width="409dp"
        android:layout_height="173dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.664"
        app:srcCompat="@drawable/main3" />

    <ImageButton
        android:id="@+id/imageButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.308"
        app:srcCompat="@drawable/main2" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
- activity_binding.xml
```
<?xml version="1.0" encoding="utf-8"?>
<GridView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/grid_view"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:columnWidth="90dp"
    android:gravity="center"
    android:horizontalSpacing="10dp"
    android:numColumns="auto_fit"
    android:stretchMode="columnWidth"
    android:verticalSpacing="10dp" />
```
- activity_install.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:orientation="vertical"
    android:layout_weight="12"
    android:layout_height="wrap_content"
    tools:context=".InstallActivity">

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_weight="8"
        android:layout_height="wrap_content">


        <ImageView
            android:id="@+id/photo"
            android:layout_width="126dp"
            android:layout_height="145dp"
            android:layout_marginLeft="5dp"
            android:layout_marginTop="50dp"
            android:src="@drawable/logo" />

        <EditText
            android:layout_width="300dp"
            android:layout_height="wrap_content"
            android:id="@+id/name1"
            android:layout_marginTop="50dp"
            android:hint="@string/name"
            android:layout_marginLeft="5dp"
            android:layout_toRightOf="@id/photo"/>

        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/phone1"
            android:hint="@string/phone"
            android:layout_marginTop="100dp"
            android:layout_marginLeft="5dp"
            android:layout_toRightOf="@id/photo"/>

        <EditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:id="@+id/address1"
            android:hint="@string/address"
            android:layout_marginTop="150dp"
            android:layout_marginLeft="5dp"
            android:layout_toRightOf="@id/photo"/>
    </RelativeLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">


        <Button
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:text="@string/binding"/>

    </LinearLayout>

    <Spinner
        android:id="@+id/blank1"
        android:layout_width="410dp"
        android:layout_height="30dp"
        android:layout_alignParentLeft="true"
        android:layout_gravity="center"/>

    <TextView
        android:id="@+id/sever"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:width="150dp"
        android:height="50dp"
        android:gravity="center"
        android:text="选择服务:"
        android:textSize="24sp"
        android:layout_toRightOf="@id/photo"/>

    <CheckBox
        android:id="@+id/serve1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="安装"
        android:textSize="25sp"/>

    <CheckBox
        android:id="@+id/serve2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="维修"
        android:textSize="25sp"/>

    <CheckBox
        android:id="@+id/serve3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="移机"
        android:textSize="25sp"/>

    <CheckBox
        android:id="@+id/serve4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="咨询"
        android:textSize="25sp"/>

    <Spinner
        android:id="@+id/blank2"
        android:layout_width="410dp"
        android:layout_height="30dp"
        android:layout_alignParentLeft="true"
        android:layout_gravity="center"/>

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_weight="2"
        android:layout_height="wrap_content">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:id="@+id/time1"
            android:layout_marginTop="20dp"
            android:text="    预约时间: "
            android:textSize="25sp"
            android:gravity="center"/>

        <EditText
            android:layout_width="250dp"
            android:layout_height="wrap_content"
            android:id="@+id/time"
            android:layout_marginTop="10dp"
            android:hint="@string/time"
            android:layout_marginLeft="5dp"
            android:layout_toRightOf="@id/time1" />
    </RelativeLayout>

    <Spinner
        android:id="@+id/blank3"
        android:layout_width="410dp"
        android:layout_height="30dp"
        android:layout_alignParentLeft="true"
        android:layout_gravity="center"/>

        <Button
            android:layout_width="match_parent"
            android:layout_height="50dp"
            android:text="@string/send2"/>

</LinearLayout>
```
- activity_evaluate.xml
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical" >
    <TextView
        android:layout_width="100dp"
        android:layout_height="50dp"
        android:text="评价服务"/>
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/subject" />
    <EditText
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="@string/message" />

    <Button
        android:layout_width="124dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="@string/send" />
</LinearLayout>
```
3.	实现界面控件的事件处理
4.	运行项目，查看效果
5.	在Git Bash上提交实验代码和上传的图片

## 四、实验结果
![activity_evaluate.xml](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab4_evaluate.png)

![activity_binding.xml](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab4_binding.png)

![activity_main.xml](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab4_main.png)

![activity_install.xml](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab4_install.png)

## 五、实验心得
本次实验的内容是Android界面设计编程，实验难度中等。通过本次实验，我思考了整个项目的整体布局，我学习了界面布局和控件的使用，同时将项目的布局做了一次较大的修改，
我分别使用了ConstraintLayout布局、RelativeLayout布局、LinearLayout布局以及布局之间的嵌套，实现了界面控件的事件处理。
