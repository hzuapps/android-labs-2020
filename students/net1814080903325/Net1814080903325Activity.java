package edu.hzuapps.androidlabs.net1814080903325;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Net1814080903325Activity extends AppCompatActivity {

    private ImageView mImageView;
    private TextView mTextView;
    private String FileName = "play_state";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903325);
        init();
    }

    private void init() {
         mImageView = this.findViewById(R.id.detail_play_control);
         mTextView = this.findViewById(R.id.detail_play_control);
         mImageView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //修改当前的播放状态
                 mTextView.setText("正在播放");
                 //修改ui更新播放状态
                 mImageView.setImageResource(R.mipmap.pause_black_normal);
                 //获取当前的播放状态
                 String text = mTextView.getText().toString();
                 //将当前播放状态保存到sp里头去
                 FileOutputStream fileOutputStream = null;
                 try {
                     fileOutputStream = openFileOutput(FileName, Context.MODE_PRIVATE);
                     fileOutputStream.write(text.getBytes());
                     fileOutputStream.close();
                 } catch (Exception e) {
                     e.printStackTrace();
                 }


             }
         });
    }
}
