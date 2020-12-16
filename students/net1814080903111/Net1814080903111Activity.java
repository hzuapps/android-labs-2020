
package edu.hzuapps.androidlabs.net1814080903111;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Net1814080903111Activity extends AppCompatActivity implements Runnable,View.OnClickListener {
    private Handler handler;
    private TextView textView;
    private Button btn_check,btn_signin;
    private String yearmonth,day;
    private SimpleDateFormat simpleDateFormat;
    final Net1814080903111Activity th = this;

    final private int record = 111;
    //数据库配置
    static final String db_name = "RecordDB";
    static final String tb_name = "RecordTB";
    SQLiteDatabase db;
    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.net_1814080903111_activity);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date date = new Date(System.currentTimeMillis());
        yearmonth = simpleDateFormat.format(date);
        simpleDateFormat = new SimpleDateFormat("dd");
        day =  simpleDateFormat.format(new Date(System.currentTimeMillis()));

        initView();
        checktoday();
        c =db.rawQuery("select * from " + tb_name ,null);
        while(c.moveToNext()){
            System.out.println(c.getString(0)+" "+c.getString(1));
        }
        handler = new Handler() {
            public void handleMessage(Message msg) {
                textView.setText("当前时间："+(String)msg.obj);
            }
        };
        new Thread(this).start();
    }
    private String getYearmonth(){
        simpleDateFormat = new SimpleDateFormat("yyyyMM");
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }
    private String getDay(){
        simpleDateFormat = new SimpleDateFormat("dd");
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }
    private void checktoday(){      //查看今天是否签到
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);  //有则访问 没则创建
        String createTable = "CREATE TABLE IF NOT EXISTS " +
                tb_name +
                "(yearmonth VARCHAR (6) not null," +
                " day VARCHAR (2) not null )" ;
        db.execSQL(createTable);

        c =db.rawQuery("select * from " + tb_name +" where yearmonth LIKE '"+yearmonth+"' and day LIKE '"+day+"'",null);
        while(c.moveToNext()){
            btn_signin.setText("今日已签到");
            btn_signin.setEnabled(false);
        }
        //db.delete(tb_name,"yearmonth=" + " 202010",null);测试删除语句
    }
    private void addData (String yearmonth,String day){
        ContentValues cv = new ContentValues(2);
        cv.put("yearmonth",yearmonth);
        cv.put("day",day);
        db.insert(tb_name,null,cv);
    }
    private void initView() {       //设置组件
        textView=(TextView) findViewById(R.id.tv_time);
        btn_signin=findViewById(R.id.btn_signin);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_signin:
                addData(yearmonth,day);
                btn_signin.setEnabled(false);
                btn_signin.setText("今日已签到");
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,record,2,"查看签到记录");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case record:
                Intent intent = new Intent(th,activity_record.class);
                th.startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            while(true){
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
                String str=sdf.format(new Date());
                handler.sendMessage(handler.obtainMessage(100,str));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}