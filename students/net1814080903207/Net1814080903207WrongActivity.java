package edu.hzuapps.androidlabs.Net1814080903207;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Net1814080903207WrongActivity extends AppCompatActivity {

    private String[] datas = {"Activity n活动;热闹状况;活跃;活动","Activity n活动;热闹状况;活跃;活动","Activity n活动;热闹状况;活跃;活动","Activity n活动;热闹状况;活跃;活动","Activity n活动;热闹状况;活跃;活动"};
    private ArrayAdapter<String> adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrong);
        listView = (ListView) findViewById(R.id.ll1);
//        初始化适配器
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1,datas);
        listView.setAdapter(adapter);
    }

}