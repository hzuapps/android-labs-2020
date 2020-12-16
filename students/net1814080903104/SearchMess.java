package edu.hzuapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchMess extends AppCompatActivity{
    private Button btn,btn1;
    private TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_mess);

        textview = findViewById(R.id.insert_edittext);
        textview.setTextSize(18);

        final DatabaseHelper mySql = new DatabaseHelper(this,"Character",null,5);
        btn = (Button)findViewById(R.id.button_search);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("btn","btn");
                mySql.getWritableDatabase();
                SQLiteDatabase db = mySql.getWritableDatabase();

                Cursor cursor = db.query("Character",null,null,null,null,null,null);
                String textview_data = "";
                while(cursor.moveToNext()){
                    String name = "角色名:"+cursor.getString(cursor.getColumnIndex("name"))+"\n"
                            +"职业："+ cursor.getString(cursor.getColumnIndex("profession"))+"\n"
                            +"等级："+cursor.getInt(cursor.getColumnIndex("level"))+"\n";
                    textview_data = textview_data + "\n" + name;
                }
                textview.setText(textview_data);

            }
        });

        btn1 = (Button) findViewById(R.id.button_return);
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SearchMess.this,Net1814080903104Activity.class);
                SearchMess.this.startActivity(intent);
            }
        });


    }
}