package edu.hzuapps.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Net1814080903333StudentsInformationActivity2 extends AppCompatActivity implements View.OnClickListener {
   private Button home01,add,delete,query,update;
   private  EditText stuname,coursename,classtime;
   private  TextView textView;
   private ContentValues values;
   private String name,course,time;
   private MyHelper helper;
   private SQLiteDatabase db;
   private Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentsinformationactivity2_net1814080903333);
        helper=new myHelper(this);
        init();
    }

    private void init() {
        stuname = (EditText) findViewById(R.id.edit00);
        textView = (TextView) findViewById(R.id.studenttext);
        coursename = (EditText) findViewById(R.id.edit11);
        classtime = (EditText) findViewById(R.id.edit22);
        add = (Button) findViewById(R.id.button00);
        update = (Button) findViewById(R.id.button11);
        home01 = (Button) findViewById(R.id.button22);
        query = (Button) findViewById(R.id.button33);
        delete = (Button) findViewById(R.id.button44);
        add.setOnClickListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);
        home01.setOnClickListener(this);
        query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button22:
                    Intent intent1 = new Intent(Net1814080903333StudentsInformationActivity2.this, MainActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.button00:
                    name = stuname.getText().toString();
                    course = coursename.getText().toString();
                    time = classtime.getText().toString();
                    if (name.equals("")||course.equals("")&&time.equals(""))
                    {
                        Toast.makeText(this, "请输入数据!!!", Toast.LENGTH_LONG).show();
                    }else{
                    db = helper.getReadableDatabase();
                    values = new ContentValues();
                    values.put("stuname", name);
                    values.put("courses", course);
                    values.put("classtime", time);
                    db.insert("StuImformation", null, values);
                    Toast.makeText(this, "添加成功！", Toast.LENGTH_LONG).show();
                    db.close();
                    break;}
                case R.id.button33:
                    db = helper.getReadableDatabase();
                    cursor = db.query("StuImformation",null,null,null,null,null,null);
                    if (cursor.getCount() == 0) {
                        textView.setText("");
                        Toast.makeText(this, "没有数据！！！", Toast.LENGTH_LONG).show();
                    } else {
                        cursor.moveToFirst();
                                textView.setText("Name:"+cursor.getString(0)+"\t"+"Course:"+cursor.getString(1)+"\t"+"Date:"+cursor.getString(2));
                    }
                    while (cursor.moveToNext()) {
                        textView.append("\n"+"Name:"+ cursor.getString(0)+"\t"+"Course:" + cursor.getString(1)+"\t"+ "Date:" + cursor.getString(2));
                    }
                    cursor.close();
                    db.close();
                    break;
                case R.id.button44:
                    db=helper.getWritableDatabase();
                    db.delete("StuImformation","classtime=? and stuname=?",new String[]{classtime.getText().toString(),stuname.getText().toString()});
                    Toast.makeText(this, "删除成功！", Toast.LENGTH_LONG).show();
                    cursor = db.query("StuImformation",null,null,null,null,null,null);
                        cursor.moveToFirst();
                        textView.setText("Name:"+cursor.getString(0)+"\t"+"Course:"+cursor.getString(1)+"\t"+"Date:"+cursor.getString(2));
                    while (cursor.moveToNext()) {
                        textView.append("\n"+"Name:"+ cursor.getString(0)+"\t"+"Course:" + cursor.getString(1)+"\t"+ "Date:" + cursor.getString(2));
                    }
                    cursor.close();
                    db.close();
                    break;
                case R.id.button11:
                    db=helper.getWritableDatabase();
                    values=new ContentValues();
                    values.put("stuname",name=stuname.getText().toString());
                    values.put("courses", course=coursename.getText().toString());
                    values.put("classtime", time=classtime.getText().toString());
                   db.update("StuImformation",values,"stuname=?",new String[]{stuname.getText().toString()});
                    db.close();
                    Toast.makeText(this, "更新成功！", Toast.LENGTH_LONG).show();

                    break;

            }
        }

    }

