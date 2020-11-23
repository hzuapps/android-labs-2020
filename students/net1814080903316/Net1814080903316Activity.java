package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Net1814080903316Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_1814080903316_activity);
    }

        public void goImformation(View view){
            Intent intent=new Intent(this, ImformationActivity.class);
            startActivity(intent);
    }

        public void goTable(View view){
        Intent intent=new Intent(this, TableActivity.class);
        startActivity(intent);
    }
}
