# 一、实验目标
1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容
1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局组件；
3. 实现各个Activity之间的跳转;

# 三、实验步骤
1. 创建Activity和xml文件
2. 配置AndroidManifest.xml

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
        <activity android:name=".Sec1814080911205Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".CheckActivity" />
        <activity android:name=".AddCityActivity" />
        <activity android:name=".AddTextActivity"></activity>
    </application>
</manifest>

3. 在Sec1814080911205Activity中添加跳转按钮的代码及线性布局
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="edu.hzuapps.androidlabs.Sec1814080911205Activity"
    android:background="@drawable/index">

    <Button

        android:id="@+id/buttoncity"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:background="#66186DEC"
       android:text="添加城市"
        />

    <Button
        android:id="@+id/buttontext"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="添加备注" />

    <Button
        android:id="@+id/buttoncheck"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="查看天气" />

</LinearLayout>

# 四、实验结果
![lab2](https://github.com/wuuuxj/android-labs-2020/tree/master/students/sec1814080911205/lab2.jpg)

# 五、实验心得
通过这次实验，学会了各个页面之间利用button组件的跳转功能。
