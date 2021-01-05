package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity1 extends AppCompatActivity {

    ListView listView;
    ListviewAdapter listviewAdapter;
    Database db = new Database();
    MainActivity1 that = this;

    ArrayList<ArrayList<String>> studentList = new ArrayList<ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        listView = (ListView)findViewById(R.id.mobile_list);

        listviewAdapter = new ListviewAdapter(this,db.getStudentList(that),db);
        listView.setAdapter(listviewAdapter);
    }
}