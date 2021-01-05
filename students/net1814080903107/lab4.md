
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
1. 主界面采用约束布局，菜单栏采用滚动组件，菜单项采用线性布局
2. 给各个按钮添加监听器，重写点击事件
3. 商店界面列表采用ListView，并再Activity添加监听
# 四、实验结果
![lab4_1](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab4_1.PNG)
![lab4_2](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab4_2.PNG)

![lab4_2](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab4_3.PNG)

# 五、实验心得
本次实现主要实现界面，并且完善界面点击操作事件，处理任务，并且可以在页面跳转后添加函数onActivityResult，实现页面返回处理，实现更多功能。
