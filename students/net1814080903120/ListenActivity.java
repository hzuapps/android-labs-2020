package edu.hzuapps.androidlabs.net1814080903120;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListenActivity extends AppCompatActivity {

        private Button btn11,btn22;
        private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listen);
        btn11=(Button)findViewById(R.id.btn1);
        btn22=(Button)findViewById(R.id.btn2);
        btn11 = (Button) findViewById(R.id.btn1);
        btn22 = (Button) findViewById(R.id.btn2);
        textView=(TextView)findViewById(R.id.textView);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn22.getText().toString().equals("发送")){
                    btn22.setText("发送");
                }else{

                    btn22.setText("按钮可用");
                }
            }
        });


    }public void gu(View view){
        Intent intent = new Intent();
        intent.setClass(this,ListenotherActivity.class);
        startActivity(intent);
    }
}
