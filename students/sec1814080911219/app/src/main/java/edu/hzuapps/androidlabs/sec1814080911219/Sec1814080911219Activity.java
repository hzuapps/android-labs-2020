package edu.hzuapps.androidlabs.sec1814080911219;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Sec1814080911219Activity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Activity thisActivity=this;
        Button button1=(Button)findViewById(R.id.button_cipherupload);
        View view1=findViewById(R.id.button_cipherupload);
        Button button2=(Button)findViewById(R.id.button_showfilelist);
        View view2=findViewById(R.id.button_showfilelist);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(thisActivity,CipheruploadActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent=new Intent(thisActivity,ShowfilelistActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}