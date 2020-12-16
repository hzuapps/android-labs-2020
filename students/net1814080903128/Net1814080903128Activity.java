package edu.hzuapps.androidlabs.Net1814080903128.cookcake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class Net1814080903128Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    final Activity thisActivity = this;

    Button button = (Button) findViewById(R.id.cake);

    View view = findViewById(R.id.cake);

        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(thisActivity, CakeActivity.class);
            thisActivity.startActivity(intent);
        }
    });


}
}
