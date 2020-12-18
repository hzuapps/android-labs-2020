# 实验二
## 一、实验目标
1. 创建2-3个与自己选题有关的Activity；
2. 利用Intent实现Activity间的跳转

## 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转

## 三、实验步骤
1. 创建Net1814080903339Activity、BuyActivity、ConcludeActivity、WatchingActivity和相应的XML文件；
2. 在activity_net1814080903339.xml中添加按钮，并为此按钮赋予一个唯一的id；
3. 在Net1814080903339Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
 public class Net1814080903339Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903339);
    }

    public void onClickWatching(View view) {
       Intent intent = new Intent(this,WatchingActivity.class);
        startActivity(intent);
    }

    public void onClickBuy(View view) {
        Intent intent = new Intent(this,BuyActivity.class);
        startActivity(intent);
    }

    public void onClickConclude(View view) {
        Intent intent = new Intent(this,ConcludeActivity.class);
        startActivity(intent);
    }
}
```

## 四、实验结果
![图片](https://raw.githubusercontent.com/39-chen/android-labs-2020/master/students/net1814080903339/2.png)

## 五、实验心得
本次实验创建了与所选题目功能相关的Activity，学习到如何利用按钮在Activity之间跳转。实验过程中遇到无法使用虚拟机运行app，最后选择了用真机运行。

