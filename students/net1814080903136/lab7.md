# 实验七
## 一、实验目标
1. 理解Android相机、蓝牙、传感器等设备编程方法。
2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 二、实验内容
1. 选择一个跟选题相关的设备功能；
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

2. 编程实现设备使用。

## 三、实验步骤
1. 创建PhotoActivity.java和activity_photo.xml文件，xml文件创建界面和按钮
2. 编写请求拍照，点击拍照获取图片
```java
     // 处理点击按钮
        ((Button) findViewById(R.id.button_take_photo)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // 请求拍照
                dispatchTakePictureIntent();
            }
        });
    }
    static final int REQUEST_IMAGE_CAPTURE = 1;
    // 请求拍照
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    // 获取缩略图
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
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
![lab6](https://github.com/yesijie0216/android-labs-2020/blob/master/students/net1814080903136/shiyan7.jpg)
## 五、实验心得
实验7项目也没有用到，但是还是学习了，运行了老师所给示例，学到了如何调用拍照设备，将获取的图片变为略缩图。
