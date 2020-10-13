package edu.hzuapp.androidlabs.net1814080903141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903141Activity extends AppCompatActivity {
    private Net1814080903141Activity myThis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903141);
        myThis=this;
        Button newButton = findViewById(R.id.NewButton),
                recordButton=findViewById(R.id.RecordButton);
        newButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent newIntent=new Intent(myThis,NewActivity.class);
                startActivity(newIntent);
            }
        });
        recordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent newIntent=new Intent(myThis,RecordActivity.class);
                startActivity(newIntent);
            }
        });
    }
}