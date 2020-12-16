package edu.hzuapp.androidlabs.Net1814080903133;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903133Activity extends AppCompatActivity {
    private Net1814080903133Activity myThis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903133);
        myThis=this;
        Button bookButton = findViewById(R.id.BookButton),
                readButton=findViewById(R.id.ReadButton);
        bookButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent bookIntent=new Intent(myThis,BookActivity.class);
                startActivity(bookIntent);
            }
        });
        readButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent bookIntent=new Intent(myThis,ReadActivity.class);
                startActivity(bookIntent);
            }
        });
    }
}