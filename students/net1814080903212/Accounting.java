package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.widget.Toast;
import java.util.Random;
import android.view.View.OnClickListener;


public class Accounting extends AppCompatActivity implements OnClickListener {

    private EditText timeInsert;
    private EditText numberInsert;
    private TextView tvQueryResult;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounting);

        //依靠DatabaseHelper的构造函数创建数据库
        DatabaseHelper dbHelper = new DatabaseHelper(Accounting.this, "test_db", null, 1);
        db = dbHelper.getWritableDatabase();

        initView();
    }
    private void initView() {
        Button accounting = findViewById(R.id.button_accounting);
        Button accountbook = findViewById(R.id.button_openAccountBook);
        Button btQuery = findViewById(R.id.bt_query);

        timeInsert = findViewById(R.id.ac_time);
        numberInsert = findViewById(R.id.ac_number);

        // 1个查询结果展示文本
        tvQueryResult = findViewById(R.id.tv_query_result);

        accounting.setOnClickListener(this);
        accountbook.setOnClickListener(this);
        btQuery.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        String timeData = timeInsert.getText().toString();
        String numberData = numberInsert.getText().toString();
        switch (v.getId()) {
            //记账按钮
            case R.id.button_accounting:
                //创建存放数据的ContentValues对象
                ContentValues values = new ContentValues();
                values.put("time", timeData);
                values.put("number", numberData);
                //数据库执行插入命令
                db.insert("accountbook", null, values);
                showAccountInfo(" "," ");
                break;
            case R.id.button_openAccountBook:
                final Accounting thisActivity = this;
                Intent intent = new Intent(thisActivity, AccountBook.class);
                thisActivity.startActivity(intent);
                break;
            case R.id.bt_query:
                //创建游标对象
                Cursor cursor = db.query("accountbook", new String[]{"time","number"}, null, null, null, null, null);
                //利用游标遍历所有数据对象（for循环中，建议使用StringBuilder替代String）
                //为了显示全部，把所有对象连接起来，放到TextView中
                StringBuilder tvData = new StringBuilder();
                while (cursor.moveToNext()) {number
                    String time = cursor.getString(cursor.getColumnIndex("time"));
                    String number = cursor.getString(cursor.getColumnIndex("number"));
                    tvData.append("\n账单日期").append(time).append(" 账单数目").append();
                }
                tvQueryResult.setText(tvData.toString());
                cursor.close(); // 关闭游标，释放资源
                break;
            default:
                break;
        }
    }
    private void showAccountInfo(String name, String tags) {
        ((EditText) findViewById(R.id.ac_time)).setText(name);
        ((EditText) findViewById(R.id.ac_number)).setText(tags);
    }

}