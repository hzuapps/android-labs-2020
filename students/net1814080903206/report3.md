# 实验三

## 一、实验目标

1. 了解Android应用中各种资源的概念与使用方法；
2. 掌握在Android应用中使用图片等资源的方法。

## 二、实验内容

1. 在界面上显示至少一张图片（按照自己的题目添加）；
2. 提交res/drawable及图片使用的代码；
3. 提交res/values, res/layout等其他代码；
4. 将应用运行结果截图，放到实验报告中；
5. 点击图片（或按钮）时，打开另一个Activity。

## 三、实验步骤
1.在xml文件中设置Imageview，Textview和button 
```
<ImageView
        android:id="@+id/photo1"
        android:layout_width="120dp"
        android:layout_height="198dp"
        android:scaleType="fitXY"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.099"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.076"
        />
<TextView
        android:id="@+id/money1"
        android:layout_width="120dp"
        android:layout_height="30dp"
        android:gravity="center"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.099"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.355" />
 <Button
        android:id="@+id/add_goods1"
        android:layout_width="120dp"
        android:layout_height="50dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.099"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.43" />
```
2.在Activity中对按钮和图片框以及文字框添加相应的事件
```
 shoes.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                if(v==shoes)
                {
                     iconname=context.getResources().getStringArray(R.array.shoes);
                    final int[] b=new int[iconname.length];
                    for(int i=0;i<4;i++)
                        b[i]=context.getResources().getIdentifier(iconname[i],"drawable",getPackageName());
                    imageView1.setImageResource(b[0]);
                    imageView2.setImageResource(b[1]);
                    imageView3.setImageResource(b[2]);
                    imageView4.setImageResource(b[3]);
                    textView1.setText("1299");
                    textView2.setText("1099");
                    textView3.setText("899");
                    textView4.setText("699");
                }
           }
       });
 ```
## 四、实验结果
![实验3结果](https://github.com/wjm20000603/android-labs-2020/tree/master/students/net1814080903206/testimage/t3.jpg)

## 五、心得体会
这次的实验内容是添加图片，难度不是很大，在上课的时候就已经掌握了相应的步骤，下课后根据自己软件的功能来相应的添加图片。
