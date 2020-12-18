# 实验二 Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题：[https://github.com/hzuapps/android-labs-2020/issues](https://github.com/hzuapps/android-labs-2020/issues) ；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转。

## 三、实验步骤

1. 创建 Net1814080903315Activity(主界面)、SaveActivity(储存界面)、SortedtActivity(分类界面)、SeektActivity(查找界面)；
2. 在布局文件中创建 Button 组件；
3. 为 Button 添加点击事件处理；
4. 通过 startActivity(Intent) 实现界面跳转。

```java
public class Net1814080903315Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903315Activity thisActivity = this;

        Button button1 = (Button) findViewById(R.id.button_open1);//第一个button
        Button button2 = (Button) findViewById(R.id.button_open2);//第二个button
        Button button3 = (Button) findViewById(R.id.button_open3);//第三个button
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, SaveActivity.class);//实现第一个跳转
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, SortedActivity.class);//实现第二个跳转
                startActivity(intent);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, SeekActivity.class);//实现第三个跳转
                startActivity(intent);
            }
        });
            }
        }
```

```java
public class SaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
    }
}
```

```java
public class SeekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
    }
}
```

```java
public class SortedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorted);
    }
}
```

5. 将创建的 Activity 注册到 AndroidManifest.xml 中；

```xml
 <activity android:name=".SortedActivity"></activity>
        <activity android:name=".SeekActivity" />
        <activity android:name=".SaveActivity" />
        <activity android:name=".Net1814080903315MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        </activity>
```

## 四、实验结果及截图
![avatar](https://raw.githubusercontent.com/WeiCzai/android-labs-2020/master/students/net1814080903315/labs2.png)

## 五、实验心得

本次实验学习了使用 startActivity(Intent) 去实现界面跳转，并且使用按钮onclick方法触发跳转，照着做就可以完成。
