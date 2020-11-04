
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
1. 三个页面均采用自适应布局（默认布局），插入自己要用的控件；
2. 根据需要在界面对应的java类中通过控件ID添加事件处理：
```
xml:
<Button
        ...
        android:id="@+id/XXX"
        ...
        />
java:
Button button1 = (Button)findViewById(R.id.XXX);
        button1.setOnClickListener(new View.OnClickListener() {  
            @Override
            public void onClick(View v) {   
                ...(要实现的功能)
                startActivity(intent);
            }
```

# 四、实验结果
![lab4_Lighten](https://raw.githubusercontent.com/huanxuaner/android-labs-2020/master/students/net1814080903109/lab4_Lighten.PNG)
![lab4_TurnoffScreen](https://raw.githubusercontent.com/huanxuaner/android-labs-2020/master/students/net1814080903109/lab4_TurnoffScreen.PNG)

# 五、实验心得
这次实验已经实现了其中一个功能，但在虚拟机上无法体现，安装到手机上实操后才能实现调节亮度的功能。
而界面的布局根据自己的使用喜好和是否顺手来选择即可，本次实验使用自适应布局是因为便于调整控件的位置。
