# 实验三
## 一、实验目标
1.了解Android应用中各种资源的概念与使用方法；
2.掌握在Android应用中使用图片等资源的方法。
## 二、实验内容
1.在界面上显示至少一张图片（按照自己的题目添加）；
2.提交res/drawable及图片使用的代码；
3.提交res/values, res/layout等其他代码；
4.将应用运行结果截图，放到实验报告中；
5.点击图片（或按钮）时，打开另一个Activity。
## 三、实验步骤
1.将图片放到res下的drawable文件夹

2. 在splash_activity.xml插入启动页面的图片

``` xml
<ImageView
        android:id="@+id/iv_show"
        android:src="@drawable/user1"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_weight="1"
        />
```

3. 打开一个Activity

```java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903326);
        initUI();
    }

    private void initUI() {
        findViewById(R.id.btn_inf).setOnClickListener(this);
        findViewById(R.id.btn_mine).setOnClickListener(this);
    }
```

## 四、实验结果
```java
<LinearLayout

        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center"
        android:orientation="horizontal">
        <Button
            android:id="@+id/btn_inf"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="消息"
            ></Button>
        <Button
            android:id="@+id/btn_view"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="视频"
            ></Button>

        <Button
            android:id="@+id/btn_mine"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="我"
            ></Button>

        />
    </LinearLayout>
```

## 五、实验心得
这次实验在主页上添加了一张图片，并且点击主页的按钮进行跳转。
实验结果图片：
https://github.com/Li3069/android-labs-2020/blob/master/students/net1814080903326/first.png
