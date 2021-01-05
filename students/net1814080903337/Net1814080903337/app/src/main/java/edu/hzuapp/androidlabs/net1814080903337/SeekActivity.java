package edu.hzuapp.androidlabs.net1814080903337;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeekActivity extends Activity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);
        button=(Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
                Intent intent = new Intent(SeekActivity.this, SeekResult.class);
                startActivity(intent);
            }
        });
    }



}
