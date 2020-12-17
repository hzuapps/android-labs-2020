# 实验二：Android组件编程
## 一、实验要求
- 在Issues中创建自己的选题：[https://github.com/hzuapps/android-labs-2020/issues](https://github.com/hzuapps/android-labs-2020/issues) 
- 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）
- 将标题设置为自己的学号+对应的功能或题目
- 根据自己选择的题目实现Activity中导航、调用等功能（选做）
## 二、实验内容
- 根据功能创建相应的Activity
- 编写Activity对应的布局文件
- 实现各个Activity之间的跳转
## 三、实验步骤
- 创建 Net1814080903323Activity(主界面)、InvitationActivity(帖子界面)、TipsActivity(小技巧界面)
- 在布局文件中创建 Button 组件
- 为 Button 添加点击事件处理
- 通过 startActivity(i) 实现界面跳转
```java
public class Net1814080903323Activity extends AppCompatActivity {
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Net1814080903323Activity.this, InvitationActivity.class);
                startActivity(i);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Net1814080903323Activity.this, TipsActivity.class);
                startActivity(j);
            }
        });
}
```
```java
public class InvitationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitation);
    }
}
```
```java
public class TipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
    }
}
```
- 将创建的 Activity 注册到 AndroidManifest.xml 中；
```xml
        <activity android:name=".TipsActivity"></activity>
        <activity android:name=".InvitationActivity" />
        <activity android:name=".Net1814080903323Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

## 四、实验结果
  
![应用首页](https://github.com/joshua-ben/android-labs-2020/blob/master/students/net1814080903323/test2.jpg)  
首页添加按钮运行结果截图

## 五、实验心得
本次实验学习了使用 startActivity(i)、startActivity(j)分别去实现界面跳转并且使用按钮onclick方法触发跳转，练习好就可以顺利完成这次实验了。
