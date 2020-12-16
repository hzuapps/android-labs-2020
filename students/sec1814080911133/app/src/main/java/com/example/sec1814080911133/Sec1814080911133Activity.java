package com.example.sec1814080911133;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;

public class Sec1814080911133Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button Tem = (Button)findViewById(R.id.button3);
        Tem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911133Activity.this,TemActivity.class);
                startActivity(intent);
            }
        });

        Button Knw = (Button)findViewById(R.id.button4);
        Knw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sec1814080911133Activity.this,KnwActivity.class);
                startActivity(intent);
            }
        });

    }
}