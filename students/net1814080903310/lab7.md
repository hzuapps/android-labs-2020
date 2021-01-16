# 实验七

## 1.实验目标
1.理解Android相机、蓝牙、传感器等设备编程方法。
2.理解Android设备编程与前面所学组件、存储、网络及界面开发的知识点关系。

## 2.实验内容
1.选择一个跟选题相关的设备功能；
（1）拍照显示、录视频；
（2）控制和检测网络；
（3）获取用户位置信息；
（4）判断屏幕方向并提示用户旋转手机（小游戏）；
（5）摇一摇手机。

2.编程实现设备使用。

## 3.实验步骤
由于实验目的用不到实验七的设备编程，所以在原本的实验上做修改。此次修改增加了视频播放页播放多一个视频的功能。

1.在xml布局设置一个新的按钮来播放video2

activity_play1814080903310.xml
```
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".students.net1814080903310.PlayVideo18148080903310Activity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <VideoView
                android:id="@+id/videoView2"
                android:layout_width="354dp"
                android:layout_height="242dp"
                android:layout_weight="1" />
        </LinearLayout>

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="horizontal">

            <Button
                android:id="@+id/startVideo"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="点击播放视频1" />

            <Button
                android:id="@+id/stopVideo"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:text="结束" />
        </LinearLayout>

        <Button
            android:id="@+id/playVideo2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="点击播放视频2" />

    </LinearLayout>
</androidx.constraintlayout.widget.ConstraintLayout>
```

2.设置一个新的函数init2来实现点击按钮播放视频

PlayVideo1814080903310Activity
```
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
```

## 4.实验结果
![播放视频1](https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/lab7_1.png)
![播放视频2](https://github.com/JeesionChone/android-labs-2020/blob/master/students/net1814080903310/lab7_2.png)

## 5.实验心得
添加了一个新的按钮，一个新的listener，然后把原有的函数init复制一份，改为init2，把要播放的视频文件名改正，就可以实现在同一个Videoview播放不同的视频。
