# 实验七：Android设备编程

## 一、实验目标

1.理解Android相机、蓝牙、传感器等设备编程方法。
2.理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容
1.选择一个跟选题相关的设备功能；
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

2.编程实现设备使用。

## 三、实验步骤
由于所作APP未使用到设备编程，在原来的APP代码上修改增添

1. 进入界面activity_final__order.xml；
2. 结合之前做好的页面建立各个文本框并赋值好属性；
3. 在string内写好各个id对于的字符；
4. 建立最终提交订单按钮。

activity_final__order.xml如下：

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="edu.hzuapps.net1814080903301.Final_Order">

    <EditText
        android:id="@+id/editText"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="47dp"
        android:layout_marginBottom="41dp"
        android:hint="@string/howtodo"
        app:layout_constraintBottom_toTopOf="@+id/editText2"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editText1"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText1"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="30dp"
        android:layout_marginTop="20dp"
        android:layout_marginEnd="35dp"
        android:layout_marginBottom="20dp"
        android:hint="@string/price"
        app:layout_constraintBottom_toTopOf="@+id/editText5"
        app:layout_constraintEnd_toStartOf="@+id/editText"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText2"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginEnd="52dp"
        android:layout_marginBottom="33dp"
        android:hint="@string/message1"
        app:layout_constraintBottom_toTopOf="@+id/editText3"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editText5"
        app:layout_constraintTop_toBottomOf="@+id/editText" />

    <EditText
        android:id="@+id/editText3"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginEnd="32dp"
        android:layout_marginBottom="25dp"
        android:hint="@string/weedingname"
        app:layout_constraintBottom_toTopOf="@+id/editText7"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editText8"
        app:layout_constraintTop_toBottomOf="@+id/editText2" />

    <EditText
        android:id="@+id/editText4"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginEnd="37dp"
        android:layout_marginBottom="225dp"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="@string/message"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editText11"
        app:layout_constraintTop_toBottomOf="@+id/editText7" />

    <EditText
        android:id="@+id/editText5"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="30dp"
        android:layout_marginEnd="30dp"
        android:layout_marginBottom="37dp"
        android:hint="@string/where"
        app:layout_constraintBottom_toTopOf="@+id/editText6"
        app:layout_constraintEnd_toStartOf="@+id/editText2"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText1" />

    <EditText
        android:id="@+id/editText6"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="30dp"
        android:layout_marginEnd="52dp"
        android:layout_marginBottom="14dp"
        android:hint="@string/boyphone"
        app:layout_constraintBottom_toTopOf="@+id/editText8"
        app:layout_constraintEnd_toStartOf="@+id/editText3"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText5" />

    <EditText
        android:id="@+id/editText7"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginEnd="42dp"
        android:layout_marginBottom="13dp"
        android:hint="@string/girlphone"
        app:layout_constraintBottom_toTopOf="@+id/editText4"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toEndOf="@+id/editText9"
        app:layout_constraintTop_toBottomOf="@+id/editText3" />

    <EditText
        android:id="@+id/editText8"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="30dp"
        android:layout_marginEnd="42dp"
        android:layout_marginBottom="27dp"
        android:hint="@string/boyname"
        app:layout_constraintBottom_toTopOf="@+id/editText9"
        app:layout_constraintEnd_toStartOf="@+id/editText3"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText6" />

    <EditText
        android:id="@+id/editText9"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="30dp"
        android:layout_marginEnd="42dp"
        android:layout_marginBottom="23dp"
        android:hint="@string/weedingday"
        app:layout_constraintBottom_toTopOf="@+id/editText11"
        app:layout_constraintEnd_toStartOf="@+id/editText7"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText8" />

    <EditText
        android:id="@+id/editText10"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:gravity="top"
        android:hint="@string/message"

        app:layout_constraintBottom_toTopOf="parent"
        app:layout_constraintEnd_toStartOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editText11"
        android:layout_width="0dp"
        android:layout_height="0dp"
        android:layout_marginStart="30dp"
        android:layout_marginEnd="28dp"
        android:layout_marginBottom="3dp"
        android:hint="@string/girlname"
        app:layout_constraintBottom_toTopOf="@+id/button"
        app:layout_constraintEnd_toStartOf="@+id/editText4"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText9" />

    <Button
        android:id="@+id/button"
        android:layout_width="542dp"
        android:layout_height="0dp"
        android:layout_gravity="right"
        android:layout_marginBottom="41dp"
        android:text="@string/sumbitThisOrder"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText11" />


</androidx.constraintlayout.widget.ConstraintLayout>
```


## 四、实验结果及截图

![实验七图片](https://github.com/hzuapps/android-labs-2020/blob/master/students/net1814080903301/7.png)

## 五、实验心得
由于自己并不需要用到设备编程，所以本次实验内容主要是去结合前面的页面去写一个最终订单提交页面，使得自己的APP更加的完善和人性化，实验内容不多，在原来的基础上去再写一个页面就搞定了。
