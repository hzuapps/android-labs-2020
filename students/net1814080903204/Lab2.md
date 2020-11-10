# 一、实验要求

- 在Issues中创建自己的选题
- 根据自己的选题创建2-3个Activity
- 实现Activity之间的跳转

# 二、实验内容

- 根据自己的选题所需要的功能创建Activity
- 编辑布局文件
- 通过按钮实现Activity之间的跳转


# 三、实验步骤

- 创建两个功能Activity
- 在AndroidManifest.xml中注册新创建的Activity
- 在activity_main.xml文件中添加一个Button控件，根据需要设计其外观
- 在Net1814080903204Activity.java中添加Click事件处理，实现Activity之间的跳转

```
        Button button1 = (Button) findViewById(R.id.Button1);
        Button button2 = (Button) findViewById(R.id.Button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903204Activity.this, setting.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903204Activity.this, remind.class);
                startActivity(intent);
            }
        });
```

# 四、实验结果

 ![实验截图](https://github.com/Dwweryu/android-labs-2020/blob/master/students/net1814080903204/Lab2.png)

# 五、实验心得
- 第二次实验在提交方面没有遇到什么问题，因为第一次实验已经熟悉了相应的操作。在android_main.xml中添加Button也没有什么问题，只不过在实现Click事件实现跳转的时候遇到了些麻烦，经过在网上的学习也解决了。
