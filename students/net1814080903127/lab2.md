# 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转
# 二、实验内容
1. 根据功能创建相应的Activity
2. 编写Activity对应的布局文件
3. 实现各个Activity之间的跳转
# 三、实验步骤
1. 创建Net1814080903127Activity、AddActivity、RemindActivity
2. 创建与上一步对应的xml布局文件
3. 在Net1814080903127Activity.java中添加按钮和跳转事件
```java
        Button button = findViewById(R.id.button);
        final Net1814080903127Activity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, AddActivity.class);
                _this.startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, RemindActivity.class);
                _this.startActivity(intent);
            }
        });
```
# 四、实验结果
![lab2](https://github.com/cxcx75/android-labs-2020/blob/master/students/net1814080903127/lab2.png)
# 五、实验心得
本次实验主要学了使用Android组件，我在主界面定义了两个按钮，并为它们定义跳转事件来实现另外两个个Activity 的跳转，最后程序顺利运行。
