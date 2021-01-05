package edu.hzuapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903338Activity extends AppCompatActivity {



    public void onClickRead(View view) {
        Intent intent1 = new Intent(this, ReadActivity.class);
        startActivity(intent1);
    }
    public void onClickWrite(View view) {
        Intent intent2 = new Intent(this, WriteActivity.class);
        startActivity(intent2);
    }

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903338);

    }


    }

