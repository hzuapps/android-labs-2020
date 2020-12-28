# 实验七
## 一、 实验目标
1. 理解Android相机、蓝牙、传感器等设备编程方法。
2. 理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。
## 二、 实验内容
1. 拍照显示并存储图片
2. 编程实现设备使用
## 三、 实验步骤

1. 在activity_shareedit.xml创建一个“拍照”按钮

   ```java
   <Button
               android:id="@+id/take_photo"
               android:layout_width="wrap_content"
               android:layout_height="wrap_content"
               android:layout_weight="1"
               android:text="拍照"/>
   ```

   

2. 新建一个TakephotoActivity.java和activity_takephoto.xml文件

3. 实现点击“拍照”按钮跳转到activity_takephoto界面

   ```java
   mBtnPhoto = (Button) findViewById(R.id.take_photo);
           mBtnPhoto.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   switch (view.getId()) {
                       case R.id.take_photo:
                           Intent intent = new Intent(ShareeditActivity.this,TakephotoActivity.class);
                           startActivity(intent);
                           break;
   ```

   

4. 在activity_takephoto.xml文件添加TextureView组件存放摄像头捕获到的画面，再添加一个Button实现点击按钮完成拍照事件

   ```java
   <TextureView
          android:id="@+id/textureView"
          android:layout_width="match_parent"
          android:layout_height="match_parent"/>
   
       <Button
           android:layout_width="70dp"
           android:layout_height="70dp"
           android:text="take"
           android:onClick="capture"
           app:layout_constraintBottom_toBottomOf="parent"
           app:layout_constraintLeft_toLeftOf="parent"
           app:layout_constraintRight_toRightOf="parent"
           app:layout_constraintTop_toTopOf="parent"
           app:layout_constraintVertical_bias="0.97"></Button>
   ```

5. 在AndroidManifest.xml文件添加权限

   ```java
       <uses-permission android:name="android.permission.CAMERA" />
       <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
   ```

   

6. 在TakephotoActivity.java创建startCameraThread方法开启摄像头线程

   ```java
   //开启摄像头线程
       private void startCameraThread() {
           mHandlerThread = new HandlerThread("CameraThread");
           mHandlerThread.start();
           mCameraHandler = new Handler(mHandlerThread.getLooper());
       }
   ```

   

7. 创建setupCamera方法设置摄像头参数

   ```java
   //设置摄像头参数
       @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
       private void setupCamera(int width, int height) {
           manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
   
           //获得摄像头ID
           try {
               for (String cameraID : manager.getCameraIdList()) {
                   CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraID);
   
                   Integer facing = characteristics.get(CameraCharacteristics.LENS_FACING);
                   if (facing != null && facing == CameraCharacteristics.LENS_FACING_FRONT) {    //摄像头朝向向前，则继续
                       continue;
                   }
                   StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);    //获得分辨率
   
                   if (map != null) {    //找到摄像头能够输出的最符合当前显示界面分辨率的最小值
                       mPreviewSize = getOptimalSize(map.getOutputSizes(SurfaceTexture.class), width, height);
                       mCaptureSize = Collections.max(Arrays.asList(map.getOutputSizes(ImageFormat.JPEG)),new Comparator<Size>(){
                           @Override
                           public int compare(Size o1,Size o2){
                               return Long.signum(o1.getWidth()*o1.getHeight()-o2.getWidth()*o2.getHeight());
                           }
                       });
                   }
   
                   //建立ImageReader存储照片
                   setupImageReader();
   
                   mCameraId = cameraID;
                   break;
               }
           } catch (CameraAccessException e) {
               e.printStackTrace();
           }
       }
   private Size getOptimalSize(Size[] sizeMap, int width, int height) {
           List<Size> sizeList = new ArrayList<Size>();
   
           for (Size option : sizeMap) {
               if (width > height) {   //横屏
                   if (option.getWidth() > width && option.getHeight() > height) {
                       sizeList.add(option);
                   } else {  //竖屏
                       if (option.getWidth() > height && option.getHeight() > width) {
                           sizeList.add(option);
                       }
                   }
               }
           }
   
           if (sizeList.size() > 1) {
               return Collections.min(sizeList, new Comparator<Size>() {
                   @Override
                   public int compare(Size o1, Size o2) {
                       return Long.signum(o1.getWidth() * o1.getHeight() - o2.getWidth() * o2.getHeight());
                   }
               });
           }
   
           return sizeMap[0];
       }
   ```

   

8. 创建openCamera方法打开摄像头

   ```java
   //打开摄像头
       @RequiresApi(api = Build.VERSION_CODES.M)
       private void openCamera(){
           String[] permissions = {Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
   
           int i=0;
           for(String permission:permissions){
               if(checkSelfPermission(permission)!=PackageManager.PERMISSION_GRANTED){
                   this.requestPermissions(permissions,i++);
               }
           }
           if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
               this.requestPermissions(permissions,0);
               return;
           }
           try {
               manager.openCamera(mCameraId, mStateCallback, mCameraHandler);
           } catch (CameraAccessException e) {
               e.printStackTrace();
           }
       }
   ```

   

