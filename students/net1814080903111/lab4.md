# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

#  二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
```
// XML
android:id="@+id/btn_check"
// Java
findViewById(R.id.btn_check);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

# 三、实验步骤
1. 页面布局为线性布局，插入两个按钮；
2. 根据需要在界面对应的java类中通过控件ID添加事件处理：
```
xml:
<Button
        ...
        android:id="@+id/btn_check"
        ...
        />
<Button
        ...
        android:id="@+id/btn_signin"
        ...
        />
java:
Button btn = findViewById(R.id.btn_check);
        final Net1814080903111Activity th = this;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(th, activity_check_recond.class);
                th.startActivity(intent);
            }
        });
```

# 四、实验结果
![lab4_1](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab4_1.png)
![lab4_2](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab4_2.png)

# 五、实验心得
这次实验主要是关于页面的布局和控件对页面的跳转。
