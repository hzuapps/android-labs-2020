# 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转
# 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;
# 三、实验步骤
1. 创建Activity和xml文件;
2. 在AndroidManifest.xml添加虚拟机打开时所需要的权限;
```java
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Net1814080903132Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".AskActivity"/>
        <activity android:name=".CommentActivity"/>
    </application>

</manifest>
```
3. 在Net1814080903132Activity中添加跳转按钮的代码;
```java
Button button = findViewById(R.id.button);
        final Net1814080903132Activity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, AskActivity.class);
                _this.startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, CommentActivity.class);
                _this.startActivity(intent);
            }
        });
```
# 四、实验结果

# 五、实验心得
学习了可以通过添加按钮实现页面的跳转
