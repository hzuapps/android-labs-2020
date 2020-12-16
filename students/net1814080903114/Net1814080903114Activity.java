package edu.hzuapps.androidlabs;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Net1814080903114Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903114);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button btu=(Button)findViewById(R.id.test);
        btu.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent it=new Intent(Net1814080903114Activity.this,MainActivity.class);
                Net1814080903114Activity.this.startActivity(it);
        }
        });
        Button but1=(Button)findViewById(R.id.add);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(Net1814080903114Activity.this,addActivity.class);
                Net1814080903114Activity.this.startActivity(it);
            }
        });
        Button but2=(Button)findViewById(R.id.delete);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it= new Intent(Net1814080903114Activity.this,deleteActivity.class);
                Net1814080903114Activity.this.startActivity(it);
            }
        });
 //封装函数

//        forward(R.id.test);
//        forward (R.id.add);
//        forward (R.id.delete);


    }
//    public  void forward(int type){
//        Button but2=(Button)findViewById(type);
//        but2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it= new Intent(Net1814080903114Activity.this,.class);
//                Net1814080903114Activity.this.startActivity(it);
//            }
//        });
//    }

}
