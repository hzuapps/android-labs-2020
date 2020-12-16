# 一、实验目的

1.创建2-3个与自己选题有关的Activity  
2.利用Intent实现Activity间的跳转

# 二、实验内容

1.根据功能创建相应的Activity  
2.编写Activity对应的布局文件  
3.实现各个Activity之间的跳转

# 三、实验步骤

1.创建与功能有关的Net1814080903330.java、SearchActivity.java、CollectionActivity.java文件
2.在activity_net1814080903330的layout视图中添加Button按钮用于跳转页面 
```
 <Button
        android:id="@+id/button1"
        android:layout_width="0dip"
        android:layout_weight="1"
        android:layout_height="match_parent"
        android:text="主页"
        android:textSize="30dp"
        />

    <Button
        android:id="@+id/button2"
        android:layout_width="0dip"
        android:layout_weight="1"
        android:layout_height="match_parent"
        android:text="收索"
        android:textSize="30dp"/>

    <Button
        android:id="@+id/button3"
        android:layout_width="0dip"
        android:layout_weight="1"
        android:layout_height="match_parent"
        android:text="收藏"
        android:textSize="30dp" />            
```


3.为Button按扭添加Click点击事件实现跳转（主页转跳播放音乐）
```
 Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903330Activity.this , Net1814080903330Activity.class);
                startActivity(intent);
            }
        });
```
4.调试是否能完成页面之间的跳转

# 四、实验结果


# 五、实验心得
本次实验一共填写了2个功能，主界面Net1814080903330.java、功能分别为CollectionActivity.java、SearchActivity.java，功能实现跳转做起来也挺简单的。
