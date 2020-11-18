# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903104Activity、SearchMessActivity、GetRewardActivity和相应的XML文件；
2. 添加按钮；
3. 在Net1814080903104Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
final Net1814080903104Activity thisActivity = this;

        Button button = (Button) findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,GetReward.class);
                thisActivity.startActivity(intent);
            }
        });


        Button button1 = (Button) findViewById(R.id.button_search);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(thisActivity,SearchMess.class);
                thisActivity.startActivity(intent);
            }
        });
```

## 四、实验结果
![](https://github.com/3ho-y/android-labs-2020/blob/master/students/net1814080903104/lab2(1).png)
![](https://github.com/3ho-y/android-labs-2020/blob/master/students/net1814080903104/lab2(2).png)
![](https://github.com/3ho-y/android-labs-2020/blob/master/students/net1814080903104/lab2(3).png)

## 五、实验心得
本次实验创建了与所选题目功能相关的Activity，学习到如何利用按钮在Activity之间跳转。实验过程中界面跳转后闪退，在AndroidManifest.xml添加相应的权限后解决问题。
