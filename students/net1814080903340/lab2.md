# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903340Activity、EasyActivity、MiddleActivity、HighActivity和相应的XML文件；
2. 在activity_net1814080903340.xml中添加按钮，并为此按钮赋予一个唯一的id；
3. 在Net1814080903340Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
 public void onClickEasy(View view) {
            Intent intent = new Intent(this, Easy.class);
            startActivity(intent);
        }
        public void onClickMiddle(View view) {
            Intent intent = new Intent(this,Middle.class);
            startActivity(intent);
        }

        public void onClickHigh(View view) {
            Intent intent = new Intent(this,High.class);
            startActivity(intent);
        }


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_net1814080903340);
        }
    }
```

## 四、实验结果
![截图](https://github.com/88hua/android-labs-2020/blob/master/students/net1814080903340/test02.JPG)

## 五、实验心得
本次实验我创建了我的项目功能相关的Activity，学习到如何利用按钮触发下一个Activity。实验过程中虚拟机运行后出现无法显示所有的按钮的情况，但通过上网查询后发现是与布局相关的问题及时在https://developer.android.google.cn网站的指南学习操作后成功解决了遇到的问题。
