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
1.主界面采用LinearLayout布局，将图片、APP名字、以及三个界面的跳转按键进行竖直排版

主界面xml:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="10dp"
    android:background="@color/colorRed"
    tools:context=".Net1814080903312Activity">

    ...
</LinearLayout>
```
2.播放界面在整体采用LinearLayout竖直方向布局中再加入一个LinearLayout水平方向布局

播放界面xml:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:background="@drawable/wangyiyun3"
    tools:context=".PlayActivity">
...

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="50dp"
        android:orientation="horizontal">

        ...
    </LinearLayout>

</LinearLayout>
```
# 四、实验结果

# 五、实验心得
本次实验主要是学习对于界面布局的设计和调整，通过设计布局能使APP界面看起来更美观舒适。
