# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

#  二、实验内容
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

# 三、实验步骤
1. 根据自己项目设置了相对布局方式。
2. 在相对布局下设置了CalendarView和ListView
3. 在Net1814080903110Activity设置ListView
```java
        String[] mobileArray = { //
                "日程一", "日程二", "日程三", "日程四"
        };
        ListView lv = (ListView) findViewById(R.id.dates);

        ArrayAdapter s1 = new ArrayAdapter<String>(this, R.layout.listview_item, mobileArray);

        lv.setAdapter(s1);


        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        };
        lv.setOnItemClickListener(listener);

```

# 四、实验结果
![lab4](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab4.png)

# 五、实验心得
认识了各个布局的界面，根据自己项目的需要选择了相对布局，在进行ListView调试的时候遇到了数据不显示的问题，经过同学的指出是因为自己的代码没设置好而导致的，最后成功解决并显示了相应的内容。
