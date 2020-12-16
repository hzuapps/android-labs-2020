# 实验四
## 一、实验目标 #

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！）

## 二、实验内容 #

1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout；
2. 通过控件ID获取界面对象，执行相关操作；
3. 实现界面控件的事件处理，例如点击按钮；
4. 操作之后，切换到你的第二个界面。

## 三、实验步骤 #

1. 使用LinearLayout布局
```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".UploadActivity">
    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/reminder" />
    <EditText
        android:id="@+id/foods"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/name"
        android:hint="@string/foods" />
    <Spinner
        android:id="@+id/genre"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/foods"
        android:layout_alignParentLeft="true"
        android:layout_toLeftOf="@+id/scene" />
    <Spinner
        android:id="@id/scene"
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/foods"
        android:layout_alignParentRight="true" />

    <EditText
        android:id="@+id/way"
        android:layout_width="match_parent"
        android:layout_height="524dp"
        android:layout_below="@id/genre"
        android:hint="@string/ways" />
    <Button
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/way"
        android:layout_alignParentRight="true"
        android:text="@string/done" />
</RelativeLayout>

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SearchActivity">
    <EditText
        android:id="@+id/search_name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/search_name" />
    <Spinner
        android:id="@+id/genre"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_below="@id/search_name" />
    <Button
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/genre"
        android:layout_alignParentRight="true"
        android:text="@string/search"/>
</RelativeLayout>
```
2. 初始化控件（通过控件ID获取界面对象，执行相关操作；）
```java
 public class UploadActivity extends AppCompatActivity {
    private static final String[] genre01={"炒","煎","炸","甜品","饮品","减肥餐","异国料理","宝宝辅食","孕妇餐"};
    private static final String[] scene01={"早餐","午餐","晚餐","小吃","便当","宿舍食谱"};
    private Spinner spinner;
    private ArrayAdapter<String> adapter01,adapter02;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        spinner = (Spinner) findViewById(R.id.genre);
        adapter01 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,genre01);
        adapter01.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter01);
        spinner = (Spinner) findViewById(R.id.scene);
        adapter02 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,scene01);
        adapter02.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter02);
    }
```
## 四、实验结果 #
![运行结果首页](https://github.com/ting-man/android-labs-2020/blob/master/students/net1814080903341/4-1.jpg)
![运行结果功能页](https://github.com/ting-man/android-labs-2020/blob/master/students/net1814080903341/4-2.jpg)
![运行结果功能页](https://github.com/ting-man/android-labs-2020/blob/master/students/net1814080903341/4-3.jpg)
## 五、实验心得 #
通过本次实验，了解了设计界面布局及控件的使用，对于完成整改程序是较为重要的一步，后续会继续更新。
