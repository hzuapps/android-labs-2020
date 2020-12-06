# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903103Activity、ClockActivity、ReckonActivity和相应的XML文件；
2. 添加按钮；
3. 在Net1814080903103Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
 protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903103Activity thisActivity =this;
        Button btnOpen =(Button)findViewById(R.id.button_clock);
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(thisActivity,ClockActivity.class);
                thisActivity.startActivity(intent);
            }
        });


        Button btnOpen2 =(Button)findViewById(R.id.button_reckon);
        btnOpen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(thisActivity,ReckonActivity.class);
                thisActivity.startActivity(intent);
            }
        });
```
## 四、实验结果
![按钮](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab2.png)
![跳转界面1](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab3.png)
![跳转界面2](https://github.com/1814080903103/android-labs-2020/blob/master/students/net1814080903103/lab4.png)

## 五、实验心得
本次实验学会了使用button等的功能以及实现跳转功能.
