package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Net814080903333TeacherHomeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button home01,add,delete,query,update;
    private EditText thname,stuname,totaltime;
    private TextView textView;
    private ContentValues values;
    private String name,course,time;
    private MyHelper helper;
    private SQLiteDatabase db;
    private Cursor cursor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacherhomehctivity_net1814080903333);
        helper=new myHelper(this);
        init();
    }

    private void init() {
        thname = (EditText) findViewById(R.id.edit0);
        textView = (TextView) findViewById(R.id.teachertext0);
        stuname = (EditText) findViewById(R.id.edit1);
        totaltime = (EditText) findViewById(R.id.edit2);
        add = (Button) findViewById(R.id.button);
        update = (Button) findViewById(R.id.button1);
        home01 = (Button) findViewById(R.id.button2);
        query = (Button) findViewById(R.id.button3);
        delete = (Button) findViewById(R.id.button4);
        add.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        home01.setOnClickListener(this);
        query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button2:
                Intent intent = new Intent(Net814080903333TeacherHomeActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.button:
                name = thname.getText().toString();
                course = stuname.getText().toString();
                time = totaltime.getText().toString();
                if (name.equals("")||course.equals("")&&time.equals(""))
                {
                    Toast.makeText(this, "请输入数据!!!", Toast.LENGTH_LONG).show();
                }else{
                    db = helper.getReadableDatabase();
                    values = new ContentValues();
                    values.put("teachername", name);
                    values.put("stuname", course);
                    values.put("totaltimes", time);
                    db.insert("TimeAndMoney", null, values);
                    Toast.makeText(this, "添加成功！", Toast.LENGTH_LONG).show();
                    db.close();
                    break;}
            case R.id.button3:
                db = helper.getReadableDatabase();
                cursor = db.query("TimeAndMoney",null,null,null,null,null,null);
                if (cursor.getCount() == 0) {
                    textView.setText("");
                    Toast.makeText(this, "没有数据！！！", Toast.LENGTH_LONG).show();
                } else {
                    cursor.moveToFirst();
                    textView.setText("Name:"+cursor.getString(0)+"\t"+"StuName:"+cursor.getString(1)+"\t"+"Totaltimes:"+cursor.getString(2));
                }
                while (cursor.moveToNext()) {
                    textView.append("\n"+"Name:"+ cursor.getString(0)+"\t"+"StuName:" + cursor.getString(1)+"\t"+ "Totaltimes:" + cursor.getString(2));
                }
                cursor.close();
                db.close();
                break;
            case R.id.button4:
                db=helper.getWritableDatabase();
                db.delete("TimeAndMoney","teachername=? and stuname=?",new String[]{thname.getText().toString(),stuname.getText().toString()});
                Toast.makeText(this, "删除成功！", Toast.LENGTH_LONG).show();
                cursor = db.query("TimeAndMoney",null,null,null,null,null,null);
                cursor.moveToFirst();
                textView.setText("Name:"+cursor.getString(0)+"\t"+"StuName:"+cursor.getString(1)+"\t"+"Totaltimes:"+cursor.getString(2));
                while (cursor.moveToNext()) {
                    textView.append("\n"+"Name:"+ cursor.getString(0)+"\t"+"StuName:" + cursor.getString(1)+"\t"+ "Totaltimes:" + cursor.getString(2));
                }
                cursor.close();
                db.close();
                break;
            case R.id.button1:
                db=helper.getWritableDatabase();
                values=new ContentValues();
                values.put("teachername",name=thname.getText().toString());
                values.put("stuname", course=stuname.getText().toString());
                values.put("totaltimes", time=totaltime.getText().toString());
                db.update("TimeAndMoney",values,"stuname=? and teachername=?",new String[]{stuname.getText().toString(),thname.getText().toString()});
                db.close();
                Toast.makeText(this, "更新成功！", Toast.LENGTH_LONG).show();

                break;

    }
}}