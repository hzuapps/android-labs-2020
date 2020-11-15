# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

# 二、实验内容

1.使用其中一种布局方式，设计所选题目的界面。
2.通过控件ID获取界面对象，执行相关操作：
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
3.实现界面控件的事件处理，例如点击按钮：
image

public class MainActivity extends Activity  implements OnClickListener {    
    // ......   
    @Override    
    public void onClick(View v) { 
    // ......
4.操作之后，切换到你的第二个界面。

# 三、实验步骤

1. 在activity_net1814080903338.xml中使用LinearLayout 

    ```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:background="@drawable/bg"
    android:orientation="vertical" >
   ```
2. 在读页面中代码实现listview填充

    ```java
   String[] recorded={"这是第一段话","这是第二段话","这是第三段话","这是第四段话","这是第五段话"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, recorded);
        ListView listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);
 
   ```
 # 四、实验结果
 ![读页面](https://github.com/guo02/android-labs-2020/blob/master/students/net1814080903338/3.PNG)
 # 五、实验心得
 通过这次实验，我学到了关于布局的相关知识，并在APP中添加了listview布局。至此，离成为一个完整的APP又接近了一步。

