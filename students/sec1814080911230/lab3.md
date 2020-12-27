# 实验三


## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

1. 在界面上显示至少一张图片；
2. 点击图片（或按钮）时，打开另一个Activity。


## 三、实验步骤

1.先将背景图放在drawable里面

2.在activity_main.xml里插入背景图

```
android:background="@drawable/background" 

  
3.在activity_rank.xml里面插入背景图

```
android:background="@drawable/rank_backgroud"

4、实现跳转

```
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            final Activity thisActivity = this;
            Button btnOpen = (Button) findViewById(R.id.button1);
            View view = findViewById(R.id.button1);
            btnOpen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(thisActivity, StartGameActivity.class);
                    thisActivity.startActivity(intent);
                    //thisActivity.startActivityForResult(intent, 2016);
                }
            });

            Button btnOpen1 = (Button) findViewById(R.id.button2);
            View view1 = findViewById(R.id.button2);
            btnOpen1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view1) {
                    Intent intent = new Intent(thisActivity, RankActivity.class);
                    thisActivity.startActivity(intent);
                    //thisActivity.startActivityForResult(intent, 2016);
                }
            });

        }
        
        

## 四、实验结果
![主界面](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab3(1).png)
![rank界面](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab3(2).png)
  
  
## 五、实验心得体会
  本次实验主要是给界面加了背景图，然后调整了一下按钮的位置，让整体界面更加美观舒服，包括跳转后的界面也插入了背景图。

