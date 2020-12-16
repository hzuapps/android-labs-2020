package edu.hzuapps.androidlabs.net1814080903119;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class DynamicPaperActivity extends AppCompatActivity {
    private Button dynamicset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_paper);

        dynamicset = findViewById(R.id.button5);
        final DynamicPaperActivity _this = this;
        Intent intent=getIntent();
        final Integer position = intent.getIntExtra("id",0);
         final VideoView dynamicVideo = findViewById(R.id.videoView1);
        dynamicVideo.setVideoURI(Uri.parse(videocol[position]));
        dynamicVideo.start();
        dynamicVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                dynamicVideo.start();
            }
        });

        dynamicset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DynamicPaperActivity.this,"设置成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public String[] videocol = {
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video1,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video3,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video4,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video5,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video6,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video7,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video8,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video9,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video10,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video11,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video12,
            "android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video13
    };
}