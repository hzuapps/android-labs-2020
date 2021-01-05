package edu.hzuapps.androidlabs.net1814080903202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.List;
import java.util.Map;

public class Moment1814080903202Activity extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;
    private ImageButton back;
    private ImageButton scan;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> resultlist;
    private Gson gson;
    private GsonBuilder gsonBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_moment1814080903202);
        listView = findViewById(R.id.MomentList);
        back = findViewById(R.id.back);
        scan = findViewById(R.id.scan);
        back.setOnClickListener(this);
        scan.setOnClickListener(this);
        gsonBuilder=new GsonBuilder();
        gson=gsonBuilder.create();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String jsonText = getJson();
                resultlist = gson.fromJson(jsonText,new TypeToken<List<Map<String,Object>>>(){}.getType());
                System.out.println(resultlist);
            }
        });
        simpleAdapter = new SimpleAdapter(Moment1814080903202Activity.this,resultlist,
                R.layout.moment_listview_item,
                new String[]{"name","time","head","content","img1","img2","img3"},
                new int[]{R.id.name,R.id.time,R.id.head,R.id.content,R.id.img1,R.id.img2,R.id.img3});
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data, String textRepresentation) {
                if (view instanceof ImageView) {
                    ImageView iv = (ImageView) view;
                    if(iv.getId() == R.id.head){
                        RequestOptions options = new RequestOptions().centerCrop() .transform(new RoundTransform(iv.getContext(),30));
                        Glide.with(iv.getContext()).load((String) data).apply(options).into(iv);
                    }else{
                        Glide.with(iv.getContext()).load((String) data).into(iv);
                    }
                    return true;
                }
                return false;
            }
        });
        listView.setAdapter(simpleAdapter);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()){
            case R.id.back:
                onBackPressed();
                break;
            case R.id.scan:
                intent = new Intent(this, Scan1814080903202Activity.class);
                startActivity(intent);
                break;
        }
    }

    private String getJson(){
        String jsonurl = "http://49.234.91.116:80/android/Moment.json";
        String jsonText = new String();
        try {
            URL url = new URL(jsonurl);
            // 创建网络连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // 以流的方式去读取网络数据：字符流 / 字节流
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()));
            String lines;
            StringBuffer sb = new StringBuffer("");
            while ((lines = reader.readLine()) != null) {
                lines = URLDecoder.decode(lines, "utf-8");
                sb.append(lines);
            }
            System.out.println(sb);
            jsonText = sb.toString();
            reader.close();
            // 断开连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText;
    }
}
