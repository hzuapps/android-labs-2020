# 实验二：Android存储编程
## 一、实验要求
- 根据选题要求使用文件存储 
- 将应用产生的数据保存到文件存储中；
- 说明使用的文件存储方式：内部 or 外部；
- 将运行结果截图。
## 二、实验内容
- 根据功能修改xml
- 将产生的数据保存在内部
- 保存后刷新跳转
- 功能截图
## 三、实验步骤
- 根据功能修改activity_tips.xml
- 将获取的信息（分享的小技巧）保存在内部
- 保存后刷新跳转
```java
public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        final EditText text1ET =(EditText)findViewById(R.id.editText1);
        Button login=(Button)findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //把获取到信息利用起来

                String text1=text1ET.getText().toString();
                FileOutputStream fos=null;
                //抛出异常
                try {
                    fos=openFileOutput("login",MODE_PRIVATE);
                    //把这些信息写入
                    fos.write((text1).getBytes());
                    fos.flush();//刷新
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                } finally {
                    if(fos!=null){
                        try {
                            fos.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
                Intent intent =new Intent();
                //跳转到InternalDataReadActivity
                intent.setClass(TipsActivity.this,TipsActivity.class);
                startActivity(intent);//实现跳转
            }
        });

    }

}
```
-按钮以及编辑文本
```java
    <EditText
        android:id="@+id/editText1"
        android:layout_width="354dp"
        android:layout_height="432dp"
        android:layout_marginBottom="128dp"
        android:hint="请输入你想分享的技巧"
        android:selectAllOnFocus="false"
        android:singleLine="false"
        app:layout_constraintBottom_toBottomOf="parent"
        tools:ignore="MissingConstraints"
        tools:layout_editor_absoluteX="35dp" />
```
```java
    <Button
        android:id="@+id/button1"
        android:layout_width="111dp"
        android:layout_height="23dp"
        android:layout_marginBottom="76dp"
        android:background="#26C9DD"
        android:text="保存"
        android:textColor="#FFFFFF"
        android:textSize="16sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.716"
        app:layout_constraintStart_toStartOf="parent"
        tools:ignore="MissingConstraints" />
```

## 四、实验结果
  
![示例截图](https://github.com/joshua-ben/android-labs-2020/blob/master/students/net1814080903323/test5.jpg)  


## 五、实验心得
本次实验使用了文本获取并且存储，增加、完善了想要的功能！
