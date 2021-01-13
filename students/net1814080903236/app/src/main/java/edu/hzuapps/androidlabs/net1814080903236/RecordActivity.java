package edu.hzuapps.androidlabs.net1814080903236;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;


public class RecordActivity extends AppCompatActivity {

    Button button_record, button_information, startbtn,stopbtn;
    EditText editName, editSex, data;
    String fileName = "record_file";
    MediaRecorder recorder;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        editName = findViewById(R.id.editName);
        editSex = findViewById(R.id.editSex);
        data = findViewById(R.id.data);
        button_record = findViewById(R.id.button2_1);
        button_information = findViewById(R.id.button2_2);
        startbtn = findViewById(R.id.button2_3);
        stopbtn = findViewById(R.id.button2_4);


        startbtn.setOnClickListener(new mClick());
        stopbtn.setOnClickListener(new mClick());


        path = getExternalCacheDir().getAbsolutePath();
        path += "/" + System.currentTimeMillis();

         if(Build.VERSION.SDK_INT>=23){
             String[] permissions = {
                     Manifest.permission.WRITE_EXTERNAL_STORAGE,
                     Manifest.permission.RECORD_AUDIO
             };
             for(int i=0;i<permissions.length;i++)
             {
                 if (PackageManager.PERMISSION_GRANTED != this.checkSelfPermission(permissions[i])){
                     this.requestPermissions(permissions,i);
                 }
             }
         }
    }

    class mClick implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            if(v==startbtn){
                startRecordAudio(path);
            }
            if (v==stopbtn){
                stopRecordAudio();
            }
        }
        public void startRecordAudio(String path){

            if(recorder==null){
                recorder=new MediaRecorder();
            }
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);//设置录音信息来源、
            recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);//设置录音的输出格式
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);//设置编码格式

            recorder.setOutputFile(path);
            try{
                recorder.prepare();//录音前的准备
                recorder.start();//开始录制
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void stopRecordAudio(){

            if(recorder!=null){
                recorder.stop();//停止录制
                recorder.reset();//重置
                recorder.release();//释放
                recorder=null;

            }
            Toast.makeText(RecordActivity.this, "录制成功", Toast.LENGTH_SHORT).show();
        }
    }

    public void btn2_1Click(View view) throws IOException {
        String name = editName.getText().toString();
        String sex = editSex.getText().toString();
        String d = data.getText().toString();

        FileOutputStream fileOutputStream = openFileOutput(fileName, Context.MODE_APPEND);
        fileOutputStream.write((name + "," + sex + "," + d + "\n").getBytes());
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }

        Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
    }

    public void btn2_2Click(View view) {
        final RecordActivity thisActivity2 = this;
        button_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity2, InformationActivity.class);
                RecordActivity.this.startActivity(intent);
            }
        });
}
}


