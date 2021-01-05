package edu.hzuapps.androidlabs.net1814080903105;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ShoppingActivity extends AppCompatActivity {

    ListView lv = null;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        final String receivedata=getIntent().getStringExtra("data");
        final TextView textView1 = (TextView) this.findViewById(R.id.commodity_name);
        textView1.setText(receivedata);
        final EditText editText1 = (EditText) this.findViewById(R.id.num);
        Button btn = (Button) this.findViewById(R.id.confirm);
        lv = (ListView) this.findViewById(R.id.lv);
        db = SQLiteDatabase.openOrCreateDatabase(this.getFilesDir().toString()
                + "/my.db3", null);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = textView1.getText().toString();
                String num = editText1.getText().toString();
                try {
                    insertData(db, name, num);
                    Cursor cursor = db.rawQuery("select * from table_info", null);
                    inflateListView(cursor);
                } catch (Exception e) {
                    String sql = "create table table_info(_id integer primary key autoincrement,name varchar(25),num varchar(20))";
                    db.execSQL(sql);
                    insertData(db, name, num);
                    Cursor cursor = db.rawQuery("select * from table_info", null);
                    inflateListView(cursor);
                }
            }
        });
    }

    // 向数据库中插入数据
    private void insertData(SQLiteDatabase db, String name, String num) {
        db.execSQL("insert into table_info values (null,?,?)", new String[] { name, num });
    }

    // 向ListView中填充数据
    public void inflateListView(Cursor cursor) {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(ShoppingActivity.this,
                R.layout.activity_splist_view_item, cursor, new String[] { "name", "num" },
                new int[] { R.id.listname, R.id.listnum },
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        lv.setAdapter(adapter);
    }
}
