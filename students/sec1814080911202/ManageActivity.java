package edu.hzuapps.androidlabs.sec1814080911202;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static edu.hzuapps.androidlabs.sec1814080911202.Sec1814080911202Activity.db_name;
import static edu.hzuapps.androidlabs.sec1814080911202.Sec1814080911202Activity.tb_name;


public class ManageActivity extends AppCompatActivity{

    private ArrayList list = new ArrayList();
    private String[] data;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        updateList();

//        String[] data = (String[]) list.toArray(new String[list.size()]);

//        Log.i("3",data.toString());



        ((Button) findViewById(R.id.insert_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertBook();
            }
        });
        ((Button) findViewById(R.id.delete_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteBook();
            }
        });


    }

    // 更新listview
    private void updateList(){

        DatabaseHelper dbHelp = new DatabaseHelper(ManageActivity.this,
                db_name,null,1);
        SQLiteDatabase db = dbHelp.getWritableDatabase();

        String query = "SELECT `name` FROM book";

        Cursor cursor = db.rawQuery(query, null);
        list.clear();
        while (cursor.moveToNext()) {
            Log.i("1",cursor.getString(0));
            list.add(cursor.getString(0));
//            Log.i("2",cursor.getString(0));
        }
        data = (String[]) list.toArray(new String[list.size()]);
        arrayAdapter = new ArrayAdapter<String> (
                ManageActivity.this, android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.listview);

        listView.setAdapter(arrayAdapter);

    }

    private void insertBook(){
        DatabaseHelper dbHelp = new DatabaseHelper(ManageActivity.this,
                db_name,null,1);
        SQLiteDatabase db = dbHelp.getWritableDatabase();

        EditText book = findViewById(R.id.insert_text);
        String bookName = book.getText().toString();
//        System.out.println(bookName);
        book.setText("");


//        System.out.println("[+]" + bookName);
//        String sql = "INSERT INTO book('name','isborrow') VALUES(`bookName`,0)";
//        db.execSQL(sql);

        ContentValues contentValues = new ContentValues();
        contentValues.put("name",bookName);
        contentValues.put("isborrow",0);
        db.insert(tb_name,null,contentValues);

        updateList();

    }

    private void deleteBook(){
        DatabaseHelper dbHelp = new DatabaseHelper(ManageActivity.this,
                db_name,null,1);
        SQLiteDatabase db = dbHelp.getWritableDatabase();

        EditText book = findViewById(R.id.delete_text);
        String bookName = book.getText().toString();
        System.out.println(bookName);
        book.setText("");

//        String sql = "DELETE FROM `book` WHERE name = " + bookName;
//        db.execSQL(sql);

        db.delete("book","name=?",bookName.split(","));

        updateList();
    }




}