package edu.hzuapps.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903118PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_1814080903118_personal);
        Button navLendBtn3=(Button) findViewById(R.id.navLendBtn3);
        navLendBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
                String lendable=sharedPreferences.getString("lendable","false");
                Intent intent=new Intent();
                if(lendable.equals("false"))
                    intent.setClass(Net1814080903118PersonalActivity.this,Net1814080903118WorkUnLendActivity.class);
                else
                    intent.setClass(Net1814080903118PersonalActivity.this,Net1814080903118WorkLendActivity.class);
                startActivity(intent);
            }
        });
    }
}