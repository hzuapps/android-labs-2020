package edu.hzuapp.androidlabs.net1814080903323activity;

import android.animation.ObjectAnimator;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import static java.lang.Integer.parseInt;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener{
    private static TextView name_song;
    private ObjectAnimator animator;
    private MusicServiceActivity.MusicControl musicControl;
    String name;
    Intent intent1,intent2;
    MyServiceConn conn;
    private boolean isUnbind =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        intent1=getIntent();
        init();
    }
    private void init(){


        name_song=(TextView)findViewById(R.id.music_name);

        findViewById(R.id.btn_play).setOnClickListener(this);
        findViewById(R.id.btn_pause).setOnClickListener(this);
        findViewById(R.id.btn_continue_play).setOnClickListener(this);
        findViewById(R.id.btn_exit).setOnClickListener(this);

        name=intent1.getStringExtra("name");
        name_song.setText(name);
        intent2=new Intent(this,MusicServiceActivity.class);
        conn=new MyServiceConn();
        bindService(intent2,conn,BIND_AUTO_CREATE);
    }

    class MyServiceConn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service){
            musicControl=(MusicServiceActivity.MusicControl) service;
        }
        @Override
        public void onServiceDisconnected(ComponentName name){

        }
    }
    private void unbind(boolean isUnbind){
        if(!isUnbind){
            musicControl.pausePlay();
            unbindService(conn);
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_play:
                String position=intent1.getStringExtra("position");
                int i=parseInt(position);
                musicControl.play(i);
                animator.start();
                break;
            case R.id.btn_pause:
                musicControl.pausePlay();
                animator.pause();
                break;
            case R.id.btn_continue_play:
                musicControl.continuePlay();
                animator.start();
                break;
            case R.id.btn_exit:
                unbind(isUnbind);
                isUnbind=true;
                finish();
                break;
        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        unbind(isUnbind);
    }
}
