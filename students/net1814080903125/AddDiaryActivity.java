package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddDiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);

        Button back_btn1 = (Button)findViewById(R.id.back_btn1);
        back_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDiaryActivity.this, Net1814080903125Activity.class);
                AddDiaryActivity.this.startActivity(intent);
            }
        });

    }
}