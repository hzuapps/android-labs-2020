# 一、实验目标

1. 理解Android相机、蓝牙、传感器等设备编程方法。
2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

# 二、实验内容

- 选择一个跟选题相关的设备功能；

（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

1. 编程实现设备使用。

# 三、实验步骤

1. 在AndroidManifest.xml添加相加等相关访问权限。

   ```xml
   <uses-permission android:name="android.permission.CAMERA" />
   ```

2. 编写xml布局，通过点击图标，然后跳到相机拍照页面。

   ```xml
   <RelativeLayout
       android:layout_width="match_parent"
       android:layout_height="60dp"
       android:layout_marginLeft="12dp"
       android:layout_marginRight="12dp"
       android:layout_marginTop="5dp">
       <TextView
           android:id="@+id/foundit_add_title_tv"
           android:layout_width="60dp"
           android:layout_height="wrap_content"
           android:layout_alignParentLeft="true"
           android:text="标题:"
           android:textColor="@android:color/darker_gray"
           android:textSize="16sp"
           android:layout_centerVertical="true"
           android:gravity="center"/>
       <EditText
           android:id="@+id/foundit_add_title_et"
           android:layout_width="match_parent"
           android:layout_height="50dp"
           android:layout_toRightOf="@id/foundit_add_title_tv"
           android:ellipsize="end"
           android:background="@drawable/shape_foundit_public"
           android:layout_centerVertical="true"/>
   </RelativeLayout>
   ```

   省略下面部分。最终效果：

   ![布局效果]()

3. 进入拍照页面，根据其相机对应的Intent中的action进行设置就好。

   定义final常量，然后进入拍照页面。

   ```java
   private static final int PHOTO_PICKED_WITH_DATA = 3021;
   private static final int CAMERA_WITH_DATA = 3023;
   ```

   ```java
   /**
    * 拍照
    */
   private void takePhoto() {
       //直接询问
   
       ActivityCompat.requestPermissions(Net1814080903317FoundItAddActivity.this, new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
   
       Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);//调用系统相机
       startActivityForResult(intent,CAMERA_WITH_DATA);
   
   }
   ```

4. 然后再将相机拍照后的结果返回到add页面，重写onActivityResult方法。

   ```java
   @Override
   protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // TODO Auto-generated method stub
       if(resultCode!=RESULT_OK)
           return;
       switch(requestCode){
           case CAMERA_WITH_DATA:
               final Bitmap photo = data.getParcelableExtra("data");
               if(photo!=null){
                   doCropPhoto(photo);
               }
           case PHOTO_PICKED_WITH_DATA:
               Bitmap photo1 = data.getParcelableExtra("data");
               if(photo1!=null){
                   showPicIv.setVisibility(View.VISIBLE);
                   showPicIv.setImageBitmap(photo1);
               }
   
       }
   }
   ```

   ```java
   protected void doCropPhoto(Bitmap data){
       Intent intent = getCropImageIntent(data);
       startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
   }
   public static Intent getCropImageIntent(Bitmap data) {
       Intent intent = new Intent("com.android.camera.action.CROP");
       intent.setType("image/*");
       intent.putExtra("data", data);
       intent.putExtra("crop", "true");
       intent.putExtra("aspectX", 1);
       intent.putExtra("aspectY", 1);
       intent.putExtra("outputX", 128);
       intent.putExtra("outputY", 128);
       intent.putExtra("return-data", true);
       return intent;
   }
   ```

# 四、实验结果

   最终的运行结果展示：

![运行结果截图](https://github.com/jaydjxing/android-labs-2020/blob/master/students/net1814080903317/%E5%AE%9E%E9%AA%8C%E4%B8%83%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.jpg?raw=true)

# 五、实验心得体会

这次实验，调用摄像头，然后把图片显示回来，这也只是简单的实现了一下，在实际的开发中，还需要进行把数据保存数据库，然后再在个人页面中将数据进行显示，这部分其实和实验六存储编程部分逻辑基本一样。继续努力。