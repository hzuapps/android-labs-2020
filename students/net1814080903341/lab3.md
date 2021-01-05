# 实验三
## 一、实验目标 #

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容 #

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤 #

1. 在界面显示图片及按钮
```xml
  <Button
        android:id="@+id/button"
        android:layout_width="88dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="104dp"
        android:layout_marginLeft="104dp"
        android:layout_marginTop="125dp"
        android:layout_marginEnd="219dp"
        android:layout_marginRight="219dp"
        android:layout_marginBottom="558dp"
        android:onClick="onClickUpload"
        android:text="上传"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.194"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0" />

    <Button
        android:id="@+id/button2"
        android:layout_width="88dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="104dp"
        android:layout_marginLeft="104dp"
        android:layout_marginTop="29dp"
        android:layout_marginEnd="219dp"
        android:layout_marginRight="219dp"
        android:layout_marginBottom="481dp"
        android:onClick="onClickSearch"
        android:text="搜索"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.194"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button"
        app:layout_constraintVertical_bias="0.0" />

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="46dp"
        android:layout_marginBottom="8dp"
        android:src="@drawable/food"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/button2" />
```
2. 点击按钮进行跳转
```java
  public void onClickUpload(View view) {
        Intent intent=new Intent(this, UploadActivity.class);
        startActivity(intent);
    }
    public void onClickSearch(View view) {
        Intent intent=new Intent(this, SearchActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903341);
    }
```

## 四、实验结果 #

![logo](https://github.com/ting-man/android-labs-2020/blob/master/students/net1814080903341/food.jpg)
![图片效果](https://github.com/ting-man/android-labs-2020/blob/master/students/net1814080903341/3.jpg)
## 五、实验心得 #
通过本次实验，了解了Android应用中各种资源的概念与使用，掌握了在Android应用中使用图片等资源的方法。
