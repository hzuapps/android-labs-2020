# 实验二：Android组件编程

## 一、实验要求

1. 在Issues中创建自己的选题：[https://github.com/hzuapps/android-labs-2020/issues](https://github.com/hzuapps/android-labs-2020/issues) ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

## 三、实验步骤


创建 MainActivity(主界面)、Net1814080903329Activity(作业提交界面)、HomeworkMangerActivity（作业管理界面)；

在布局文件中创建 Button 组件；

为 Button 添加点击事件处理；

通过 startActivity(Intent) 实现界面跳转

```java
public class MainActivity extends AppCompatActivity {
    private Button mbtnTextview;
    private Button mbtnButton;
    private Button mbtnButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnTextview = findViewById(R.id.btn_textview);
        mbtnTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作业提交界面
                Intent intent=new Intent(MainActivity.this,Net1814080903329Activity.class);
                startActivity(intent);
            }
        });


        mbtnButton=(Button) findViewById(R.id.btn_button);
        mbtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作业管理按钮界面
                Intent intent=new Intent(MainActivity.this,HomeworkMangerActivity.class);
                startActivity(intent);
            }
        });


        mbtnButton1=(Button) findViewById(R.id.btn_imge);
        mbtnButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到作业图片界面
                Intent intent=new Intent(MainActivity.this,PictureActivity.class);
                startActivity(intent);
            }
        });


    }

```

```java
public class Net1814080903329Activity extends AppCompatActivity {
    private Button mbtnTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903329);

    }
}
```

```java
public class HomeworkMangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework_manger);
    }
        public void showToast(View view){
            Toast.makeText(this,"点击启动了",Toast.LENGTH_LONG).show();
        }
    }

```



将创建的 Activity 注册到 AndroidManifest.xml 中；

```sssisixml
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
        <activity android:name=".PictureActivity"></activity>
        <activity android:name=".HomeworkMangerActivity" />
        <activity android:name=".Net1814080903329Activity" />
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## 四、实验结果及截图

![实验二图片](https://github.com/2950743175/android-labs-2020/blob/master/students/net1814080903329/lab2.PNG)



## 五、实验心得
本次实验主要的内容是做跳转的按钮，在创建了项目后，在项目中创建各个功能的activity，并且实现了页面的跳转，通过findViewById()获得按钮，使用按钮onclick方法触发跳转，学习起来比较有趣。
