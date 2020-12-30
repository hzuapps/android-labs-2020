# 实验四：Android界面设计编程

## 一、实验目标
- 根据选题要求设计界面布局及控件使用；
- 布局xml及界面控制操作代码提交并截图；
- 将应用运行结果截图。

## 二、实验内容 
- 使用一种布局方式设计界面； 
-  通过控件ID获取界面对象，执行相关操作； 
-  实现界面控件的事件处理; 
-  操作之后，切换到第二个界面。 

## 三、实验步骤
- 使用ConstraintLayout布局设计；
- 通过控件ID获取界面对象，执行相关操作；
- 实现界面控件的事件处理。
```java
public class Net1814080903332Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Net1814080903332Activity thisActivity = this;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, SelectTravelPlace.class);
                startActivity(intent);
            }
        });


    }
}
```
## 四、实验结果
![图片](https://github.com/eason89/android-labs-2020/blob/master/students/net1814080903332/4.PNG)
## 五、实验心得
  这次实验将界面布局进行设计，增加一些功能，实现了APP的基本逻辑
