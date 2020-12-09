# 实验五

## 一、 实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

## 二、 实验内容

+ 根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中
2. 使用的文件存储方式：内部存储
3. 将运行结果截图

## 三、 实验步骤

1. 创建一个activity_text.xml文件和TextActivity.java类并将其连接起来

2. 设置点击“+”按钮，跳转到activity_text界面

   ```java
   textView1=findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(t, Chat.class);
                t.startActivity(intent);
            }
        });
   ```

3. 在activity_text添加两个EditText控件来输入内容，添加“保存信息”按钮来实现文件存储，添加TextView控件来显示预览的内容

   ```java
    <TextView
            android:id="@+id/textView6"
            android:layout_width="111dp"
            android:layout_height="52dp"
            android:layout_marginTop="100dp"
            android:layout_marginEnd="22dp"
            android:layout_marginBottom="42dp"
            android:gravity="center"
            android:text="账号名称"
            android:textSize="24sp"
            app:layout_constraintBottom_toTopOf="@+id/textView7"
            app:layout_constraintEnd_toStartOf="@+id/ettp"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView7"
            android:layout_width="111dp"
            android:layout_height="52dp"
            android:layout_marginTop="10dp"
            android:layout_marginEnd="23dp"
            android:layout_marginBottom="317dp"
            android:gravity="center"
            android:text="个性签名"
            android:textSize="24sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toStartOf="@+id/ettp2"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textView6" />

        <EditText
            android:id="@+id/ettp"
            android:layout_width="279dp"
            android:layout_height="52dp"
            android:ems="10"
            android:inputType="textNoSuggestions"
            app:layout_constraintBottom_toBottomOf="@+id/textView6"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toEndOf="@+id/textView6"
            app:layout_constraintTop_toTopOf="@+id/textView6"
            app:layout_constraintVertical_bias="1.0" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="156dp"
            android:layout_marginEnd="157dp"
            android:layout_marginBottom="200dp"
            android:text="保存信息"
            android:textSize="30sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent" />
        <TextView
            android:id="@+id/textView8"
            android:layout_width="414dp"
            android:layout_height="197dp"
            android:layout_marginTop="6dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="1.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/button"
            app:layout_constraintVertical_bias="1.0" />

        <EditText
            android:id="@+id/ettp2"
            android:layout_width="279dp"
            android:layout_height="52dp"
            android:ems="10"
            android:inputType="textNoSuggestions"
            app:layout_constraintBottom_toBottomOf="@+id/textView7"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintTop_toTopOf="@+id/textView7" />
   ```

4. 在TextActivity.java类中创建鼠标点击事件把信息存储在数据库中

   ```java
   try {
            db=openOrCreateDatabase(dbn, Context.MODE_PRIVATE, null);
            button= this.<Button>findViewById(R.id.button);
            String ct="CREATE TABLE IF NOT EXISTS " + tbn + "(yh CHAR(8) not null primary key," + "qm VARCHAR(100) not null)";
            db.execSQL(ct);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView8 = (TextView) findViewById(R.id.textView8);
                    ettp=findViewById(R.id.ettp);
                    ettp2=findViewById(R.id.ettp2);
                    String n=ettp.getText().toString();
                    String q=ettp2.getText().toString();
                    String a=null;
                    addData(n,q);
                    Cursor cs=db.rawQuery("SELECT * FROM " + tbn, null);
                    if(cs.moveToFirst()){
                        a="用户信息：\n"+"用户名："+cs.getString(0)+"\t"+"个性签名："+cs.getString(1)+"\n";
                    }
                    while (cs.moveToNext()){
                        a+="用户名："+cs.getString(0)+"\t"+"个性签名："+cs.getString(1)+"\n";
                    }
                    textView8.setText(a);
                    db.close();
                }
            });
        }
    catch (Exception e){
            System.out.println(e);
    }
    ```

## 四、 实验结果

![实验五图片](https://github.com/waljja/android-labs-2020/blob/master/students/net1814080903130/sy5.1.PNG)

## 五、 实验心得体会

通过这次实验我学会了用Android Studio软件来实现数据存储和查询。
