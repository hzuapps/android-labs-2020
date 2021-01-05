package edu.hzuapps.androidlabs.net1814080903219;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class QueryScoreActivity extends AppCompatActivity {

    private Button queryBtn;
    private Button returnBtn;
    private ImageButton returnImgBtn;
    private ListView scorelist;
    private Spinner spinner;
    private List<Course> courses = new ArrayList<>();
    private TextView courseName;
    private TextView courseCredit;
    private TextView courseCategory;
    private TextView courseScore;
    private int sortWay = 0;
    private int sortItem = 0;
    private Gson gson;
    private GsonBuilder builder;

    private String[] sSortWay = {
            "成绩升序",
            "成绩降序",
            "学分升序",
            "学分降序",
    };
    private BaseAdapter adapter = new BaseAdapter() {
        private LayoutInflater inflater;
        @Override
        public int getCount() {
            return courses.size();
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
                view = inflater.inflate(R.layout.item_course,null);
            } else {
                view = convertView;
            }

            courseName = (TextView) view.findViewById(R.id.name);
            courseCredit = (TextView) view.findViewById(R.id.credit);
            courseCategory = (TextView) view.findViewById(R.id.category);
            courseScore = (TextView) view.findViewById(R.id.score);

            courseName.setText(courses.get(position).getName());
            courseCredit.setText(Integer.toString(courses.get(position).getCredit()));
            courseCategory.setText(courses.get(position).getCategory());
            courseScore.setText(Integer.toString(courses.get(position).getScore()));

            return view;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_score);
        queryBtn = this.findViewById(R.id.btn_query);
        returnBtn = this.findViewById(R.id.btn_return);
        returnImgBtn = this.findViewById(R.id.imgbtn_return);
        scorelist = findViewById(R.id.scorelist);
        spinner = findViewById(R.id.spinner);

        builder=new GsonBuilder();
        gson=builder.create();

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
                            Course c = gson.fromJson(str, Course.class);
                            courses.add(c);
//                            System.out.println("1312321321321321321323");
                            System.out.println(courses);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        query();
        spinner.setAdapter(new ArrayAdapter<String>(this.getApplicationContext(),R.layout.spinner_item,sSortWay));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sortWay = position % 2 == 0 ? 0 : 1;
                if(position < 2){
                    sortItem = 0;
                }else{
                    sortItem = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        queryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                query();
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

    private void query() {
        sortList();
        scorelist.setAdapter(adapter);
    }


    private void sortList() {
        for (int i=0; i<courses.size()-1; i++) {
            for (int j=0; j<courses.size()-i-1;j++) {
                int[] lj = new int[] {
                        courses.get(j).getScore(),
                        courses.get(j).getCredit(),
                };
                int[] lj1 = new int[]{
                        courses.get(j+1).getScore(),
                        courses.get(j+1).getCredit(),
                };

                if (sortWay == 0) {
                    if (lj[sortItem] > lj1[sortItem]) {
                        Course temp = courses.get(j);
                        courses.set(j,courses.get(j+1));
                        courses.set(j+1,temp);
                    }
                } else {
                    if (lj[sortItem] < lj1[sortItem]) {
                        Course temp = courses.get(j);
                        courses.set(j,courses.get(j+1));
                        courses.set(j+1,temp);
                    }
                }
            }
        }
        System.out.println("排序完"+courses);
    }

    private String getGitHubIssues() {
        String gitApi = "http://49.234.91.116:8080/examples/course.json";
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

    //将之前的测试数据注释掉
    /*private void createCourseList() {
        Course c1 = new Course("数据库系统概论",2,"必修",93);
        Course c2 = new Course("JAVA程序设计",3,"必修",90);
        Course c3 = new Course("Android应用开发",2,"选修",95);
        Course c4 = new Course("Linux操作系统",5,"选修",91);
        courses.add(c1);
        courses.add(c2);
        courses.add(c3);
        courses.add(c4);
    }*/

}