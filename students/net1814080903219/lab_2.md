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
1. 在https://github.com/hzuapps/android-labs-2020/issues   下提交自选题“校园小灵通”；
2. 在java包下创建三个相关功能Activity；
- Net1814080903219Activity.java
- QueryScoreActivity.java
- PhysicalScoreActivity.java
3. 在activity_main.xml添加两个按钮，分别为“查询体测成绩”和“查询成绩”；
4. 在Net1814080903219Activity.java通过findViewById找到布局中的两个按钮
5. 为两个按钮绑上点击事件，实现页面跳转，分别跳转到QueryScoreActivity界面和PhysicalScoreActivity界面
```
public class Net1814080903219Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnScore1 = findViewById(R.id.button);
        btnScore1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1814080903219Activity.this, QueryScoreActivity.class);
                startActivity(intent);
            }
        });

        Button btnScore2 =   findViewById(R.id.button2);
        btnScore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Net1814080903219Activity.this, PhysicalScoreActivity.class);
                startActivity(intent);
            }
        });
    }
}
```
# 四、实验结果
![lab2result1](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab2_result1.png)

![lab2result2](https://github.com/account-lin/android-labs-2020/blob/master/students/net1814080903219/lab2_result2.png)
# 五、实验心得
通过这次实验，掌握了如何用layout布局进行界面设计，并实现了Activity之间的跳转。由于对布局不够熟悉，导致两个按钮的位置摆放出现问题。后面通过对布局相关属性的了解，才解决问题。
