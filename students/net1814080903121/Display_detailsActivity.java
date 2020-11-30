package edu.hzuapps.androidlabs.net1814080903121;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import db.DBHelper;

public class Display_detailsActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DBHelper helper=new DBHelper(this);

        Button btn_del;
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        Cursor c = helper.queryName(name);//定义光标
        String[] from={"_id","name","telephone","email","address"};
        int[] to={R.id.id,R.id.name_2,R.id.telephone,R.id.email,R.id.address};
        //SimpleCursorAdapter 一个简单的适配器，将游标中的数据映射到布局文件中的TextView控件或者ImageView控件中
        //from: 一个列名称列表，标志着绑定到视图的数据，如果游标不可用，则可为空
        //to: 用来展示from数组中数据的视图，如果游标不可用，则可为空
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(this,R.layout.display_details,c,from,to);
        ListView listView=getListView();
        //listview绑定数据适配器
        listView.setAdapter(adapter);

    }
}

