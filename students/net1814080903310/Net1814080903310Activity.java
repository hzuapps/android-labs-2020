package edu.hzuapps.androidlabs.students.net1814080903310;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import edu.hzuapps.androidlabs.R;

public class Net1814080903310Activity extends AppCompatActivity {
    Button button = null;
    Button button1 =null;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.video);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(Net1814080903310Activity.this,PlayVideo18148080903310Activity.class);
                startActivity(intent);
            }
        });

        button1 = (Button)findViewById(R.id.info);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903310Activity.this,Information1814080903310Activity.class);
                startActivity(intent);
            }
        });
    }
}
