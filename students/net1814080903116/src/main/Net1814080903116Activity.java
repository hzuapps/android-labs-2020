package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903116Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindActivityButton(R.id.postButton, PostActivity.class);
        bindActivityButton(R.id.treeHoldButton, TreeholdActivity.class);

    }

    private void bindActivityButton(int ButtonId,final Class activity){
        Button button = (Button)findViewById(ButtonId);
        final Net1814080903116Activity thisActivity = this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity,activity);
                thisActivity.startActivity(intent);
            }
        });
    }

    public void onClick(View view) {
    }
}