# 一、实验目标
1、在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；  
2、根据自选题目，编写一个或多个Activity（主窗口类带上专业学号前缀，放到自己的Java包下）；  
3、将标题设置为自己的学号+对应的功能或题目；  
4、根据自己选择的题目实现Activity中导航、调用等功能（选做）。  
# 二、实验内容   
1、自己选择题目；  
2、根据题目在Android Studio中创建一个或多个Activity；  
3、在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转;  
4、在 Activity 添加按钮点击事件处理，实现跳转。
# 三、实验步骤   
1、在https://github.com/hzuapps/android-labs-2020/issues下提交自选题“旅游方案”；   
2、打开Android Studio,在java包下创建四个相关功能Activity：  
Net1814080903224MainActivity.java  
Net1814080903224RecommendActivity.java  
Net1814080903224ProductionActivity.java   
Net1814080903224careActivity.java  
3、在Net1814080903224MainActivity的layout文件中设置两个按钮，分别为“注意事项”和“景点推荐”；在Net1814080903224MainActivity.java中创建按钮对象jump1和jump2；   
4、在Net1814080903224RecommendActivity.java的layout文件中设置按钮“返回”；在Net1814080903224RecommendActivity.java中创建按钮对象jump3；     
5、使用findViewById方法引用布局文件中的对应按钮，使得在写.java的按钮时能与布局文件里的一致；  
6、设置jump1、jump2和jump3的点击事件；  
7、创建intent跳转对象，Intent(源Activity.this,目标Activity.class)；  
8、startActivity(intent)实现点击跳转  
```
public class Net1814080903224activity extends AppCompatActivity {
    private Button jump1;
    private Button jump2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jump1 = findViewById(R.id.recommend);
        jump1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903224activity.this,RecommendActivity.class);
                startActivity(intent);
            }
        });
        jump2 = findViewById(R.id.care1);
        jump2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903224activity.this,CareActivity.class);
                startActivity(intent);
            }
        });
        };
    }
```
```
public class RecommendActivity extends AppCompatActivity {
    private Button jump3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
                jump3 = findViewById(R.id.production);
        jump3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecommendActivity.this,Net1814080903224activity.class);
                startActivity(intent);
            }
        });
        }
    }
 ```
 ```
public class ProductionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production);
    }
}
 ```
 ```
 public class CareActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
    }
}
 ```
# 四、实验结果   

# 五、实验心得体会   
