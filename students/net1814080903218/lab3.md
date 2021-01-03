# 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法;

2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验内容

1. 学会Android应用中资源的运用;

2. 在界面显示自己所需要的图片。

# 三、实验步骤

1. 将head.jpg放在res/drawable目录下；
2. 在activity_net1814080903218.xml中按钮，在<Button>标签中添加android:drawableTop属性，属性值为"@drawable/head"，
3. 在Net1814080903218Activity中添加以下代码实现界面跳转
```
Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, info.class);
                _this.startActivity(intent);
            }
        });
```
4. 运行界面查看图片显示结果

## 四、实验结果

[![img](file:///C:\Users\wumu\AppData\Local\Temp\ksohtml15696\wps3.png)](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab3.png)![img](file:///C:\Users\wumu\AppData\Local\Temp\ksohtml15696\wps4.jpg)![img](file:///C:\Users\wumu\AppData\Local\Temp\ksohtml15696\wps5.jpg)

 

# 五、实验心得

这次实验了解了如何在Android应用中添加图片资源，放在res文件夹下的drawable中，再通过地址进行引用。

 