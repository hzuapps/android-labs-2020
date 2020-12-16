package edu.hzuapps.androidlabs.net1814080903119;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    Button button = findViewById(R.id.button2);
    final FirstActivity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(_this, SecondActivity.class);
            _this.startActivity(intent);
        }
    });
}
}