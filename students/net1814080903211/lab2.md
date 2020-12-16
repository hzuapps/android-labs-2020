# 实验二：Android组件编程

## 一、实验目标

1. 在Issues中创建自己的选题；
2. 根据自选题目，编写一个或多个Activity（主窗口类带上学号前缀，放到自己的Java包下）；
3. 将标题设置为自己的学号+对应的功能或题目；
4. 根据自己选择的题目实现Activity中导航、调用等功能（选做）。

## 二、实验内容

1. 根据自己的选题功能，创建 2-3 个 Activity（界面可以尝试设计）；
2. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
3. 在 Activity 添加按钮点击事件处理，实现跳转

## 三、实验步骤

1. 创建ProfileActivity.java和activity_main.xml
2. 创建BrowseActivity.java和activity_browse.xml
3. 在Net1814080903211添加两个public方法处理跳转按钮

``` java
 public void jumpToProfile(View v)
 {
     Intent newActivity = new Intent(this, ProfileActivity.class);
     startActivity(newActivity);
 }

 public void jumpToBrowse(View v)
 {
     Intent newActivity = new Intent(this, BrowseActivity.class);
     startActivity(newActivity);
 }
```

4. 在activity_main.xml内添加两个按钮，假设使用ConstraintLayout布局

``` xml
 <Button
     android:id="@+id/toProfileBtn"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:onClick="jumpToProfile"
     android:text="@string/profile_button"
     app:layout_constraintEnd_toEndOf="parent"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="parent" />

 <Button
     android:id="@+id/toBrowseBtn"
     android:layout_width="match_parent"
     android:layout_height="wrap_content"
     android:onClick="jumpToBrowse"
     android:text="@string/browse_button"
     app:layout_constraintEnd_toEndOf="parent"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toBottomOf="@id/toProfileBtn" />
```

## 四、实验结果

![result](https://raw.githubusercontent.com/Xterisk/android-labs-2020/master/students/net1814080903211/lab2.png)

## 五、实验心得

本次实验正式接触了Android里布局和控件的使用，总体还是比较轻松的。
