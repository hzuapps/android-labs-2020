# 实验四
## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容

1. 选择布局方式布局界面中的控件；
2. 通过控件ID获取界面对象，执行相关操作；
3. 完善选题功能，实现界面控件的事件处理。

## 三、实验步骤

1. 在主界面中使用LinearLayout布局，布局两个按钮的位置；
```xml
<LinearLayout
        android:background="@drawable/diary"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

    <Button

        android:id="@+id/pwd_btn"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:text="设置密码"
        android:textSize="16dp"
        android:layout_marginTop="400dp"
        android:textColor="@color/design_default_color_secondary_variant" />

    <Button
        android:id="@+id/add_btn"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:text="添加日记"
        android:textSize="16dp"
        android:layout_marginTop="10dp"
        android:textColor="@color/design_default_color_secondary_variant" />
</LinearLayout>
```
2. 在activity_password.xml中使用LinearLayout，布局一个图片，再内嵌一个LinearLayout布局，设置按钮位置；
```xml
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="232dp">

        <TextView
            android:id="@+id/lock"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="10dp"
            android:layout_marginBottom="10dp"
            android:drawableLeft="@drawable/lock"
            />
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="horizontal">
            <Button
                android:id="@+id/set_btn"
                android:layout_width="100dp"
                android:layout_height="70dp"
                android:text="设置"
                android:textSize="25dp"
                android:layout_marginLeft="60dp"
                android:textColor="@color/design_default_color_secondary_variant"
                />
            <Button
                android:id="@+id/back_btn2"
                android:layout_width="100dp"
                android:layout_height="70dp"
                android:text="返回"
                android:textSize="25dp"
                android:textColor="@color/design_default_color_secondary_variant"
                android:layout_marginLeft="60dp"
                />
       </LinearLayout>
</LinearLayout>
```
3. 在activity_add_diary.xml中使用LinearLayout，布局两个EdietText，再内嵌一个LinearLayout布局，设置按钮位置。
```xml
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        tools:layout_editor_absoluteX="0dp"
        tools:layout_editor_absoluteY="35dp">

        <EditText
            android:id="@+id/editText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="请输入标题"
            android:textColorHint="@color/colorPrimaryDark" />

        <EditText
            android:layout_width="match_parent"
            android:layout_height="528dp"
            android:layout_weight="1"
            android:gravity="left"
            android:hint="请输入内容"
            android:textColorHint="@color/colorPrimaryDark" />

        <LinearLayout
            android:layout_width="409dp"
            android:layout_height="38dp"
            android:orientation="horizontal">

            <Button
                android:id="@+id/save_btn"
                android:layout_width="213dp"
                android:layout_height="match_parent"
                android:text="保存"
                android:textSize="15dp"
                android:textColor="@color/design_default_color_secondary_variant" />

            <Button
                android:id="@+id/back_btn1"
                android:layout_width="194dp"
                android:layout_height="wrap_content"
                android:text="返回"
                android:textSize="15dp"
                android:textColor="@color/design_default_color_secondary_variant" />
        </LinearLayout>
</LinearLayout>
```
## 四、实验结果

![主界面](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab1(1).png)
![次界面](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab2(1).png)
![次界面](https://github.com/zkw55/android-labs-2020/blob/master/students/net1814080903125/lab2(1).png)

## 五、实验心得体会

本次实验掌握了线性布局、相对布局等方式，在做实验的过程中，由于选题内容较为简单，使用线性布局就能够做出相应的界面效果。
