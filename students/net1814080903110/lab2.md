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
```xml
       <activity
            android:name=".RemindActivity"
            android:label="Activity2">
            <intent-filter>
                <action android:name="com.intent.Activity2" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
        <activity
            android:name=".SettingActivity"
            android:label="Activity1">
            <intent-filter>
                <action android:name="com.intent.Activity1" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
        <activity android:name=".Net1814080903110Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
    </activity>
```
3. 在Net1814080903110Activity中添加跳转按钮的代码
```xml
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(Net1814080903110Activity.this, SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903110Activity.this, RemindActivity.class);
                startActivity(intent);
            }
        });
```

# 四、实验结果
![lab2](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab3.png)
![lab2](https://raw.githubusercontent.com/xyl123580/android-labs-2020/master/students/net1814080903110/lab3.png)

# 五、实验心得
学习了如何利用按钮来进行页面跳转的操作，实验过程中遇到了跳转后app闪退的问题，经过检测是没有在AndroidManifest.xml添加相应的权限，添加后顺利解决。
