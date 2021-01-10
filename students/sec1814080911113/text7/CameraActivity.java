package edu.hzuapps.androidlabs.sec1814080911113;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CameraActivity extends Activity {

    private String tag ="CameraActivity";
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;
    private Camera camera;
    private MediaRecorder mediaRecorder;
    private Button photoButton; //拍照按钮
    private Button vedioButton; //摄像按钮
    private TextView timeTextView;

    protected boolean isPreview = false; //摄像区域是否准备良好
    private boolean isRecording = true; // true表示没有录像，点击开始；false表示正在录像，点击暂停
    private boolean bool;

    private int hour = 0;
    private int minute = 0;  //计时专用
    private int second = 0;

    private File mRecVedioPath;
    private File mRecAudioFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        initCamera();
        initViews();
    }
    //初始化摄像头
    private void initCamera() {
        mRecVedioPath = new File(Environment.getExternalStorageDirectory()
                .getAbsolutePath() + "/mahc/video/temp/");
        if (!mRecVedioPath.exists()) {
            mRecVedioPath.mkdirs();
        }
        surfaceView = (SurfaceView) findViewById(R.id.camera_surfaceview);
        SurfaceHolder cameraSurfaceHolder = surfaceView.getHolder();
        cameraSurfaceHolder.addCallback(new Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    camera = Camera.open();
                    //设置Camera的角度/方向
                    camera.setDisplayOrientation(90);
                    Camera.Parameters parameters = camera.getParameters();
                    parameters.setPreviewFrameRate(5); // 每秒5帧
                    parameters.setPictureFormat(ImageFormat.JPEG);// 设置照片的输出格式
                    parameters.set("jpeg-quality", 85);// 照片质量
                    camera.setParameters(parameters);
                    camera.setPreviewDisplay(holder);
                    isPreview = true;
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                surfaceHolder = holder;
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                       int height) {
                surfaceHolder = holder;
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (camera != null) {
                    if (isPreview) {
                        camera.stopPreview();
                        isPreview = false;
                    }
                    camera.release();
                    camera = null; // 释放Camera
                }
                surfaceView = null;
                surfaceHolder = null;
                mediaRecorder = null;
            }
        });
        //开发时建议设置

        cameraSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    //初始化视图组件
    private void initViews() {
        timeTextView = (TextView) findViewById(R.id.camera_time);
        timeTextView.setVisibility(View.GONE);
        photoButton = (Button) findViewById(R.id.camera_photo);
        vedioButton = (Button) findViewById(R.id.camera_vedio);
        ButtonOnClickListener onClickListener = new ButtonOnClickListener();
        photoButton.setOnClickListener(onClickListener);
        vedioButton.setOnClickListener(onClickListener);
    }

    class ButtonOnClickListener implements OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.camera_vedio:
                    //点击开始录像
                    if(isRecording){
                        if (isPreview) {
                            camera.stopPreview();
                            camera.release();
                            camera = null;
                        }
                        second = 0;
                        minute = 0;
                        hour = 0;
                        bool = true;
                        if(null==mediaRecorder){
                            mediaRecorder = new MediaRecorder();
                        }else {
                            mediaRecorder.reset();
                        }
                        //表面设置显示记录媒体（视频）的预览
                        mediaRecorder.setPreviewDisplay(surfaceHolder.getSurface());
                        //开始捕捉和编码数据到setOutputFile（指定的文件）
                        mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
                        //设置用于录制的音源
                        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                        //设置在录制过程中产生的输出文件的格式
                        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
                        //设置视频编码器，用于录制
                        mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.H264);
                        //设置audio的编码格式
                        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
                        //设置要捕获的视频的宽度和高度
                        mediaRecorder.setVideoSize(320, 240);
                        // 设置要捕获的视频帧速率
                        mediaRecorder.setVideoFrameRate(15);
                        try {
                            mRecAudioFile = File.createTempFile("Vedio", ".3gp",
                                    mRecVedioPath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mediaRecorder.setOutputFile(mRecAudioFile.getAbsolutePath());
                        try {
                            mediaRecorder.prepare();
                            timeTextView.setVisibility(View.VISIBLE);
                            handler.postDelayed(task, 1000);
                            mediaRecorder.start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        isRecording = !isRecording;
                        Log.e(tag, "=====开始录制视频=====");
                    }else {
                        //点击停止录像
                        bool = false;
                        mediaRecorder.stop();
                        timeTextView.setText(FormatUtil.format(hour)+":"+FormatUtil.format(minute)+":"+ FormatUtil.format(second));
                        mediaRecorder.release();
                        mediaRecorder = null;
                        FormatUtil.videoRename(mRecAudioFile);
                        Log.e(tag, "=====录制完成，已保存=====");
                        isRecording = !isRecording;
                        try {
                            camera = Camera.open();
                            Camera.Parameters parameters = camera.getParameters();
//      parameters.setPreviewFrameRate(5); // 每秒5帧
                            parameters.setPictureFormat(ImageFormat.JPEG);// 设置照片的输出格式
                            parameters.set("jpeg-quality", 85);// 照片质量
                            camera.setParameters(parameters);
                            camera.setPreviewDisplay(surfaceHolder);
                            camera.startPreview();
                            isPreview = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case R.id.camera_photo:
                    if (mediaRecorder != null) {
                        try {
                            bool = false;
                            mediaRecorder.stop();
                            timeTextView.setText(FormatUtil.format(hour) + ":" + FormatUtil.format(minute) + ":"
                                    + FormatUtil.format(second));
                            mediaRecorder.release();
                            mediaRecorder = null;
                            FormatUtil.videoRename(mRecAudioFile);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        isRecording = !isRecording;
                        Log.e(tag, "=====录制完成，已保存=====");
                        try {
                            camera = Camera.open();
                            Camera.Parameters parameters = camera.getParameters();
//      parameters.setPreviewFrameRate(5); // 每秒5帧
                            parameters.setPictureFormat(ImageFormat.JPEG);// 设置照片的输出格式
                            parameters.set("jpeg-quality", 85);// 照片质量
                            camera.setParameters(parameters);
                            camera.setPreviewDisplay(surfaceHolder);
                            camera.startPreview();
                            isPreview = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (camera != null) {
                        camera.autoFocus(null);
                        camera.takePicture(null, null, new PictureCallback() {
                            @Override
                            public void onPictureTaken(byte[] data, Camera camera) {
                                new SavePictureTask().execute(data);
                                camera.startPreview();
                                Log.e(tag,"=====拍照成功=====");
                            }
                        }); // 拍照
                    }
                    break;
                default:
                    break;
            }
        }
    }
    /*
     * 定时器设置，实现计时
     */
    private Handler handler = new Handler();
    private Runnable task = new Runnable() {
        public void run() {
            if (bool) {
                handler.postDelayed(this, 1000);
                second++;
                if (second >= 60) {
                    minute++;
                    second = second % 60;
                }
                if (minute >= 60) {
                    hour++;
                    minute = minute % 60;
                }
                timeTextView.setText(FormatUtil.format(hour) + ":" + FormatUtil.format(minute) + ":"
                        + FormatUtil.format(second));
            }
        }
    };



    class SavePictureTask extends AsyncTask<byte[], String, String> {
        @Override
        protected String doInBackground(byte[]... params) {
            String path = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/pictures";
            File out = new File(path);
            if (!out.exists()) {
                out.mkdirs();
            }
            File picture = new File(path+"/"+new Date().getTime()+".jpg");
            try {
                FileOutputStream fos = new FileOutputStream(picture.getPath());
                fos.write(params[0]);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.e(tag, "=====照片保存完成=====");
            CameraActivity.this.finish();
            return null;
        }
    }
}