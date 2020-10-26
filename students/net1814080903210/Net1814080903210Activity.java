package edu.hzuapp.androidlabs.net1814080903210;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Net1814080903210Activity extends AppCompatActivity {
    String[] news={
            "新闻1","新闻2","新闻3","新闻4","新闻5","新闻6",
    };
    int image=R.drawable.news;
    Net1814080903210Activity _this=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.list_view);
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        for(int i=0;i<news.length;i++){
            Map<String,Object> map=new HashMap();
            map.put("text",news[i]);
            map.put("image",image);
            list.add(map);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.activity_main_item,new String[]{"text","image"},new int[]{R.id.text_view,R.id.image_view});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(_this,NewsInfoActivity.class);
                _this.startActivity(intent);
            }
        });
    }
}
