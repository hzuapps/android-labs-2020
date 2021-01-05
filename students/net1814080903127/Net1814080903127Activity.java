package edu.hzuapps.androidlabs.net1814080903127;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class Net1814080903127Activity extends AppCompatActivity {
    private ListView textList;
    private SQLiteDatabase sqLiteDatabase;
    private NoteAdapter noteAdapter;
    private List<Note> list;
    private Button addText;
    private int itemID;
    private Note textItem;
    final Net1814080903127Activity _this = this;
    public void refresh(){
        DBHelper db=new DBHelper(_this);
        sqLiteDatabase=db.getReadableDatabase();
        //获取数据
        list=db.querydata(sqLiteDatabase);
        noteAdapter=new NoteAdapter(_this,list);
        textList=findViewById(R.id.textlist);
        textList.setAdapter(noteAdapter);
        registerForContextMenu(textList);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textList=findViewById(R.id.textlist);
        refresh();

        //表项点击事件
        textList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemID=list.get(position).getId();
                textItem=list.get(position);
                textList.showContextMenu();
                Intent intent=new Intent(_this,AddActivity.class);
                Bundle bundle=new Bundle();
                String Update_Context=textItem.getContext();
                String Update_Title=textItem.getTitle();
                //传递数据
                bundle.putInt("id",itemID);
                bundle.putString("context",Update_Context);
                bundle.putString("title",Update_Title);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //长按删除
        textList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                itemID=list.get(position).getId();
                new AlertDialog.Builder(_this)
                        .setTitle("长按删除")
                        .setMessage("确定删除")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                DBHelper db=new DBHelper(_this);
                                sqLiteDatabase=db.getReadableDatabase();
                                db.delete(sqLiteDatabase,itemID);
                                refresh();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create().show();
                return true;
            }
        });

        //"新建便签"按钮事件
        addText = findViewById(R.id.RemindAdd);
        //final Net1814080903127Activity _this = this;
        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, AddActivity.class);
                _this.startActivity(intent);
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_this, RemindActivity.class);
                _this.startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        String title="提示";
        new AlertDialog.Builder(Net1814080903127Activity.this)
                .setTitle(title)
                .setMessage("确定退出吗？")
                .setPositiveButton("确定" ,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sqLiteDatabase.close();
                        finish();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).create().show();
    }

}
