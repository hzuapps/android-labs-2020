# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登陆注册！）
# 二、实验内容
1. 了解界面布局的几种类型：LinearLayout, RelativeLayout, Adapter, ConstraintLayout；
2. 使用上述其中一种布局进行选题各界面的设计；
3. 使用和选题各界面相关的控件；
4. 实现界面控件的事件处理
# 三、实验步骤
1. 选取RelativeLayout布局方式，为纪念日页面设计；
2. 修改xml的布局为RelativeLayout；
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="15dp"
    tools:context=".Net1814080903220MainActivity"
    android:background="@drawable/bird"> //主页界面放置app背景图片
    <RelativeLayout
```
3. 建立Button组件；
```
  <Button
        android:id="@+id/P_icture"
        android:layout_width="310dp"
        android:layout_height="70dp"
        android:layout_marginTop="470dp"
        android:layout_centerHorizontal="true"
        android:background="@drawable/btn_picture"
        android:text="更换背景图片"
        android:textColor="#FFF"
        android:textSize="30dp">
    </Button>
```
4. 添加按钮，建立点击事件，从Net1814080903220MainActivity显式跳转到Net1814080903220PictureActivity。
```
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        
        Picture = (Button) findViewById(R.id.P_icture);
        Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903220MainActivity.this,Net1814080903220PictureActivity.class);
                startActivity(intent);
            }
        });
        };
```
# 四、实验结果
![result4](https://raw.githubusercontent.com/JieBro333/android-labs-2020/master/students/net1814080903220/lab4result.jpg)
# 五、实验心得
遇到的问题：
1. 不懂各种布局的具体区别；

解决的办法：
1. 问同学；
2. 百度搜索了解
