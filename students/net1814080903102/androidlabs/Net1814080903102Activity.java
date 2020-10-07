package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903102Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Net1814080903102Activity thisActivity = this;

        Button addbutton = (Button) findViewById(R.id.button_add);
        addbutton.setOnClickListener(new View.OnClickListener(){//匿名类
            @Override
            public void onClick(View v){//打开
                Intent intent = new Intent(thisActivity,addclass.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult();
            }
        });

        Button setbutton = (Button) findViewById(R.id.button_setting);
        setbutton.setOnClickListener(new View.OnClickListener(){//匿名类
            @Override
            public void onClick(View v){//打开
                Intent intent = new Intent(thisActivity,setclass.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult();
            }
        });
    }
}

//    class MyClickListener implements View.OnClickListener{//新类
//        @Override
//        public void onClick(View v){
//
//        }
//
//    }