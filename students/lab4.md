#实验四 Android界面设计编程
##一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。
##二、实验内容
1. 使用其中一种布局方式，设计所选题目的界面，建议用LinearLayout。
LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学)
通过控件ID获取界面对象，执行相关操作：
对相对应的xml文件，操作为：android:id="@+id/pu_1"，android:id="@+id/cb_1"
对相对应的Java文件，操作为：mpu_1 = (TextView) findViewById(R.id.pu_1);
mse_1 = (TextView) findViewById(R.id.se_1);
2.实现界面控件的事件处理，例如点击按钮。
3.在gitbash上进行代码提交。
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_tiao1 = (Button) findViewById(R.id.button1);
        final MainActivity thisActivity1 = this;
        button_tiao1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent1 = new Intent(thisActivity1, MarkActivity.class);
                MainActivity.this.startActivity(Intent1);
            }
        });
        Button button_tiao2 = (Button) findViewById(R.id.button2);
        final MainActivity thisActivity2 = this;
        button_tiao2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent2 = new Intent(thisActivity2, SerachActivity.class);
                MainActivity.this.startActivity(Intent2);
            }
        });
    }
}
##三、实验步骤 
1、布局界面有activity_main.xml、activity_punchtheclock.xml、activity_searchword.xml；
2、通过控件ID获取界面对象，执行相关操作：
（1）对activity_punchtheclock.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/punch"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="30dp">

    <TextView
        android:id="@+id/pu_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="请默写背过的两个单词"
        android:textColor="#C72828"
        android:textSize="24sp"
        android:singleLine="true"
        android:ellipsize="marquee"
        android:focusable="true"
        android:focusableInTouchMode="true"
        android:marqueeRepeatLimit="marquee_forever"/>

    <EditText
        android:id="@+id/et_1"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="50dp"
        android:hint="Write the first word please."
        android:textColor="#AC20CE"
        android:textSize="16sp" />

    <EditText
        android:id="@+id/et_2"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_below="@+id/et_1"
        android:layout_marginTop="30dp"
        android:hint="Write the second word please."
        android:textColor="#AC20CE"
        android:textSize="16sp" />

     <Button
         android:id="@+id/btn_start"
         android:layout_width="match_parent"
         android:layout_height="50dp"
         android:layout_below="@id/et_2"
         android:layout_marginTop="100dp"
         android:text="来复习旧单词吧"
         android:textColor="#fff"
         android:textSize="20dp"
         android:background="#ff9933"/>


</RelativeLayout>
（2）对activity_searchword.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/se_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Please input."
        android:textColor="#C72828"
        android:textSize="24sp"
        android:ellipsize="marquee"
        android:focusable="true"
        android:focusableInTouchMode="true"
        android:marqueeRepeatLimit="marquee_forever"
        android:singleLine="true"
        />

    <CheckBox
        android:id="@+id/cb_1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        android:text="英译汉"
        android:textSize="20sp" />
    <CheckBox
        android:id="@+id/cb_2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="汉译英"
        android:layout_toRightOf="@id/cb_1"
        android:layout_marginTop="40dp"
        android:textSize="20sp"/>

    <EditText
        android:id="@+id/et_1"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="20dp"
        android:layout_below="@id/cb_2"
        android:hint="英译汉"
        android:textColor="#AC20CE"
        android:maxLines="3"
        android:textSize="16sp" />

    <EditText
        android:id="@+id/et_2"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_below="@+id/et_1"
        android:layout_marginTop="30dp"
        android:hint="汉译英"
        android:maxLines="3"
        android:textColor="#AC20CE"
        android:textSize="16sp" />

    <Button
        android:id="@+id/btn_start"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_below="@id/et_2"
        android:layout_marginTop="100dp"
        android:text="Confirm"
        android:textColor="#fff"
        android:textSize="20dp"
        android:background="#3FAFAF"/>

</RelativeLayout>
3、在gitbash上提交activity_punchtheclock.xml，activity_searchword.xml以及activity_main.xml代码，git push结束。

##四、实验结果



五、实验心得 
   一开始我不太理解如何实现布局，后面通过在b站上面学习相关布局知识，选择使用relativelayout来实现布局，有一定的收获。
