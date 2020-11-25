# 实验四

## 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！）

## 二、实验内容
1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：
```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```
3. 实现界面控件的事件处理;
4. 操作之后，切换到第二个界面。

## 三、实验步骤

1. 主界面和功能界面都采用RelativeLayout布局,主界面代码示例如下；
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Net1814080903136Activity">
    </RelativeLayout>
```

2. 在主界面创建列表，选择列表歌曲一二三；  
创建列表：
```java
public class Net1814080903136Activity extends AppCompatActivity {
    String[] mobileArray  = { //
            "曲目一", "曲目二", "曲目三"
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            ArrayAdapter adapter = new ArrayAdapter<String>(this, //
                    R.layout.support_simple_spinner_dropdown_item, mobileArray );

            ListView listView = (ListView) findViewById(R.id.mp3list);
            listView.setAdapter(adapter);
}
```
  将列表显示在界面：
```xml
<ListView
    android:id="@+id/mp3list"

    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_below="@id/button_cut"/>

```

3. 创建搜索文本框以及复选框选择音乐文件的界面代码  
文本框：
```xml
<EditText
        android:id="@+id/name"
        android:layout_gravity="center_vertical"
        android:layout_margin="10dp"
        android:drawablePadding="5dp"
        android:layout_width="500dp"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:imeOptions="actionSearch"
        android:inputType="text"
        android:layout_toRightOf="@id/tp"
        android:hint="请输入本地音乐"/>
```  

复选框：
```xml
<CheckBox
    android:id="@+id/select"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_alignParentRight="true"
    android:focusable="false"
    android:focusableInTouchMode="false"
    android:clickable="false"
    android:layout_below="@id/button_cut"
    />
```

## 四、实验结果
![实现列表布局及复选框代码和结果](https://github.com/yesijie0216/android-labs-2020/blob/master/students/net1814080903136/main4.JPG)
![点击按钮跳转功能界面](https://github.com/yesijie0216/android-labs-2020/blob/master/students/net1814080903136/gongneng4.JPG)


## 五、实验心得
本次实验掌握了如何使用布局，在这里我使用的都是相对布局，相对熟悉的掌握的布局的技巧。并且学会了创建列表，知道如何编写复选框,但对于复选框的多个选择事件处理还未掌握，并且如何实现一个曲目搭配一个复选框的操作未实现。
