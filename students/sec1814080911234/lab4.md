#  实验四

## 一、实验目标

- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图。

## 二、实验内容

- 使用一种布局方式设计界面；
- 通过控件ID获取界面对象，执行相关操作：
- 实现界面控件的事件处理;
- 操作之后，切换到第二个界面。

## 三、实验步骤

- 1.三个界面创建事件、日期计算和节假日均采用线性布局。
- 2.在创建事件界面创建两个输入文本框EditTest用来获取事件名称和日期，再添加一个创建按钮。
```xml
<EditText
        android:id="@+id/edit1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/s_name" />
    <EditText
        android:id="@+id/edit2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/s_date" />

    <Button
        android:id="@+id/button1"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="@string/create" />
```
- 3.在日期计算界面添加一个EditTest用于获取日期，添加一个ImageView用于显示计算结果，添加一个查询按钮。
```xml
<TextView
        android:id="@+id/date_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textAlignment="center"
        android:text="剩余天数"/>

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/s_date"
        android:layout_marginTop="10dp"/>

    <Button
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="查询" />
```
- 4.在节假日界面添加多个ImageView用于显示节假日剩余天数。
```xml
<TextView
        android:id="@+id/fes1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="距离春节还剩"/>

    <TextView
        android:id="@+id/fes2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="距离劳动节还剩"/>

    <TextView
        android:id="@+id/fes3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="距离端午节还剩"/>

    <TextView
        android:id="@+id/fes4"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="距离中秋节还剩"/>
    <TextView
        android:id="@+id/fes5"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="距离国庆节还剩"/>
```

## 四、实验结果

![lab4](raw.githubusercontent.com/1728799039/android-labs-2020/master/students/sec1814080911234/lab4.png)

## 五、心得体会

本次实验通过布局和控件，实现页面的基本设计。
