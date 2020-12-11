# 实验三：Android资源使用编程

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验要求

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

将图片放到项目中的 src/main/res/drawable 中。

在activity_Plan.xml,添加TextView，如下：

```xml
<TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/plan"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"
        android:text="  指定计划" />
```

在 activity_performance.xml添加TextView，如下：

```xml
<TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/performance"
        android:text="  开始运动"
        android:paddingLeft="160dp"
        android:paddingTop="100dp"/>
```

在 activity_sec1814080911222.xml,添加 background 如下：

```
android:background="@drawable/bg"
```

然后再在java代码中调整图片大小

```java
public class PlanActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Button btnOpen1 = (Button) findViewById(R.id.main_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911222Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Drawable drawable = getResources().getDrawable(R.drawable.plan);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }
}
```

```java
public class PerformanceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        Button btnOpen = (Button) findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911222Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });


        Drawable drawable = getResources().getDrawable(R.drawable.performance);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }


}

```

## 四、实验结果及截图

![tp1](https://github.com/zsc-do/android-labs-2020/blob/master/students/sec1814080911222/lab1-4/lab2(1).png)


![tp2](https://github.com/zsc-do/android-labs-2020/blob/master/students/sec1814080911222/lab1-4/lab2(2).png)


![tp3](https://github.com/zsc-do/android-labs-2020/blob/master/students/sec1814080911222/lab1-4/lab2(3).png)

## 五、实验心得

成功在activity中插入图片，并且通过在xml中设置了一系列的样式与布局，并成功运行，学习并使用了最常见的线性布局。