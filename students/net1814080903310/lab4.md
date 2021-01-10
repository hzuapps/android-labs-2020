# 实验四：Android界面设计编程

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

## 二、实验内容

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout；
2. 通过控件ID获取界面对象，执行相关操作；
3. 实现界面控件的事件处理，例如点击按钮；
4. 操作之后，切换到你的第二个界面。


## 三、实验步骤

1. 使用LinearLayout布局

```
activity_play1814080903310.xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".students.net1814080903310.PlayVideo18148080903310Activity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <VideoView
                android:id="@+id/videoView2"
                android:layout_width="354dp"
                android:layout_height="242dp"
                android:layout_weight="1" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <Button
                android:id="@+id/startVideo"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="播放" />

            <Button
                android:id="@+id/stopVideo"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="结束" />
        </LinearLayout>
    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
    ```
    
    2. 初始化控件、实现界面控件的事件处理，例如点击按钮；
    
    ```
    Net1814080903310Activity
package edu.hzuapps.androidlabs.students.net1814080903310;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import edu.hzuapps.androidlabs.R;

public class Net1814080903310Activity extends AppCompatActivity {
    Button button = null;
    Button button1 =null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.video);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Net1814080903310Activity.this,PlayVideo18148080903310Activity.class);
                startActivity(intent);
            }
        });

        button1 = (Button)findViewById(R.id.info);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903310Activity.this,Information1814080903310Activity.class);
                startActivity(intent);
            }
        });
    }
}

```

```
Information1814080903310Activity

package edu.hzuapps.androidlabs.students.net1814080903310;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info1814080903310);

        PersonName = (EditText)findViewById(R.id.editTextTextPersonName);
        EmailAddress = (EditText)findViewById(R.id.editTextTextEmailAddress);
        Phone = (EditText)findViewById(R.id.editTextPhone);
        read = (Button)findViewById(R.id.read);
        write = (Button)findViewById(R.id.write);
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
        Toast.makeText(this,"昵称为："+mPersonName+"邮箱为："+mEmailAddress+"电话为："+mPhone,Toast.LENGTH_LONG).show();
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

```
package edu.hzuapps.androidlabs.students.net1814080903310;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import edu.hzuapps.androidlabs.R;

public class PlayVideo18148080903310Activity extends AppCompatActivity {
    private VideoView videoView;
    private Button startVideo;
    private Button stopVideo;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play18148080903310);
        intView();
    }

    private void intView(){
        videoView = (VideoView)findViewById(R.id.videoView2);
        startVideo = (Button)findViewById(R.id.startVideo);
        stopVideo = (Button)findViewById(R.id.stopVideo);

        startVideo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                init();
            }
        });
        stopVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
    }

    private void init(){
        videoView = (VideoView)findViewById(R.id.videoView2);
        mediaController = new MediaController(this);
        String uri = "android.resource://"+getPackageName()+"/"+R.raw.video;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
    }
}
```

## 四、实验结果

![实验4结果截图](https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/lab4_1.png)

![实验4结果截图](https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/lab4_2.png)		

## 五、实验心得

用android studio的默认constraint布局的话，要给约束才不会让图标跳回0.0的坐标，用linear布局就会方便很多。
按钮的点击事件在这里做了两个activity的，一个是主页面点击按钮跳转到“我的”页面，一个是跳转到“视频”页面。
在“视频”页面中，用的是内置的VideoView控件来实现。设置了一个点击播放视频的按钮，一个点击停止播放的按钮。
