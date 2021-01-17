package edu.hzuapps.androidlabs.students.net1814080903310;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import edu.hzuapps.androidlabs.R;

public class PlayVideo18148080903310Activity extends AppCompatActivity {
    private VideoView videoView;
    private Button startVideo;
    private Button stopVideo;
    private MediaController mediaController;
    private Button playVideo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play18148080903310);
        intView();
    }

    private void intView(){
        videoView = (VideoView)findViewById(R.id.videoView2);
        startVideo = (Button)findViewById(R.id.startVideo);
        stopVideo = (Button)findViewById(R.id.stopVideo);
        playVideo2 = (Button)findViewById(R.id.playVideo2);

        startVideo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                init();
            }
        });
        stopVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.stopPlayback();
            }
        });
        playVideo2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                init2();
            }
        });
    }

    private void init(){
        videoView = (VideoView)findViewById(R.id.videoView2);
        mediaController = new MediaController(this);
        String uri = "android.resource://"+getPackageName()+"/"+R.raw.video;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
    }

    private void init2(){
        videoView = (VideoView)findViewById(R.id.videoView2);
        mediaController = new MediaController(this);
        String uri = "android.resource://"+getPackageName()+"/"+R.raw.video2;
        videoView.setVideoURI(Uri.parse(uri));
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);
        videoView.requestFocus();
        videoView.start();
    }
}
