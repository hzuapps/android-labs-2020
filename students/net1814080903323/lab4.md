#实验四
##一、实验目标
1.根据选题要求设计界面布局及控件使用；
2.布局xml及界面控制操作代码提交并截图；
3.将应用运行结果截图。

##二、实验内容 
1. 使用一种布局方式设计界面； 
2. 通过控件ID获取界面对象，执行相关操作； 
3. 实现界面控件的事件处理; 
4. 操作之后，切换到第二个界面。 

##三、实验步骤
1.使用LinearLayout布局设计；
2.通过控件ID获取界面对象，执行相关操作；
3.实现界面控件的事件处理。
```java
public class Net1814080903323Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903323);

        final Button botton1;
        botton1 = findViewById(R.id.button1);
        botton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botton1.setBackgroundColor(Color.rgb(255, 0, 0));
                Intent i = new Intent(Net1814080903323Activity.this, InvitationActivity.class);
                startActivity(i);
            }
        });
        final Button botton2;
        botton2 = findViewById(R.id.button2);
        botton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botton2.setBackgroundColor(Color.rgb(255, 0, 0));
                Intent i = new Intent(Net1814080903323Activity.this, TipsActivity.class);
                startActivity(i);
            }
        });

    }
```

## 四、实验结果
![图片](https://github.com/joshua-ben/android-labs-2020/blob/master/students/net1814080903323/test4.jpg)

## 五、实验心得
  这次实验将界面布局进行设计，增加一些功能。
