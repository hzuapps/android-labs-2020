# 一、实验目标
1. 学习了解android组件
2. 学会在Activity上添加按钮、链接、或导航栏，实现各个Activity的跳转。
# 二、实验内容
1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

# 三、实验步骤
1. 确定选题：租房系统
2. 设计两个功能，一是查看房源，二是出租房间
3. 建立三个JAVA类：Net1814080903239Activity（主页面的设计）、RenthouseActivity（出租房间功能设计）、ShowhouseActivity（查看房源功能设计）
4. 将三个Activity注册到AndroidMainifest.xml中
``` 

 <activity android:name=".Net1814080903239Activity"></activity>
        <activity android:name=".RenthouseActivity" />
        <activity android:name=".ShowhouseActivity">
``` 

5. 在Net1814080903239Activity添加一个“查看房源”的按钮，点击按钮跳转到出租房间页面
``` 
  final Net1814080903239Activity thisActivity = this;
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, showhouseActivity.class);
                startActivity(intent);
            }
``` 
6. RenthouseActivity中添加“出租房间”按钮，点击按钮，跳转到ShowhouseActivity这个类显示的内容。
``` 
  Button button = (Button) findViewById(R.id.button2);
        final showhouseActivity thisActivity = this;

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, renthouseActivity.class);
                thisActivity.startActivity(intent);
            }
``` 
7. 在git bash上提交代码
  
# 四、实验结果
![实验二截图](https://raw.githubusercontent.com/Joanwjk/android-labs-2020/master/students/net1814080903239/sy2.png)

# 五、实验心得
这次实验主要学习在Activity添加按钮，点击按钮可以跳转页面，学习了setOnClickListene函数、Intent、findViewById等的应用，实现了简单的跳转。
