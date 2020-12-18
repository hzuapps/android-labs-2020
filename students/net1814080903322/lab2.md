# 实验二

## 一、实验目标

1.在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues ；

2.根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；

3.将标题设置为自己的学号+对应的功能或题目；

4.根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1.创建自己的安卓项目选题；
2.
根据自选题在Android Studio中创建一个或多个Activity；
3.
实现一个Activity与另一个Activity之间的跳转（显式或隐式）

## 三、实验步骤与结果

1. AndroidManifest.xml
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="hzu.android.labs">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".Funtion_Next"></activity>
        <activity android:name=".Net1814080903326Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```
2. Funtion_Next.java

~~~
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtion__next);

~~~

3.功能：Net1814080903326Activity.java
~~~
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Net1814080903326Activity thisActivity = this;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Funtion_Next.class);
                startActivity(intent);
            }
        });
~~~

## 四、实验心得

 本次实验是主要进行的是，通过按钮这个组件实现界面跳转，在课上通过老师的讲解，课后自己的复习可以完成！
