# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

## 三、实验步骤
1. 创建Net1814080903124SneakerActivity，它会自动创建并链接上相应的XML文件

 ```java
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903124_sneaker);}
 ```
 
2. 创建Net1814080903124ACCActivity以及Net1814080903124ClothesActivity（和第一步一样）
3. 在Net1814080903124MainActivity中使用openActivity方法实现Activity之间的跳转
     
```java 
        openActivity(Activity activity, Class activityClass) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivity(intent);}
```

## 四、实验结果
![创建Activity](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab2_1.png)
![Activity跳转](https://github.com/SJ4real/android-labs-2020/blob/master/students/net1814080903124/lab2_2.png)

## 五、实验心得
根据所选题目创建了与项目功能相关的几个Activity，并在主Activity中使用Intent完成各Activity之间的跳转，可以在Activity对应XML中添加不同的组件，并在相应的Activity中实现对应功能。
