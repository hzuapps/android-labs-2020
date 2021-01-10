
# 实验六：Android网络编程

## 一、实验目标
1. 掌握Android网络访问方法
2. 理解XML和JOSN表示数据的方法

## 二、实验内容
1. 从网络下载一个文件（图片、MP3、MP4）；
2. 保存到手机，在应用中使用文件；
3. 将应用运行结果截图。


## 三、实验步骤
由于所作APP未使用到网络编程，在原来的APP代码上修改增添

1. 进入界面activity_add_weeding_dress.xml；
2. 新建各个文本框并赋值好属性；
3. 在string内写好各个id对于的字符；
4. 建立提交按钮。

activity_add_weeding_dress.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapps.net1814080903301.AddWeedingDress">

    <EditText
        android:id="@+id/editText"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="13dp"
        android:hint="@string/howtodo"
        app:layout_constraintBottom_toTopOf="@+id/editText2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText6" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="7dp"
        android:hint="@string/price"
        app:layout_constraintBottom_toTopOf="@+id/editText5"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText" />

    <EditText
        android:id="@+id/editText3"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="12dp"
        android:hint="@string/message1"
        app:layout_constraintBottom_toTopOf="@+id/editText6"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText4" />

    <EditText
        android:id="@+id/editText4"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginBottom="7dp"
        android:hint="@string/weedingname"
        app:layout_constraintBottom_toTopOf="@+id/editText3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText5"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginBottom="360dp"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="@string/message"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText2" />

    <EditText
        android:id="@+id/editText6"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:hint="@string/where"
        app:layout_constraintBottom_toTopOf="@+id/editText"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText3" />

    <Button
        android:id="@+id/button"
        android:layout_width="100dp"
        android:layout_height="wrap_content"
        android:layout_gravity="right"
        android:layout_marginEnd="16dp"
        android:layout_marginBottom="16dp"
        android:text="@string/addweedingdress"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText5" />

</androidx.constraintlayout.widget.ConstraintLayout>
```


## 四、实验结果及截图

![实验六图片](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/6.png)

## 五、实验心得
本次实验内容主要是在前面做好的APP基础上去增加一个页面，使得自己的APP更加的完善和人性化，实验内容不多，在原来的基础上去再写一个页面就搞定了。
