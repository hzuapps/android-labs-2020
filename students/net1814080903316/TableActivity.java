package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TableActivity extends AppCompatActivity {
    Context context=this;

    String[] weekArrays = { //
            "星期一", "星期二", "星期三", "星期四",
            "星期五", "星期六", "星期天"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.item,R.id.textView, weekArrays);

        AdapterView.OnItemClickListener messageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id)
            {

                Intent intent=new Intent(context, CourseActivity.class);
                int week=position+1;
                intent.putExtra("week","星期"+week);
                startActivity(intent);

            }
        };
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setOnItemClickListener(messageClickedHandler);
        listView.setAdapter(adapter);/* */
    }


}
