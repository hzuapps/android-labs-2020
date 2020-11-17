#  实验二

## 一、实验目标

- 创建2-3个与自己选题有关的Activity
- 利用Intent实现Activity间的跳转

## 二、实验内容

- 根据功能创建相应的Activity；
- 编写Activity对应的布局文件；
- 实现各个Activity之间的跳转;

## 三、实验步骤

- 创建 MainActivity.java(主界面)、ChatInterfaceActivity.java(设置界面)、ContactPersonActivity.java(帮助界面)；
- 将创建的 Activity 注册到 AndroidManifest.xml 中；
- 在布局文件中创建 Button 组件；
- 为 Button 添加点击事件处理；
- 通过 MainActivity.java的(Intent) 实现界面跳转

```java
	private Button mBtnTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = findViewById(R.id.btn_textview);

        mBtnTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
                startActivity(intent);
            }
        });
    }
```


## 四、实验结果
![主界面](https://raw.githubusercontent.com/Cai-J/android-labs-2020/master/students/net1814080903231/Lab/lab_2_1.png)
![image](https://raw.githubusercontent.com/Cai-J/android-labs-2020/master/students/net1814080903231/Lab/lab_2_2.png)
## 五、心得体会

本次实验开始进行界面的跳转，通过按钮绑定事件实现跳转别的Activity，通过这个跳转可以实现简单功能。
