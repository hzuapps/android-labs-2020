# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

# 二、实验内容

1. 选择布局方式布局界面中的控件；
2. 通过控件ID获取界面对象，执行相关操作；
3. 完善选题功能，实现界面控件的事件处理。

# 三、实验步骤

1.先创建一个数组存放各个城市的信息cityArry
2.创建一个ListView
3.使用适配器调用ListView嵌套cityArry


```java
public class CheckActivity extends AppCompatActivity {

    String[] cityArr = {"北京：温度2°；今日天气晴朗","上海：温度5°；今日多云转晴","广州：温度20°；今日天气晴朗，建议防暑","深圳：温度18°；今日多云","重庆：温度10°；今日有小雨"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        ListView listcity = (ListView) findViewById(R.id.list_city);
        ArrayAdapter arrayAdapter = new ArrayAdapter<String>(this,R.layout.activity_list_city_item,cityArr);
        listcity.setAdapter(arrayAdapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        };
        listcity.setOnItemClickListener(listener);
    }
```

# 四、实验结果

![lab4](https://github.com/wuuuxj/android-labs-2020/tree/master/students/sec1814080911205/lab4.jpg)

# 五、实验心得体会
 通过本次实验，学会了适配器和线性布局以及相对布局的使用
