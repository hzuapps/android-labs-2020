package edu.hzuapps.androidlabs.net1814080903326;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Net1814080903326Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903326);

        initUI();
    }

    private void initUI() {
        findViewById(R.id.btn_inf).setOnClickListener(this);
        findViewById(R.id.btn_mine).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_inf:
                //跳转到第二界面
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),FirstActivity.class);
                this.startActivity(intent);
                break;
            case R.id.btn_mine:
                //跳转到第二界面

                break;
        }

    }
}