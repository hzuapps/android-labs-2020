# 实验四 Android界面设计编程
## 一、实验要求
1.根据选题要求设计界面布局及控件使用  
2.布局xml及界面控制操作代码提交并截图  
3.将应用运行结果截图  
## 二、实验内容
1.使用LinearLayout，设计所选题目的界面  
2.通过控件ID获取界面对象，执行相关操作  
3.实现界面控件的事件处理  
## 三、实验步骤
1.使用LinearLayout对activity_first进行布局。代码如下
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Net1814080903326Activity">

    <ImageView
        android:id="@+id/iv_show"
        android:src="@drawable/user1"
        android:layout_width="100dp"
        android:layout_height="100dp"
        android:layout_weight="1"
        />

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
            android:id="@+id/btn_mine"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="我"
            />

        />
    </LinearLayout>

</LinearLayout>
```
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical" android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:textSize="25dp"
        android:textColor="@android:color/holo_red_light"
        android:text="第二页"
        android:layout_gravity="center"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

    </TextView>

</LinearLayout>
```
2.通过findViewById，创建对事件的监听
```java
public class Net1814080903326Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903326);

        initUI();
    }

    private void initUI() {
        findViewById(R.id.btn_inf).setOnClickListener(this);
        findViewById(R.id.btn_mine).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_inf:
                //跳转到第二界面
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),FirstActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_mine:
                //跳转到第二界面

                break;
        }

    }
}
```
## 四、实验结果
![result](https://github.com/Li3069/android-labs-2020/blob/master/students/net1814080903326/first.png)
![result](https://github.com/Li3069/android-labs-2020/blob/master/students/net1814080903326/second.png)
## 五、实验心得
这次实验主要是学习使用LinearLayout通过多次操作就能达到想要的效果。
