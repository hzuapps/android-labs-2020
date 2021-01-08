# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout；
2. 通过控件ID获取界面对象，执行相关操作；
3. 实现界面控件的事件处理，例如点击按钮；
4. 操作之后，切换到你的第二个界面。
   	

## 三、实验步骤

1. 使用LinearLayout布局

   ```
   <?xml version="1.0" encoding="utf-8"?>
   <LinearLayout
       xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:app="http://schemas.android.com/apk/res-auto"
       xmlns:tools="http://schemas.android.com/tools"
       android:layout_width="match_parent"
       android:orientation="horizontal"
       android:layout_height="match_parent"
   
       tools:context=".MainActivity">
   
   
       <Button
           android:text="开始游戏"
           android:id="@+id/button2"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"/>
   
       <Button
           android:text="游戏失败界面"
           android:id="@+id/button1"
           android:layout_width="wrap_content"
           android:layout_height="wrap_content"/>
   
   </LinearLayout>
   ```

2. 初始化控件、实现界面控件的事件处理，例如点击按钮；

   ```
   public class MainActivity extends AppCompatActivity {
       private Button mButton;
       private View.OnClickListener mOnClickListener;
   
       @Override
       protected void onCreate(Bundle savedInstanceState) {
   
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);
   
   
   
           mOnClickListener = new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   switch (v.getId()){
                       case R.id.button1:
                           Intent intent = new Intent(MainActivity.this, FailGameScene.class);
                           startActivity(intent);
                           break;
                       case R.id.button2:
                           Intent intent2 = new Intent(MainActivity.this, GameScene.class);
                           startActivity(intent2);
                           break;
                   }
   
               }
           };
   
   
           mButton = findViewById(R.id.button1);
           mButton.setOnClickListener(mOnClickListener);
   
           mButton = findViewById(R.id.button2);
           mButton.setOnClickListener(mOnClickListener);
       }
   }
   ```

   

## 四、实验结果

![实验4结果截图](https://github.com/1nnocent1/android-labs-2020/blob/master/students/sec1814080911125/lab4_1.png)

![实验4结果截图](https://github.com/1nnocent1/android-labs-2020/blob/master/students/sec1814080911125/lab4_2.png)		

## 五、实验心得

经过本次实验，学习了设计界面及控件的使用。