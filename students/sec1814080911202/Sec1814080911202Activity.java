package edu.hzuapps.androidlabs.sec1814080911202;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Time;

public class Sec1814080911202Activity extends AppCompatActivity implements View.OnClickListener {

    static final String db_name = "bookDB";
    static final String tb_name = "book";
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sec_1814080911202_activity);

        final Sec1814080911202Activity thisActivity = this;

        Button borrowBtn = (Button) findViewById(R.id.button_borrow);
        borrowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, BorrowActivity.class);
                startActivity(intent);
            }
        });

        Button manageBtn = (Button) findViewById(R.id.button_manage);
        manageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 显式打开一个Activity
                Intent intent = new Intent(thisActivity, ManageActivity.class);
                startActivity(intent);
            }
        });

        initDatabase();

    }

    protected void initDatabase(){
        DatabaseHelper dbHelp = new DatabaseHelper(Sec1814080911202Activity.this,
                db_name,null,1);
//        dbHelp.onCreate(db);
        db = dbHelp.getWritableDatabase();

        insert("内网安全攻防");
        insert("web安全攻防");
        insert("SQL注入攻击与防御");
        insert("从0到1：CTFer成长之路");
        insert("逆向工程");

    }

    private void insert(String bookname){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", bookname);
        contentValues.put("isborrow", "0");
        db.insert(tb_name, null, contentValues);
    }

    @Override
    public void onClick(View v) {

    }
}