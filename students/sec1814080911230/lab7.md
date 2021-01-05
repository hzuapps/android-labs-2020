# 实验七 Android设备编程

## 一、实验要求

1、理解Android相机、蓝牙、传感器等设备编程方法

2、理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系

## 二、实验内容

1、选择一个跟选题相关的设备功能：

（1）拍照显示、录视频；

（2）控制和检测网络；

（3）获取用户位置信息；

（4）判断屏幕方向并提示用户旋转手机（小游戏）；

（5）摇一摇手机。

2、编程实现设备使用。

## 三、实验步骤

1、在PhotoActivity写处理点击按钮

```java

   ((Button) findViewById(R.id.button_take_photo)).setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) { // 请求拍照
                  dispatchTakePictureIntent();
              }
          });
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
```

2、在对应的xml文件中写入拍照按钮

```java

    <Button
        android:id="@+id/button_take_photo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="150dp"
        android:layout_marginTop="300dp"
        android:text="拍照"
        />
```

3、在PhotoActivity中写获取缩略图

```java

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = new ImageView(this);
            // TODO: 如何设置图片的大小？
            imageView.setImageBitmap(imageBitmap);
            linearLayout.addView(imageView);
        }
    }
```

## 四、实验结果

![lab7(1)](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab7(1).png)
![lab7(2)](https://raw.githubusercontent.com/wukai230/android-labs-2020/master/students/sec1814080911230/lab7(2).png)

## 五、实验心得

  这次实验是实现拍照功能，在我本来的app中也没有用到相关功能，所以是在我主页中新添加了一个按钮跳转到PhotoActivity专门来实现拍照功能，因为手机是有带拍照功能的，所以只需要调用使用相机的函数可以拥有拍照功能了。
  
