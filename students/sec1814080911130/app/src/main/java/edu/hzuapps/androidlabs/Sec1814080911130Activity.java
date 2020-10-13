package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911130Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911130);

        final Sec1814080911130Activity thisActivity = this;
        Button BtnStart = (Button) findViewById(R.id.button_start);
        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,PlayActivity.class);
                thisActivity.startActivity(intent);
            }
        });
        Button BtnOptions = (Button) findViewById(R.id.button_options);
        BtnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,OptionsActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
