package edu.hzuapps.androidlabs.net1814080903119;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button button  = findViewById(R.id.button1);
        button.setOnClickListener(this);
        final HomePageActivity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, GridViewActivity.class);
                _this.startActivity(intent);
            }
        });
        initView();
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://edu.hzuapps.androidlabs.net1814080903119/"+R.raw.video6));

        //MediaController mediaController = new MediaController(this);
        //videoView.setMediaController(mediaController);
        videoView.start();
        //循环播放
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });
    }
    @Override
    protected  void onRestart(){
        initView();
        super.onRestart();
    }

    @Override
    public void onClick(View v) {

    }
}