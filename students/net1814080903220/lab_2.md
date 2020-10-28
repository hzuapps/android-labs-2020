# 一、实验目标
1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues；
2. 根据自选题目，编写一个或多个Activity（所有均带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）
# 二、实验内容
1. 自定义选题；
2. 根据自选题在Android Studio中创建一个或多个Activity；
3. 实现一个Activity与另一个Activity之间的跳转（显式或隐式）
# 三、实验步骤
1. 在https://github.com/hzuapps/android-labs-2020/issues下提交自选题；
2. 打开Android Studio,创建自选题目app对应的若干个功能Activity；
3. 在需要实现跳转的Activity的xml文件中设置跳转按钮；
4. 在需要实现跳转的Activity的java类中用findViewByID方法发现对应跳转按钮；
5. 设置点击事件，用显式方法实现点击跳转功能
```
public class Net1814080903220MainActivity extends AppCompatActivity {
    private Button Edit;
    private Button Picture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Edit = (Button) findViewById(R.id.E_dit);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903220MainActivity.this,Net1814080903220EditActivity.class);
                startActivity(intent);
            }
        });
        Picture = (Button) findViewById(R.id.P_icture);
        Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903220MainActivity.this,Net1814080903220PictureActivity.class);
                startActivity(intent);
            }
        });
        };
    }
```
# 四、实验结果
![lab2result1](https://raw.githubusercontent.com/JieBro333/android-labs-2020/master/students/net1814080903220/lab2result1.jpg)；

![lab2result2](https://raw.githubusercontent.com/JieBro333/android-labs-2020/master/students/net1814080903220/lab2result.png)
# 五、实验心得

遇到的问题：
1. 不理解Activity是个什么东西；
2. 不熟悉findViewById方法，不知道传回的返回值是View类型，容易忘记强制转换成控件类型；

解决的办法：
1. 听老师讲；
2. 百度搜索进一步了解
