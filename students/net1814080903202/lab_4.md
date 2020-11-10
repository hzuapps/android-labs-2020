# 一、实验目标
1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。  
# 二、实验内容
1. 学习界面布局相关内容：LinearLayout, RelativeLayout, Adapter, ConstraintLayout；
2. 修改styles.xml和AndroidManifest.xml,在各layout布局文件下重写ToolBar；
3. 根据功能需求，使用LinearLayout, RelativeLayout, Adapter,ListView等实现界面编程；
4. 实现各界面功能事件处理。  
# 三、实验步骤
1. 在styles.xml新建一个style，继承NoActionBar，名字为MyAppTheme，在AndroidManifest.xml中各activity使用theme调用，然后在各界面布局文件重写对应的ToolBar；
```
    <style name="MyAppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>
```
```
    <activity android:name=".Scan1814080903202Activity" android:theme="@style/MyAppTheme"/>
    <activity android:name=".Comment1814080903202Activity" android:theme="@style/MyAppTheme"/>
    <activity android:name=".Moment1814080903202Activity" android:theme="@style/MyAppTheme"/>
    <activity android:name=".Net1814080903202Activity" android:theme="@style/MyAppTheme">
```
2. 在activity_moment1814080903202.xml中添加ListView控件，再编写moment_listview_item.xml作为它的子布局，这一部分都使用LinearLayout布局；在item布局中，使用LinearLayout布局嵌套，名字、头像、时间为一部分，内容为另一部分，头像部分编写head_radius.xml实现圆角；在Java类中使用Adapter加载布局；
```
    <?xml version="1.0" encoding="utf-8"?>
    <layer-list xmlns:android="http://schemas.android.com/apk/res/android">
        <item android:left="-10dp" android:top="-10dp" android:right="-10dp" android:bottom="-10dp">
            <shape android:shape="oval">
                <solid
                    android:color="#eee"/>
                <stroke
                    android:width="10dp" android:color="#fff"/>
                <size
                    android:width="40dp"
                    android:height="40dp"/>
                <gradient android:centerColor="#0000" />
            </shape>
        </item>
    </layer-list>
```
3. activity_comment1814080903202.xml总布局为LinearLayout，使用View指定高度5dp和背景色来实现分隔效果，中间部分为ListView，最下面用LinearLayout放置输入框和发送按钮；ListView的子布局为moment_listview_item.xml文件，使用RelativeLayout，使得头像和名字、时间显示在左边，内容显示在右边；在Java类中编写实体类CommentBean.java封装数据，使用SimpleAdapter加载布局；
4. 为ToolBar的返回按钮添加点击事件，实现onBackPressed()方法，扫码按钮实现跳转Scan1814080903202Activity；在Comment1814080903202Activity中为发送按钮添加点击事件，若输入框内容不为空，将数据写入到CommentBean对象，再加入resultlist列表，调用simpleAdapter.notifyDataSetChanged()重新加载新内容；  
# 四、实验结果
![lab4](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab4_1.jpg)
![lab4](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab4_2.jpg)
![lab4](https://github.com/tillsunrise/android-labs-2020/blob/master/students/net1814080903202/lab4_3.jpg)  
# 五、实验心得
这次实验相对就比较难了，要写的东西很多，首先在布局上，要重写各界面下的ToolBar，要设计各界面布局，要设计ListView的item布局等等，这个过程比较繁琐枯燥，虽然没有遇到大的问题，但是为了显示效果就要不断微调，还有要注意各种细节，比如分隔的View，圆角头像的xml等等。在Java类功能部分，难的是数据的封装，listview数据的动态加载，我使用了静态list对象来实现这一效果。在做实验的过程中学习了很多新知识和各种代码的用法，提升很大。
