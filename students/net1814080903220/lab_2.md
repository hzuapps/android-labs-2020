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
1. 在https://github.com/hzuapps/android-labs-2020/issues下提交自选题“纪念日”；
2. 打开Android Studio,在java包下创建三个相关功能Activity；
- Net1814080903220MainActivity.java
- Net1814080903220EditActivity.java
- Net1814080903220PictureActivity.java
3. 在Net1814080903220MainActivity的layout文件中设置两个按钮，分别为“编辑纪念日”和“更换背景图片”；
4. 在Net1814080903220MainActivity.java中创建按钮对象Edit和Picture；
5. 使用findViewById方法引用布局文件中的对应按钮，使得在写.java的按钮时能与布局文件里的一致；
6. 设置Edit和Picture点击事件；
7. 创建intent跳转对象，使用显式方法Intent(源Activity.this,目标Activity.class)；
8. startActivity(intent)实现点击跳转
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
