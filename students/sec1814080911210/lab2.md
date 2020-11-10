# 实验二

## 一、实验目标
- 在Issues中创建自己的选题
- 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）
- 将标题设置为自己的学号+对应的功能或题目
- 根据自己选择的题目实现Activity中导航、调用等功能
## 二、实验内容
- 根据自己的选题功能，创建 2-3 个 Activity  
Sec1814080911210Activity.java (首页、LAUNCHER、主活动)  
功能1Activity.java  
功能2Activity.java
- 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
- 在 Sec1814080911210Activity.java 添加按钮点击事件处理，实现跳转
## 三、实验步骤
1. 创建选题：惠州学院地图app  
2. 创建四个Activity  
Sec1814080911210Activity.java （首页）  
AddinfoActivity.java（增添信息）  
LocationActivity.java（显示地点信息）  
MapActivity.java（显示地图）  
3. 在activity_sec1814080911210.xml上添加两个按钮（1、查看地图 2、查看地点信息）  
在activity_addinfo.xml添加两个按钮（1、确定 2、取消）  
在activity_map.xml添加两个按钮（1、查看地点信息 2、增加地点信息） 
4. 分别在Sec1814080911210Activity.java、AddinfoActivity.java、MapActivity.java为按扭添加点击事件实现跳转  
以Sec1814080911210Activity.java中代码为例：  

        Button btnOpen = (Button) findViewById(R.id.search);
        Button btnOpen2 = (Button) findViewById(R.id.map);

        View view = findViewById(R.id.search);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, LocationActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        View view2 = findViewById(R.id.map);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, MapActivity.class);
                thisActivity.startActivity(intent);
            }
        });
## 四、实验结果
![lab2](raw.githubusercontent.com/tangcongbaobing/android-labs-2020/master/students/sec1814080911210/lab2.PNG)
## 五、实验心得
本次实验是创建自己的选题并根据自己的选题创建activity，我选择的选题是地图系统，打算实现1、地图查看 2、地点信息查看 3、增加地点信息 三个功能，所以创建了主页面、地图页面、地点信息页面、
增加地点信息页面四个activity，并在页面中添加了按钮并通过点击事件实现了页面间的跳转。实验做下来难度尚可，根据老师提供的参考代码能很快的做出来，在Android Studio中通过图形化界面编辑按钮
也不难，主要还是得理解实现页面跳转的代码的具体含义、一些变量跟参数的设定以及java语言的相关知识。
