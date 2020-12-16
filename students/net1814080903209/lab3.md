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

2. 在主页面用ImageView应用图片作为背景图片

   ```xml
   <ImageView
        android:id="@+id/img_bc"
        android:layout_width="match_parent"
        android:layout_height="650dp"
        android:layout_centerVertical="true"
        android:adjustViewBounds="true"
        android:src="@drawable/bc" />
   ```

# 四、实验结果
![](https://raw.githubusercontent.com/itgopan/android-labs-2020/master/students/net1814080903209/lab3.png)

# 五、实验心得
为主页添加了背景图片，采用图片获取资源，熟悉了调用资源的方法，逐步对android开发有了更深的了解。
