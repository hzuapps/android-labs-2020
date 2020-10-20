package edu.hzuapps.androidlabs.sec1814080911113;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911113Activity extends AppCompatActivity {

    private Button button;
    private View.OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.first_Button:
                        Intent intent = new Intent(Sec1814080911113Activity.this, MyMusicActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.sceond_Button:
                        Intent intent1 = new Intent(Sec1814080911113Activity.this, PauseActivity.class);
                        startActivity(intent1);
                        break;
                }
            }
        };

        button = findViewById(R.id.first_Button);
        button.setOnClickListener(onClickListener);

        button = findViewById(R.id.sceond_Button);
        button.setOnClickListener(onClickListener);


    }
}