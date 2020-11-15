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
设计页面：
1.主页面
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/bg"
    tools:context=".Net1814080903337Activity">

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginBottom="88dp"
        android:onClick="Record"
        android:text="@string/record"
        app:layout_constraintBottom_toTopOf="@+id/button2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.501"
        app:layout_constraintStart_toStartOf="parent" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:onClick="Seek"
        android:text="@string/seek"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="@+id/button"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.663" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="100dp"
        android:onClick="Overdue"
        android:text="@string/overdue"
        app:layout_constraintStart_toStartOf="@+id/button2"
        app:layout_constraintTop_toBottomOf="@+id/button2" />

</androidx.constraintlayout.widget.ConstraintLayout>


2.添加页面
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/rbg"
    tools:context=".RecordActivity">

    <Button
        android:id="@+id/button5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="260dp"
        android:layout_marginRight="260dp"
        android:layout_marginBottom="64dp"
        android:text="@string/submit"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent" />

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayout"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="68dp"
        android:layout_marginLeft="68dp"
        android:layout_marginTop="120dp"
        android:layout_marginEnd="68dp"
        android:layout_marginRight="68dp"
        android:layout_marginBottom="105dp"
        app:layout_constraintBottom_toTopOf="@+id/editText5"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <com.google.android.material.textfield.TextInputEditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/name" />
    </com.google.android.material.textfield.TextInputLayout>

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayout2"
        android:layout_width="395dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="15dp"
        app:layout_constraintStart_toStartOf="@+id/textInputLayout"
        app:layout_constraintTop_toBottomOf="@+id/textInputLayout">

        <com.google.android.material.textfield.TextInputEditText
            android:layout_width="278dp"
            android:layout_height="49dp"
            android:hint="@string/location" />
    </com.google.android.material.textfield.TextInputLayout>

    <EditText
        android:id="@+id/editText4"
        android:layout_width="0dp"
        android:layout_height="45dp"
        android:layout_marginStart="68dp"
        android:layout_marginLeft="68dp"
        android:layout_marginEnd="10dp"
        android:layout_marginRight="10dp"

        android:autofillHints=""
        android:ems="10"
        android:hint="@string/opendate"
        android:inputType="date"
        app:layout_constraintBaseline_toBaselineOf="@+id/editText5"
        app:layout_constraintEnd_toStartOf="@+id/editText5"
        app:layout_constraintStart_toStartOf="parent" />

    <EditText
        android:id="@+id/editText5"
        android:layout_width="144dp"
        android:layout_height="45dp"
        android:layout_marginEnd="62dp"
        android:layout_marginRight="62dp"
        android:layout_marginBottom="500dp"
        android:ems="10"
        android:hint="@string/overduedate"
        android:inputType="date"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editText4"
        app:layout_constraintTop_toBottomOf="@+id/textInputLayout"
        android:importantForAutofill="no"/>

</androidx.constraintlayout.widget.ConstraintLayout>


3.搜索页面
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@drawable/sbg"
    tools:context=".SeekActivity">

    <com.google.android.material.textfield.TextInputLayout
        android:id="@+id/textInputLayout3"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="44dp"
        android:layout_marginEnd="8dp"
        android:layout_marginRight="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <com.google.android.material.textfield.TextInputEditText
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="@string/SeekWarning" />
    </com.google.android.material.textfield.TextInputLayout>

    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="26dp"
        android:layout_marginEnd="29dp"
        android:layout_marginRight="29dp"
        android:onClick="SeekResult"
        android:text="@string/seek"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textInputLayout3" />

 # 四、实验结果
 
![主页面](https://github.com/fairy-lee/android-labs-2020/blob/master/students/net1814080903337/picture/2.png)

![添加页面](https://github.com/fairy-lee/android-labs-2020/blob/master/students/net1814080903337/picture/3.png)

![搜索页面](https://github.com/fairy-lee/android-labs-2020/blob/master/students/net1814080903337/picture/4.png)

 # 五、实验心得
 本次实验要求对应用页面进行设计，难度很大，也很难预计到自己会遇到什么样地问题。在这个过程中遇到了很多问题，只能一点点搜索，一点点的修改代码，调试后都一一地解决了或者寻找到了另一种解决方法，
