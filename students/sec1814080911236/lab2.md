# 实验二：Android组件编程

## 一、实验要求

1. 根据自选题目，编写一个或多个Activity;
2.将标题设置为自己的学号+对应的功能或题目；
3.根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容
1.根据自己的选题功能，创建 2-3 个 Activity
2.Net123456Activity.java (首页、LAUNCHER、主活动)
3..功能1Activity.java
4.功能2Activity.java
5.AndroidManifest.xml
6.在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
7.在 Net123456Activity.java 添加按钮点击事件处理，实现跳转。

## 三、实验步骤
1.在github上创建issues号确认选题，列出功能；
2.功能1.checkpointActivity（关卡开始）
3.功能2. propsActivity（道具）
4.AndroidManifest.xml
5.在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。

```java
public class  CheckpointActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ Checkpoint);
        Button btnOpen = (Button) findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911236Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });


	Drawable drawable = getResources().getDrawable(R.drawable.checkpoint);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }
}
```

```java
public class PropsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Button btnOpen1 = (Button) findViewById(R.id.main_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911236Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

Drawable drawable = getResources().getDrawable(R.drawable.props);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }
}
```

```java
public class Sec1814080911236Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911236_activity);
        Button btnOpen1 = (Button) findViewById(R.id.plan_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,PropsActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id. Checkpoint_btn);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, CheckpointActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }
}
```

6. AndroidManifest.xml 

```sssisixml
package="edu.hzuapps.androidlabs.sec1814080911236" >

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme" >
        <activity android:name=".PropsActivity"></activity>
        <activity android:name=".CheckpointActivity" />
        <activity android:name=".sec1814080911236Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## 四、实验结果及截图

![实验二图片](https://github.com/zhanglinfeng1234/android-labs-2020/blob/master/students/sec1814080911236/2.lab.png)

![实验二图片](https://github.com/zhanglinfeng1234/android-labs-2020/blob/master/students/sec1814080911236/2.lab3.png)

![实验二图片](https://github.com/zhanglinfeng1234/android-labs-2020/blob/master/students/sec1814080911236/lab2.png)

## 五、实验心得

​        此次实验主要进行添加按钮，可以让自己的app进行点击事件处理，实现跳转。实验按照老师的要求一步步进行还是比较快的，实验进行过程中会报错，需要自己耐心去解决。实验的过程中还要注意大小写，java包要全部小写开头，在Pull request发送之后，一定要自己查看自己修改的文件，看看有没有改错文件。