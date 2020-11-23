package edu.hzuapp.androidlabs.net1814080903210;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
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
            "5G流量和WiFi6的最全科普,以后你都离不开","市值2.13万亿,韩国最大集团三星,放在我国是什么水平"
            ,"苹果又要出新品，这次的主角是?","JDG曝出LPL冬季转会第一天消息,没想到最先离开的是他","千金难买食谱大全!收藏好,别丢了!","DNF盘点游戏中一些特别搞笑的装备,你还记得吗?",
    };
    int image=R.drawable.news;
    Net1814080903210Activity _this=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveNews();
        ListView listView = findViewById(R.id.list_view);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Cursor c = getContentResolver() // 执行查询
                .query(NewsProvider.CONTENT_URI, null, null, null, null);
        while(c.moveToNext()) {
            String introduction="";
            String content="";//此页面不展示此内容
            int image=0;
            introduction = c.getString(c.getColumnIndex(NewsProvider.INTRODUCTION));
            content = c.getString(c.getColumnIndex(NewsProvider.CONTENT));
            image = c.getInt(c.getColumnIndex(NewsProvider.IMAGE));
            Map<String, Object> map = new HashMap();
            map.put("introduction", introduction);
            map.put("image", image);
            list.add(map);
        }
        final Net1814080903210Activity _this=this;
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,list,R.layout.activity_main_item,new String[]{"introduction","image"},new int[]{R.id.text_view,R.id.image_view});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(_this,NewsInfoActivity.class);
                _this.startActivity(intent);
            }
        });
    }
    public void saveNews(){
        for(int i=0;i<news.length;i++){
            ContentValues values=new ContentValues();
            values.put(NewsProvider.INTRODUCTION,news[i]);
            values.put(NewsProvider.CONTENT,"暂无内容，后面补充");
            values.put(NewsProvider.IMAGE,image);
            Uri uri = getContentResolver() // 执行插入操作
                    .insert(NewsProvider.CONTENT_URI, values);
        }
    }
}
