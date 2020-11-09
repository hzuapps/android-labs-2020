# 实验三

## 一、实验目标
- 了解Android应用中各种资源的概念与使用方法
- 掌握在Android应用中使用图片等资源的方法
## 二、实验内容
- 在界面上显示至少一张图片
- 提交res/drawable及图片使用的代码
- 提交res/values, res/layout等其他代码
- 将应用运行结果截图，放到实验报告中
- 点击图片（或按钮）时，打开另一个Activity
## 三、实验步骤
1. 将所要添加的图片用英文小写命名（带含义）放入项目目录的res/drawable 针对我的项目，我添加了map.png、main.png。
2. 在主页面activity_sec1814080911210.xml中将main用ImageView方法设为背景，代码为：  
```xml   
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="380dp"
        android:src="@drawable/main"
        />
 ```       
        
3. 在activity_map.xml中将map.png作为背景，直接在布局代码中使用background，代码为：
```xml   
    android:background="@drawable/map"
 ``` 
4. 实现点击按钮跳转另一个Activity在上一个实验中已经实现，例如在主页面中两个按钮实现跳转的代码如下：
        
        Button btnOpen = (Button) findViewById(R.id.search);
        Button btnOpen2 = (Button) findViewById(R.id.map);

        View view = findViewById(R.id.search);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, LocationActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        View view2 = findViewById(R.id.map);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, MapActivity.class);
                thisActivity.startActivity(intent);
            }
        });

## 四、实验结果
![lab3](raw.githubusercontent.com/tangcongbaobing/android-labs-2020/master/students/sec1814080911210/lab3.PNG)
## 五、实验心得
本次实验是Android资源运用，但其实实际操作时只用到了图片的运用，只要将需要使用的图片放入项目的res/drawable目录下，并在使用时用"@drawable/图片名"调用该图片即可。还学会了图片的
几种运用方法，可以使用imageview，在用作背景时还可以用background，总的来说这次实验比较简单。
