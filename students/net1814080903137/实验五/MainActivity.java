package edu.hzuapps.androidlabs.net1814080903137;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.database.sqlite.SQLiteException;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private NoteDatabase dbHelper;
    //private PlanDatabase planDatabase;

//    private Context context=this;
    final String TAG = "tag";
    FloatingActionButton btn;
    private String edit;
//    TextView tv;
//    private ListView lv;
//    private NoteAdapter adapter;
//    private List<Note> noteList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (FloatingActionButton) findViewById(R.id.fab);
//        tv=findViewById(R.id.tv);//对应activity.xml的TiexView
//        lv=findViewById(R.id.lv);
//        adapter=new NoteAdapter(getApplicationContext(),noteList);
//        refreshListView();
//        lv.setAdapter(adapter);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditActivity.class);//intent相当于一个信号
                startActivityForResult(intent,0);//传输intent启动edit
            }
        });
    }
    //接收startActivityForResult传输的结果
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){//data存储从edit传输过来的信息
        super.onActivityResult(requestCode,resultCode,data);
        String content=data.getStringExtra("input");
        Log.d(TAG,edit);
//        String time=data.getStringExtra("time");
//        Note note=new Note(content,time,1);
//        CRUD op=new CRUD(context);
//        op.open();
//        op.addNote(note);
//        op.close();
//        refreshListView();
    }

//    public void refreshListView(){
//        CRUD op=new CRUD(context);
//        op.open();
//        if (noteList.size()>0)noteList.clear();
//        noteList.addAll(op.getAllNotes());
//        op.close();
//        adapter.notifyDataSetChanged();
//    }

}