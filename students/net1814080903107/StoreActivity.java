package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.net.Inet4Address;

public class StoreActivity extends AppCompatActivity {
    boolean flag=false;
    ListView listView;
    String storeName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Intent i=getIntent();
        listView=findViewById(R.id.chooseList);
        //set store name
        TextView textView=findViewById(R.id.storeName);
        textView.setText(i.getStringExtra("title"));
        storeName=i.getStringExtra("id");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v=null;
                switch (position){
                    case 0:
                        v=findViewById(R.id.mainView);
                        break;
                    case 1:
                        v=findViewById(R.id.sideView);
                        break;
                    case 2:
                        v=findViewById(R.id.snackView);
                        break;
                }
                //置顶
                v.bringToFront();
            }
        });
    }
    public void click(View v){
        Intent it=new Intent();
        it.setType("video/*");
        startActivityForResult(it,101);
    }
    protected void onActivityResult(int reqCode,int resCode,Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (resCode == Activity.RESULT_OK)
            flag=true;
    }

}