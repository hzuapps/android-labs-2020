package com.example.pl.qzd;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.aaa.net1714080903132.R;

public class Month1 extends AppCompatActivity {
    ImageButton imageButton;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.month1);
        getSupportActionBar().hide();

        imageButton = findViewById(R.id.IB_qh);
        imageView = findViewById(R.id.IV);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.t4));
                Intent intent = new Intent(Month1.this,Days.class);
                view.getContext().startActivity(intent);

            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Month1.this,Days.class);
                view.getContext().startActivity(intent);

            }
        });
    }
}
