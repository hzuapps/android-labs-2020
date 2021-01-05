package edu.hzuapps.androidlabs.net1814080903127;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class RemindActivity extends AppCompatActivity {
    RemindActivity _this=this;
    private ListView textList;
    private SQLiteDatabase sqLiteDatabase;
    private NoteAdapter noteAdapter;
    private RemindAdapter remindAdapter;
    private List<Note> list;
    private Note textItem;
    private int itemID;

    public void refresh(){
        RemindDBHelper db=new RemindDBHelper(_this);
        sqLiteDatabase=db.getReadableDatabase();
        //获取数据
        list=db.querydata(sqLiteDatabase);
        remindAdapter=new RemindAdapter(_this,list);
        textList=findViewById(R.id.textlist);
        textList.setAdapter(remindAdapter);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remind);
        this.setTitle("待办");
        refresh();
        Button button=findViewById(R.id.RemindAdd);
        final RemindActivity R=this;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(R,RemindAdd.class);
                startActivity(intent);
            }
        });
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
                                RemindDBHelper db=new RemindDBHelper(_this);
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
    }
}
