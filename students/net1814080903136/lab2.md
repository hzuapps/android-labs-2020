# 实验二

## 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 创建自己的安卓项目选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤

1. 创建 2-3 个 Activity

Net123456Activity.java (首页、LAUNCHER、主活动)：Net1814080903136Activity.java

功能1Activity.java：Edit1814080903136Activity.java

功能2Activity.java：Compound1814080903136Activity.java

AndroidManifest.xml

2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转
```xml(创建按钮代码示例)
<Button
            android:id="@+id/button_cut"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_below="@id/name"
            android:text="剪切" />
```

在 Net1814080903136Activity.java 添加按钮点击事件处理，实现跳转
```jave(添加按钮点击事件实现跳转代码示例)
  public class Net1814080903136Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final  Net1814080903136Activity thisActivity = this;
       Button btncut =(Button) findViewById(R.id.button_cut);
        btncut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Edit1814080903136Activity.class);
                thisActivity.startActivity(intent);
            }
        });
}
}
```

## 四、实验结果

![按钮绑定事件 点击事件实现跳转](https://github.com/yesijie0216/android-labs-2020/blob/master/students/net1814080903136/2.JPG)
      

## 五、实验心得

　　实验相对简单，本次实验掌握了如何创建简单按钮以及实现跳转，清楚的明白代码之间的对应关系。  
