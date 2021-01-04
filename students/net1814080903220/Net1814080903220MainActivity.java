package edu.hzuapps.androidlabs.net1814080903220;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Net1814080903220MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Button edit = (Button) findViewById(R.id.E_dit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903220MainActivity.this, Net1814080903220EditActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        Button picture = (Button) findViewById(R.id.P_icture);
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Net1814080903220MainActivity.this, Net1814080903220PictureActivity.class);
                startActivity(intent);
                finish();
            }
        });

        TextView textView = (TextView) findViewById(R.id.content);
        TextView textView1 = (TextView) findViewById(R.id.apartdate1);

    }

    /*@Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("data",textView.getText().toString());
        outState.putString("data1",textView1.getText().toString());
    }
    protected void  onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String s = savedInstanceState.getString("data");
        String s1 = savedInstanceState.getString("data1");
        textView.setText(s);
        textView.setText(s1);
    }*/
};
