package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buy extends AppCompatActivity {
    private Buy mythis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mythis=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        Button command=findViewById(R.id.buttonSeache);
        command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent commandIntent=new Intent(mythis,Command.class);
                startActivity(commandIntent);
            }
        });
    }
}
