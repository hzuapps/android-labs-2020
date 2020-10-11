package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903329Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Net1814080903329Activity thisActivity=this;
        Button button=(Button)findViewById(R.id.button_open);
        button.setOnClickListener(new View.OnClickListener()
                                  {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent=new Intent(thisActivity,secondActivity.class);
                                          startActivity(intent);
                                      }

                                  }
        );

    }
}