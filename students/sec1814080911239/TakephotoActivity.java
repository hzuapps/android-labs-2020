package edu.hzuapps.myapplication;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import android.util.SparseArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class TakephotoActivity extends Activity {

    TextureView mPreviewView;
    HandlerThread mHandlerThread;
    Handler mCameraHandler;
    CameraManager manager;
    Size mPreviewSize;  //最佳预览尺寸(使用util包里的）
    Size mCaptureSize;  //最佳拍照尺寸
    String mCameraId;
    CameraDevice mCameraDevice;
    CaptureRequest.Builder mCaptureRequestBuild;
    CaptureRequest mCaptureRequest;
    CameraCaptureSession mCameraCaptureSession;
    ImageReader mImageReader;
    private static final SparseArray ORIENTATION = new SparseArray();

    static{
        ORIENTATION.append(Surface.ROTATION_0,90);
        ORIENTATION.append(Surface.ROTATION_90,0);
        ORIENTATION.append(Surface.ROTATION_180,270);
        ORIENTATION.append(Surface.ROTATION_270,180);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takephoto);

        mPreviewView = findViewById(R.id.textureView);
    }

    protected void onResume() {
        super.onResume();
        startCameraThread();//启动摄像头线程
        //开始预览之前的监听
        if (!mPreviewView.isAvailable()) {
            mPreviewView.setSurfaceTextureListener(mTextureListener);   //监听
        }else{
            startPreview();
        }

    }

    TextureView.SurfaceTextureListener mTextureListener = new TextureView.SurfaceTextureListener() {
        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        //组件可用
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int width, int height) {
            //当SurfaceTexture可用，设置相机的参数，并打开摄像头
            setupCamera(width, height);  //设置摄像头
            openCamera();   //打开摄像头
        }

        @Override
        //组件状态改变
        public void onSurfaceTextureSizeChanged(@NonNull SurfaceTexture surfaceTexture, int i, int i1) {

        }

        @Override
        //组件被销毁
        public boolean onSurfaceTextureDestroyed(@NonNull SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override
        //组件更新
        public void onSurfaceTextureUpdated(@NonNull SurfaceTexture surfaceTexture) {

        }
    };  //中间一大串是一条一句，要加;

    //开启摄像头线程
    private void startCameraThread() {
        mHandlerThread = new HandlerThread("CameraThread");
        mHandlerThread.start();
        mCameraHandler = new Handler(mHandlerThread.getLooper());
    }

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
                        public int compare(Size o1, Size o2){
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

    CameraDevice.StateCallback mStateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(@NonNull CameraDevice camera) {
            mCameraDevice = camera;
            startPreview();
        }

        @Override
        public void onDisconnected(@NonNull CameraDevice camera) {
            mCameraDevice.close();
            mCameraDevice = null;
        }

        @Override
        public void onError(@NonNull CameraDevice camera, int error) {
            mCameraDevice.close();
            mCameraDevice = null;
        }
    };


    //开始预览
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

    //开始拍照
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

    private void unLockFocus(){
        try {
            mCaptureRequestBuild.set(CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_CANCEL);
            mCameraCaptureSession.setRepeatingRequest(mCaptureRequestBuild.build(),null,mCameraHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

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

            String path = Environment.getExternalStorageDirectory()+"/DCIM/CameraV2";   //照片存储路径
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
}