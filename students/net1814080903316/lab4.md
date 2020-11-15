# 实验四
## 1.实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！）

## 2.实验内容
1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。
LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)
2. 通过控件ID获取界面对象，执行相关操作：
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
3. 实现界面控件的事件处理，例如点击按钮：
4. 操作之后，切换到你的第二个界面。

## 3.实验步骤
1. 配置net_1814080903316_activity.xml为LinearLayout，配置activity_imformation.xml与activity_table.xml为ConstraintLayout。
2. 配置activity_imformation.xml，通过TextView与Plain Text组件添加相应的文字说明和文字框。
3. 设计item.xml作为适配器的参数，在activity_table.xml中添加ListView组件。
4. 在TableActivity.java中声明字符串数组与适配器，将适配器配置在activity_table.xml中的ListView组件上。


## 4.实验结果
![项目图片](https://raw.githubusercontent.com/alllovetaken/android-labs-2020/master/students/net1814080903316/lab4_1.PNG)
![项目图片](https://raw.githubusercontent.com/alllovetaken/android-labs-2020/master/students/net1814080903316/lab4_2.PNG)

## 5.实验心得
  这次实验最大问题出在适配器的使用上。声明配置适配器的java类与xml界面文件不对应，虽然在编译期间没有报错，但一旦运行就会直接闪退。
 
