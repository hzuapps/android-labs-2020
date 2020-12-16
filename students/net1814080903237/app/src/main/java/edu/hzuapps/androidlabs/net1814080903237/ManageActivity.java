package edu.hzuapps.androidlabs.net1814080903237;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
public class ManageActivity extends AppCompatActivity{
private String[] data={"1","2","3"};
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                ManageActivity.this,android.R.layout.simple_list_item_1,data);

        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}

