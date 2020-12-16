package edu.hzuapps.Net1814080903341Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class Net1814080903341 extends AppCompatActivity {

    public void onClickUpload(View view) {
        Intent intent=new Intent(this,Upload.class);
        startActivity(intent);
    }

    public void onClickSearch(View view) {
        Intent intent=new Intent(this,Search.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903341);
    }

}