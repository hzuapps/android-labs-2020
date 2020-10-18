package edu.hzuapp.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903133Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903133);
        Button setBtn = findViewById(R.id.setBtn);
        Button novel1 = findViewById(R.id.novel1);
        final Net1814080903133Activity myThis = this;
        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent setIntent = new Intent(myThis,SettingActivity.class);
                startActivity(setIntent);
            }
        });
        novel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent novel1Intent=new Intent(myThis,NovelReadActivity.class);
                startActivity(novel1Intent);
            }
        });
    }
}