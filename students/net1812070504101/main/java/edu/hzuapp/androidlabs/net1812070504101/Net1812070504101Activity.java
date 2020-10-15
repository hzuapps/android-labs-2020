package edu.hzuapp.androidlabs.net1812070504101;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1812070504101Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.androidmanifest);

        Button seache=findViewById(R.id.button);
        seache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent=new Intent(Net1812070504101Activity.this, RandomActivity.class);
                startActivity(searchIntent);
            }
        });
    }


}
