package edu.hzuapps.androidlabs.sec1814080911202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sec1814080911202Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911202_activity);

        final Sec1814080911202Activity thisActivity = this;

        Button borrowBtn = (Button) findViewById(R.id.button_borrow);
        borrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,BorrowActivity.class);
                startActivity(intent);
            }
        });

        Button manageBtn = (Button) findViewById(R.id.button_manage);
        manageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式打开一个Activity
                Intent intent = new Intent(thisActivity,ManageActivity.class);
                startActivity(intent);
            }
        });





    }
}