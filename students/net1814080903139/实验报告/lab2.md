# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤

1. 创建Activity和xml文件
2. 在AndroidManifest.xml添加虚拟机打开时所需要的权限

```
       <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androids">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity
            android:name=".TimeActivity"
            android:parentActivityName=".Net1814080903139Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903139Activity"></meta-data>
        </activity>
        <activity
            android:name=".AlarmActivity"
            android:parentActivityName=".Net1814080903139Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903139Activity"></meta-data>
        </activity>
        <activity
            android:name=".TimerActivity"
            android:parentActivityName=".Net1814080903139Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903139Activity"></meta-data>
        </activity>
        <activity
            android:name=".StopWatchActivity"
            android:parentActivityName=".Net1814080903139Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903139Activity" />
        </activity>

    </application>

</manifest>
```

1. 在Net1814080903139Activity中添加跳转按钮的代码

```
public class Net1814080903139Activity extends AppCompatActivity {
    private Net1814080903139Activity myThis;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903139);
        myThis=this;
        Button  alarmButton = findViewById(R.id.AlarmButton),
                timerButton=findViewById(R.id.TimerButton),
                stopwatchButton=findViewById(R.id.StopWatchButton);

        alarmButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent alarmIntent=new Intent(myThis,AlarmActivity.class);
                startActivity(alarmIntent);
            }
        });
        timerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent timerIntent=new Intent(myThis,TimerActivity.class);
                startActivity(timerIntent);
            }
        });
        stopwatchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent stopwatchIntent=new Intent(myThis,StopWatchActivity.class);
                startActivity(stopwatchIntent);
            }
        });

    }
}
```

# 四、实验结果

![lab2](https://github.com/BBsan13/android-labs-2020/blob/master/students/net1814080903139/实验报告图片/lab2result.PNG)

# 五、实验心得

学习了如何利用按钮来进行页面跳转的操作，根据所选题目创建了与项目功能相关的4个Activity，学习到了如何通过Intent实现Activity间的跳转。