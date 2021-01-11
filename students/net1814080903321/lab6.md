# 实验六 Android网络编程

## 一、实验目标

- 掌握Android网络访问方法；
- 理解XML和JSON表示数据的方法。

## 二、实验内容

- 在个人目录中创建一个表示数据的XML或JSON文件；
- 数据文件代码提交之后从GitHub获取文件URL；
- 在应用中通过网络编程访问GitHub的数据文件；
- 在应用中解析并显示文件所包含的数据；
- 将应用运行结果截图。

## 三、实验步骤

- 在activity_show.xml中创建 FloatingActionButton 组件

```xml
    <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerInParent="true"
        android:layout_marginEnd="28dp"
        android:layout_marginRight="28dp"
        android:layout_marginBottom="40dp"
        android:clickable="true"
        android:src="?android:attr/listChoiceIndicatorSingle"
        app:backgroundTint="#C1E6FF"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        tools:ignore="MissingConstraints"
        tools:visibility="visible" />
```

- 在ShowActivity.java为 FloatingActionButton 添加点击事件处理
- 通过 startActivity(i) 实现界面跳转，实现点击返回主页

```java
        FloatingActionButton fab = findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ShowActivity.this, Net1814080903321Activity.class);
                startActivity(i);
            }
        });
```

- 在activity_store.xml中创建 FloatingActionButton 组件

```xml
            <com.google.android.material.floatingactionbutton.FloatingActionButton
            android:id="@+id/fab2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignParentBottom="true"
            android:layout_centerInParent="true"
            android:layout_marginEnd="28dp"
            android:layout_marginRight="28dp"
            android:layout_marginBottom="40dp"
            android:clickable="true"
            android:src="?android:attr/listChoiceIndicatorSingle"
            app:backgroundTint="#C1E6FF"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            tools:ignore="MissingConstraints"
            tools:visibility="visible" />
```

- 在StoreActivity.java为 FloatingActionButton 添加点击事件处理
- 通过 startActivity(i) 实现界面跳转，实现点击返回主页

```java
        FloatingActionButton fab = findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StoreActivity.this, Net1814080903321Activity.class);
                startActivity(i);
            }
        });
```

- 在activity_personal_details.xml中创建 FloatingActionButton 组件

```xml
        <com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/fab3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerInParent="true"
        android:layout_marginEnd="28dp"
        android:layout_marginRight="28dp"
        android:layout_marginBottom="40dp"
        android:clickable="true"
        android:src="?android:attr/listChoiceIndicatorSingle"
        app:backgroundTint="#C1E6FF"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        tools:ignore="MissingConstraints"
        tools:visibility="visible" />
```

- 在PersonalDetailsActivity.java为 FloatingActionButton 添加点击事件处理
- 通过 startActivity(i) 实现界面跳转，实现点击返回主页

```java
        FloatingActionButton fab = findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonalDetailsActivity.this, Net1814080903321Activity.class);
                startActivity(i);
            }
        });

```

## 四、实验结果

![运行截图](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/6_1.jpg)  
页面添加悬浮按钮运行截图

## 五、实验心得
    本次实验学习网络编程，不过没有做网络编程，而是继续完善APP的界面设计。添加了FloatingActionButton组件（悬浮按钮），实现各页面点击悬浮按钮返回主页。
