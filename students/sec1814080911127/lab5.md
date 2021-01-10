# 实验五：Android存储编程

## 一、实验目标

- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储

## 二、实验内容

- 使用文件内部存储方式
- 在TxtActivity中，存储输入的值

## 三、实验步骤

```java
    public class TxtActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText edtData;
    private Button btnWriteToApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_txt);

        //初始化控件对象
        edtData =(EditText)findViewById(R.id.edtData);
        btnWriteToApp = (Button)findViewById(R.id.btnWriteToApp);

        btnWriteToApp.setOnClickListener(this);
    }

    public void onClick(View view){
        switch (view.getId()){
            case  R.id.btnWriteToApp:
                writeToApp(edtData.getText().toString());
                break;
        }
    }
    public void writeToApp(String data){
        FileOutputStream out = null;
        try {
            out = openFileOutput("myFile",MODE_PRIVATE);
            out.write(data.getBytes());
            out.flush();// 清理缓冲区的数据流
            out.close();// 关闭输出流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
```

- 布局

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <EditText
        android:id="@+id/edtData"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="输入要保存的数据"/>
    <Button
        android:id="@+id/btnWriteToApp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        android:text="写入到内部文件"/>

</LinearLayout>
```

## 四、实验结果

![实验结果](https://github.com/Dokemg/android-labs-2020/blob/master/students/sec1814080911127/lab5.png)  


## 五、实验心得

本次实验学会了如何在Android中实现存储数据，了解到有三种方式：一是文件存储，二是轻量存储、三是SQLite数据库存储，三种存储方式各有各的优势，文件存储和轻量存储比较适合存储简单量少的数据，而SQLlite适合存储比较复杂的结构性数据。
