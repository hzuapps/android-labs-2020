# 实验三：Android资源使用编程

## 一、实验目的

1.了解Android应用中各种资源的概念与使用方法；
2.掌握在Android应用中使用图片等资源的方法。

## 二、实验要求
1.在界面上显示至少一张图片；
2.提交res/drawable及图片使用的代码；
3.提交res/values, res/layout等其他代码；
4.将应用运行结果截图，放到实验报告中；
5.点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

1. 将图片放到项目中的 src/main/res/drawable 中。

2. 在activity_checkpoint.xml,添加TextView，如下：

```
<TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/checkpoint"
        android:text=" 关卡开始"
        android:paddingLeft="150dp"
        android:paddingTop="120dp"/>
```

3. 在 activity_props.xml添加TextView，如下：

```
<TextView
        android:id="@+id/textview_01"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableTop="@drawable/props"
        android:paddingLeft="150dp"
        android:paddingTop="120dp"
        android:text=" 道具" />
```

4. 在 activity_sec1814080911236.xml,添加 background 如下：

```
android:background="@drawable/bg"
```

5. 然后再在java代码中调整图片大小

```
public class propsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_props);
        Button btnOpen1 = (Button) findViewById(R.id.main_btn);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
       
```
6. 运行显示

## 四、实验结果及截图

![tp1](https://github.com/zhanglinfeng1234/android-labs-2020/blob/master/students/sec1814080911236/2.lab.png)


![tp2](https://github.com/zhanglinfeng1234/android-labs-2020/blob/master/students/sec1814080911236/lab2.png)


![tp3](https://github.com/zhanglinfeng1234/android-labs-2020/blob/master/students/sec1814080911236/2.lab3.png)

## 五、实验心得
​       通过本次实验，自己的摸索成功在activity中插入图片，在界面上显示了三张图片。掌握了通过在xml中设置样式和布局。在实验中有一个问题就是图片的位置、大小还需要精调，他们的属性调整有点难，不过总的来说实验本身还是比较简单的。