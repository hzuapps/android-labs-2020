# 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤

1. 创建Net1814080903141Activity、GameActivity、RecordActivity和相对应xml文件

   ![lab2-1](D:\android-labs-2020\students\net1814080903141\实验结果截图\lab2-1.png)

2. 在AndroidManifest.xml添加虚拟机打开时所需要的权限

```
     <?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapp.androidlabs.net1814080903141">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".RecordActivity"
            android:parentActivityName=".Net1814080903141Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903141Activity"></meta-data>
        </activity>
        <activity android:name=".GameActivity"
            android:parentActivityName=".Net1814080903141Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903141Activity"></meta-data>
        </activity>
        <activity android:name=".Net1814080903141Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN"/>
                <category android:name="android.intent.category.LAUNCHER"/>
            </intent-filter>
        </activity>
    </application>

</manifest>
```

3. 在Net1814080903141.Activity中添加跳转按钮的代码

```
        Button gameButton = findViewById(R.id.GameButton),
                recordButton=findViewById(R.id.RecordButton);
        gameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent gameIntent=new Intent(myThis,GameActivity.class);
                startActivity(gameIntent);
            }
        });
        recordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent recordIntent=new Intent(myThis,RecordActivity.class);
                startActivity(recordIntent);
            }
        });
```



# 四、实验结果

![lab2-2](D:\android-labs-2020\students\net1814080903141\实验结果截图\lab2-2.png)

# 五、实验心得

通过这次实验，我掌握了AndroidManifest的基础配置，学习了如何利用按钮进行页面之间的跳转。实验过程比较顺利，不过还是存在一两个小问题，最后在老师的提醒下，完成并提交了实验。