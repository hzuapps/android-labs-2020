# 实验四 
  ## 一、实验目标 
  1. 根据选题要求设计界面布局及控件使用； 
  2. 布局xml及界面控制操作代码提交并截图； 
  3. 将应用运行结果截图。 

   ## 二、实验内容 
  1. 使用一种布局方式设计界面； 
  2. 通过控件ID获取界面对象，执行相关操作： 
  3. 实现界面控件的事件处理; 
  4. 操作之后，切换到第二个界面。 

   ## 三、实验步骤 
  1.主页面采用了线性布局和相对布局相结合，设置了两个按钮，即"录屏"按钮和"我的"按钮；
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".Net1814080903318Activity">

    <RelativeLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <Button
            android:id="@+id/button"
            android:layout_width="135dp"
            android:layout_height="96dp"
            android:layout_marginLeft="130dp"
            android:layout_marginTop="80dp"
            android:text="录屏" />

        <Button
            android:id="@+id/button2"
            android:layout_width="150dp"
            android:layout_height="109dp"
            android:layout_marginLeft="130dp"
            android:layout_marginTop="480dp"
            android:text="我的" />

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="262dp"
            android:layout_height="216dp"
            android:layout_marginLeft="70dp"
            android:layout_marginTop="200dp"
            app:srcCompat="@drawable/logo" />
    </RelativeLayout>
</LinearLayout>
```

  2.录屏界面使用了线性布局，设置了个ImageButton，并进行了相应的配置；
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical" >

    <TextView
        android:id="@+id/textView2"
        android:layout_width="370dp"
        android:layout_height="52dp"
        android:textSize="40dp"
        android:paddingLeft="100dp"
        android:text="录屏界面" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="500dp">

        <VideoView
            android:id="@+id/videoView"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </LinearLayout>
    <ImageButton
        android:id="@+id/imageButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="21dp"
        android:layout_marginLeft="133dp"
        app:srcCompat="@drawable/lp" />
</LinearLayout>
```

  3.我的视频界面使用了线性布局，设置了个ImageButton和Button；
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingLeft="16dp"
    android:paddingRight="16dp"
    android:orientation="vertical" >

    <TextView
        android:id="@+id/textView"
        android:layout_width="327dp"
        android:layout_height="wrap_content"
        android:text="我的视频，点击播放"
        android:textSize="30dp" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="100dp">
        <ImageButton
            android:id="@+id/imageButton3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"

            app:srcCompat="@drawable/video1" />

        <ImageButton
            android:id="@+id/imageButton4"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            app:srcCompat="@drawable/video1" />

    </LinearLayout>

    <Button
        android:id="@+id/button3"
        android:layout_width="150dp"
        android:layout_height="wrap_content"
        android:layout_marginLeft="200dp"
        android:text="视频管理" />
</LinearLayout>
```

   ## 四、实验结果 
  ![实验截图](https://raw.githubusercontent.com/xiaocheng123785/android-labs-2020/master/students/net1814080903318/4-1.jpg)
  ![实验截图](https://raw.githubusercontent.com/xiaocheng123785/android-labs-2020/master/students/net1814080903318/4-2.jpg)

   ## 五、实验心得 
  本次实验主要是对界面的布局进行设计，线性布局比较容易理解和实现，app三个的界面都设置了线性布局，并且添加了各自的一些组件。
