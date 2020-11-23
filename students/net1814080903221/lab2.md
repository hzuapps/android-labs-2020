# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity
2. 编写Activity对应的布局文件
3. 实现各个Activity之间的跳转

# 三、实验步骤

1. 将创建的Activity注册到AndroidManifest.xml
2. 在MainActivity的layout视图中添加Button按钮用于跳转页面
3. 为Button按扭添加Click点击事件实现跳转
   ```java
           Button btn1 = (Button)findViewById(R.id.button);
        final MainActivity thisActivity = this;
        btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,PersonalHomeActivity.class);
                thisActivity.startActivity(intent);
            }
        });
   ```

# 四、实验结果
![实验截图](https://raw.githubusercontent.com/TiAmo825/android-labs-2020/master/students/net1814080903221/lab2.jpg)

# 五、实验心得
学会了如何在xml文件里添加button，并添加点击事件从而实现页面跳转。
