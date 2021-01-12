package edu.hzuapps.androidlabs.net1814080903113;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class StartAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start__anima);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Thread background = new Thread(){
            public void run(){

                try {
                    sleep(2 * 1000);
                    Intent intent = new Intent(StartAnimation.this, Net1814080903113MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }

        };
        background.start();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