9. 创建startPreview方法实现预览功能

   ```java
   private void startPreview(){
   
           //建立图像缓冲区
           SurfaceTexture mSurfaceTexture = mPreviewView.getSurfaceTexture();
           mSurfaceTexture.setDefaultBufferSize(mPreviewSize.getWidth(),mPreviewSize.getHeight());
   
           //得到界面的显示对象
           Surface previewSurface = new Surface(mSurfaceTexture);
   
           try {
               mCaptureRequestBuild = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
               mCaptureRequestBuild.addTarget(previewSurface);
   
               //建立通道（CaptureRequest和CaptureSession会话)
               mCameraDevice.createCaptureSession(Arrays.asList(previewSurface,mImageReader.getSurface()), new CameraCaptureSession.StateCallback() {
                   @Override
                   public void onConfigured(@NonNull CameraCaptureSession session) {
   
                       try {
                           mCaptureRequest = mCaptureRequestBuild.build();
                           mCameraCaptureSession = session;
                           mCameraCaptureSession.setRepeatingRequest(mCaptureRequest,null,mCameraHandler);
                       } catch (CameraAccessException e) {
                           e.printStackTrace();
                       }
                   }
   
                   @Override
                   public void onConfigureFailed(@NonNull CameraCaptureSession session) {
   
                   }
               }, mCameraHandler);
   
           } catch (CameraAccessException e) {
               e.printStackTrace();
           }
   
       }
   ```

10. 创建capture方法实现拍照功能

    ```java
    public void capture(View view){
    
            //获取摄像头的请求
            CaptureRequest.Builder mCameraBuilder = null;
            try {
                mCameraBuilder = mCameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
            mCameraBuilder.addTarget(mImageReader.getSurface());
    
            //获取摄像头方向
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
    
            //设置拍照方向
            mCameraBuilder.set(CaptureRequest.JPEG_ORIENTATION,(Integer)ORIENTATION.get(rotation)) ;
            CameraCaptureSession.CaptureCallback mCaptureCallBack = new CameraCaptureSession.CaptureCallback() {
                @Override
                public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
    
                    Toast.makeText(getApplicationContext(),"相片已保存",Toast.LENGTH_LONG).show();
                    unLockFocus();
                    super.onCaptureCompleted(session, request, result);
                }
            };
    
    
            try {
                mCameraCaptureSession.stopRepeating();
                mCameraCaptureSession.capture(mCameraBuilder.build(),mCaptureCallBack,mCameraHandler);
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
    
    
        }
    ```

    

11. 创建setupImageReader方法和ImageSaver接口来实现文件夹创建和照片存储

    ```java
    //建立ImageReader存储照片
        private void setupImageReader(){
            mImageReader = ImageReader.newInstance(mCaptureSize.getWidth(),mCaptureSize.getHeight(),ImageFormat.JPEG,2);
            mImageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
                @Override
                public void onImageAvailable(ImageReader reader) {
                    mCameraHandler.post(new ImageSaver(reader.acquireNextImage()));
                }
            },mCameraHandler);
        }
    
        private class ImageSaver implements Runnable{
            Image mImage;
            public ImageSaver(Image image){
                mImage = image;
            }
            @Override
            public void run(){
                ByteBuffer buffer = mImage.getPlanes()[0].getBuffer();
                byte[] data = new byte[buffer.remaining()];
                buffer.get(data);
    
                String path = Environment.getExternalStorageDirectory()+"/DCIM/CameraV2/";   //照片存储路径
                File mImageFile = new File(path);
                //如果文件夹不存在，则创建一个文件夹存放照片
                if(!mImageFile.exists()){
                    mImageFile.mkdir();
                }
    
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName = path + "IMG_"+timeStamp+".jpg";
    
                try {
                    FileOutputStream fos = new FileOutputStream(fileName);
                    fos.write(data,0,data.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    
    
            }
        }
    ```

12. 运行程序完成拍照之后，在Device File Explorer找到图片存储位置sdcard-DCIM-CameraV2，验证照片是否存储成功

    ## 四、实验结果

![获得拍照权限](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/agreetakephoto.png)

图1.获得拍照权限

![获得存储权限](https://github.com/jalyn-1001/mytest/blob/master/sec1814080911239/agreeaccessphoto.png)

图2.获得存储权限

![预览画面](https://github.com/jalyn-1001/mytest/tree/master/sec1814080911239/preview.png)

图3.预览画面

![拍照存储](https://github.com/jalyn-1001/mytest/tree/master/sec1814080911239/save.png)

图4.拍照存储

![图片存储位置](https://github.com/jalyn-1001/mytest/tree/master/sec1814080911239/location.png)

图5.图片存储位置

![拍摄结果](https://github.com/jalyn-1001/mytest/tree/master/sec1814080911239/photo.jpg)

图6.拍摄结果

## 五、 实验心得体会

​	本次实验实现了拍摄并存储照片的功能。在AndroidManifest.xml文件添加摄像头和访问文件夹存储照片的权限。util包下的Size提供了getWidth()和getHeight()方法可以获取屏幕的宽和高，可以通过比较getWidth()和getHeight()大小来判断当前屏幕是横屏还是竖屏，然后让预览画面随之改变方向。

​	在实验中建立了两个缓冲区，一个是预览图片时建立的缓冲区，一个是拍摄图片时建立的缓冲区，这两个缓冲区是不一样的，前者的缓冲区只是一个预览状态，并没有存储在手机里，后者的缓冲区才真正存储到了手机里。

​	存储图片的时候，要判断一下文件夹是否存在，如果不存在则要调用mkdir()方法创建一个文件夹。