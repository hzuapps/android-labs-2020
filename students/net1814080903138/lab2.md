# 实验二 
  ## 一、实验目标 
  1. 根据自己的选题，创建2-3个Activity 
  2. 实现Activity间的跳转 
  
   ## 二、实验内容 
  1. 根据功能创建相应的Activity； 
  2. 编写Activity对应的布局文件； 
  3. 在 Activity 上添加按钮、链接或导航栏，实现各个 Activity 的跳转。
  
   ## 三、实验步骤 
  1. 创建 Net1814080903138Activity、Add1814080903138Activity(添加界面)、Check1814080903138Activity(检查界面)；
  2. 配置AndroidManifest.xml；
  3. 在相应的界面中创建 Button 组件;
  ```java
  Button button1 = (Button)findViewById(R.id.button_add);
  Button button2 = (Button)findViewById(R.id.button_check);
  ```
  ```xml
       <Button
            android:id="@+id/button_add"
            android:layout_width="96dp"
            android:layout_height="wrap_content"
            android:layout_below="@id/homework_name"
            android:layout_alignParentRight="true"
            android:text="@string/b_add" />
        <Button
            android:id="@+id/button_check"
            android:layout_width="96dp"
            android:layout_height="wrap_content"
            android:layout_below="@id/homework_name"
            android:layout_toLeftOf="@id/button_add"
            android:text="@string/b_check" />
  ```
  4. 为 Button 添加点击事件处理，实现跳转；
  ```java
   Button button1 = (Button)findViewById(R.id.button_add);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, add1814080903138Activity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button button2 = (Button)findViewById(R.id.button_check);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, check1814080903138Activity.class);
                thisActivity.startActivity(intent);
            }
        });
   ```     
  
   ## 四、实验结果 
  ![lab2](https://github.com/linjhong/android-labs-2020/blob/master/students/net1814080903138/lab2.png) 
  
   ## 五、实验心得 
  在本次实验中，根据自己的选题功能创建了Activity，学习到了activity以及AndroidMainfest的配置。在Activity中添加相应的按钮实现不同界面之间的跳转。完成得相对顺利。
