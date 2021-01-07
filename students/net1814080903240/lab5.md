# 实验五：Android存储编程

## 一、实验目标

1.	了解Android的存储手段
2.	掌握Android的文件存储
3.	掌握Android的数据库存储

## 二、实验内容
1.	将应用产生的数据保存到文件存储中；
2.	使用内部存储将产生的数据保存到文件存储中；
3.	将运行结果截图

## 三、实验步骤
1.	创建一个新的Java类FileStoreActivity.java
2.	创建一个新的界面命名为activity_filestore.xml
3.	在activity_filestore.xml中使用线性布局加入一个编辑框（使用EditText控件）、两个按钮（使用Button控件，分别是保存功能和显示功能）和一个显示框使用TextView控件
```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:padding="25dp"
    android:orientation="vertical" >

    <EditText
        android:id="@+id/et_suggest"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/subject" />

    <Button
        android:id="@+id/save_btn"
        android:layout_width="360dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:text="@string/save" />

    <Button
        android:id="@+id/show_btn"
        android:layout_width="360dp"
        android:layout_height="wrap_content"
        android:text="@string/show" />

    <TextView
        android:id="@+id/text_view"
        android:layout_width="360dp"
        android:layout_height="150dp"
        android:layout_marginTop="10dp"
        android:hint="@string/content"/>
</LinearLayout>
```
4.	在FileStoreActivity.java中定义两个方法用于保存和显示信息
```java
public class FileStoreActivity extends AppCompatActivity {
    private EditText suggest_editText;
    private Button save_btn;
    private Button show_btn;
    private TextView mContent;
    private final String mFileName = "test.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filestore);

        suggest_editText = findViewById(R.id.et_suggest);
        save_btn = findViewById(R.id.save_btn);
        show_btn = findViewById(R.id.show_btn);
        mContent = findViewById(R.id.text_view);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(suggest_editText.getText().toString());
                mContent.setText("");
            }
        });


        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContent.setText(read());
            }
        });
    }


    //存储数据
    private void save(String content){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(mFileName, MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    //读取数据
    private String read(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput(mFileName);
            byte[] buff = new byte[1024];
            StringBuffer sb = new StringBuffer("");
            int length = 0;
            while ((length = fileInputStream.read(buff)) > 0){
                sb.append(new String(buff,0,length));
            }return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
```

## 四、实验结果
![lab5_MODE_PRIVATE](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab5_MODE_PRIVATE.png)

![lab5_MODE_APPEND](https://github.com/Clever2app/android-labs-2020/blob/master/students/net1814080903240/lab5_MODE_APPEND.png)


## 五、实验心得
本次实验的实验内容是Android存储编程，主要学习了Android Studio的文件内部存储，在Android Studio中将应用程序所产生的数据保存在文件中，并将数据显示到界面上，
利用文件的输入输出流来完成存储操作，由于之前学习过Java的文件输入输出流相关知识点，所以本次实验遇到的问题较为顺利解决。在做实验的过程中学习到一个新的知识点，
选择MODE_PRIVATE模式则会显示更新后的输入的信息，而选择MODE_APPEND模式则会显示新输入的信息续写在上次输入后位置。
