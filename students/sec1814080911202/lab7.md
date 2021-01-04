# 一、实验目的

1. 理解Android相机、蓝牙、传感器等设备编程方法
2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系

# 二、实验内容

1. 选择一个跟选题相关的设备功能：
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

2. 编程实现设备使用。

# 三、实验步骤

1. 在AndroidManifest.xml中添加：
```xml
    <uses-feature
        android:name="android.hardware.camera"
        android:required="true" />
   	<activity android:name=".PhotoActivity" />
```

2. 新建activity_photo.xml，以下是主要代码:
```xml
    <Button
        android:id="@+id/button_open_camera"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="拍照"/>

```

3. 新建PhotoActivity.java，以下是主要代码：
```java
	private void dispatchTakePictureIntent() {
	        // 调用相机
	        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
	            this.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
	            //this.startActivity(takePictureIntent);
	        }
	    }

    // 获取动作结果的回调方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            // 在Java创建界面控件
            ImageView imageView = new ImageView(this);
            imageView.setImageBitmap(imageBitmap); // NullPointerException

            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
            linearLayout.addView(imageView); // 显示
        }
    }
```


# 四、实验结果

![lab7](https://raw.githubusercontent.com/L1nzSec/android-labs-2020/master/students/sec1814080911202/lab7.png)


# 五、实验心得

本次实验是Android设备编程，选取的是调用相机拍照，由于自己的课程设计没有调用相机的功能，因此只是个demo来实现实验内容。通过本次实验，了解了安卓设备编程，要注意相机编程需要在AndroidManifest.xml给出相应的权限，学会了如何调用相机，并获取缩略图。
