# 实验二

## 一、实验目标

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

## 二、实验内容

1. 根据功能创建相应的Activity；
2. 编写Activity对应的布局文件；
3. 实现各个Activity之间的跳转;

## 三、实验步骤

1.将创建的Activity注册到AndroidManifest.xml
```xml
<activity android:name=".search" />
<activity android:name=".online_store">
```
2.在布局文件中创建Button
```xml
 <Button
        android:id="@+id/Adidas"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="search"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.086"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.922" />


```
3.给button添加监视器实现页面跳转
```button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(online_store.this, search.class);
                online_store.this.startActivity(intent);
            }
        });
     
```
## 四、实验结果
![实验2结果](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/testimage/t2.jpg)

## 五、心得体会
这次的实验内容是添加按钮然后实现页面的跳转，总体来说难度不大。
