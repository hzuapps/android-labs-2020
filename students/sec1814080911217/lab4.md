# 实验四 Android界面设计编程
## 一、实验要求
1.根据选题要求设计界面布局及控件使用  
2.布局xml及界面控制操作代码提交并截图  
3.将应用运行结果截图  
## 二、实验内容
1.使用LinearLayout，设计所选题目的界面  
2.通过控件ID获取界面对象，执行相关操作  
3.实现界面控件的事件处理  
## 三、实验步骤
1.使用LinearLayout对EarnIntegralAcitivity和ExchangeIntegralAcitivity两个功能进行布局。代码如下
```
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        >


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:textSize="30dp"
                android:text="每日签到 （+10）" />
            <Button
                android:id="@+id/earn1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="earn"
                />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:id="@+id/textView3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:textSize="30dp"
                android:paddingTop="70dp"
                android:text="拍照分享 （+20）" />
            <Button
                android:id="@+id/earn2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="earn"
                />


        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:id="@+id/textView4"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:textSize="30dp"
                android:paddingTop="70dp"
                android:text="观看15s广告 （+20）" />
            <Button
                android:id="@+id/earn3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="earn"
                />

        </LinearLayout>
```
```
<LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        >


        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:id="@+id/textView2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:textSize="30dp"
                android:text="英雄瑞文 （1000）" />
            <Button
                android:id="@+id/exchange1"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="exchange"
                />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:id="@+id/textView3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:textSize="30dp"
                android:paddingTop="70dp"
                android:text="英雄剑圣 （800）" />
            <Button
                android:id="@+id/exchange2"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="exchange"
                />


        </LinearLayout>
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">
            <TextView
                android:id="@+id/textView4"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:textSize="30dp"
                android:paddingTop="70dp"
                android:text="双倍经验卡 （50）" />
            <Button
                android:id="@+id/exchange3"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="exchange"
                />

        </LinearLayout>
```
2.通过findViewById对控件创建事件。
```
Button Earn1 = (Button) findViewById(R.id.earn1);

        View view1 = findViewById(R.id.earn1);

        Earn1.setOnClickListener(new View.OnClickListener() {}
Button Earn2 = (Button) findViewById(R.id.earn2);

        View view2 = findViewById(R.id.earn2);

        Earn2.setOnClickListener(new View.OnClickListener() {}
Button Earn3 = (Button) findViewById(R.id.earn3);

        View view3 = findViewById(R.id.earn3);

        Earn3.setOnClickListener(new View.OnClickListener() {}
```
```
Button Exchange1 = (Button) findViewById(R.id.exchange1);

        View view1 = findViewById(R.id.exchange1);

        Exchange1.setOnClickListener(new View.OnClickListener() {}
Button Exchange2 = (Button) findViewById(R.id.exchange2);

        View view2 = findViewById(R.id.exchange2);

        Exchange2.setOnClickListener(new View.OnClickListener() {}
Button Exchange3 = (Button) findViewById(R.id.exchange3);

        View view3 = findViewById(R.id.exchange3);

        Exchange3.setOnClickListener(new View.OnClickListener() {}
```
## 四、实验结果
![result](https://raw.githubusercontent.com/1364480222/android-labs-2020/master/students/sec1814080911217/lab4s1.png)
![result](https://raw.githubusercontent.com/1364480222/android-labs-2020/master/students/sec1814080911217/lab4s2.png)
## 五、实验心得
这次实验主要是学习使用LinearLayout对功能进行布局，多个LinearLayout相嵌套从而达到想要的控件布局。理解后，通过多次操作就能达到想要的效果。
