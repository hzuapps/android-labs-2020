# 实验二：Android组件编程

## 一、实验要求

1. 在Issues中创建自己的选题：[https://github.com/hzuapps/android-labs-2020/issues](https://github.com/hzuapps/android-labs-2020/issues) ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转。

## 三、实验步骤


1. 创建 Sec1814080911224Activity(主界面)、DrawActivity(洗牌界面)、ShuffleActivity(比大小界面)；
2. 在布局文件中创建 Button 组件；
3. 为 Button 添加点击事件处理；
4. 通过 startActivity(Intent) 实现界面跳转。

```java
public class sec1814080911224Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911224_activity);
        Button btnOpen1 = (Button) findViewById(R.id.draw_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,DrawActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.shuffle_btn);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,ShuffleActivity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }
}
```

```java
public class DrawActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        Button btnOpen = (Button) findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911224Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
 	Drawable drawable = getResources().getDrawable(R.drawable.Drawable);
        	drawable.setBounds(0,0,200,200);
       	TextView textview = (TextView) findViewById(R.id.textview_01);
       	textview.setCompoundDrawables(null,drawable,null,null);
    }
}

```

```java
public class ShuffleActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shuffle);
        Button btnOpen1 = (Button) findViewById(R.id.main_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911224Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
	Drawable drawable = getResources().getDrawable(R.drawable.shuffle);
        	drawable.setBounds(0,0,200,200);
        	TextView textview = (TextView) findViewById(R.id.textview_01);
        	textview.setCompoundDrawables(null,drawable,null,null);
    }
}

```


5. 将创建的 Activity 注册到 AndroidManifest.xml 中；

```sssisixml
        <activity android:name=".ShuffleActivity"></activity>
        <activity android:name=".DrawActivity" />
        <activity android:name=".sec1814080911224Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

## 四、实验结果及截图

![实验二图片](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab2-1.PNG)

![实验二图片](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab2-2.PNG)

![实验二图片](https://github.com/ljjljjj/android-labs-2020/blob/master/students/sec1814080911224/lab2-3.PNG)

## 五、实验心得

本次实验是Android Studio的第一次真正地使用，创建了项目，为之后的功能做了一些铺垫，预留了一些功能，并且运行成功。代码写的比较困难，对于Java语言不太熟练。还需要更加努力。