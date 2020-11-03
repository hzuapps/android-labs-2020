# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。（不要做登录注册！

# 二、实验内容

1. 使用其中一种布局方式，设计所选题目的界面(LinearLayout, RelativeLayout, Adapter, ConstraintLayout (自学))
2. 通过控件ID获取界面对象，执行相关操作：
3. 实现界面控件的事件处理，例如点击按钮：
4. 操作之后，切换到你的第二个界面。

# 三、实验步骤

1. 选取LinearLayout布局方式，为账本页面设计。
2. 修改xml的布局为LinearLayout。
```
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/asss"
    tools:context=".AccountBook"
    android:orientation="vertical">
</LinearLayout>
```
3. 建立ListView组件
```
<ListView
    android:id="@+id/account_list"
    android:layout_width="match_parent"
    android:layout_height="512dp"
    tools:layout_editor_absoluteX="0dp"
    tools:layout_editor_absoluteY="67dp">
</ListView>
```
4. 建立ListView子组件的xml文件
```
<?xml version="1.0" encoding="utf-8"?>
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/label"
    android:layout_width="fill_parent"
    android:layout_height="fill_parent"
    android:padding="10dip"
    android:textSize="16dip"
    android:textStyle="bold">
</TextView>
```
5. 添加按钮，建立点击事件，绑定监视器。
```
Button btnOpen = (Button) findViewById(R.id.button_back);
final AccountBook thisActivity = this;
btnOpen.setOnClickListener(new View.OnClickListener(){
  @Override
  public void onClick(View view){
    Intent intent = new Intent(thisActivity, Net1814080903212Activity.class);
    thisActivity.startActivity(intent);
  }
});
```
# 四、实验结果

![result](https://raw.githubusercontent.com/Unknowuse/android-labs-2020/master/students/net1814080903212/lab4result1.png)
![result](https://raw.githubusercontent.com/Unknowuse/android-labs-2020/master/students/net1814080903212/lab4result2.png)

# 五、实验心得

这次实验我对我实现了账本的布局，将账本的大致样子实现了出来。后面只需要实现账本动态的获取数据库的数据，并显示出来就可以了。这次实验使用的是静态数组，后面只需要动态的将数据库的数据放置到数组中就可以实现了。
