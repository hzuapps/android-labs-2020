package edu.hzuapps.androidlabs.Net1814080903220;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903220MainActivity extends AppCompatActivity {

    private Button Edit;
    private Button Picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Edit = (Button) findViewById(R.id.E_dit);
        Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903220MainActivity.this,Net1814080903220EditActivity.class);
                startActivity(intent);
            }
        });
        Picture = (Button) findViewById(R.id.P_icture);
        Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903220MainActivity.this,Net1814080903220PictureActivity.class);
                startActivity(intent);
            }
        });
        };
    }