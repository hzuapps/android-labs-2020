# 一、实验目标 #

1. 根据选题要求设计界面布局及控件使用
2. 布局xml及界面控制操作代码提交并截图
3. 将应用运行结果截图

# 二、实验内容 #

1. 使用其中一种布局方式设计所选题目的界面
2. 通过控件ID获取界面对象，执行相关操作
3. 使用适配器完成自己其中一个界面的功能
4. 将应用运行结果截图

# 三、实验步骤 #
1. 使用constraintLayout来控制自己所有界面的小按钮和图片
2. 在xml文件中对自己的button和textview进行命名，方便自己记得后来对想使用的按钮。
3. 使用以下代码在Net1814080903207WrongActivity.java中使用适配器：

```java
private ArrayAdapter<String> adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);
        listView = (ListView) findViewById(R.id.ll1);
//        初始化适配器
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,datas);
        listView.setAdapter(adapter);
    }
```
# 四、实验结果 #
![程序界面1](https://raw.githubusercontent.com/522090231/android-labs-2020/master/students/net1814080903207/lab4_answer1.png)

![程序界面2](https://raw.githubusercontent.com/522090231/android-labs-2020/master/students/net1814080903207/lab4_answer2.png)

# 五、实验心得 #

本次实验需要初步实现自己的项目，需要对组件进行具体任务绑定，用java代码进行实现了简单的适配器，对于自己背单词软件的功能又近了一步。
