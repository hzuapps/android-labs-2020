# 实验三
## 一、实验目标
1.根据选题要求设计界面布局及控件使用  
2.布局xml及界面控制操作代码提交并截图  
3.将应用运行结果截图   
  
## 二、实验内容
1.使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout  
2.通过控件ID获取界面对象，执行相关操作  
3.实现界面控件的事件处理，例如点击按钮  
4.操作之后，切换到你的第二个界面  

## 三.实验步骤
1.在Net1812070504101Activity中添加代码实现跳转  
```
        btn1=findViewById(R.id.btnStastic);
        btn2=findViewById(R.id.btnCheck);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               Intent i =new Intent( Net1812070504101Activity.this, StatisticActivity.class);
               startActivity(i);
            }
       });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i =new Intent( Net1812070504101Activity.this, CheckActivity.class);
                startActivity(i);
            }
        });
```
2.在activity_main.xml文件中添加组件(挑选部分)  
```
 <Button
        android:id="@+id/btnCheck"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        android:text="考勤"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.908"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.851" />
  <Button
        android:id="@+id/btnStastic"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        android:text="统计"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.081"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.851" />
```
3.在activity_check.xml 文件中添加组件构建布局 (挑选部分)
```
<Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="8dp"
        android:text="确定"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.943"
        app:layout_constraintStart_toStartOf="@+id/editText3"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.579" />
    <EditText
        android:id="@+id/editText"
        android:layout_width="400dp"
        android:layout_height="80dp"
        android:layout_marginStart="5dp"
        android:layout_marginLeft="5dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="5dp"
        android:layout_marginRight="5dp"
        android:layout_marginBottom="8dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="网工一班"
        android:textSize="18sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.214" />
```

```
在activity_statistic.xml文件中添加组件构建布局 (挑选部分)
<TextView
        android:id="@+id/textView3"
        android:layout_width="106dp"
        android:layout_height="38dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="8dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:layout_marginBottom="528dp"
        android:text="0"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.978"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />
```

四、实验结果    
1.主页面     
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab4_1.png" width =200px><br/>
2.详细界面  
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab4_2.png" width =200px>
<img src="https://github.com/lyRomantic/android-labs-2020/blob/master/students/net1812070504101/lab4_2.png" width =200px>


























