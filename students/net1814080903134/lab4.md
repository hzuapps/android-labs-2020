# 一、实验目标

 1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

 # 二、实验内容

 1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：

 ```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```

1. 实现界面控件的事件处理;
2. 操作之后，切换到第二个界面。

 # 三、实验步骤

 1. 在activity_personal_center,xml中使用ListView

    ```xml
    <ListView
        android:id="@+id/person_list"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/main"
        ></ListView>
   ```

2. 代码实现listview填充

    ```java
     String[] mobileArray = {
            "账号名", "昵称", "收藏", "关注",
            "粉丝", "安全"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_center);


        ArrayAdapter adapter = new ArrayAdapter<String>(this, //
                R.layout.support_simple_spinner_dropdown_item, mobileArray);

        ListView listView = (ListView) findViewById(R.id.person_list);
        listView.setAdapter(adapter);
   ```

 # 四、实验结果

 ![个人中心](https://github.com/yyih/android-labs-2020/blob/master/students/net1814080903134/photos/personal-listview.PNG)

 # 五、实验心得

 通过本次实验学习到了更多页面布局的知识，我选择了RelativeLayout布局，利用列表来显示个人中心的信息，一开始添加代码之后出现了页面无法跳转的的问题，经过排查发现是在主页面的java文件里函数重复定义了。
