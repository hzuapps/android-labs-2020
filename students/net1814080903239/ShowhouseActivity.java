package edu.hzuapps.androidlabs.net1814080903239;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class ShowhouseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhouse);

        Button button = (Button) findViewById(R.id.button2);
        final ShowhouseActivity thisActivity = this;

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, RenthouseActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
