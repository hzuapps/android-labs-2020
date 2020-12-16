package edu.hzuapps.androidlabs.net1814080903202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import java.util.Random;

public class Comment1814080903202Activity extends AppCompatActivity implements View.OnClickListener{
    private Button send;
    private ImageButton back;
    private ImageButton scan;
    private ListView listView;
    private EditText editcontent;
    private SimpleAdapter simpleAdapter;
    private List<Map<String,Object>> resultlist;
    private int[] head = {R.drawable.head1,R.drawable.head2,R.drawable.head3,R.drawable.ghost};
    private String[] name = {"Lunette","viices","Themagicians","Ghost"};
    private DatabaseHelper databaseHelper = new DatabaseHelper(this,"comment.db",null,1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment1814080903202);
        send = findViewById(R.id.send);
        back = findViewById(R.id.back);
        scan = findViewById(R.id.scan);
        back.setOnClickListener(this);
        scan.setOnClickListener(this);
        send.setOnClickListener(this);
        listView = findViewById(R.id.CommentList);
        editcontent = findViewById(R.id.content);
        query();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                onBackPressed();
                break;
            case R.id.scan:
                Intent intent = new Intent(this, Scan1814080903202Activity.class);
                startActivity(intent);
                break;
            case R.id.send:
                String content = editcontent.getText().toString();
                if(content.equals("")){
                    Toast.makeText(Comment1814080903202Activity.this,"发送内容为空！",Toast.LENGTH_LONG).show();
                }else{
                    Date date = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String time = simpleDateFormat.format(date);
                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    Random random = new Random();
                    int rand = random.nextInt(4);
                    values.put("name",name[rand]);
                    values.put("time",time);
                    values.put("content",content);
                    values.put("head",head[rand]);
                    long res = db.insert("comments",null,values);
                    if(res>0){
                        Toast.makeText(Comment1814080903202Activity.this,"发送成功！",Toast.LENGTH_LONG).show();
                        query();
                    }else{
                        Toast.makeText(Comment1814080903202Activity.this,"发送失败！",Toast.LENGTH_LONG).show();
                    }
                    db.close();
                    editcontent.setText("");
                }
                break;
        }
    }

    private void query(){
        resultlist = new ArrayList<>();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.query("comments",null,null,null,null,null,null);
        while (cursor.moveToNext()){
            Map<String,Object> map = new HashMap<>();
            CommentBean commentBean = new CommentBean(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3));
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
        cursor.close();
        db.close();
    }
} 