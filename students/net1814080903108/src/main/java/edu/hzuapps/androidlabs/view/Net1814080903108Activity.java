package edu.hzuapps.androidlabs.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.R;

public class Net1814080903108Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903108);
        bindActivityReplaceButton(R.id.sureButton,MainActivity.class);
    }

    private void bindActivityReplaceButton(int buttonId, final Class linkActivity){
        Button button = (Button)findViewById(buttonId);
        final Net1814080903108Activity thisActivity = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,linkActivity);
                thisActivity.startActivity(intent);
            }
        });
    }
}

