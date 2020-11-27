package edu.hzuapps.androidlabs.net1814080903121;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import db.DBHelper;

/**
 * Created by 533 on 2018/5/26.
 */

public class displayActivity extends ListActivity {
    public EditText et;
    SQLiteDatabase sqLiteDatabase;
    private AlertDialog.Builder createAlertDialog(int icDialogAlert, String string) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(icDialogAlert);
        builder.setTitle(string);
        builder.setNegativeButton("取消", null);
        return builder;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        final DBHelper helper=new DBHelper(this);
        Cursor c = helper.queryAll();//定义光标
        String[] from={"_id","name","telephone","email","address"};
        int[] to={R.id.id,R.id.name_1};
        //SimpleCursorAdapter 一个简单的适配器，将游标中的数据映射到布局文件中的TextView控件或者ImageView控件中
        //from: 一个列名称列表，标志着绑定到视图的数据，如果游标不可用，则可为空
        //to: 用来展示from数组中数据的视图，如果游标不可用，则可为空
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.display,c,from,to);
        ListView listView=getListView();
        //listview绑定数据适配器
        listView.setAdapter(adapter);
        //构建对话框builder
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        final AlertDialog.Builder builder1=new AlertDialog.Builder(this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(final AdapterView<?> adapterView, View view, final int i, long l) {


                final SQLiteCursor sqlitecursor= (SQLiteCursor) adapterView.getAdapter().getItem(i);
                final long temp=l;
                final String[] options = new String[] { "详细信息", "删除" ,"删除所有联系人"};
                builder.show();
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog , int which) {
                        switch (which) {
                            case 0:
                                Intent intent = new Intent(displayActivity.this, display_detailsActivity.class);

                                String name=sqlitecursor.getString(1);

                                Log.v("*this",name);
                                intent.putExtra("name",name);
                                startActivity(intent);
                                break;
                             //删除记录
                            case 1:
                                builder1.setMessage("是否删除记录？").setPositiveButton("是", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        helper.delete((int)temp);
                                        Cursor c=helper.queryAll();
                                        String[] from={"_id","name","telephone","phone","email","address"};
                                        int[] to={R.id.id,R.id.name_1};
                                        SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.display,c,from,to);
                                        ListView listView=getListView();
                                        listView.setAdapter(adapter);
                                    }
                                }).setNegativeButton("否", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                AlertDialog ad1=builder1.create();
                                ad1.show();
                                break;
                            default:
                                break;
                            case 2:
                                helper.delete_all();
                                String[] from={"_id","name","telephone","phone","email","address"};
                                int[] to={R.id.id,R.id.name_1};
                                Cursor c=helper.queryAll();
                                SimpleCursorAdapter adapter=new SimpleCursorAdapter(getApplicationContext(),R.layout.display,c,from,to);
                                ListView listView=getListView();
                                listView.setAdapter(adapter);
                        }
                    }
                });
            }
        });
        helper.close();
    }
}



