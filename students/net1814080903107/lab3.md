
# 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

# 二、实验要求
1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

# 三、实验步骤
1. 将图片保存到res/drawable,并用小写英文命名

2. 用ImageView应用图片并填充

   ```xml
   <style name="menuItemLayout">
           <item name="android:layout_width">6dp</item>
           <item name="android:layout_height">match_parent</item>
           <item name="android:layout_weight">1</item>
           <item name="android:scaleType">fitXY</item>
   </style>
   ```

   

# 四、实验结果
![lab3_1](https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/master/students/net1814080903107/screenshots/lab3_1.PNG)

# 五、实验心得
图片使界面不显得生硬，同样的给图片添加点击事件可以在XML添加click，或Activity添加组件监听器。
