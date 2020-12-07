# 实验二
## 一、实验目标 #

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容 #

1. 根据自己的选题功能，创建2-3 个 Activity（界面可以尝试设计）；
- Sec1814080911128Activity.java (首页、LAUNCHER、主活动)
- 功能1Activity.java
- 功能2Activity.java
- AndroidManifest.xml
2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
- 在 Sec1814080911128Activity.java 添加按钮点击事件处理，实现跳转

## 三、实验步骤 #

1. 创建AndroidManifest.xml，Sec1814080911128Activity.java，JsonParseActivity.java，NewsInfoActivity.java四个文件；
2. 添加按钮
3. 点击事件处理，实现跳转

```java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		final Sec1814080911128Activity thisActivity =this;
        myBtn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBtn_one.setText("按钮1已被点击，即将跳转");
				Intent intent =new Intent(thisActivity,NewsInfoActivity.class);
				thisActivity.startActivity(intent);
            }
        });
        myBtn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myBtn_two.setText("按钮2已被点击，不跳转");
            }
        });
    }
```

## 四、实验结果 #

![运行结果](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab2-1.pngg)
![运行结果](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab2-2.png)
## 五、实验心得 #
通过本次实验，了解按钮点击事件的处理以及实现了各个 Activity 的跳转，更好地理解了控制流程。