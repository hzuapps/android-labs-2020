# 实验五       
## 一、实验目标  
1. 了解Andoid的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。
## 二、实验内容  
1. 将SellActivity中发布闲置产生的数据保存； 
2. 使用的内部存储方式；
3. 将运行结果截图。 
## 三、实验步骤  
1. 在activity_sell.xml中的Button添加点击事件onClick:saveClick，以及给之前创建的两个EditText添加id；
2. 在SellActivity中声名对象； 
```
    Button save,choose;
    EditText name,name1;
    TextView textView;
    String filename="thing_file";

    save = findViewById(R.id.save);
    choose = findViewById(R.id.choose);
    name = findViewById(R.id.name);
    name1 = findViewById(R.id.name1);
    textView=findViewById(R.id.textView1);
```
3. 在SellActivity中实现数据存储
```
    Button save,choose;
    EditText name,name1;
    TextView textView;
    String filename="thing_file";
```
## 四、实验结果  
![运行结果](https://github.com/liangyunrong/android-labs-2020/blob/master/students/net1814080903237/app/src/main/res/drawable/sy5-1.PNG)
![保存数据的文件](https://github.com/liangyunrong/android-labs-2020/blob/master/students/net1814080903237/app/src/main/res/drawable/sy5-2.PNG)
## 五、实验心得  
&#160; &#160;这个实验之前我没有很懂，然后是结课之后看学习视频然后才知道怎么做的。
