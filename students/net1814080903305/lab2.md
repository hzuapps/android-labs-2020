# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建MainActivity（主界面）、AlarmSetActivity（用于设置闹钟）、TimeDisplayActivity（用于显示时间）和相应的XML文件；
2. 添加按钮，分别命名为button和button1；
3. 在MainActivity.java添加两个按钮点击事件处理，实现按钮button跳转到AlarmSetActivity，按钮button1跳转到TimeDisplayActivity；
```java
final MainActivity thisActivity=this;
        Button btnitem = (Button) findViewById(R.id.button);
        btnitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,AlarmSetActivity.class);
                startActivity(intent);
            }
        });
        Button btnread = (Button) findViewById(R.id.button1);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,TimeDisplayActivity.class);
                startActivity(intent);
            }
        });
```

## 四、实验结果
![按钮](https://raw.githubusercontent.com/bakamaid777/android-labs-2020/master/students/net1814080903305/lab2.png)

## 五、实验心得
根据所选题目功能创建了相应的Activity，在相应的xml文件进行配置界面，创建两个按钮并实现了通过按钮在Activity之间跳转。
