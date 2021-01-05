# 实验四 Android界面设计编程

## 一、实验要求

- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图；

## 二、实验内容

- 在所学的几种布局方式中自行选择设计界面；
- 通过findViewById获取界面对象，执行相关操作；
- 实现界面控件的事件处理；


## 三、实验步骤
1. APP首页actvity_main.xml使用LinearLayout进行布局，在LinearLayout容器中，包含一个imageview控件，两个button控件分别链接其他两个页面，通过设置layout_height、layout_width、layout_marginTop、layout_gravity等，来进行组件首页组件布局
```activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".Sec1814080911102Activity"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/iv_homepage"
        android:layout_width="278dp"
        android:layout_height="117dp"
        android:layout_gravity="center"
        android:layout_marginTop="140dp"
        app:srcCompat="@drawable/homepage_clock"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/button_list"
        android:layout_width="170dp"
        android:layout_height="90dp"
        android:layout_marginTop="40dp"
        android:layout_gravity="center"
        android:text="待办事项"
        android:textSize="30dp"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/button_clock"
        android:layout_width="170dp"
        android:layout_height="90dp"
        android:layout_marginTop="35dp"
        android:layout_gravity="center"
        android:text="专注计时"
        android:textSize="30dp"
        tools:ignore="MissingConstraints" />

</LinearLayout>
```

2. 在待办事项页面中，需要用到列表，所以要将页面中的列表以单个组件的形式封装成一个新的组件activity_list_child.xml
``` activity_list_child.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    >
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical">
        <TextView
            android:id="@+id/textView1"
            android:layout_width="wrap_content"
            android:layout_height="50dp"
            android:gravity="center"
            android:text="吃饭睡觉"
            android:textSize="25dp" />
    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:gravity="right">

        <!--android:gravity是指定本元素的子元素相对它的对齐方式。
        android:layout_gravity是指定本元素相对它的父元素的对齐方式-->

        <Button
            android:id="@+id/button_item_done"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_gravity="center"
            android:text="√"
            android:textSize="20dp"/>

        <Button
            android:id="@+id/button_item_delete"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_gravity="center"
            android:text="×"
            android:textSize="20dp" />
    </LinearLayout>
</LinearLayout>
```

3. 在待办事项页面activity_list.xml中，包含一个TextView控件，一个button控件，还有一个ScrollView容器用来包裹列表，实现滚动效果
``` activity_list.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:text="待办事项"
        android:textSize="25sp"
        android:layout_gravity="center"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/button_newitems"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:backgroundTint="@android:color/background_light"
        android:text="新建待办"
        android:layout_gravity="center"
        tools:ignore="MissingConstraints" />

    <ScrollView
        android:id="@+id/vertical_scroll_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
        <LinearLayout
            android:layout_width="300dp"
            android:layout_height="match_parent"
            android:layout_gravity="center"
            android:orientation="vertical">
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
            <include layout="@layout/acticity_list_child" />
        </LinearLayout>
    </ScrollView>

</LinearLayout>
```

4. 在专注计时页面activity_clock.xml中，使用了纵向的LinearLayout布局，包含了一个TextView控件，一个Chronometer计时器控件，还嵌套了一个水平的LinearLayout布局，内含三个button控件，用于控制计时器
``` activity_clock.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    tools:context=".Sec1814080911102Activity"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tv_clock"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="200dp"
        android:text="专注计时"
        android:textSize="25sp"
        tools:ignore="MissingConstraints" />

    <Chronometer
        android:id="@+id/ch_clock"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:layout_gravity="center"
        android:textSize="25pt" />

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginTop="30dp">

        <Button
            android:id="@+id/button_start"
            android:text="开始计时"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <Button
            android:id="@+id/button_stop"
            android:text="暂停计时"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <Button
            android:id="@+id/button_Go_on"
            android:text="继续计时"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

    </LinearLayout>

</LinearLayout>
```


## 四、实验结果
- 主页
![主页](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab4%E4%B8%BB%E9%A1%B5.PNG)

- 子列表
![子列表](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab4%E5%AD%90%E5%88%97%E8%A1%A8.PNG)

- 待办事项界面
![待办事项页面](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab4%E5%BE%85%E5%8A%9E%E4%BA%8B%E9%A1%B9%E9%A1%B5%E9%9D%A2.PNG)

- 专注计时页面
![专注计时页面](https://github.com/2587900/android-labs-2020/blob/master/students/sec1814080911102/screenshots/lab4专注计时页面.PNG)

## 五、实验心得
 通过本次实验，我了解了各种布局的应用，对APP的整体页面的布局做了一个合理美观的布局，同时认识到了许多不同的控件及其功能，对布局的调整和对部件的设置更加熟练。