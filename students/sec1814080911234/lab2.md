# 实验二

## 一、实验目标
- 在Issues中创建自己的选题
- 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）
- 将标题设置为自己的学号+对应的功能或题目
- 根据自己选择的题目实现Activity中创建事件，日期计算等功能
## 二、实验内容
- 根据自己的选题功能，创建 2-3 个 Activity  
Sec1814080911234Activity.java (首页、LAUNCHER、主活动)  
功能1Activity.java  
功能2Activity.java
- 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
- 在 Sec1814080911234Activity.java 添加按钮点击事件处理，实现跳转
## 三、实验步骤
1. 创建选题：倒数日  
2. 创建四个Activity  
Sec1814080911234Activity.java （首页）  
CreateActivity.java（创建事件）  
DateActivity.java（日期计算）  
FestivalActivity.java（节假日）  
3. 在activity_sec1814080911234.xml上添加三个按钮（创建事件、日期计算、节假日）   
4. 在Sec1814080911234Activity.java为按扭添加点击事件实现跳转，部分代码如下

```xml
        button_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,CreateActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        button_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,DateActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        button_festival.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,FestivalActivity.class);
                thisActivity.startActivity(intent);
            }
        });
```
## 四、实验结果
![lab2](raw.githubusercontent.com/1728799039/android-labs-2020/master/students/sec1814080911234/lab2.png)
## 五、实验心得
从这次实验开始我们就要为自己的选题开始做实验了，通过一个个实验来逐渐完善自己app，我选的是倒数日，需要实现三个功能，分别是创建事件让其在首页中显示、日期计算指定日期的剩余天数和节假日的剩余天数。这次实验需要做的是在首页创建按钮并实现点击后跳转到其他页面，总的来说还是比较简单的。
