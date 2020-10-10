package edu.hzuapps.androidlabs.net1814080903123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903123Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent it = new Intent();
                                       it.setClass(Net1814080903123Activity.this, NovelSearch.class);
                                       Net1814080903123Activity.this.startActivity(it);
                                   }    });

            Button btn1= findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent it=new Intent();
                    it.setClass( Net1814080903123Activity.this, MyBookshelf.class);
                    Net1814080903123Activity.this.startActivity(it);
                }

        });
    }
}