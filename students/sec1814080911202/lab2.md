# 一、实验报告

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容

1. 根据功能创建相应的Activity
2. 编写Activity对应的布局文件
3. 实现各个Activity之间的跳转

# 三、实验步骤

1. 将创建的Activity注册到AndroidManifest.xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="edu.hzuapps.androidlabs.sec1814080911202">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".BorrowActivity"></activity>
        <activity android:name=".ManageActivity" />
        <activity android:name=".Sec1814080911202Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

2. 创建Button按钮用于跳转页面
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Sec1814080911202Activity">

    <!-- 管理图书按钮 -->
    <Button
        android:id="@+id/button_manage"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="管理图书" />

    <!-- 借阅图书按钮 -->
    <Button
        android:id="@+id/button_borrow"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="借阅图书" />
</LinearLayout>
```

3. 为Button按扭添加Click点击事件实现跳转
```java
public class Sec1814080911202Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911202_activity);

        final Sec1814080911202Activity thisActivity = this;

        Button manageBtn = (Button) findViewById(R.id.button_manage);
        manageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式打开一个Activity
                Intent intent = new Intent(thisActivity,ManageActivity.class);
                startActivity(intent);
            }
        });

        Button borrowBtn = (Button) findViewById(R.id.button_borrow);
        borrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ManageActivity.class);
                startActivity(intent);
            }
        });

    }
}
```

# 四、实验结果

 ![lab2](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab2.png)

# 五、实验心得

本次实验是创建2-3个与自己选题有关的Activity，然后利用Intent实现Activity间的跳转。通过本次实验，了解了Android项目下各个文件的作用，学会了在layout下的文件添加按钮，以及在Activity文件中为button添加点击事件。
