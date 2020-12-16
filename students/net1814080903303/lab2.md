# 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容
1. 根据功能创建相应的Activity
2. 编写Activity对应的布局文件
3. 实现各个Activity之间的跳转

# 三、实验步骤
1. 创建功能类-Net1814080903303Activity、ClassActivity、StudentActivity、InformationActivity
   它会自动创建并链接上相应的XML文件
```java
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903303);
```
2. 在Net1814080903303Activity的layout视图中添加3个Button按钮“课程记录”、“请假情况”、“信息汇总”
   分别跳转ClassActivity、StudentActivity、InformationActivity三个界面
3. 调用函数实现为Button按扭添加Click点击事件实现跳转（以ClassActivity为例）
 ```java
           Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myStartActivity(Net1814080903303Activity.this, ClassActivity.class);
            }
        });
           public void myStartActivity(Context context,Class _class){
        Intent intent = new Intent(context, _class);
        startActivity(intent);
    }
   ```
# 四、实验结果
![result](https://github.com/tiamo669/android-labs-2020/blob/master/students/net1814080903303/second_1.jpg)
# 五、实验心得
  根据自己选择的题目创建与项目功能相关的几个Activity，并在主Activity中使用Intent和Click点击事件完成各主Activity和其他三个Activity之间的跳转，
运用使用函数调用来实现多个按钮的跳转，避免出现重复累赘的Java代码。
