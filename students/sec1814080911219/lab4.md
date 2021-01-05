# 一、实验目标  

1. 根据选题要求设计界面布局及控件使用
2. 布局xml及界面控制操作代码提交并截图
3. 将应用运行结果截图

# 二、实验内容

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout
2. 通过控件ID获取界面对象，执行相关操作:
  // XML
  android:id="@+id/my_button"
  // Java
  findViewById(R.id.my_button);
3. 实现界面控件的事件处理
4. 操作之后，切换到你的第二个界面

# 三、实验步骤

1. activity_main.xml中采用相对布局RelativeLayout中嵌套3个线性布局LinearLayout。第一个LinearLayout，实现登陆名称的输入框和按钮，设置layout_marginTop="20dp"，orientation="horizontal"；第二个LinearLayout放置选择文件、密文上传和明文上传三个按钮，设置layout_marginTop="90dp"，orientation="vertical"；第三个LinearLayout放置文件列表按钮，设置layout_marginTop="545dp"，orientation="horizontal"，background="@android:color/white"
2. activity_showfilelist.xml依旧使用LinearLayout，所有配置保持不变
3. activity_cipherupload.xml中采用相对布局RelativeLayout，每个CheckBox组件以及Button均使用layout_marginTop调整位置
4. 为每个xml中的组件设置id，使用background="@android:color/transparent"将部分按钮的背景色设置为透明，使用textSize属性对部分部分文字字体作出调整
5. 通过public void onClick(View v) { }为每个按钮编写点击事件处理

# 四、实验结果
![result](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab4-1.PNG)
![result](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab4-2.PNG)
![result](https://raw.githubusercontent.com/CGB588/android-labs-2020/master/students/sec1814080911219/lab4-3.PNG)
# 五、实验心得

&#160; &#160; &#160; &#160;通过这次实验，我学会了Android开发中的布局方式，包括线性布局、相对布局等，同时也学会了在相对布局中如何调整各个组件的位置，如何调整按钮文字大小和按钮背景颜色，如何通过嵌套实现两种布局方式的配合使用，各种控件包括按钮、输入框等的使用以及编写按钮的点击事件处理等。
