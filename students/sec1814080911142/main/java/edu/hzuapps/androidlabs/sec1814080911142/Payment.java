package edu.hzuapps.androidlabs.sec1814080911142;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fkcg);
        final Button button1 = (Button) findViewById(R.id.button11);
        final Button button2 = (Button) findViewById(R.id.button22);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911142Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
    }


}
