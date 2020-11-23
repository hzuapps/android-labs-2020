# 实验二：Android组件编程

 ## 一、实验目标

 1. 在Issues中创建自己的选题；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

 ## 二、实验内容

 1. 根据自己的选题功能，创建 2-3 个 Activity（界面可以尝试设计）；
2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
3. 在 Activity 添加按钮点击事件处理，实现跳转

 ## 三、实验步骤

 1. 创建RankActivity.java和AndroidMainfest.xml
2. 创建Net1814080903112Activity.java和GameActivity.java
3. 在Net1814080903112添加两个public方法处理跳转按钮

 ``` java
public class GameActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
} 
public class RankActivity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
    }
} 

 ```

 4. 在Net1814080903112Activity.java里面创建2个按钮实现跳转

 ``` xml
 public class Net1814080903112Activity extends AppCompatActivity {

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903112);

         final AppCompatActivity thisActivity = this;

         final Button gameButton,rankButton;
        gameButton = (Button) findViewById(R.id.gameButton);
        rankButton =(Button) findViewById(R.id.rankButton);

         gameButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,GameActivity.class);
                thisActivity.startActivity(intent);
            }
        });

         rankButton.setOnClickListener(new View.OnClickListener(){

             @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,RankActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
} 
 ```

 ## 四、实验结果

 ![result](D:\android-labs-2020\students\net1814080903112\2.png)

 ## 五、实验心得

 本次实验主要是Android组件编程。先创建几个Activity在Activity中添加按钮并实现跳转。而我设计的是两个按钮分别是开始游戏和分数排行，实现了按钮的跳转。