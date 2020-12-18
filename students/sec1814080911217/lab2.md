# 实验二：Android组件编程
## 一、实验目标
1.创建2-3个与自己选题有关的Activity  
2.利用Intent实现Activity间的跳转
## 二、实验内容
1.根据功能创建相应的Activity  
2.编写activity_main.xml  
3.编写Activity对应的布局文件  
4.编写Activity的Java代码  
5.使用Intent实现跳转  
## 三、实验步骤
1.创建Sec1814080911217Activity、EarnIntegralActivity、ExchangeIntegralActivity  
2.创建activity_main.xml、activity_earn_integral.xml、activity_exchange_integral.xml  
3.在activity_main.xml中创建3个Button并赋予id、text等属性。

        <Button  
        android:id="@+id/button_earn_activity"  
        android:layout_width="wrap_content"  
        android:layout_height="wrap_content"  
        android:layout_marginLeft="85dp"  
        android:layout_marginTop="100dp"  
        android:layout_weight="0"  
        android:textSize="50sp"  
        android:background="#00000000"  
        android:textColor="@android:color/black"  
        android:text="赚取积分" />  
        <Button  
        android:id="@+id/button_exchange_activity"  
        android:layout_width="wrap_content"  
        android:layout_height="wrap_content"  
        android:layout_marginLeft="85sp"  
        android:layout_marginTop="100dp"  
        android:layout_weight="0"  
        android:textSize="50sp"  
        android:background="#00000000"  
        android:textColor="@android:color/black"  
        android:text="兑换积分" />  
        
4.在Sec1814080911217Activity中通过findViewById方法，id参数绑定Button。  
5.利用onclick方法为各个Button创建点击处理事件。  
6.完成从Set1814080911217Activity到EarnIntegralActivity以及ExchangeIntegralActivity的跳转  

        Button Earn = (Button) findViewById(R.id.button_earn_activity);

        View view1 = findViewById(R.id.button_earn_activity);

        Earn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent = new Intent(thisActivity, EarnIntegralActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

        Button Exchange = (Button) findViewById(R.id.button_exchange_activity);

        View view2 = findViewById(R.id.button_exchange_activity);

        Exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intent = new Intent(thisActivity, ExchangeIntegralActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });

## 四、实验结果
![result](https://github.com/1364480222/android-labs-2020/blob/master/students/sec1814080911217/lab2.PNG)
![result](https://github.com/1364480222/android-labs-2020/blob/master/students/sec1814080911217/labs2.png)

## 五、实验心得
 这一次实验内容是创建EarnIntegralActivity、ExchangeIntegralActivity两个activity，并在主页面里布置两个对应的按钮实现功能的跳转。这次学习到了xml的基本组件以及布局，学习到了通过id进行绑定组件以实现功能。
