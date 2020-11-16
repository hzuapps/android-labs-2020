# 实验四 
  ## 一、实验目标 
  1. 根据选题要求设计界面布局及控件使用； 
  2. 布局xml及界面控制操作代码提交并截图； 
  3. 将应用运行结果截图。 
  
   ## 二、实验内容 
  1. 使用一种布局方式设计界面； 
  2. 通过控件ID获取界面对象，执行相关操作： 
  3. 实现界面控件的事件处理; 
  4. 操作之后，切换到第二个界面。 
  
   ## 三、实验步骤 
  1. 主页面使用RelativeLayout布局并设计两个按钮和文本框。
  ```xml
    <Spinner
        android:id="@+id/dates"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true" />

    <EditText
        android:id="@+id/class_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/dates"
        android:hint="@string/c_reminder" />
    <EditText
        android:id="@+id/homework_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/class_name"
        android:hint="@string/h_reminder" />
```
  2. check按钮，add按钮点击实现跳转。
  3. check页面设计了列表，add页面设计一个同功能的check按钮。
   ```java
   public class check1814080903138Activity extends AppCompatActivity {
     String[] myitem = { "作业一", "实验一","作业二","作业三","实验二" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check1814080903138);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                check1814080903138Activity.this, android.R.layout.simple_list_item_1, myitem);
        ListView listView = (ListView) findViewById(R.id.mlist);
        listView.setAdapter(adapter);
    }
}
   ```
   ## 四、实验结果 
  ![lab4](https://github.com/linjhong/android-labs-2020/blob/master/students/net1814080903138/lab4.png)
  
   ## 五、实验心得 
  本次实验在ListView的设计上出现了问题，没办法显示列表并强制退出程序。最后检查出来是代码的问题，使用了Andriod提供的simple_view代码解决了该问题。

