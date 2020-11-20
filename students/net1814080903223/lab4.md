# 一、实验目标

1. 根据选题要求设计界面布局及控件使用；
2. 布局xml及界面控制操作代码提交并截图；
3. 将应用运行结果截图。

# 二、实验内容

1. 使用一种布局方式设计界面；
2. 通过控件ID获取界面对象，执行相关操作：

```
// XML
android:id="@+id/my_button"
// Java
findViewById(R.id.my_button);
```

1. 实现界面控件的事件处理;
2. 操作之后，切换到第二个界面。

# 三、实验步骤

1. 根据自己项目设置了Linearlayout。

2. 主界面avtivity_net1814080903223布局
   ```  
   <?xml version="1.0" encoding="utf-8"?>
   <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/tupian1"
    tools:context=".Net1814080903223Activity">

    <Button
        android:id="@+id/btn"
        android:layout_width="146dp"
        android:layout_height="90dp"
        android:layout_marginTop="192dp"
        android:text="PLAY"
        android:textSize="30dp"
        android:background="@drawable/tupian101"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/btn2"
        android:layout_width="146dp"
        android:layout_height="90dp"
        android:layout_marginTop="392dp"
        android:text="VIEWANDMODIFY"
        android:textSize="30dp"
        android:background="@drawable/tupian101"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView6"
        android:layout_width="370dp"
        android:layout_height="54dp"
        android:layout_marginTop="24dp"
        android:text="欢迎进入猜拳游戏"
        android:textSize="30dp"
        android:background="@drawable/tupian102"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.457"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
``` 
</androidx.constraintlayout.widget.ConstraintLayout>
``` 
3. 第一界面activity_play布局

   ```
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:background="@drawable/tupian2"
        android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="125dp"
        android:layout_height="100dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="136dp"
        android:text="PLAYERE"
        android:textSize="30dp"
        android:background="@drawable/tupian102"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="125dp"
        android:layout_height="100dp"
        android:layout_marginTop="136dp"
        android:layout_marginEnd="40dp"
        android:layout_marginRight="40dp"
        android:text="AL"
        android:textSize="30dp"
        android:background="@drawable/tupian102"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="110dp"
        android:layout_height="75dp"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="396dp"
        android:text="石头"
        android:textSize="30dp"
        android:background="@drawable/tupian202"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="110dp"
        android:layout_height="75dp"
        android:layout_marginStart="148dp"
        android:layout_marginLeft="148dp"
        android:layout_marginTop="396dp"
        android:text="剪刀"
        android:textSize="30dp"
        android:background="@drawable/tupian202"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button3"
        android:layout_width="110dp"
        android:layout_height="75dp"
        android:layout_marginTop="396dp"
        android:layout_marginEnd="16dp"
        android:layout_marginRight="16dp"
        android:text="布"
        android:textSize="30dp"
        android:background="@drawable/tupian202"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
``` 
</androidx.constraintlayout.widget.ConstraintLayout>
```
 
4. 第二界面activity_viewandmodify布局
```  
    <?xml version="1.0" encoding="utf-8"?>
    <androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:background="@drawable/tupian2"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView2"
        android:layout_width="125dp"
        android:layout_height="100dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="136dp"
        android:text="PLAYERE"
        android:textSize="30dp"
        android:background="@drawable/tupian102"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <TextView
        android:id="@+id/textView3"
        android:layout_width="125dp"
        android:layout_height="100dp"
        android:layout_marginTop="136dp"
        android:layout_marginEnd="40dp"
        android:layout_marginRight="40dp"
        android:text="AL"
        android:textSize="30dp"
        android:background="@drawable/tupian102"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        android:layout_width="110dp"
        android:layout_height="75dp"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="396dp"
        android:text="石头"
        android:textSize="30dp"
        android:background="@drawable/tupian202"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="110dp"
        android:layout_height="75dp"
        android:layout_marginStart="148dp"
        android:layout_marginLeft="148dp"
        android:layout_marginTop="396dp"
        android:text="剪刀"
        android:textSize="30dp"
        android:background="@drawable/tupian202"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button3"
        android:layout_width="110dp"
        android:layout_height="75dp"
        android:layout_marginTop="396dp"
        android:layout_marginEnd="16dp"
        android:layout_marginRight="16dp"
        android:text="布"
        android:textSize="30dp"
        android:background="@drawable/tupian202"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</androidx.constraintlayout.widget.ConstraintLayout>
 ``` 
# 四、实验结果

！[实验结果]（https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan401.jpg）
！[实验结果]（https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan401.jpg）
！[实验结果]（https://github.com/wenzequan/android-labs-2020/blob/master/students/net1814080903223/shiyan401.jpg）

# 五、实验心得

在布局方面根据自身的需要设计选择了Linearlayout布局，同时根据自己的选题猜拳游戏在布局中创建了较多的组件，并且添加了较多的图片显得更美观。
