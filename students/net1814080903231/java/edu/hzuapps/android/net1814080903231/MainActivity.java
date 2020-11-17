package edu.hzuapps.android.net1814080903231;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mBtnTextView;
    private Button person_list_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = findViewById(R.id.btn_textview);

        person_list_button = findViewById(R.id.person_list);

        mBtnTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
                startActivity(intent);
            }
        });

        person_list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ContactPersonActivity.class);
                startActivity(intent);
            }
        });




//        final Activity thisActivity = this;
//        Button btnOpen = (Button) findViewById(R.id.button);
//        View view = findViewById(R.id.button);
//        btnOpen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(thisActivity,ChatInterfaceActivity.class);
//                thisActivity.startActivityForResult(intent,2016);
//            }
//        });
    }
}