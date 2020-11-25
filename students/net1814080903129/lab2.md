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


1. 创建 Net1814080903129Activity(主界面)、OperationActivity(普通运算界面)、ShiftActivity(进制换算界面)；
2. 在布局文件中创建 Button 组件；
3. 为 Button 添加点击事件处理；
4. 通过 startActivity(Intent) 实现界面跳转。

```java
public class Net1814080903129Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_operation);
        View view = findViewById(R.id.button_operation);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, OperationActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button btnOpen2 = (Button) findViewById(R.id.button_shift);
        View view2 = findViewById(R.id.button_shift);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, ShiftActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
```

```java
public class OperationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_back);
        btnOpen.setX(300f);
        btnOpen.setY(200f);

        View view = findViewById(R.id.button_back);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903129Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
```

```java
public class ShiftActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shift);

        final Activity thisActivity = this;

        Button btnOpen = (Button) findViewById(R.id.button_back2);
        btnOpen.setX(300f);
        btnOpen.setY(200f);

        View view = findViewById(R.id.button_back2);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903129Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
```


5. 将创建的 Activity 注册到 AndroidManifest.xml 中；

```sssisixml
        <activity android:name=".ShiftActivity" />
        <activity android:name=".OperationActivity" />
        <activity android:name=".Net1814080903129Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

## 四、实验结果及截图

![实验二图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab2(1).PNG)

![实验二图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab2(2).PNG)

![实验二图片](https://github.com/hkx0505/android-labs-2020/raw/master/students/net1814080903129/TP/lab2(3).PNG)

## 五、实验心得

本次实验用通过 startActivity(Intent) 实现界面跳转，并且使用按钮onclick方法触发跳转，由于对android studio这个开发软件还不太熟悉，在创建和编程的过程中也出现了一些小问题，但也成功解决。