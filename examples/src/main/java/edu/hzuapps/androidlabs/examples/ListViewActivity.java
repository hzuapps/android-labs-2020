package edu.hzuapps.androidlabs.examples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.hzuapps.androidlabs.R;

public class ListViewActivity extends AppCompatActivity {

    String[] mobileArray = { //
            "Android", "iPhone", "WindowsMobile", "Blackberry",
            "WebOS", "Ubuntu", "Windows7", "Max OS X"
            //, "a", "b", "c", "d", "e", "f"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, //
                R.layout.activity_list_view_item, mobileArray);

        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        };
        listView.setOnItemClickListener(listener);
    }
}
