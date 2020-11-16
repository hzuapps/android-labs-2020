package edu.hzuapps.androidlabs.sec1814080911106;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static edu.hzuapps.androidlabs.sec1814080911106.R.layout.*;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_edit);

        final EditActivity thisActivity = this;

        Button listBtn = (Button) findViewById(R.id.btn_back);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, Sec1814080911106Activity.class);
                startActivity(intent);
            }
        });

    }
}