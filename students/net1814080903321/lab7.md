# 实验七 Android设备编程

## 一、实验目标

- 理解Android相机、蓝牙、传感器等设备编程方法；
- 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容

- 根据自己的选题选择相应的设备编程；
- 为安卓项目添加拍照功能；
- 编写实现拍照功能的代码。

## 三、实验步骤

- 分别在activity_store.xml、activity_show.xml中使用 CardView 创建卡片式布局

```xml
    <androidx.cardview.widget.CardView
                android:id="@+id/cardView1"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="20dp"
                app:cardCornerRadius="10dp"
                app:cardElevation="10dp"
                android:layout_marginTop="200dp"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                tools:ignore="MissingConstraints">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="150dp">

                    <ImageButton
                        android:id="@+id/kaonai"
                        android:layout_width="150dp"
                        android:layout_height="150dp"
                        android:scaleType="centerCrop"
                        app:layout_constraintStart_toStartOf="parent"
                        app:layout_constraintTop_toBottomOf="@+id/textView3"
                        app:srcCompat="@drawable/kaonai"
                        android:onClick="myclick"/>

                    <LinearLayout
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:orientation="vertical">

                        <TextView
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:padding="5dp"
                            android:text="益禾烤奶"
                            android:textSize="24sp"
                            android:textStyle="bold" />

                        <TextView
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:padding="5dp"
                            android:text="月售200份"
                            android:textSize="18sp"/>

                        <TextView
                            android:layout_width="match_parent"
                            android:layout_height="wrap_content"
                            android:padding="5dp"
                            android:text="￥8"
                            android:textColor="#DA1010"
                            android:textSize="24sp"/>

                    </LinearLayout>
                </LinearLayout>
            </androidx.cardview.widget.CardView>
```

- 分别在activity_store.xml、activity_show.xml中实现滚动条，滚动可以浏览到超出屏幕的部分

```xml
    <ScrollView
        android:id="@+id/scrollView2"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content">

        <LinearLayout
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <androidx.cardview.widget.CardView
                ...
            </androidx.cardview.widget.CardView>
        </LinearLayout>
    </ScrollView>
```

- 在ShowActivity.java设置 ImageButton 组件的myclick( )点击事件，并通过showSingleDialog()方法实现选择规格再跳转到个人信息填写界面

```java
    public void myclick(View v){
        switch (v.getId ()){
            case R.id.kaonai:
                showSingleDialog1();
                break;
            case R.id.fan:
                showSingleDialog2();
                break;
            case R.id.hanbao:
                showSingleDialog3();
                break;
            case R.id.roujuan:
                showSingleDialog4();
                break;
        }
    }

    int ide = 0;  //全局变量
    private void showSingleDialog1() {
        final String[] guige = {"无糖","半塘" ,"全糖"};
        final AlertDialog.Builder dialog = new AlertDialog.Builder (this)
                .setTitle ("请选择规格:")
                .setSingleChoiceItems (guige, 0, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ide = which;
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (ShowActivity.this,"你选择了："+guige[ide],Toast.LENGTH_LONG).show ();
                        Intent i = new Intent(ShowActivity.this, PersonalDetailsActivity.class);
                        startActivity(i);
                    }
                });

        dialog.show ();
    }
```

## 四、实验结果

![7_1](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/7_1.jpg)  
Store界面运行截图

![7_2](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/7_2.jpg)  
Show界面运行截图

![7_3](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/7_3.jpg)  
选择规格截图

![7_4](https://github.com/Classic-Z/android-labs-2020/blob/master/students/net1814080903321/7_4.jpg)  
选择规格后跳转个人信息填写界面截图

## 五、实验心得
    本次实验学习设备编程，不过没有做设备编程，而是优化了易速达APP的界面设计。Store和Show界面都通过卡片形式展示内容，在Show点击图片会弹出单选窗口选择规格，点击确定会在屏幕下方显示所选规格并跳转到个人信息填写界面。
