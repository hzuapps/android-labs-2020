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
public class Net1814080903117Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903117);

        Button btnOpen1 = findViewById(R.id.up_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,UploadActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = findViewById(R.id.down_btn);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,DownloadActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });


    }
}
```

```java
public class DownloadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Button btnOpen1 = findViewById(R.id.main_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903117Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

    }
}
```

```java
public class UploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        Button btnOpen = findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Net1814080903117Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

    }
}
```



将创建的 Activity 注册到 AndroidManifest.xml 中；

```sssisixml
       <activity android:name=".DownloadActivity" />
        <activity android:name=".UploadActivity" />
        <activity android:name=".Net1814080903117Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

## 四、实验结果及截图

![实验二图片](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(1).png)


![实验二图片](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(2).png)


![实验二图片](https://raw.githubusercontent.com/Cloudtq/android-labs-2020/master/students/net1814080903117/lab2(3).png)

## 五、实验心得

本次实验初步使用android studio，通过创建了项目，在项目中创建各个功能的activity，并且实现了跳转逻辑，通过findViewById()获得按钮，使用按钮onclick方法触发跳转，比较简单能够独立完成。