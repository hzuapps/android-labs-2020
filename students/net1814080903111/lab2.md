# 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤
1. 将创建的Activity注册到AndroidManifest.xml；
2. 在Net1814080903111MainActivity的layout文件视图中添加Button按钮用于跳转页面； 
3. 为按键添加事件处理：
```
Button b = (Button)findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {  //匿名类
            @Override
            public void onClick(View v) {   //功能
                Intent intent = new Intent(Net1814080903109Activity.this, XXX.class);
                startActivity(intent);
            }
;
```
4. 创建相应功能的Activity名为'XXX'；
5. 利用startActivity(intent)实现跳转；

# 四、实验结果
 ![lab2_1](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab2_1.png)
 ![lab2_2](https://raw.githubusercontent.com/JC527/android-labs-2020/master/students/net1814080903111/lab2_2.png)
 

# 五、实验心得
本次实验实现不同页面的跳转，在主页面通过一个事件触发来实现页面跳转
