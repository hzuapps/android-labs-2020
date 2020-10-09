package edu.hzuapps.androidlabs.net1814080903103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReckonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reckon);
        Button btnOpen =(Button)findViewById(R.id.return_btn);
        btnOpen.setX(200f);
        btnOpen.setY(200f);
        btnOpen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent =new Intent(ReckonActivity.this,Net1814080903103Activity.class);
                ReckonActivity.this.startActivity(intent);
            }
        });

    }
}
