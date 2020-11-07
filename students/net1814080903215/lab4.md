# 一、实验报告

1. 根据选题要求设计界面布局及控件使用
2. 布局xml及界面控制操作代码提交并截图
3. 将应用运行结果截图

# 二、实验内容

1. 使用一种布局方式设计界面
2. 通过控件ID获取界面对象，执行相关操作
3. 实现界面控件的事件处理
4. 操作之后，切换到第二个界面

# 三、实验步骤

1. 创建`constraintlayout`布局的页面，实现自己的三到四个功能

2. 在每个页面的下方设置三个Button控件作为底部导航栏，可自由调整相对位置

   ```
    <Button
        android:id="@+id/button"
        android:layout_width="126dp"
        android:layout_height="57dp"
        android:background="@android:color/background_light"
        android:text="@string/个人空间"
        android:textColor="@android:color/black"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />

    <Button
        android:id="@+id/button3"
        android:layout_width="127dp"
        android:layout_height="57dp"
        android:background="@android:color/background_light"
        android:text="@string/上传照片"
        android:textColor="@android:color/background_dark"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />

    <Button
        android:id="@+id/button2"
        android:layout_width="126dp"
        android:layout_height="57dp"
        android:background="@android:color/background_light"
        android:text="@string/摄影社区"
        android:textColor="@android:color/black"
        android:textStyle="bold"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="1.0" />
   ```

3. 在画面上添加自己的图片，以及在layout设置面板中更换背景颜色


# 四、实验结果



![实验截图](https://raw.githubusercontent.com/Deng-dong555/android-labs-2020/master/students/net1814080903215/lab4_pic_1.jpg)

![实验截图](https://raw.githubusercontent.com/Deng-dong555/android-labs-2020/master/students/net1814080903215/lab4_pic_2.jpg)

# 五、实验心得

本次实验实现了APP的基本界面的雏形，我为每个界面都设置了模仿于微信下方导航栏的三个按钮，比较粗略的模仿。
选用了相对来说比较自由的constraintlayout的布局，可以自由调整控件的位置。在后续的设计中可能也会使用到其
它的布局。
