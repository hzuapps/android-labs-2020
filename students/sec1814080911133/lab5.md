# 实验五

## 一、实验目标
- 了解Andoid的存储手段
- 掌握Android的文件存储
- 掌握Android的数据库存储
## 二、实验内容
- 将应用产生的数据保存到文件存储中
- 说明使用的偏好设置存储方式
- 将运行结果截图
## 三、实验步骤
1.在activity_create.xml中设置好文本输入框
 ```xml
    <EditText
        android:id="@+id/editName"
        android:layout_width="119dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:gravity="center_horizontal"
        android:layout_marginTop="180dp"
        android:hint="请输入姓名"
        android:textSize="16sp"
        tools:ignore="MissingConstraints" />

    <EditText
        android:id="@+id/editTem"
        android:layout_width="116dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:gravity="center_horizontal"
        android:hint="请输入体温"
        android:textSize="16sp"
        app:layout_constraintTop_toBottomOf="@+id/editName"
        tools:ignore="MissingConstraints" />
 ```
2. 在CreateActivity.java中进行编程，实现文件存储功能
 ```java   
package edu.hzuapps.androidlabs.sec1814080911133;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sec1814080911133.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class TActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    EditText editName,editTem;
    TextView textView1;
    TextView textView2;

    String fileName = "file";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t);

        Button 返回 = (Button)findViewById(R.id.button7);
        返回.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TActivity.this, TemActivity.class);
                startActivity(intent);
            }
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        editName = findViewById(R.id.editName);
        editTem = findViewById(R.id.editTem);

        textView1 = findViewById(R.id.txt1);
        textView2 = findViewById(R.id.txt2);

    }

    public void btn1Click(View view) throws IOException {
     String name = editName.getText().toString();
     String tem = editTem.getText().toString();

     FileOutputStream fileOutputStream = openFileOutput(fileName,Context.MODE_APPEND);
     fileOutputStream.write((name+"##"+tem+"##").getBytes());
     if(fileOutputStream != null){
         fileOutputStream.close();
     }
     Toast.makeText(this,"存储成功",Toast.LENGTH_LONG).show();
}

    public void btn2Click(View view) throws IOException {
        FileInputStream fileInputStream = openFileInput(fileName);
        byte[] input = new byte[fileInputStream.available()];
        while (fileInputStream.read(input) != -1){
            String str = new String(input);
            String [] s = str.split("##");

            int n=s.length;
            textView1.setText("姓名："+s[n-2]);
            textView2.setText("体温："+s[n-1]);


        }
        if(fileInputStream != null){
            fileInputStream.close();
        }
    }
}
 ```
3.在activity_create.xml中设置好输出框，并通过步骤2的代码，实现输出
 ```xml
<TextView
            android:id="@+id/txt1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center|top"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:text="输入的姓名"
            android:textSize="18sp" />

        
<TextView
            android:id="@+id/txt2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="top|center"
            android:layout_weight="1"
            android:gravity="center_horizontal"
            android:text="输入的体温"
            android:textSize="18sp" />
 ```
## 四、实验结果
![lab5](https://github.com/Jamielxl/android-labs-2020/blob/master/students/sec1814080911133/lab5_pic.png)
## 五、实验心得
本次实验是Android存储编程，我做的实验是文件存储的内部存储，将文本输入框输入的数据获取到Activity中显示出来，一开始有难度，跟着老师的代码并通过网上的资料的查阅后来做出来了。