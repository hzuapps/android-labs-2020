# 实验六：Android网络编程
## 一、实验要求
- 在个人目录中创建一个表示数据的XML或JSON文件；
- 数据文件代码提交之后从GitHub获取文件URL；
- 在应用中通过网络编程访问GitHub的数据文件；
- 在应用中解析并显示文件所包含的数据；
- 将应用运行结果截图。
## 二、实验内容
- 根据功能新增展示数据的xml
- 将保存的数据读取出来
- 功能截图
## 三、实验步骤
- 根据功能新增activity_tipsresult.xml
- 将小技巧上获取的信息（分享的小技巧）展示出来
- 更换TipsActivity跳转为TipsResultActivity

-新增activity_tipsresult.xml
```java
    <TextView
    android:id="@+id/textView5"
    android:layout_width="309dp"
    android:layout_height="78dp"
    android:layout_marginStart="4dp"
    android:layout_marginLeft="4dp"
    android:layout_marginBottom="93dp"
    android:background="#2187B5"
    android:text="心灵鸡汤"
    android:textColor="#FFFFFF"
    android:textSize="36sp"
    app:layout_constraintBottom_toTopOf="@+id/button1"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent"
    app:layout_constraintVertical_bias="0.0" />
```
```java
    <TextView

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/textView1"
        android:layout_marginTop="56dp"
        app:layout_constraintBottom_toTopOf="@+id/editText1"
        app:layout_constraintTop_toBottomOf="@+id/textView5"
        tools:layout_editor_absoluteX="35dp"
        tools:ignore="MissingConstraints" />
```
-TipsResultActivity
```java
public class TipsResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsresult);
        FileInputStream fis = null;
        byte[] buffer = null;
        try {
            fis = openFileInput("login");
            buffer = new byte[fis.available()];
            fis.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            TextView text1TV = (TextView) findViewById(R.id.textView1);
            String data = new String(buffer);
            String text1 = data.split(" ")[0];
            text1TV.setText("小技巧："+text1);
        }
    }
}
```
-更换跳转
```java
public class TipsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        final EditText text1ET = (EditText) findViewById(R.id.editText1);
        Button login = (Button) findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //把获取到信息利用起来

                String text1 = text1ET.getText().toString();
                FileOutputStream fos = null;
                //抛出异常
                try {
                    fos = openFileOutput("login", MODE_PRIVATE);
                    //把这些信息写入
                    fos.write((text1).getBytes());
                    fos.flush();//刷新
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                Intent intent = new Intent();
                intent.setClass(TipsActivity.this, TipsResultActivity.class);
                startActivity(intent);//实现跳转
            }
        });
            }
    }
```

## 四、实验结果
  
![示例截图](https://github.com/joshua-ben/android-labs-2020/blob/master/students/net1814080903323/test6.jpg)  


## 五、实验心得
本次实验在前面的文本获取、存储，新增小技巧展示。
