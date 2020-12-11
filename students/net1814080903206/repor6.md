# 实验六

## 一、实验目标

1. 解决实验五留下的闪退问题
2. 解决商品展示有限的问题

## 二、实验内容

1. 对代码进行修改，按钮增加判断条件来解决闪退
2. 使用ScrollView来解决商品显示数量有限的问题

## 三、实验步骤
1. 增加判断条件解决存入数据库没有输入id会闪退的问题，并弹出提示
```
 todatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==todatabase) {

                    String id=Showtest.getText().toString();
                    if(id!=null)
                    thisactivity.save_message(id);
                    else
                        Toast.makeText(getBaseContext(), "用户信息为空! \n" , Toast.LENGTH_LONG).show();
                }
            }
        });
 ```
2. 对选择的商品进行判断，判断是否为空，解决之前留下清除商品之后再查询会闪退的问题
```
check_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==check_now)
                {
                    Goods goods=new Goods();
                    Bitmap[] a=goods.show_goods();
                    String[] showprice=goods.show_price();
                    String[] goodname=goods.Goods_name();
                    if(a!=null){
                    goods1.setImageBitmap(a[0]);
                    goods2.setImageBitmap(a[1]);
                    goods3.setImageBitmap(a[2]);
                    goods4.setImageBitmap(a[3]);
                    goods5.setImageBitmap(a[4]);
                    price1.setText(showprice[0]);
                    price2.setText(showprice[1]);
                    price3.setText(showprice[2]);
                    price4.setText(showprice[3]);
                    price5.setText(showprice[4]);
                    goods_name1.setText(goodname[0]);
                        goods_name2.setText(goodname[1]);
                        goods_name3.setText(goodname[2]);
                        goods_name4.setText(goodname[3]);
                        goods_name5.setText(goodname[4]);
                        Toast.makeText(getBaseContext(), "finish! \n" , Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "undo! \n" , Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
```
3. 使用Scrollview和LinearLayout的嵌套使用，解决商品显示数量有限的问题，优化了商品展示样式。
```
<ScrollView
        android:layout_width="250dp"
        android:layout_height="564dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.072"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.125"
        tools:ignore="MissingConstraints">

        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <ImageView
                android:id="@+id/goods1"
                android:layout_width="250dp"
                android:layout_height="220dp" />
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="50dp"
                >
                <TextView
                    android:id="@+id/price1"
                    android:gravity="center"
                    android:layout_width="100dp"
                    android:layout_height="50dp" />

                <CheckBox
                    android:id="@+id/checkbox1"
                    android:layout_width="100dp"
                    android:layout_height="50dp" />

            </LinearLayout>
            <TextView
                android:id="@+id/goods_name1"
                android:layout_width="match_parent"
                android:layout_height="50dp"/>
```
 ## 四、实验结果
 [第六次实验图片1](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/tesephoto/t61.jpg)  
[第六次实验图片2](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/testimage/t62.jpg)  

## 五、心得体会
  这次的实验本来的内容是网络，但是我这个不需要用到相应的功能，并且之前留下的闪退错误比较多，这次实验就用来解决之前闪退的问题。之前还有个最大的遗憾是界面会限制商品展示的数量，
一开始是在网上找到的是用Scrollview嵌套其他的布局，发现会显示混乱，于是用了最基础的linearlayout。
