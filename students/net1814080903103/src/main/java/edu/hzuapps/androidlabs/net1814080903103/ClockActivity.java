package edu.hzuapps.androidlabs.net1814080903103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Button btnOpen2 =(Button)findViewById(R.id.button_clock);
        btnOpen2.setX(600f);
        btnOpen2.setY(200f);
        btnOpen2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(ClockActivity.this,Net1814080903103Activity.class);
                ClockActivity.this.startActivity(intent);
            }
        });
    }
}
