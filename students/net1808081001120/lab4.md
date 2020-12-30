# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。**（不要做登录注册！）**

##  二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

## 三、实验步骤

1. 创建一个HistoryActivity,并在activity_history.xml中，选择Design界面
2. 在Text中拉3个TextView，作为表头名称存放位置；
3. 在Text中拉3个EditTxet，作为签到数据存放位置；
4. 将一个Button按钮嵌入。

activity_history.xml
```
    <TextView
        android:id="@+id/textView3"
        android:layout_width="150dp"
        android:layout_height="47dp"
        android:layout_marginTop="72dp"
        android:layout_marginEnd="128dp"
        android:gravity="center"
        android:text="历史记录"
        android:textSize="30sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraint Top_toTopOf="parent" />

    <TextView
        android:id="@+id/textView4"
        android:layout_width="80dp"
        android:layout_height="42dp"
        android:layout_marginStart="120dp"
        android:layout_marginTop="76dp"
        android:gravity="center"
        android:text="编号"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3" />

    <TextView
        android:id="@+id/textView5"
        android:layout_width="102dp"
        android:layout_height="42dp"
        android:gravity="center"
        android:text="签到日期"
        android:textSize="18sp"
        app:layout_constraintStart_toEndOf="@+id/textView4"
        app:layout_constraintTop_toTopOf="@+id/textView4" />

    <EditText
        android:id="@+id/editTextTextPersonName2"
        android:layout_width="80dp"
        android:layout_height="42dp"
        android:ems="10"
        android:gravity="center"
        android:inputType="textPersonName"
        android:text="1"
        app:layout_constraintStart_toStartOf="@+id/textView4"
        app:layout_constraintTop_toBottomOf="@+id/textView4" />

    <EditText
        android:id="@+id/editTextTextPersonName3"
        android:layout_width="80dp"
        android:layout_height="42dp"
        android:ems="10"
        android:gravity="center"
        android:inputType="textPersonName"
        android:text="2"
        app:layout_constraintStart_toStartOf="@+id/editTextTextPersonName2"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName2" />

    <EditText
        android:id="@+id/editTextTextPersonName4"
        android:layout_width="80dp"
        android:layout_height="42dp"
        android:ems="10"
        android:gravity="center"
        android:inputType="textPersonName"
        android:text="3"
        app:layout_constraintStart_toStartOf="@+id/editTextTextPersonName3"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName3" />

    <EditText
        android:id="@+id/editTextTextPersonName5"
        android:layout_width="102dp"
        android:layout_height="42dp"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName2"
        app:layout_constraintTop_toBottomOf="@+id/textView5" />

    <EditText
        android:id="@+id/editTextTextPersonName6"
        android:layout_width="102dp"
        android:layout_height="42dp"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName3"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName5" />

    <EditText
        android:id="@+id/editTextTextPersonName7"
        android:layout_width="102dp"
        android:layout_height="42dp"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName4"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName6" />
```

activity_personview.xml
```
    <TextView
        android:id="@+id/textView2"
        android:layout_width="203dp"
        android:layout_height="57dp"
        android:layout_marginTop="268dp"
        android:layout_marginEnd="104dp"
        android:background="#4CAF50"
        android:gravity="center"
        android:text="已成功签到"
        android:textSize="36sp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="247dp"
        android:layout_height="46dp"
        android:layout_marginStart="80dp"
        android:layout_marginTop="356dp"
        android:background="#F8F4F4"
        android:text="查看签到记录"
        android:textColor="#3F51B5"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
PersonviewActivity.java
```
public class PersonviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personview);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PersonviewActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

    }
}
```
   
## 四、实验结果及截图


![实验四图片](https://github.com/SaTarU1IX/android-labs-2020/blob/master/students/net1808081001120/lab-4(1).png)

![实验四图片](https://github.com/SaTarU1IX/android-labs-2020/blob/master/students/net1808081001120/lab-4(2).png)



## 五、实验心得
本次实现主要实现界面布局，并且完善界面点击操作事件，也添加了一些可输入边框，使界面更加丰富。
