# 实验五  
## 一、实验目标  
1.了解Andoid的存储手段;  
2.掌握Android的文件存储;  
3.掌握Android的数据库存储.   
## 二、实验内容  
应用数据存储可采用数据库存储。  
1.将应用产生的数据存储到数据库中；  
2.将应用运行结果截图。    
## 三、实验步骤   
本次实验实现:将输入内容存储到内部文件，获取发送到另一个界面
1.在activity_queryinterface1814080903135.xml中创建一个编辑框（EditText）和一个按钮（Button），并在按钮中设置触发事件sendMessage
```
<EditText
    android:id="@+id/edit_message1"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    />

<Button
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:onClick="sendMessage"
    android:text="发送"
    android:layout_below="@+id/button3"/>
 ``` 
2.在Queryinterface1814080903135Activity.java下声明一个sendMessage方法
```
 public void sendMessage(View view){
    Intent intent = new Intent(this,Buyingtickets1814080903135Activity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message1);
    String message = editText.getText().toString();
    intent.putExtra("EXTRA_MESSAGE",message);
    startActivity(intent);
}
```
3.在activity_buyingtickets1814080903135.xml下创建一个文本框（TextView）并设置id
```
<TextView
    android:id="@+id/RecMes"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_below="@id/button2"
    />
```
4.在Buyingtickets1814080903135Activity.java的onCreat方法中添加以下代码：
```
setContentView(R.layout.activity_buyingtickets1814080903135);
Intent intent = getIntent();
String message = intent.getStringExtra("EXTRA_MESSAGE");
TextView textView = (TextView) findViewById(R.id.RecMes);
textView.setText(message);
```
## 四、实验结果截图
![实验结果](https://github.com/clinying/android-labs-2020/blob/master/students/net1814080903135/lab5-1.png)
![实验结果](https://github.com/clinying/android-labs-2020/blob/master/students/net1814080903135/lab5-2.png)
## 五、实验心得
通过这次实验，我学会了如何将内容存储到内部文件，在没弄懂之前觉得挺难的，弄懂之后就还好，但有个没用到的知识点还有一点疑问，课后需要再花些时间去琢磨。
