package edu.hzuapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ReadActivity extends AppCompatActivity {
    String[] recorded={"这是第一段话","这是第二段话","这是第三段话","这是第四段话","这是第五段话"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, recorded);
        ListView listView = (ListView) findViewById(R.id.listview1);
        listView.setAdapter(adapter);


    }

}
