package edu.hzuapps.androids;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;

public class AlarmActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.alarm_play_aty);

        mp = MediaPlayer.create(this,R.raw.music);
        mp.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
        mp.release();
    }

    private MediaPlayer mp;
}
