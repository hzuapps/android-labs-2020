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
    private static int REQ_1 = 1;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);
        mImageView=findViewById(R.id.iv);
    }

    public void startCamera1(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQ_1);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == REQ_1){
                Bundle bundle = data.getExtras();
                Bitmap bitmap = (Bitmap) bundle.get("data");
                mImageView.setImageBitmap(bitmap);
            }
        }

    }}
```

3. 结合前面所学的知识对PhotoActivity.java文件对应的xml文件进行布局的绘制；

## 四、实验结果

![image](https://github.com/wolkenthrut7/android-labs-2020/blob/master/students/sec1814080911129/lab7.png)

## 五、实验心得体会

   通过本次实验我掌握了Android设计开发中实现调用相机的方法，通过本次学习启蒙了我调用设备方法的学习方式，以后会更顺利的学习调用其他传感器设备的方式。