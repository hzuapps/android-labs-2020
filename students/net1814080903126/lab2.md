## 一、实验目标

 1. 在Issues中创建自己的选题；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

 ## 二、实验内容

 1. 根据自己的选题功能，创建 2-3 个 Activity（界面可以尝试设计）；
2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
3. 在 Activity 添加按钮点击事件处理，实现跳转。

 ## 三、实验步骤

 1. 创建GameActivity.java和AndroidMainfest.xml
2. 创建Net1814080903126Activity.java和GameActivity.java
3. 在Net1814080903126添加public方法处理跳转按钮

    public class GameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
    } 
    public class ScoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
    }
} 

 4. 在Net1814080903112Activity.java里面创建2个按钮实现跳转

    public class Net1814080903126Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903126);
    
        final AppCompatActivity thisActivity = this;
    
        final Button newGameButton,continueButton,scoreButton;
        newGameButton = (Button) findViewById(R.id.newGameButton);
        continueButton = (Button) findViewById(R.id.continueGameButton);
        scoreButton = (Button) findViewById(R.id.scoreButton);
    
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,GameActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ContinueGameActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    
        scoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, ScoreActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
} 

 ## 四、实验结果

![](D:\android-labs-2020\students\net1814080903126\image\2.png)

 ## 五、实验心得

本次实验我创造了两个Activity并通过设置按钮以实现界面跳转。

