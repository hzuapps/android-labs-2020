package edu.hzuapps.androidlabs.net1814080903219;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

public class PhysicalScoreActivity extends AppCompatActivity {

    private ListView listView;
    private Button returnBtn;
    private ImageButton returnImgBtn;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private TextView tv9;
    private Gson gson;
    private GsonBuilder builder;
//    private PhysicalScore physicalScore = new PhysicalScore(172,55,3985,7,218,18,240,10,70);
    private PhysicalScore physicalScore = null;

    private BaseAdapter adapter = new BaseAdapter() {
        private LayoutInflater inflater;
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;
            inflater = getLayoutInflater();

            if (convertView == null) {
                view = inflater.inflate(R.layout.listview_item,null);
            } else {
                view = convertView;
            }
            tv1 = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            tv3 = view.findViewById(R.id.tv3);
            tv4 = view.findViewById(R.id.tv4);
            tv5 = view.findViewById(R.id.tv5);
            tv6 = view.findViewById(R.id.tv6);
            tv7 = view.findViewById(R.id.tv7);
            tv8 = view.findViewById(R.id.tv8);
            tv9 = view.findViewById(R.id.tv9);

            tv1.setText("身高(cm)："+physicalScore.getHigh());
            tv2.setText("体重(kg)："+physicalScore.getWeight());
            tv3.setText("肺活量(ml)："+physicalScore.getVitalCapacity());
            tv4.setText("50米跑(s)："+physicalScore.getRun50Time());
            tv5.setText("立定跳远(cm)："+physicalScore.getJump());
            tv6.setText("坐位体前屈(cm)："+physicalScore.getTouch());
            tv7.setText("1000米跑(s)："+physicalScore.getRun1000Time());
            tv8.setText("引体向上(次)："+physicalScore.getUpCount());
            tv9.setText("总分："+physicalScore.getTotalScore());
            return view;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_score);
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        builder=new GsonBuilder();
        gson=builder.create();
        listView = findViewById(R.id.score_lv);
        listView.setAdapter(adapter);
        returnBtn = this.findViewById(R.id.btn_return);
        returnImgBtn = this.findViewById(R.id.imgbtn_return);

        runOnUiThread(new Runnable() {

            @Override
            public void run() {
//                 1. 从网络获取 JSON 内容
                String jsonText = getGitHubIssues();
                if (jsonText != null) {
                    try { // 2. 解析JSON
                        JSONArray jsonArr = new JSONArray(jsonText);
                        for(int i = 0; i < jsonArr.length(); i++){
                            Object obj = jsonArr.get(i);
                            String str = obj.toString();
                            //利用Gson将其转化为实体类(Course类)
                            physicalScore = gson.fromJson(str, PhysicalScore.class);
//                            System.out.println("1312321321321321321323");
                            System.out.println(physicalScore);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        returnImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private String getGitHubIssues() {
        String gitApi = "http://49.234.91.116:8080/examples/physicalScore.json";
        URL url = null;
        String jsonText = null;
        try {
            url = new URL(gitApi);
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