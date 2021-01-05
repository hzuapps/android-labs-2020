package edu.hzuapps.androidlabs.Net1814080903207;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903207Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_start = (Button)findViewById(R.id.button);
        Button button_wrong = (Button)findViewById(R.id.button2);
        final Net1814080903207Activity address=this;
        button_start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(address, Net1814080903207ReciteActivity.class);
                        address.startActivity(intent);
                    }
                }
        );
        button_wrong.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(address, Net1814080903207WrongActivity.class);
                        address.startActivity(intent);
                    }
                }
        );
    }
}