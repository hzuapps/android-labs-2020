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


创建 Net1814080903117Activity(主界面)、DownloadActivity(下载界面)、UploadActivity(上传界面)；

在布局文件中创建 Button 组件；

为 Button 添加点击事件处理；

通过 startActivity(Intent) 实现界面跳转

```java
public class Net1814080903115Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity = this;

        Button btnBrowse = (Button) findViewById(R.id.button_browse);
        View view = findViewById(R.id.button_browse);

        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, BrowseActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
        Button btnPlay = (Button) findViewById(R.id.button_play);
        View view2 = findViewById(R.id.button_play);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, PlayActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}
```

```java
public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brouse);


        Button btnBack = (Button) findViewById(R.id.button_back);
        View view = findViewById(R.id.button_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BrowseActivity.this, Net1814080903115Activity.class);
                BrowseActivity.this.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}
```

```java
public class PlayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Button btnBack = (Button) findViewById(R.id.button_back);
        View view = findViewById(R.id.button_back);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayActivity.this, Net1814080903115Activity.class);
                PlayActivity.this.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
    }
}
```



将创建的 Activity 注册到 AndroidManifest.xml 中；

```sssisixml
   <activity android:name=".PlayActivity"></activity>
        <activity android:name=".BrowseActivity" />
        <activity android:name=".Net1814080903115Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

## 四、实验结果及截图

![实验二图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.1.png)


![实验二图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.2.png)


![实验二图片](https://github.com/1CHONG/android-labs-2020/raw/master/students/net1814080903115/lab2.3.png)

## 五、实验心得

本次实验主要的内容是做跳转的按钮，通过创建了项目，在项目中创建各个功能的activity，并且实现了跳转逻辑，通过findViewById()获得按钮，使用按钮onclick方法触发跳转，感觉挺有趣的。