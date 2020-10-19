package edu.hzuapps.androidlabs.sec1814080911142;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Register extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Register thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911142Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }

}