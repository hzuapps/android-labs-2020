# 一、实验目标 #

1. 创建2-3个与自己选题有关的Activity
2. 利用Intent实现Activity间的跳转

# 二、实验内容 #

1. 根据功能创建相应的Activity
2. 编写AndroidManifest.xml
3. 编写Activity对应的布局文件
4. 编写Activity的Java代码
5. 使用Intent实现跳转

# 三、实验步骤 #

1. 将创建的Activity注册到AndroidManifest.xml
2. 在布局文件中创建Button并赋予ID
```
// activity_main.XML
<Button
        android:id="@+id/release"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="发布闲置"
        tools:layout_editor_absoluteX="46dp"
        tools:layout_editor_absoluteY="631dp"
        android:layout_marginTop="300dp"
        android:layout_marginLeft="50dp"/>

    <Button
        android:id="@+id/personal"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="个人中心"
        tools:layout_editor_absoluteX="262dp"
        tools:layout_editor_absoluteY="631dp"
        android:layout_marginLeft="100dp"
        android:layout_marginTop="300dp"/>
        
// activity_personal_center.XML
 <Button
        android:id="@+id/main"
        android:layout_width="71dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="0dp"
        android:layout_marginLeft="0dp"
        android:layout_marginTop="10dp"
        android:text="主页" />
        
 // activity_release_idle.XML
 <Button
        android:id="@+id/done"
        android:layout_width="96dp"
        android:layout_height="wrap_content"
        android:layout_below="@id/times"
        android:layout_alignParentRight="true"
        android:text="@string/done" />

    <Button
        android:id="@+id/main"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@id/done"
        android:text="主页" />
```
3. 通过ID获取Button
```
//Net1814080903134Activity.java
Button btnPer = findViewById(R.id.personal);

//PerrsonalCenterActivity.java
Button btnMain = findViewById(R.id.main);

//ReleaseIdleActivity.java
Button btnMain = findViewById(R.id.main);
```
4. 为Button增加点击事件处理
5. 利用Intent绑定跳转类
6. 利用startActivity(intent)实现跳转
```
//Net1814080903134Activity.java
btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, PersonalCenterActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent,  2016);
            }
        });

//PerrsonalCenterActivity.java
 btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903134Activity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
//ReleaseIdleActivity.java
 btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Net1814080903134Activity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult(intent, 2016);
            }
        });
```


# 四、实验结果 #

![主页面](https://github.com/yyih/android-labs-2020/blob/master/students/net1814080903134/photos/1-%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.PNG)

![个人中心页面](https://github.com/yyih/android-labs-2020/blob/master/students/net1814080903134/photos/personal.PNG)

![发布闲置页面](https://github.com/yyih/android-labs-2020/blob/master/students/net1814080903134/photos/release.PNG)

# 五、实验心得 #
本次实验要求添加按钮并实现页面的跳转，主要需要学习Button、setOnClickListener函数、Intent、findViewById的应用。实验过程中会遇到不能跳转的问题，导致的原因基本都是函数的错误使用。
