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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Net1814080903210Activity extends AppCompatActivity {
//    String[] news={
////            "5G流量和WiFi6的最全科普,以后你都离不开","市值2.13万亿,韩国最大集团三星,放在我国是什么水平"
////            ,"苹果又要出新品，这次的主角是?","JDG曝出LPL冬季转会第一天消息,没想到最先离开的是他","千金难买食谱大全!收藏好,别丢了!","DNF盘点游戏中一些特别搞笑的装备,你还记得吗?",
////    };
    ArrayList<String>  titles=new ArrayList();
    int image=R.drawable.news;
    Net1814080903210Activity _this=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonText = getGitHubIssues();
                if (jsonText != null) {
                    try {
                        JSONArray jsonArr = new JSONArray(jsonText);
                        for(int i=0;i<jsonArr.length();i++) {
                            JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                            String title = jsonObj.getString("title");
                            titles.add(title);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        for(int i=0;i<titles.size();i++){
            ContentValues values=new ContentValues();
            values.put(NewsProvider.INTRODUCTION,titles.get(i));
            values.put(NewsProvider.CONTENT,"暂无内容，后面补充");
            values.put(NewsProvider.IMAGE,image);
            Uri uri = getContentResolver() // 执行插入操作
                    .insert(NewsProvider.CONTENT_URI, values);
        }
    }
    private String getGitHubIssues() {
        String gitApi = "https://raw.githubusercontent.com/Playerlhh/android-labs-2020/master/students/net1814080903210/titles";
        URL url = null;
        String jsonText = null;
        try {
            url = new URL(gitApi);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = URLDecoder.decode(lines, "utf-8");
                sb.append(lines);
            }
            jsonText = sb.toString();
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonText;
    }
}
