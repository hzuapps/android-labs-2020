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


创建 Net1814080903133Activity(主界面)、NovelReadActivity(阅读界面)、SettingActivity(设置界面)；

在布局文件中创建 Button 组件；

为 Button 添加点击事件处理；

通过 startActivity(Intent) 实现界面跳转

```java
public class Net1814080903133Activity extends AppCompatActivity {

    Button setBtn;
    ListView myListView;
    BookManager bookManager;
    Net1814080903133Activity that=this;
    MyListViewAdapter listAdapte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903133);

        setTitle("主界面");

//        变量初始化
        myListView = findViewById(R.id.listView);
        setBtn = findViewById(R.id.setBtn);
        addBtn = findViewById(R.id.addBtn);

        bookManager = BookManager.getBookManager();

//        设置按钮绑定事件
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setIn = new Intent(that, SettingActivity.class);
                startActivity(setIn);
            }
        });

//        给listview的item绑定点击事件，position作为ID传递参数
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(that, NovelReadActivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//        用于测试的书本导入
                try {
                    bookManager.addBook("daode","道德经","老子","道德经.txt",that);
                    listAdapte.notifyDataSetChanged();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
//        ListView绑定适配器
        listAdapte = new MyListViewAdapter(this);
        myListView.setAdapter(listAdapte);
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
<!--        主界面         -->
        <activity android:name=".Net1814080903133Activity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
<!--        阅读界面        -->
        <activity
            android:name=".myActivity.NovelReadActivity"
            android:parentActivityName=".Net1814080903133Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903133Activity" />
        </activity>
<!--        设置界面        -->
        <activity
            android:name=".myActivity.SettingActivity"
            android:parentActivityName=".Net1814080903133Activity">
            <meta-data
                android:name="android.support.PARENT_ACTIVITY"
                android:value=".Net1814080903133Activity" />
        </activity>
    </application>

</manifest>
```

## 四、实验结果及截图

主界面效果图

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab2(1).jpg" alt="主界面效果" style="zoom: 25%;" />

阅读界面效果图

<<img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab2(2).jpg" alt="阅读界面效果" style="zoom:25%;" />

设置界面效果图

 <img src="https://raw.githubusercontent.com/xiaohei504/image/master/lab2(3).jpg" alt="设置界面效果" style="zoom:25%;" />




## 五、实验心得

本次实验初步使用android studio，通过创建了项目，在项目中创建各个功能的activity，并且实现了跳转逻辑，通过findViewById()获得按钮，使用按钮onclick方法触发跳转,跳转方式是使用Intent，new一个Intent对象，参数为当前Activity上下文和要跳转的Activity，再使用StarActivity函数去跳转。