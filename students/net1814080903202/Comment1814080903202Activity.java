package edu.hzuapps.androidlabs.net1814080903202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Comment1814080903202Activity extends AppCompatActivity implements View.OnClickListener{
    private Button send;
    private ImageButton back;
    private ImageButton scan;
    private ListView listView;
    private EditText editcontent;
    private SimpleAdapter simpleAdapter;
    private static List<Map<String,Object>> resultlist;
    private List<CommentBean> list;
    private int[] head = {R.drawable.head1,R.drawable.head2,R.drawable.head1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment1814080903202);
        send = findViewById(R.id.send);
        back = findViewById(R.id.back);
        scan = findViewById(R.id.scan);
        back.setOnClickListener(this);
        scan.setOnClickListener(this);
        listView = findViewById(R.id.CommentList);
        editcontent = findViewById(R.id.content);
        if(resultlist == null){
            resultlist = new ArrayList<>();
            init();
            for(CommentBean commentBean : list){
                Map<String,Object> map = new HashMap<>();
                map.put("name",commentBean.getName());
                map.put("time",commentBean.getTime());
                map.put("content",commentBean.getContent());
                map.put("head",commentBean.getHead());
                resultlist.add(map);
            }
            simpleAdapter = new SimpleAdapter(Comment1814080903202Activity.this,resultlist,
                    R.layout.comment_listview_item,
                    new String[]{"name","time","content","head"},new int[]{R.id.name,R.id.time,R.id.content,R.id.head});
            listView.setAdapter(simpleAdapter);
        }else{
            simpleAdapter = new SimpleAdapter(Comment1814080903202Activity.this,resultlist,
                    R.layout.comment_listview_item,
                    new String[]{"name","time","content","head"},new int[]{R.id.name,R.id.time,R.id.content,R.id.head});
            listView.setAdapter(simpleAdapter);
        }

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editcontent.getText().toString();
                if(content.equals("")){
                    Toast.makeText(Comment1814080903202Activity.this,"发送内容为空！",Toast.LENGTH_LONG).show();
                }else{
                    CommentBean commentBean = new CommentBean();
                    commentBean.setName("Ghost");
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    commentBean.setTime(simpleDateFormat.format(date));
                    commentBean.setContent(content);
                    commentBean.setHead(R.drawable.ghost);
                    list.add(commentBean);
                    Map<String,Object> map = new HashMap<>();
                    map.put("name",commentBean.getName());
                    map.put("time",commentBean.getTime());
                    map.put("content",commentBean.getContent());
                    map.put("head",commentBean.getHead());
                    resultlist.add(map);
                    simpleAdapter.notifyDataSetChanged();
                    Toast.makeText(Comment1814080903202Activity.this,"发送成功！",Toast.LENGTH_LONG).show();
                    editcontent.setText("");
                }
            }
        });
    }
    private void init(){
        list = new ArrayList<>();
        CommentBean commentBean1 = new CommentBean("Lunette","2020/10/31 12:21:11","今天天气怎么样？",R.drawable.head1);
        CommentBean commentBean2 = new CommentBean("viices","2020/11/1 10:01:51","有人在学校吗？",R.drawable.head2);
        CommentBean commentBean3 = new CommentBean("tillsunrise","2020/11/8 9:12:45","有人去吃饭吗？",R.drawable.head3);
        list.add(commentBean1);
        list.add(commentBean2);
        list.add(commentBean3);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.scan:
                intent = new Intent(this, Scan1814080903202Activity.class);
                startActivity(intent);
                break;
        }
    }
}