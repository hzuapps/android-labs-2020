package edu.hzuapps.androidlabs.net1814080903137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903137Activity extends AppCompatActivity {
    private Net1814080903137Activity myThis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903137);
        //
        myThis=this;
        Button setButton = findViewById(R.id.SetButton),
                remindButton=findViewById(R.id.RemindButton);
        setButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent setIntent=new Intent(myThis,SetActivity.class);
                startActivity(setIntent);
            }
        });
        remindButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent remindIntent=new Intent(myThis,RemindActivity.class);
                startActivity(remindIntent);
        }
        });
    }
}
