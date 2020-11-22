# 实验四
## 1.实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！）

## 2.实验内容
1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。
LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)
2. 通过控件ID获取界面对象，执行相关操作：
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
3. 实现界面控件的事件处理，例如点击按钮：
4. 操作之后，切换到你的第二个界面。

## 3.实验步骤
1. 配置net_1814080903316_activity.xml为LinearLayout，配置activity_imformation.xml与activity_table.xml为ConstraintLayout。
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Net1814080903316Activity">
</LinearLayout>

<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".TableActivity">
</androidx.constraintlayout.widget.ConstraintLayout>

<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ImformationActivity">
</androidx.constraintlayout.widget.ConstraintLayout>
```
2. 配置activity_imformation.xml，通过TextView与Plain Text组件添加相应的文字说明和文字框。
```
    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginLeft="24dp"
        android:layout_marginTop="60dp"
        android:text="学号："
        android:textSize="24sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/ID"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="51dp"
        android:layout_marginLeft="51dp"
        android:ems="10"
        android:enabled="true"
        android:inputType="textPersonName"
        android:text="ID"
        app:layout_constraintBaseline_toBaselineOf="@+id/textView2"
        app:layout_constraintStart_toEndOf="@+id/textView2" />
```
3. 设计item.xml作为适配器的参数。
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">
    
    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:height="50dp"
        android:text="TextView"
        android:textSize="30sp" />
</LinearLayout>

```
4. 在activity_table.xml中添加ListView组件。
```
<ListView
        android:id="@+id/listView"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="1dp"
        android:layout_marginLeft="1dp"
        android:layout_marginTop="1dp"
        android:layout_marginEnd="1dp"
        android:layout_marginRight="1dp"
        android:layout_marginBottom="1dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

5. 在TableActivity.java中声明字符串数组与适配器，将适配器配置在activity_table.xml中的ListView组件上。
```
    String[] weekArrays = { //
            "星期一", "星期二", "星期三", "星期四",
            "星期五", "星期六", "星期天"
    };
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item,R.id.textView, weekArrays);
    ListView listView=(ListView)findViewById(R.id.listView);
    listView.setAdapter(adapter);
```

## 4.实验结果
![项目图片](https://raw.githubusercontent.com/alllovetaken/android-labs-2020/master/students/net1814080903316/lab4_1.PNG)
![项目图片](https://raw.githubusercontent.com/alllovetaken/android-labs-2020/master/students/net1814080903316/lab4_2.PNG)

## 5.实验心得
  这次实验最大问题出在适配器的使用上。声明配置适配器的java类与xml界面文件不对应，虽然在编译期间没有报错，但一旦运行就会直接闪退。
 
