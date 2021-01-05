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
1. 主界面采用RelativeLayout布局，数字按键和输入框采用的是LinearLayout布局

2. 给确认按钮添加监听器，添加金额，会跳转到金额的展示页面ShowActivity

3. ShowActivity采用RelativeLayout布局,对CountActivity传过来的数据进行展示。
# 四、实验结果
![](https://raw.githubusercontent.com/itgopan/android-labs-2020/master/students/net1814080903209/lab4_01.png)
![](https://raw.githubusercontent.com/itgopan/android-labs-2020/master/students/net1814080903209/lab4_02.png)

# 五、实验心得
本次实验完成的是记账本的添加账单部分，页面一进来就会有一个数字按键，通过点击记录本次账单的金额。
