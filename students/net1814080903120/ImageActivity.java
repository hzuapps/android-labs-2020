package edu.hzuapps.androidlabs.net1814080903120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_act);
    }
    public void kk(View view){
        Intent intent = new Intent();
        intent.setClass(ImageActivity.this,ImageotherActivity.class);
        startActivity(intent);
    }
}