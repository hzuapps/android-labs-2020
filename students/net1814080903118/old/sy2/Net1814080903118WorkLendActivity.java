package edu.hzuapps.androidlabs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903118WorkLendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_1814080903118_work_lend);
        Button navPersonalBtn2=(Button)findViewById(R.id.navPersonalBtn2);
        navPersonalBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Net1814080903118WorkLendActivity.this,Net1814080903118PersonalActivity.class);
                startActivity(intent);
            }
        });
    }
}