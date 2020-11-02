package edu.hzuapps.androidlabs.Net1814080903110;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;

public class Net1814080903110Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903110);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(Net1814080903110Activity.this, SettingActivity.class);
                                          startActivity(intent);
                                      }
                                  });
        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Net1814080903110Activity.this, RemindActivity.class);
                startActivity(intent);
            }
        });

        ListView lv = (ListView) findViewById(R.id.dates);

        ArrayAdapter s1 = new ArrayAdapter<String>(this, R.layout.listview_item, mobileArray);

        lv.setAdapter(s1);


        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        };
        lv.setOnItemClickListener(listener);
    }

    String[] mobileArray = { //
            "日程一", "日程二", "日程三", "日程四"
    };

}



