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
        <activity android:name=".view.MainActivity"></activity>
        <activity android:name=".view.Net1814080903108Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
3. 添加跳转按钮的代码
```java
private void bindActivityReplaceButton(int buttonId, final Class linkActivity){
        Button button = (Button)findViewById(buttonId);
        final Net1814080903108Activity thisActivity = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,linkActivity);
                thisActivity.startActivity(intent);
            }
        });
    }
```

# 四、实验结果

![lab2-image1](lab2-image1.png)

# 五、实验心得

学习了如何利用按钮来进行页面跳转的操作，这里不考虑性能问题使用了更加方便的反射机制实现跳转按钮的绑定，方便日后进行更多跳转按钮的绑定。

