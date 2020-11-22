# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 利用startActivity(intent)实现各个Activity之间的跳转;

# 三、实验步骤

1. 创建Sec1814080911111Activity、TimerActivity、CountdownActivity和相应的XML文件；
2. 在XML中添加按钮；
3. 在Sec1814080911111Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
  Button timer = (Button)findViewById(R.id.timer);
        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911111Activity.this,TimerActivity.class);
                startActivity(intent);
            }
        });

   Button countDown = (Button)findViewById(R.id.countDown);
        countDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911111Activity.this,CountdownActivity.class);
                startActivity(intent);
```


# 四、实验结果

```  
![添加按钮](https://github.com/holenchan/android-labs-2020/blob/master/students/sec1814080911111/lab2.png)
```  

# 五、实验心得体会
通过这次实验，我进一步掌握的Android Studio的使用，学会了在XML中添加按钮，并在MainActivity中实现点击按钮实现各个Activity的跳转
