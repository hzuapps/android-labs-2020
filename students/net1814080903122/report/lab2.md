# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤

1. 创建MainActivity、Net1814080903122Activity和xml文件
2. 在AndroidManifest.xml中注册创建的Acticvity
3. 在布局文件创建Button组件
4. 实现界面跳转

添加跳转按钮的代码

```
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903122);
        Button button = (Button) findViewById(R.id.sureButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });

    }实验二
```

# 四、实验结果

# ![image-20201116084549407](lab2.png)

# 五、实验心得

学习了如何利用按钮来进行页面跳转的操作，实验难度不算太高。