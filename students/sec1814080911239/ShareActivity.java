package edu.hzuapps.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        findViewById(R.id.text_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.text_button:
                        Intent intent = new Intent(ShareActivity.this,TextActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

        //接收文字
        Intent intent = getIntent();
        if(intent !=null){
            String string_share = intent.getStringExtra("mstring_share");
            setTitle(string_share);
        }
    }
}
