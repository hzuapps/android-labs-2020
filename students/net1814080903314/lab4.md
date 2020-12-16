# 一、实验目的
1.根据选题要求设计界面布局及控件使用  
2.布局xml及界面控制操作代码提交并截图  
3.将应用运行结果截图  
# 二、实验内容
1.使用一种布局方式设计界面  
2.通过控件ID获取界面对象，执行相关操作  
3.实现界面控件的事件处理  
4.操作之后，切换到第二个界面  
# 三、实验步骤
1.主界面采用相对布局
主界面xml:
```
<RelativeLayout
    ...
    tools:context=".Net1814080903314Activity">
    ...
    <Button
        android:id="@+id/btn_button"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Saves"
        android:layout_alignParentBottom="true"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/icn_icon"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="ScreenShot"
        tools:ignore="MissingConstraints" />
</RelativeLayout>
```
2.功能界面也采用相对布局
```
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    ...
    tools:context=".IconActivity">

    <Button
        android:id="@+id/icon_1"
        android:layout_width="62dp"
        android:layout_height="75dp"
        android:drawableTop="@drawable/sirr"
        android:scaleType="fitCenter" />
    <Button
        android:id="@+id/icon_2"
        android:layout_width="62dp"
        android:layout_height="75dp"
        android:drawableTop="@drawable/phot"
        android:layout_alignParentRight="true"
        android:scaleType="fitCenter" />
</RelativeLayout>
```
# 四、实验结果
![主界面截图](https://github.com/AzStartie/android-labs-2020/blob/master/students/net1814080903314/Exp02.png)
![功能界面截图](https://github.com/AzStartie/android-labs-2020/blob/master/students/net1814080903314/Exp04.png)
# 五、实验心得
本次实验主要了解了布局，设计了相对布局，让按钮和图片功能按钮看起来比较舒适。
