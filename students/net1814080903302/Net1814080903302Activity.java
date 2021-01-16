package edu.hzuapps.myapplication0;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Net1814080903302Activity extends AppCompatActivity implements View.OnClickListener{

    // 录音界面相关
    Button buttonStart;
    Button buttonStop;
    Button buttonLine;
    private Chronometer chrTime=null;//计时
    MediaRecorder mMediaRecorder; // MediaRecorder 实例
    boolean isRecording; // 录音状态
    String fileName; // 录音文件的名称
    String filePath; // 录音文件存储路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903302);
        initView();
    }

    private void initView(){
        buttonStart =findViewById(R.id.startluyin);
        buttonStop = findViewById(R.id.stopluyin);
        buttonLine = findViewById(R.id.luyinline);
        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);
        buttonLine.setOnClickListener(this);
        chrTime= findViewById(R.id.chronometer);
        chrTime.setFormat("%s");
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.startluyin:
                chrTime.start();
                buttonStart.setEnabled(false);
                buttonStop.setEnabled(true);
                buttonLine.setEnabled(false);
                startRecord();
                isRecording = true;
                break;
            case R.id.stopluyin:
                chrTime.stop();
                chrTime.setBase(SystemClock.elapsedRealtime());
                buttonStart.setEnabled(true);
                buttonStop.setEnabled(false);
                buttonLine.setEnabled(true);
                stopRecord(filePath);
                isRecording = false;
                break;
            case R.id.luyinline:
                Intent intent = new Intent(this, RecordingLine.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startRecord()  {
        // 开始录音
        if (mMediaRecorder == null)
            mMediaRecorder = new MediaRecorder();
        try{
            mMediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);// 设置麦克风
            mMediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
            mMediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            fileName = "录音1" + ".amr";
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
            filePath = file.getAbsolutePath();
            file.getParentFile().mkdirs();
            file.setWritable(true);
            mMediaRecorder.setOutputFile(file);
            mMediaRecorder.prepare();
            mMediaRecorder.start();
        }catch (RuntimeException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        fileName = "录音1" + ".amr";
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
        filePath = file.getAbsolutePath();
        file.getParentFile().mkdirs();
        file.setWritable(true);
    }

    public void stopRecord(String path) {
        //停止录音
        try {
            mMediaRecorder.stop();
            mMediaRecorder.reset();
            mMediaRecorder.release();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }
        InputStream isFrom = null;
        OutputStream osTo = null;
        try {
            //设置输入输出流
            isFrom = new FileInputStream(path);
            osTo = new FileOutputStream(filePath);
            byte bt[] = new byte[1024];
            int len;
            while ((len = isFrom.read(bt)) != -1) {
                osTo.write(bt, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (osTo != null) {
                try {
                    //不管是否出现异常，都要关闭流
                    osTo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (isFrom != null) {
                try {
                    isFrom.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}