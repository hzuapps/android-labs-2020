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
  
  1.主页面采用了约束布局，设置了三按钮，即"简单"按钮，"中级"按钮和“高级”按钮；
```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    tools:context=".Net1814080903340Activity">

    <Button
        android:id="@+id/button_easy"
        android:layout_width="88dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="170dp"
        android:layout_marginLeft="170dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="170dp"
        android:layout_marginRight="170dp"
        android:layout_marginBottom="16dp"
        android:onClick="onClickEasy"
        android:text=" 简单"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.006" />

    <Button
        android:id="@+id/button_middle"
        android:layout_width="88dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="170dp"
        android:layout_marginLeft="170dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="170dp"
        android:layout_marginRight="170dp"
        android:onClick="onClickMiddle"
        android:text="中级"
        android:textSize="24sp"
        app:layout_constraintBottom_toTopOf="@+id/button_easy"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_easy"
        app:layout_constraintVertical_bias="0.0" />

    <Button
        android:id="@+id/button_high"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="170dp"
        android:layout_marginLeft="170dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="170dp"
        android:layout_marginRight="170dp"
        android:layout_marginBottom="16dp"
        android:onClick="onClickHigh"
        android:text="高级"
        android:textSize="24sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toStartOf="@+id/imageView_bg"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button_middle"
        app:layout_constraintVertical_bias="0.0"
        tools:ignore="OnClick" />

    <ImageView
        android:id="@+id/imageView_bg"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="8dp"
        android:src="@drawable/bg"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />
</androidx.constraintlayout.widget.ConstraintLayout>
```

  2.简单的游戏界面使用了约束布局，设置了个9个按钮，并进行了相应的配置；
```java

        <androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    tools:context=".EasyActivity">

    <Button
        android:id="@+id/button01"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="556dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:text="1"
        app:layout_constraintEnd_toStartOf="@+id/button02"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/button02"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="1dp"
        android:layout_marginLeft="1dp"
        android:layout_marginTop="556dp"
        android:text="2"
        app:layout_constraintStart_toEndOf="@+id/button01"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button03"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="3"
        app:layout_constraintStart_toStartOf="@+id/button02"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button06"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="6"
        app:layout_constraintStart_toStartOf="@+id/button05"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button08"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="8"
        app:layout_constraintStart_toStartOf="@+id/button07"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button07"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="7"
        app:layout_constraintStart_toStartOf="@+id/button06"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button09"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="9"
        app:layout_constraintStart_toStartOf="@+id/button08"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button04"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="4"
        app:layout_constraintStart_toStartOf="@+id/button03"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button05"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="5"
        app:layout_constraintStart_toStartOf="@+id/button04"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imageView01"
        android:layout_width="390dp"
        android:layout_height="681dp"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginRight="16dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/easy" />

    <TextView
        android:id="@+id/textView01"
        android:layout_width="100dp"
        android:layout_height="38dp"
        android:layout_marginStart="400dp"
        android:layout_marginLeft="400dp"
        android:layout_marginTop="200dp"
        android:layout_marginBottom="19dp"
        android:text="简单"
        android:textSize="30sp"
        app:layout_constraintBottom_toTopOf="@+id/imageView01"
        app:layout_constraintEnd_toStartOf="@+id/imageView01"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

```

  3.中级界面使用了线性布局，设置了个9个按钮，并进行了相应的配置；
```java
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MiddleActivity">

    <Button
        android:id="@+id/button01"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="556dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:text="1"
        app:layout_constraintEnd_toStartOf="@+id/button02"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/button02"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="1dp"
        android:layout_marginLeft="1dp"
        android:layout_marginTop="556dp"
        android:text="2"
        app:layout_constraintStart_toEndOf="@+id/button01"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button03"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="3"
        app:layout_constraintStart_toStartOf="@+id/button02"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button06"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="6"
        app:layout_constraintStart_toStartOf="@+id/button05"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button08"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="8"
        app:layout_constraintStart_toStartOf="@+id/button07"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button07"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="7"
        app:layout_constraintStart_toStartOf="@+id/button06"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button09"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="9"
        app:layout_constraintStart_toStartOf="@+id/button08"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button04"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="4"
        app:layout_constraintStart_toStartOf="@+id/button03"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button05"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="5"
        app:layout_constraintStart_toStartOf="@+id/button04"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imageView01"
        android:layout_width="390dp"
        android:layout_height="681dp"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginRight="16dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/middle" />

    <TextView
        android:id="@+id/textView01"
        android:layout_width="100dp"
        android:layout_height="38dp"
        android:layout_marginStart="400dp"
        android:layout_marginLeft="400dp"
        android:layout_marginTop="200dp"
        android:layout_marginBottom="19dp"
        android:text="中级"
        android:textSize="30sp"
        app:layout_constraintBottom_toTopOf="@+id/imageView01"
        app:layout_constraintEnd_toStartOf="@+id/imageView01"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```
 4.高级界面使用了线性布局，设置了个9个按钮，并进行了相应的配置；
```java

<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".HighActivity">
    <Button
        android:id="@+id/button01"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="556dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        android:text="1"
        app:layout_constraintEnd_toStartOf="@+id/button02"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:ignore="MissingConstraints" />

    <Button
        android:id="@+id/button02"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="1dp"
        android:layout_marginLeft="1dp"
        android:layout_marginTop="556dp"
        android:text="2"
        app:layout_constraintStart_toEndOf="@+id/button01"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button03"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="3"
        app:layout_constraintStart_toStartOf="@+id/button02"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button06"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="6"
        app:layout_constraintStart_toStartOf="@+id/button05"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button08"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="8"
        app:layout_constraintStart_toStartOf="@+id/button07"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button07"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="7"
        app:layout_constraintStart_toStartOf="@+id/button06"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button09"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="9"
        app:layout_constraintStart_toStartOf="@+id/button08"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button04"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="4"
        app:layout_constraintStart_toStartOf="@+id/button03"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button05"
        android:layout_width="40dp"
        android:layout_height="50dp"
        android:layout_marginStart="40dp"
        android:layout_marginLeft="40dp"
        android:layout_marginTop="556dp"
        android:text="5"
        app:layout_constraintStart_toStartOf="@+id/button04"
        app:layout_constraintTop_toTopOf="parent" />

    <ImageView
        android:id="@+id/imageView01"
        android:layout_width="390dp"
        android:layout_height="681dp"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginEnd="16dp"
        android:layout_marginRight="16dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:srcCompat="@drawable/high" />

    <TextView
        android:id="@+id/textView01"
        android:layout_width="100dp"
        android:layout_height="38dp"
        android:layout_marginStart="400dp"
        android:layout_marginLeft="400dp"
        android:layout_marginTop="200dp"
        android:layout_marginBottom="19dp"
        android:text="高级"
        android:textSize="30sp"
        app:layout_constraintBottom_toTopOf="@+id/imageView01"
        app:layout_constraintEnd_toStartOf="@+id/imageView01"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

```
   ## 四、实验结果 
  ![截图](https://github.com/88hua/android-labs-2020/blob/master/students/net1814080903340/test04_1.JPG)
  ![截图](https://github.com/88hua/android-labs-2020/blob/master/students/net1814080903340/test04_2.JPG)
  ![截图](https://github.com/88hua/android-labs-2020/blob/master/students/net1814080903340/test04_3.JPG)
   ## 五、实验心得 
  本次实验主要是对界面的布局进行设计，我设计的界面比较简约大方。
