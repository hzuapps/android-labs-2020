package edu.hzuapps.androidlabs.net1814080903121;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import android.app.Activity;
import android.view.View;

import db.DBHelper;

public class DatabaseActivity extends Activity {
    private DBHelper db = null;
    private EditText et1,et2,et4,et5;
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        db = new DBHelper(this);
        et1=findViewById(R.id.name);
        et2=findViewById(R.id.telephone);

        et4=findViewById(R.id.email);
        et5=findViewById(R.id.address);
        b1=findViewById(R.id.btn_save1);
        b2=findViewById(R.id.btn_return1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty()||et2.getText().toString().isEmpty()||et4.getText().toString().isEmpty()||et5.getText().toString().isEmpty()){
                    Intent intent = new Intent(DatabaseActivity.this, displayActivity.class);
                    startActivity(intent);
                }

                else {
                    String Name = et1.getText().toString();
                    String Telephone = et2.getText().toString();
                    String Email = et4.getText().toString();
                    String Address = et5.getText().toString();
                    //使用ContenValues对象新增数据
                    ContentValues values = new ContentValues();
                    values.put("name", Name);//put(key,value) 插入数据到表
                    values.put("telephone", Telephone);
                    values.put("email", Email);
                    values.put("address", Address);
                    DBHelper helper = new DBHelper(getApplicationContext());
                    //将上述行数据插入到表
                    helper.insert(values);
                    Intent intent = new Intent(DatabaseActivity.this, displayActivity.class);
                    startActivity(intent);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

