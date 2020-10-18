package edu.hzuapps.androidlabs.net1814080903339activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Net1814080903339Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903339);
    }

    public void onClickWatching(View view) {
       Intent intent = new Intent(this,WatchingActivity.class);
        startActivity(intent);
    }

    public void onClickBuy(View view) {
        Intent intent = new Intent(this,BuyActivity.class);
        startActivity(intent);
    }

    public void onClickConclude(View view) {
        Intent intent = new Intent(this,ConcludeActivity.class);
        startActivity(intent);
    }
}
