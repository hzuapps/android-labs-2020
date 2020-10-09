package edu.hzuapps.androidlabs.net1814080903136;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
public class Net1814080903136Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final  Net1814080903136Activity thisActivity = this;
       Button btncut =(Button) findViewById(R.id.button_cut);
        btncut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(thisActivity, Edit1814080903136Activity.class);
                thisActivity.startActivity(intent);
            }
        });


}
}