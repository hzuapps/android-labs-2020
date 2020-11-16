# 实验三
## 一、实验目标
1. 了解Android应用中各种资源的概念与使用方法
2. 掌握在Android应用中使用图片等资源的方法。
## 二、实验内容
1. 在界面上显示至少一张图片（按照自己的题目添加）
2. 提交res/drawable及图片使用的代码
3. 将应用运行结果截图
## 三、实验步骤
1. 将要导入的图片放入res资源中的drawable中  
2. 在layout对应的xml文件中使用android:background="@drawable/main"对图片进行导入  
```xml
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
                                                   
    android:background="@drawable/main"
                                                   
    tools:context=".MainActivity">

```
3. 使用 LinearLayouthe和RelativeLayout布局来对按钮进行布局
 <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:paddingLeft="16dp"
        android:paddingRight="16dp"
        >
        <RelativeLayout
            android:layout_width="wrap_content"
            android:layout_height="540dp">

            <Button
                android:id="@+id/button00"
                android:layout_width="94dp"
                android:layout_height="wrap_content"
                android:text="@string/add" />

            <Button
                android:id="@+id/button11"
                android:layout_width="94dp"
                android:layout_height="wrap_content"
                android:layout_toRightOf="@id/button00"
                android:text="@string/update" />

            <Button
                android:id="@+id/button22"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_below="@id/studenttext"
                android:layout_marginTop="4dp"
                android:text="@string/return_home" />

            <Button
                android:id="@+id/button33"
                android:layout_width="94dp"
                android:layout_height="wrap_content"
                android:layout_toRightOf="@id/button11"
                android:text="@string/select" />

            <Button
                android:id="@+id/button44"
                android:layout_width="94dp"
                android:layout_height="wrap_content"
                android:layout_toRightOf="@id/button33"
                android:text="@string/delete" />
        </RelativeLayout>
    </LinearLayout>
## 四、实验结果
![图1实验三运行结果](https://github.com/yichouge/android-labs-2020/blob/master/students/net1814080903333/ExperimentalResult/lab3.png?raw=true)
## 五、实验心得  
本次实验难度一般、按钮布局、给activity加背景图片、遇到的问题是一开始用的是ImageView标签只能显示在文字上面会覆盖文字、用Java语言把图片设为透明还是不行、没想到安卓直接用个 
android:background="@drawable/？"（？为图片的命名）就可以实现将图片显示为背景也就是JavaSwing中的把图片设置为透明
