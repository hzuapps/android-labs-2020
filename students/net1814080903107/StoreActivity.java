package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.Inet4Address;

public class StoreActivity extends AppCompatActivity {
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
    }
    public void click(View v){
        Intent it=new Intent();
        it.setType("video/*");
        startActivityForResult(it,101);
    }
    protected void onActivityResult(int reqCode,int resCode,Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (resCode == Activity.RESULT_OK)
            flag=true;
    }
}