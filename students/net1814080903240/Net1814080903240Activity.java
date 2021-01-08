package edu.hzuapps.androidlabs.net1814080903240;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903240Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903240Activity thisActivity = this;

        Button button_install = (Button) findViewById(R.id.install);
        button_install.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, InstallActivity.class);
                startActivity(intent);
            }
        });

        Button button_binding = (Button) findViewById(R.id.binding);
        button_binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, BindingActivity.class);
                startActivity(intent);
            }
        });

        Button button_evaluate = (Button) findViewById(R.id.comment);
        button_evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, FileStoreActivity.class);
                startActivity(intent);
            }
        });

    }

}
