# 实验二

## 一、实验目标

1、创建2-3个与自己选题有关的Activity；

2、利用Intent实现Activity间的跳转

## 二、实验内容

1、根据功能创建相应的Activity；

2、编写Activity对应的布局文件；

3、实现各个Activity之间的跳转

## 三、实验步骤

1、创建录音机相关的Net1814080903302Activity.java、StartRecording.java、RecordingLine.java文件和相应的XML文件；

2、在AndroidManifest.xml上添加StartRecording和RecordingLine；

3、添加按钮；

4、在Net1814080903302Activity.java添加按钮点击事件处理，实现跳转到其他Activity

## 四、实验结果
Net1814080903302Activity.java
```
package edu.hzuapps.androidlabs;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903302Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        final Net1814080903302Activity thisActivity=this;

        Button button1=(Button)findViewById(R.id.startluyin);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thisActivity,StartRecording.class);
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.luyinline);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(thisActivity,RecordingLine.class);
                startActivity(intent);
            }
        });
    }
} 
```
RecordingLine.java
```
package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecordingLine extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recording_line_activity);

    }
}
```

StartRecording.java
```
package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class StartRecording extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_recording_activity);
    }

}
```

![初始界面](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab2_1.jpg)

![点击开始后](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab2_2.jpg)

![点击列表后](https://raw.githubusercontent.com/juntao100/android-labs-2020/master/students/net1814080903302/lab2_3.jpg)

## 五、实验心得

这次实验主要是创建一个Android studio项目并实现两个能跳转界面的按钮。通过构造函数和利用OnClick语句能够实现界面的跳转。实验难度不算大。
