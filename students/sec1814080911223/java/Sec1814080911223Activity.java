package com.example.sec1814080911223;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
public class Sec1814080911223Activity extends AppCompatActivity {
    private Button button;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    onClickListener =new View.OnClickListener()

    {
        @Override
        public void onClick (View v){

                Intent intent = new Intent(Sec1814080911223Activity.this, KaiActivity.class);
                startActivity(intent);
        }
    }

    ;

    button = findViewById(R.id.button_begin);
        button.setOnClickListener(onClickListener);


}
}