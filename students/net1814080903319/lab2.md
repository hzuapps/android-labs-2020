# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903319MainActivity（主界面）、ItemActivity（用于显示所有的乐谱条例）、ReadActivity（显示每一条乐谱条例点进去的内容）和相应的XML文件；
2. 添加按钮，分别命名为button和button2；
3. 在Net1814080903319MainActivity.java添加两个按钮点击事件处理，实现按钮button跳转到ItemActivity，按钮button2跳转到ReadActivity；
```java
final Net1814080903319MainActivity thisActivity=this;
        Button btnitem = (Button) findViewById(R.id.button);
        btnitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ItemActivity.class);
                startActivity(intent);
            }
        });
        Button btnread = (Button) findViewById(R.id.button2);
        btnread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ItemActivity.class);
                startActivity(intent);
            }
        });
```

## 四、实验结果
![按钮](https://raw.githubusercontent.com/Basr-suer/android-labs-2020/master/students/net1814080903319/lab2.jpg)

## 五、实验心得
本次实验创建了与所选题目功能相关的Activity，在相应的xml文件进行配置界面，创建两个按钮并学习到如何利用按钮在Activity之间跳转。
