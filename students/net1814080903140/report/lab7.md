#实验七 Android设备编程

##  一、实验目标

1.	理解Android相机、蓝牙、传感器等设备编程方法；
2.	理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。


## 二、实验内容

1.	根据自己的选题选择相应的设备编程；
2.	为安卓项目添加拍照功能；
3.	编写实现拍照功能的代码。


## 三、实验步骤

1. 首先，要在自己项目下的AndroidManifest.xml文件中添加如下代码片；
```
<uses-feature android:name="android.hardware.camera" android:required="true" />
```
 
2. 创建实现拍照功能的类文件，写入实现拍照编程的方法，并添加对应的按钮事件；
```
public class PhotoActivity extends AppCompatActivity {

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        // 准备界面
        linearLayout = findViewById(R.id.linear_layout);

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
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ImageView imageView = new ImageView(this);
            // TODO: 如何设置图片的大小？
            imageView.setImageBitmap(imageBitmap);
            linearLayout.addView(imageView);
        }
    }
}
```

3. 结合前面所学的知识对PhotoActivity.java文件对应的xml文件进行布局的绘制；

## 四、实验结果

![image](https://github.com/bowwran/android-labs-2020/blob/master/students/net1814080903140/reportphoto/7/result.png)

## 五、实验心得体会

   通过本次实验我掌握了Android设计开发中实现拍照这样一种设备的编程和实现方法，也认识到Android开发设备编程能够实现很多的功能，除了拍照，还有诸如蓝牙、传感器等设备编程，在以后的开发中若要用到可以进一步深入学习。