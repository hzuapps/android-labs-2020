package com.example.sec1814080911223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FenActivity extends AppCompatActivity {

    private Button button;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen);
        onClickListener =new View.OnClickListener()

        {
            @Override
            public void onClick (View v){

                Intent intent = new Intent(FenActivity.this, KaiActivity.class);
                startActivity(intent);
            }
        }

        ;

        button = findViewById(R.id.button_fen);
        button.setOnClickListener(onClickListener);


    }
}