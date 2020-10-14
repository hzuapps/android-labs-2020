package edu.hzuapp.androidlabs.net1814080903337;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Net1814080903337Activity extends AppCompatActivity {
    public void Record(View view) {
        Intent intent = new Intent(this,RecordActivity.class);
        startActivity(intent);
    }
    public void Seek(View view) {
        Intent intent = new Intent(this,SeekActivity.class);
        startActivity(intent);
    }
    public void Overdue(View view) {
        Intent intent = new Intent(this,OverdueActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903337);
    }
}
