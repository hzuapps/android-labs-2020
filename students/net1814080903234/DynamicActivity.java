package edu.hzuapp.androidlabs.net1814080903234;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        final Activity thisActivity = this;
        Button btnMian = (Button) findViewById(R.id.net);
        btnMian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Net1814080903234Activity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}
