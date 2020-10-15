package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Net1814080903107Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        ImageView image1=findViewById(R.id.imageView1);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPage=new Intent(Net1814080903107Activity.this,StoreActivity.class);
                startActivity(newPage);
            }
        });
        ImageView image2=findViewById(R.id.imageView2);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPage=new Intent(Net1814080903107Activity.this,StoreActivity.class);
                startActivity(newPage);
            }
        });

        Button seache=findViewById(R.id.buttonSeache);
        seache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent=new Intent(Net1814080903107Activity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });
    }
}
