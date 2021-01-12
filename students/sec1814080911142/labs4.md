# 一、实验目标 #

1. 根据选题要求设计界面布局及控件使用
2. 布局xml及界面控制操作代码提交并截图
3. 将应用运行结果截图

# 二、实验内容 #

1. 使用其中一种布局方式设计所选题目的界面
2. 通过控件ID获取界面对象，执行相关操作
3. 将应用运行结果截图
4. 点击图片（或按钮）时，打开另一个界面

# 三、实验步骤 #

1. 首页采用相对布局，并在其中插入TextView、Button等组件
2. java文件通过通过findViewById(R.id.xxx)返回一个组件对象；xml文件通过android:id="@+id/xxx绑定组件对象，两者建立映射关系
3. 事件函数在java中写出，在xml中绑定，如函数send()要绑定到Button的Click事件，则可以在xml文件的Button组件中加入android:onClick="send"属性
4. 根据不同的需要对组件进行不同的绑定以及函数处理

# 四、实验结果 #
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical"
    android:background="@drawable/myimage"
    >
    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="@string/to1" />


    <EditText
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="@string/subject" />


    <Button
        android:id="@+id/button11"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="@string/submit1" />
    <Button
        android:id="@+id/button22"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:text="@string/submit2" />



    </LinearLayout>

```

```java
public class Register extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smdl);
        final Button button1 = (Button) findViewById(R.id.button11);
        final Button button2 = (Button) findViewById(R.id.button22);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911142Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();


            }



        });
    }


}
```



![程序界面1](https://raw.githubusercontent.com/lxp99/android-labs-2020/students/sec1814080911142/第4次实验报告/第4次实验图片1.png)

![程序界面2](https://raw.githubusercontent.com/lxp99/android-labs-2020/students/sec1814080911142/第4次实验报告/第4次实验图片2.png)


# 五、实验心得 #

这次试验我们主要学习了xml和java的映射关系，将设计完成的xml映射到java中，实现在app中显示设计完成的xml。
