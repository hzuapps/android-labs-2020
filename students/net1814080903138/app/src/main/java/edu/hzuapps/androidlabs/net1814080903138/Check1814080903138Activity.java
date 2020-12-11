package edu.hzuapps.androidlabs.net1814080903138;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Check1814080903138Activity extends AppCompatActivity {
    private ListView mLV;
//    String data = getIntent().getStringExtra("data");
    String data;
    String[] myitem = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check1814080903138);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                Check1814080903138Activity.this, android.R.layout.simple_list_item_1,myitem);
        ListView listView = (ListView) findViewById(R.id.mlist);
        listView.setAdapter(adapter);
    }
}