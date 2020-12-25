# 实验四
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
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#E6E6E6"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/iv"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="40dp"
        android:src="@drawable/head"
        />
    <LinearLayout
        android:id="@+id/ll_number"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/iv"
        android:layout_centerVertical="true"
        android:layout_marginBottom="5dp"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:layout_marginTop="15dp"
        android:background="#ffffff">

        <TextView
            android:id="@+id/tv_number"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="10dp"
            android:text="账号"
            android:textColor="#000"
            android:textSize="20sp"/>
        <EditText
            android:id="@+id/et_number"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="5dp"
            android:background="@null"
            android:padding="10dp"/>
    </LinearLayout>

    <LinearLayout
        android:id="@+id/ll_password"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/ll_number"
        android:layout_centerVertical="true"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:background="#ffffff">

        <TextView
            android:id="@+id/tv_password"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:padding="10dp"
            android:text="密码"
            android:textColor="#000"
            android:textSize="20sp"/>
        <EditText
            android:id="@+id/et_password"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginLeft="5dp"
            android:background="@null"
            android:inputType="textPassword"
            android:padding="10dp"/>
    </LinearLayout>

    <Button
        android:id="@+id/btn_login"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/ll_password"
        android:layout_marginLeft="10dp"
        android:layout_marginRight="10dp"
        android:layout_marginTop="50dp"
        android:background="#3c8dc4"
        android:text="登录"
        android:textColor="#ffffff"
        android:textSize="20sp"
        />
		
        <LinearLayout
            android:id="@+id/loading"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:gravity="center"
            android:orientation="vertical"
            android:visibility="invisible">
            <ProgressBar
                android:layout_width="wrap_content"
                android:layout_height="wrap_content" />
            <TextView
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:text="正在加载信息..." />
        </LinearLayout>
        <ListView
            android:id="@+id/lv_news"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
</RelativeLayout>
```
2. I/O流的方法保存文件，实现文件存储用户密码，存储方式为内部，Sec1814080911128Activity.java
```java
package edu.hzuapps.androidlabs.sec1814080911128;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sec1814080911128Activity extends AppCompatActivity {

    private LinearLayout loading;
    private ListView lvNews;
    private List<NewsInfos>

    @Override
    protected void onCreate(Budle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Map<String,String> userInfo = NewSaveAccount.getUserInfo(this);
        if ((userInfo!=null)){
            user.setText(userInfo.get("user"));
            password.setText(userInfo.get("password"));
        }
        fillData();
    }
    private void initView() {
		//控件的初始化
        user = (EditText)findViewById(R.id.et_number);
        password = (EditText)findViewById(R.id.et_password);
        button = (Button) findViewById(R.id.btn_login);
        //2.设置按钮点击事件
        button.setOnClickListener(this);
        loading = (L)
    }
    @Override
    public void onClick(View v) {
        //1.点击获取账号密码
        String  s_user = user.getText().toString().trim();
        String  s_password = password.getText().toString().trim();
        //2.检查用户名和密码是否为空
        if (TextUtils.isEmpty(s_user)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(s_password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();

        //3.保存用户信息
        //I/O流的方法
        boolean isSaveSuccess = NewSaveAccount.saveUserInfo(this,s_user,s_password);
        if (isSaveSuccess){
            Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"保存失败",Toast.LENGTH_LONG).show();
        }
    }
    private void fillData() { }
    //ListView适配器
    private class NewsAdapter extends BaseAdapter {
        //listview的item数
        @Override
        public int getCount() {
            return newsInfos.size();
        }

        //条目对象
        @Override
        public Object getItem(int position) {
            return null;
        }

        //条目id
        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}
```
3. NewSaveAccount实现保存账号和密码
```java
package edu.hzuapps.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user;
    private EditText password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.初始化view
        initView();
        //2.若用户保存了信息，进行数据回写
        //I/O流方法
        Map<String,String> userInfo = NewSaveAccount.getUserInfo(this);
        if ((userInfo!=null)){
            user.setText(userInfo.get("user"));
            password.setText(userInfo.get("password"));
        }
    }

    private void initView() {
        //控件的初始化
        user = (EditText)findViewById(R.id.et_number);
        password = (EditText)findViewById(R.id.et_password);
        button = (Button) findViewById(R.id.btn_login);
        //2.设置按钮点击事件
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //1.点击获取账号密码
        String  s_user = user.getText().toString().trim();
        String  s_password = password.getText().toString().trim();
        //2.检查用户名和密码是否为空
        if (TextUtils.isEmpty(s_user)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(s_password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();

        //3.保存用户信息
        //I/O流的方法
        boolean isSaveSuccess = NewSaveAccount.saveUserInfo(this,s_user,s_password);
        if (isSaveSuccess){
            Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"保存失败",Toast.LENGTH_LONG).show();
        }
    }
}
```


## 四、实验结果 #

![运行结果](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab5-1.png)
![运行结果](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab5-2.png)
## 五、实验心得 #
通过本次实验，了解Andoid的存储手段、掌握了Android的文件存储，对于完成整改程序是较为重要的一步，后续会继续更新。
