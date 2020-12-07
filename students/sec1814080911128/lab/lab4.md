# 实验四
## 一、实验目标 #

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！）

## 二、实验内容 #

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout；
2. 通过控件ID获取界面对象，执行相关操作；
3. 实现界面控件的事件处理，例如点击按钮；
4. 操作之后，切换到你的第二个界面。

## 三、实验步骤 #

1. 使用LinearLayout布局
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <LinearLayout
            android:id="@+id/loading"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:orientation="vertical"
            android:visibility="invisible">

            <ProgressBar
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />

            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="正在加载信息..." />
        </LinearLayout>

        <ListView
            android:id="@+id/lv_news"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </FrameLayout>
</LinearLayout>
```
2. 初始化控件（通过控件ID获取界面对象，执行相关操作；）
```java
    private void initView() {
        loading = (LinearLayout) findViewById(R.id.loading);
        lvNews = (ListView) findViewById(R.id.lv_news);
    }
```
3. 实现界面控件的事件处理，例如点击按钮；
```java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
```

## 四、实验结果 #

![运行结果](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab4.png)
## 五、实验心得 #
通过本次实验，了解了设计界面布局及控件的使用，对于完成整改程序是较为重要的一步，后续会继续更新。