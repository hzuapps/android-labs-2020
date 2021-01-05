# 一、实验目标

 1. 根据选题要求设计界面布局及控件使用；
 2. 布局xml及界面控制操作代码提交并截图；
 3. 将应用运行结果截图。

 # 二、实验内容

 1. 使用一种布局方式设计界面；
 2. 通过控件ID获取界面对象，执行相关操作：

 ```
// xml
android:id="@+id/aquacardview"
// java
CardView cardView = (CardView)findViewById(R.id.aquacardview);

```

1. 实现界面控件的事件处理;
2. 操作之后，切换到第二个界面。

 # 三、实验步骤

 1. 在net1814080903113photoshow.xml中添加卡片CardView

```xml
    <androidx.cardview.widget.CardView
        android:id="@+id/aquacardview"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:layout_marginStart="9dp"
        android:layout_marginEnd="9dp"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">
        </CardView>
```

2. 在卡片布局内嵌入LinearLayout布局实现列表结构，并在里面加入ImageView和TextView实现布局里的内容

    ```xml
     <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">


            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="100dp">

                <ImageView
                    android:layout_width="150dp"
                    android:layout_height="match_parent"
                    android:layout_margin="5dp"
                    android:contentDescription="@string/app_name"
                    android:scaleType="centerCrop"
                    android:src="@drawable/aqua1" />

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="match_parent"
                    android:orientation="vertical">

                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:padding="5dp"
                        android:text="@string/utawaku"
                        android:textSize="18sp"
                        android:textStyle="bold" />

                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="wrap_content"
                        android:padding="5dp"
                        android:text="@string/yueyaori" />


                </LinearLayout>

            </LinearLayout>
   ```
3. 在Net1814080903113PhotoShowActivity类中加入卡片布局圆角设计和阴影

```java
   CardView cardView = (CardView)findViewById(R.id.aquacardview);

        cardView.setRadius(8);

        cardView.setCardElevation(8);

        cardView.setContentPadding(5,5,5,5);
        
```        
 # 四、实验结果
 ![实现效果](https://github.com/Miraiiiii/android-labs-2020/blob/master/students/net1814080903113/test4.png)
 # 五、实验心得
 这次实验用了陌生的CardView卡片布局，在一开始碰到由于版本问题产生的依赖库问题，需要把库切换到AndroidX库中，困惑了很久。后来是关于卡片布局的列表设计，查询了很多资料都不清楚怎么制作这个效果，后来发现在卡片布局里面嵌入LinearLayout布局能解决这个问题，但是又产生了无法自动刷新的问题，这个尚未解决。
