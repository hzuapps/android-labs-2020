package edu.hzuapps.androidlabs.Net1814080903342Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Net1814080903342Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903342);
    }

    public void OnClickSearchId(View view) {
        Intent intent = new Intent(this,SearchIdActivity.class);
        startActivity(intent);
    }

    public void OnClickSearchTrading(View view) {
        Intent intent = new Intent(this,SearchTradingActivity.class);
        startActivity(intent);
    }
}