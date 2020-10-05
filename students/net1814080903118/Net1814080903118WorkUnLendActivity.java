package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Net1814080903118WorkUnLendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_1814080903118_work_un_lend);

        SharedPreferences sharedPreferences = getSharedPreferences("userstatus", Context.MODE_PRIVATE);

        Button navPersonalBtn1=(Button)findViewById(R.id.navPersonalBtn1);
        navPersonalBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Net1814080903118WorkUnLendActivity.this,Net1814080903118PersonalActivity.class);
                startActivity(intent);
            }
        });


    }
}