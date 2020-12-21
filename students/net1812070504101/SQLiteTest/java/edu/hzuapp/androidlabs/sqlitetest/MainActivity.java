package edu.hzuapp.androidlabs.sqlitetest2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

     private static DatabaseHelper DBHelper=null;
     private Util util=new Util();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper=new DatabaseHelper(this);
        SQLiteDatabase DB=DBHelper.getWritableDatabase();
        util.delete(DB);
        util.insert(DB);
        util.Query(DB);
    }
}
