package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903316Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_1814080903316_activity);
        }
        public void jump(View view){
            Intent intent=new Intent(this,ToolActivity.class);
            startActivity(intent);

    }



}
