# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903318Activity、LupingActivity、My_videoActivity和相应的XML文件；
2. 在activity_net1814080903318.xml中添加按钮，并为此按钮赋予一个唯一的id；
3. 在Net1814080903318Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
 private TextView Luping;
    private TextView MyVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903318);
        Luping = findViewById(R.id.button);
        MyVideo = findViewById(R.id.button2);
        Luping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1814080903318Activity.this,LupingActivity.class);
                startActivity(intent);
            }
        });
        MyVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Net1814080903318Activity.this,MyVideoActivity.class);
                startActivity(intent);
            }
        });
    }
```

## 四、实验结果
![按钮](https://raw.githubusercontent.com/xiaocheng123785/android-labs-2020/master/students/net1814080903318/2.jpg)

## 五、实验心得
本次实验创建了与所选题目功能相关的Activity，学习到如何利用按钮在Activity之间跳转。实验过程中遇到用虚拟机运行app后，按钮不显示的，在AndroidManifest.xml添加相应的布局后解决问题。
