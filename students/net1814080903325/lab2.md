# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903325Activity（主界面）、PlayActivity（播放）
2. 添加按钮，命名为btn_play
3. 在Net1814080903325Activity.java添加按钮点击事件处理，实现按钮btn_play跳转到PlayActivity
```java
final Net1814080903325MainActivity thisActivity=this;
        Button btnPlay = (Button) findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,PlayActivity.class);
                startActivity(intent);
            }
        });
);
```

## 四、实验结果
![按钮](https://raw.githubusercontent.com/HuaStarOS/android-labs-2020/master/students/net1814080903325/lab2.jpg)

## 五、实验心得
本次实验创建了与所选题目功能相关的Activity，在相应的xml文件进行配置界面，创建按钮并学习到如何利用按钮在Activity之间跳转。
