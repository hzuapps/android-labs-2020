package edu.hzuapps.androidlabs.sec1814080911129;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;


public class Sec1814080911129Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button tax= (Button)findViewById(R.id.taxB);
        tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911129Activity.this,TaxActivity.class);
                startActivity(intent);
            }
        });

        Button http = (Button)findViewById(R.id.httpB);
        http.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911129Activity.this,HttpClientUIActivity.class);
                startActivity(intent);
            }
        });


        Button photo = (Button)findViewById(R.id.photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911129Activity.this, PhotoActivity.class);
                startActivity(intent);
            }
        });

        Button tran = (Button)findViewById(R.id.tranB);
        tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911129Activity.this,TranActivity.class);
                startActivity(intent);
            }
        });


    }

}

