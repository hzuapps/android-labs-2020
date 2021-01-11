# 实验七：Android设备编程

## 一、实验目标

1. 理解Android相机、蓝牙、传感器等设备编程方法。
2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容

因为本人的项目不涉及这方面的内容，因此本人实现和完善第三个功能界面“进制转换方法说明”。

## 三、实验步骤

1. 在konwledge.xml中对进行简单的界面设计。

   ```xml
   <LinearLayout
    	……
	<TextView
            ……
        <TextView
            ……
            android:textColor="@color/colorText"//设置文字的颜色。
            android:layout_marginTop="20dp"//设置上边距离。
            android:textSize="25dp" />//字体大小。
        <TextView
            ……
        <TextView
            ……
        <Button
            ……
            android:text="返回"/>
    </LinearLayout>
   ```

2. 对ShiftActivity.java进行设置界面跳转按钮。
   ```java
   Button btnOpen2 = (Button) findViewById(R.id.button3);
   View view2 = findViewById(R.id.button3);
   btnOpen2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(thisActivity, knowledge.class);
            thisActivity.startActivity(intent);
          }
    });
    ```
    
3. 对knowledge.java进行设置界面返回按钮。

   ```java
   Button btnOpen = (Button) findViewById(R.id.button_back1);
   View view = findViewById(R.id.button_back1);
   btnOpen.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(thisActivity, ShiftActivity.class);
            thisActivity.startActivity(intent);
          }
    });
    ```

## 四、运行结果及截图

![实验截图](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab7(1).PNG)

![实验截图](https://github.com/hkx0505/android-labs-2020/blob/master/students/net1814080903129/TP/lab7(2).PNG)

## 五、心得体会

本次实验中，由于我的项目没有用到设备编程，所以本次实验只是对第三个“进制转换方法说明”的功能实现，用到的技术也是基本的页面跳转的界面布局等。