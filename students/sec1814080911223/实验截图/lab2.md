# 实验二 Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues/47；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号1814080911223+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 创建自己的安卓项目选题：https://github.com/hzuapps/android-labs-2020/issues/47；
2. 根据自选题在Android Studio中创建三个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤

1. 打开Android Studio，在Sec1814080911223\app\src\main\java\edu\hzuapps\androidlabs\sec1814080911223下新建 3 个 Activity<br>
    + 开始游戏首页Activity：Sec1814080911238Activity.java<br>
    + 正式游戏页面Activity：KaiActivity.java<br>
    + 游戏结算页面Activity：FenActivity.java<br>


2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转

    在 Sec1814080911223Activity.java 添加按钮点击事件处理,跳转到Kai.java，实现Activity之间的跳转
```java
public class Sec1814080911223Activity extends AppCompatActivity {
    private Button button;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    onClickListener =new View.OnClickListener()

    {
        @Override
        public void onClick (View v){
                Intent intent = new Intent(Sec1814080911223Activity.this, KaiActivity.class);
                startActivity(intent);
        }
    }
    ;
    button = findViewById(R.id.button_begin);
        button.setOnClickListener(onClickListener);
}
}
```

## 四、实验结果

![实验结果](https://github.com/1814080911223/android-labs-2020/blob/master/students/sec1814080911223/%E5%AE%9E%E9%AA%8C%E6%88%AA%E5%9B%BE/lab2%E6%88%AA%E5%9B%BE.PNG)

## 五、实验心得
在本次实验中，第一次接触到了Android页面之间的一个简单的跳转，根据老师的讲解，实现页面跳转也是比较简单的。
