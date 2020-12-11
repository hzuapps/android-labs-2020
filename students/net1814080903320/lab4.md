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
1. 主界面采用LinearLayout布局，主要设置了三个按钮；
2. 按钮添加事件监听器实现界面跳转；
3. 在约跑功能界面同样使用LinearLayout布局，方便各组件位置调试；
4. 在约跑界面的XML文件中添加约跑信息填写栏并添加发布按钮。

```xml
<ImageView
        android:layout_width="wrap_content"
        android:layout_height="229dp"
        android:src="@drawable/run" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="25dp"
        android:text="请填写约跑时间、地点、联系方式并发布："
        android:textSize="20sp"/>

    <EditText
        android:layout_marginTop="20dp"
        android:id="@+id/editText2"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:ems="200"
        android:inputType="textPersonName" />

    <Button
        android:layout_marginTop="20dp"
        android:layout_width="100dp"
        android:layout_height="60dp"
        android:textSize="25dp"
        android:text="发布"/>
```

## 四、实验结果
![ListView](https://github.com/taoge183/android-labs-2020/blob/master/students/net1814080903320/实验4截图.jpg)

## 五、实验心得
此次实验主要学习了界面的设计，这里用了LinearLayout布局，各组件的位置都可以用像素自行调试，比较方便。
