
   ## 一、实验目标

   1. 理解Android相机、蓝牙、传感器等设备编程方法。
   2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

   ## 二、实验内容

   1. 拍照显示、录视频。
   2. 编程实现设备使用。

   ## 三、实验步骤

   1. 在AndroidManifest.xml添加以下代码，申请调用Android相机的使用权限
   ```java
   <uses-feature android:name="android.hardware.camera" android:required="true" />
   ```
   
   2. 在PhotoActivity.java中编写takePhoto()函数，实现请求拍照
   ```java
   private void takePhoto() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
   ```
   3. 定义一个按钮button绑定activity_main.xml中的按钮photo，创建按钮button的点击事件，调用takePhoto()函数
   ```java
   Button button=findViewById(R.id.photo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePhoto();
            }
        });
   ```

   ## 四、实验结果

   ![lab7](https://github.com/wuuuxj/android-labs-2020/tree/master/students/sec1814080911205/lab7.jpg)
   ![lab77](https://github.com/wuuuxj/android-labs-2020/tree/master/students/sec1814080911205/lab77.jpg)
   
   ## 五、心得体会
   通过本次实验，我学会了调用安卓相机的功能
