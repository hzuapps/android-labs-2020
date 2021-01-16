# 实验六

## 1.实验目标
1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 2.实验内容
1.在个人目录中创建一个表示数据的XML或JSON文件；
2.数据文件代码提交之后从GitHub获取文件URL；
3.在应用中通过网络编程访问GitHub的数据文件；
4.在应用中解析并显示文件所包含的数据；
5.将应用运行结果截图。

## 3.实验步骤
由于实验目的用不上原本实验六的网络编程功能，所以实验六在原来的基础上做修改。把原Information页的“读取资料卡”的显示功能由悬浮的显示改为固定的Textview。

1.在info的xml里面新增三个Textview

activity_info1814080903310.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".students.net1814080903310.Information1814080903310Activity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="请输入您的昵称" />

        <EditText
            android:id="@+id/editTextTextPersonName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textPersonName"
            android:text="Name" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="请输入您的邮箱" />

        <EditText
            android:id="@+id/editTextTextEmailAddress"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="textEmailAddress" />

        <TextView
            android:id="@+id/textView3"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="请输入您的电话" />

        <EditText
            android:id="@+id/editTextPhone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:ems="10"
            android:inputType="phone" />

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <Button
                android:id="@+id/write"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:onClick="onClick"
                android:text="保存" />

            <Button
                android:id="@+id/read"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:onClick="onClick"
                android:text="读取"
                tools:ignore="OnClick" />
        </LinearLayout>

        <TextView
            android:id="@+id/viewName"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="您的昵称为：" />

        <TextView
            android:id="@+id/viewEmail"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="您的邮箱为：" />

        <TextView
            android:id="@+id/viewPhone"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="您的电话为：" />

    </LinearLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

2.在activity里修改显示方式

Information1814080903310Activity

```
package edu.hzuapps.androidlabs.students.net1814080903310;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import edu.hzuapps.androidlabs.R;

public class Information1814080903310Activity extends AppCompatActivity {
    private EditText PersonName;
    private EditText EmailAddress;
    private EditText Phone;
    private Button write;
    private Button read;
    private Context This;

    private TextView viewName;
    private TextView viewPhone;
    private TextView viewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1814080903310);

        PersonName = (EditText)findViewById(R.id.editTextTextPersonName);
        EmailAddress = (EditText)findViewById(R.id.editTextTextEmailAddress);
        Phone = (EditText)findViewById(R.id.editTextPhone);
        read = (Button)findViewById(R.id.read);
        write = (Button)findViewById(R.id.write);

        viewName = (TextView)findViewById(R.id.viewName);
        viewEmail = (TextView)findViewById(R.id.viewEmail);
        viewPhone = (TextView)findViewById(R.id.viewPhone);
    }

    public void onClick(View view){
        String mPersonName = PersonName.getText().toString();
        String mEmailAddress = EmailAddress.getText().toString();
        String mPhone = Phone.getText().toString();

        switch (view.getId()){
            case R.id.write:
                msave(mPersonName,mEmailAddress,mPhone);
                break;
            case R.id.read:
                mread();
                break;
        }
    }

    private void mread(){
        SharedPreferences sp = getSharedPreferences("info",MODE_PRIVATE);
        String mPersonName = sp.getString("1","");
        String mEmailAddress = sp.getString("2","");
        String mPhone = sp.getString("3","");
        PersonName.setText("");
        EmailAddress.setText("");
        Phone.setText("");
        viewName.setText("您的昵称为："+mPersonName);
        viewEmail.setText("您的邮箱为："+mEmailAddress);
        viewPhone.setText("您的电话为："+mPhone);
        //Toast.makeText(this,"昵称为："+mPersonName+"邮箱为："+mEmailAddress+"电话为："+mPhone,Toast.LENGTH_LONG).show();
    }
    private boolean msave(String PersonName,String EmailAddress,String Phone){
        SharedPreferences sp = getSharedPreferences("info",MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("1",PersonName);
        edit.putString("2",EmailAddress);
        edit.putString("3",Phone);
        edit.apply();
        Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
        return true;
    }

}
```

## 4.实验结果及截图
![存储资料卡](https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/lab6_1.png)
![读取资料卡](https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/lab6_2.png)

## 5.实验心得
设置Textview的方法和editText的方法大同小异，就是要在activity显示的时候，要用textview.setText来实现。
