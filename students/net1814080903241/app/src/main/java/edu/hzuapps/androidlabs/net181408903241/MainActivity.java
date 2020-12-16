package edu.hzuapps.androidlabs.net181408903241;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_tiao1 = (Button) findViewById(R.id.button1);
        final MainActivity thisActivity1 = this;
        button_tiao1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent1 = new Intent(thisActivity1, MarkActivity.class);
                MainActivity.this.startActivity(Intent1);
            }
        });
        Button button_tiao2 = (Button) findViewById(R.id.button2);
        final MainActivity thisActivity2 = this;
        button_tiao2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent2 = new Intent(thisActivity2, SerachActivity.class);
                MainActivity.this.startActivity(Intent2);
            }
        });
    }
}
