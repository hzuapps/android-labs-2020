package edu.hzuapps.androidlabs.net1814080903239;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class showhouseActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showhouse);

        Button button = (Button) findViewById(R.id.button2);
        final showhouseActivity thisActivity = this;

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,renthouseActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
