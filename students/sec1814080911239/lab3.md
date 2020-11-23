# 实验三

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

1. 在界面上显示至少一张图片；
2. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤

1. 将图片放到res下的drawable文件夹

2. 在activity_main.xml插入背景图片

   ```java
   android:background="@drawable/main_background"
   ```

3. 添加三个按钮，分别对应三个功能，给按钮设置一些属性，使其更美观（代码以一个按钮为例）

   ```java
   <Button
       android:id="@+id/button1"
       android:layout_width="300dp"
       android:layout_height="50dp"
       android:layout_gravity="center_vertical"
       android:layout_marginStart="60dp"
       android:layout_marginLeft="60dp"
       android:layout_marginTop="250dp"
       android:background="@color/colorbackground"
       android:text="交流分享社区"
       android:textColor="@color/colortext"
       android:textStyle="bold"
       android:visibility="visible" />
   ```

4. 在activity_splash.xml插入图片当做启动界面

   ```java
   android:background="@drawable/splash_background"
   ```

5. 在Sec1814080911239MainActivity.java设置点击按钮实现页面跳转（代码以一个按钮为例）

   ```java
   findViewById(R.id.button1).setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View view) {
                   switch (view.getId()) {
                       case R.id.button1:
                           Intent intent = new Intent(SolveActivity.this, SolveActivity.class);
                           startActivity(intent);
                           break;
                   }
               }
           });
   ```

6. 在跳转页面使用RelativeLayout布局，添加按钮，并为按钮插入图片，使其更美观（代码以一个界面为例）

   ```java
   <RelativeLayout
           android:layout_width="match_parent"
           android:layout_height="wrap_content">
               ...
   <Button
           android:id="@+id/solve"
           android:layout_width="100dp"
           android:layout_height="110dp"
           android:layout_alignParentRight="true"
           android:layout_alignParentBottom="true"
           android:background="@drawable/solve" />
   ```

   

## 四、实验结果

![启动页面](E:\Users\10489\Desktop\study\安卓开发\图\图\background.png)

图1. 启动页面

![首页](E:\Users\10489\Desktop\study\安卓开发\图\图\MainActivity.png)

图2. 首页

![交流分享社区](E:\Users\10489\Desktop\study\安卓开发\图\图\ShareActivity2.png)

图3. 交流分享社区

![知识库](E:\Users\10489\Desktop\study\安卓开发\图\图\KnowledgeActivity2.png)

图4. 知识库

![疑难解答](E:\Users\10489\Desktop\study\安卓开发\图\图\SolveActivity2.png)

图5.疑难解答

## 五、实验心得体会

​	本次实验主要是运用图片让页面更美观，可以在.xml文件设置布局的时候插入图片作为整个页面的背景，也可以在按钮中插入图片，作为按钮。

​	Linearlayout（线性布局）和RelativeLayout（相对布局）的属性是不同的，线性布局可以设置水平布局和垂直布局，而相对布局则可以通过指定控件在某个控件的方位来进行布局，比如设置两个控件左边对齐、控件1在控件2的右边等。线性布局可以通过设置控件的权重属性来控制各个控件在布局中的占比，如果有4个控件，每个控件权重大小都为1，则每个控件占总布局宽度大小的四分之一。

​	
