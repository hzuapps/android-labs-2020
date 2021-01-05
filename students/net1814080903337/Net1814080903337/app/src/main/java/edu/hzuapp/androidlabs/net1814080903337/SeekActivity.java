package edu.hzuapp.androidlabs.net1814080903337;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SeekActivity extends Activity {
private Button button;
private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_seek);
        text =(EditText) findViewById(R.id.editText6);
        button=(Button)findViewById(R.id.button4);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String name =text.getText()+"";
                finish();
                Intent intent = new Intent(SeekActivity.this, SeekResult.class);
                intent.putExtra("data",name);
                startActivity(intent);
            }
        });

    }



}
