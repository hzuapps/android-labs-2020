# 实验二

## 一、实验目标
1. 在Issues中创建自己的选题：https://github.com/hzuapps/android-labs-2020/issues；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；

## 二、实验内容
1. 创建自己的选题
2. 根据自己的选题功能，创建 2-3 个 Activity（界面可以尝试设计）;   
  Net1814080903342Activity.java (首页、LAUNCHER、主活动)  
  功能1Activity.java：SearchIdActivity.java  
  功能2Activity.java：SearchTradingActivity.java  
  AndroidManifest.xml
3. 在 Net1814080903342Activity.java 添加按钮点击事件处理，实现跳转

## 三、实验步骤
1. 在Issues中创建自己的选题并写明功能：https://github.com/hzuapps/android-labs-2020/issues；  
选题：中国建设银行  
功能点：  
（1）查询账户信息  
（2）查询交易记录
2. 创建SearchIdActivity.java、SearchTradingActivity.java以及相应的.xml文件
3. 将创建的java文件注册到AndroidManifest.xml，修改成自己的app名称
```java
<application
    android:allowBackup="true"
    android:icon="@mipmap/ic_launcher"
    android:label="中国建设银行"
    android:roundIcon="@mipmap/ic_launcher_round"
    android:supportsRtl="true"
    android:theme="@style/AppTheme">
    <activity android:name=".Net1814080903342Activity">
        <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter></activity>
    <activity android:name=".SearchTradingActivity" />
    <activity android:name=".SearchIdActivity" />
    <activity android:name=".MainActivity">
    </activity>
</application>
```
4. 在activity_net181408090334.xml中添加按钮，设计界面；
5. 在Net1814080903342Activity.java添加按钮点击事件处理，实现跳转到其他Activity
```java
public class Net1814080903342Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903342);
    }

    public void OnClickSearchId(View view) {
        Intent intent = new Intent(this,SearchIdActivity.class);
        startActivity(intent);
    }

    public void OnClickSearchTrading(View view) {
        Intent intent = new Intent(this,SearchTradingActivity.class);
        startActivity(intent);
    }
}
```

## 四、实验结果
![实验2截图](https://raw.githubusercontent.com/momingyu1/android-labs-2020/master/students/net1814080903342/lab2.jpg)

## 五、实验心得
本次实验学习到如何添加组件，如何利用按钮在Activity之间跳转，在设置按钮时需要设置唯一的id。
