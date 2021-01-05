# 实验五
## 一、实验目标 #

1. 了解Andoid的存储手段；
2. 掌握Android的文件存储；
3. 掌握Android的数据库存储。

## 二、实验内容 #

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

## 三、实验步骤 #

1. activity_main.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".AddActivity"
    android:orientation="vertical">

    <EditText
        android:id="@+id/et_input"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="100sp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal"
        android:layout_marginLeft="100dp">
        <Button
            android:id="@+id/btn_cancel"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="取消"
            android:background="@drawable/button_view"
            tools:ignore="MissingConstraints"
            android:layout_marginRight="20dp"/>
        <Button
            android:id="@+id/btn_confirm"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="确认"
            android:background="@drawable/button_view"
            tools:ignore="MissingConstraints"/>

    </LinearLayout>

</LinearLayout> 
```

2. 内部存储：文件保存的方法
```java
    public void save(String filename, String filecontent) throws Exception {

        FileOutputStream output = mContext.openFileOutput(filename, Context.MODE_PRIVATE);
        output.write(filecontent.getBytes());
        output.close();
    }
```

3. 文件读取的方法
```java
    public String read(String filename) throws IOException {

        FileInputStream input = mContext.openFileInput(filename);
        byte[] temp = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        int len = 0;

        while ((len = input.read(temp)) > 0) {
            sb.append(new String(temp, 0, len));
        }

        input.close();
        return sb.toString();
    }
```
4. 文件存储读写Activity实现
```java
package edu.hzuapps.androidlabs.sec1814080911106;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import helper.FileHelper;

public class AddActivity extends AppCompatActivity {
    private FileHelper fileHelper;
    private TextView tagMessage;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = getApplicationContext();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button btnConfirm = (Button) findViewById(R.id.btn_confirm);
        final EditText etInput = (EditText) findViewById(R.id.et_input);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileHelper = new FileHelper(mContext);
                String fileName = "tag";
                String fileContent = etInput.getText().toString() + "。";
                try {
                    fileHelper.save(fileName,fileContent);
                    Toast.makeText(getApplicationContext(), "标签添加成功", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "标签添加失败", Toast.LENGTH_SHORT).show();
                }

                String message;
                try {
                     message = fileHelper.read(fileName);
                    tagMessage = (TextView) findViewById(R.id.tv_show2);
                    tagMessage.setText(message);
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "读取失败", Toast.LENGTH_SHORT).show();
                }


            }
        });

        Button cancelBtn = (Button) findViewById(R.id.btn_cancel);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, Sec1814080911106Activity.class);
                startActivity(intent);
            }
        });


    }
}
```

## 四、实验结果 #
![运行结果](https://github.com/18cs06/android-labs-2020/blob/master/students/sec1814080911106/lab5.png)
## 五、实验心得 #
通过本次实验，我学习了Andoid的存储手段，掌握了Android的内部存储及文件的读取，进一步丰富了app的功能。
