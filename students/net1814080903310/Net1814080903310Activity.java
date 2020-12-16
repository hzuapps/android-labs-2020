package edu.hzuapps.androidlabs.students.net1814080903310;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903310Activity extends AppCompatActivity {

    @Override
    protected void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.see);
        final Net1814080903310Activity _this = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, Main1814080903310Activity.class);
                _this.startActivity(intent);
            }
        });
    }
}
