package edu.hzuapps.browers.bookmarks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import edu.hzuapps.browers.helper.FileHelper;
import edu.hzuapps.browers.R;
import edu.hzuapps.browers.webview.MyWebViewActivity;


public class BookmarksActivity extends AppCompatActivity {
    private FileHelper fileHelper;
    private List<Bookmark> bookmarkList = new ArrayList<Bookmark>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love_list);

        // 初始化书签数据
        try {
            initBookmarks();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ListView
        final BookmarkAdapter adapter = new BookmarkAdapter(
                // 上下文，即当前的activity
                BookmarksActivity.this,
                // 一条数据都显示在这个View中
                R.layout.bookmark_item,
                // 需要显示的数据
                bookmarkList
        );
        ListView listView  = (ListView) findViewById(R.id.list_bookmarks);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String webUrl = bookmarkList.get(i).getUrl();
                String title = bookmarkList.get(i).getTitle();
                // 点击访问网址
                Intent intent = new Intent(BookmarksActivity.this, MyWebViewActivity.class);
                // Bundle携带数据
                Bundle bundle = new Bundle();
                bundle.putString("webUrl",webUrl);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }


    private void initBookmarks() throws Exception {
        fileHelper = new FileHelper(getApplicationContext());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String jsonText = getBookmarks();
                if (jsonText != null) {
                    try {
                        JSONArray jsonArr = new JSONArray(jsonText);
                        for (int i =0;i!=jsonArr.length();++i){
                            JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                            String title = jsonObj.getString("title");
                            String url = jsonObj.getString("url");
                            Bookmark bookmark = new Bookmark(title,R.drawable.bookmark_icon,url);
                            bookmarkList.add(bookmark);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        String strs = this.fileHelper.read("bookmarks");
        if(!strs.isEmpty()){

            // 文件中有内容
            String[] contents = strs.split("￥");

            for(String jsonItem : contents){
                com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(jsonItem);
                String title = jsonObject.getString("title");
                String url = jsonObject.getString("url");

                Bookmark bookmark5 = new Bookmark(title,R.drawable.bookmark_icon,url);
                bookmarkList.add(0,bookmark5);
            }
        }

    }
    private String getBookmarks() {
        // 从服务器拉取json数据
        String gitApi = "http://8.135.70.148/bookmarks.json";
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonText;
    }
}