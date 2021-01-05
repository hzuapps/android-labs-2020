package edu.hzuapps.androidlabs.net1814080903138;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Check1814080903138Activity extends AppCompatActivity {
    private ListView mLV;
    private SQLiteDatabase db;


//    String data = getIntent().getStringExtra("data");
//    String data;
//    String[] myitem = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check1814080903138);
        mLV = findViewById(R.id.mlist);
        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()
                + "/my.db3", null);
//        TextView textView1 = findViewById(R.id.tv_tz);
        String hwname = getIntent().getStringExtra("data");
        String hwfinish = "未完成";
        System.out.println(hwname);
        System.out.println(hwfinish);
        try {
//            if (hwname != "") {
                insertData(db, hwname, hwfinish);

                Cursor cursor = db.rawQuery("select * from tb_hw", null);

                inflateListView(cursor);
//            }

        } catch (Exception e) {
//            if (hwname != "") {


                String sql = "create table tb_hw(_id integer primary key autoincrement,db_hwname varchar(20),db_hwfinish varchar(50))";
                System.out.println("已进行");

                db.execSQL(sql);

                insertData(db, hwname, hwfinish);

                Cursor cursor = db.rawQuery("select * from tb_hw", null);

                inflateListView(cursor);
            }
        }

//    }
// 向数据库中插入数据
private void insertData (SQLiteDatabase db, String hwname, String hwfinish){
    db.execSQL("insert into tb_hw values (null,?,?)", new String[]{hwname,
            hwfinish});
    System.out.println("------------------");
}

    // 向ListView中填充数据
    @SuppressLint("NewApi")
    public void inflateListView (Cursor cursor){
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(Check1814080903138Activity.this,
                    R.layout.mytextview, cursor, new String[]{"db_hwname",
                    "db_hwfinish"},
                    new int[]{R.id.list_hwname, R.id.lsit_hwfinish},
                    CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);


            mLV.setAdapter(adapter);

    }

    @Override
    protected void onDestroy () {

        super.onDestroy();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }
}
