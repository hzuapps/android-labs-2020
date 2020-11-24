package edu.hzuapps.androidlabs;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
///data/data/edu.hzuapps.androidlabs/databases/shop.db
public class CountActivity extends AppCompatActivity implements View.OnClickListener{

    TextView click_leibie;
    TextView total_leibie;
    TextView total_money;
    TextView tb_note_date;
    TextView total_time;
    TextView tb_calc_num_0;
    TextView tb_calc_num_dot;
    TextView tb_calc_num_1;
    TextView tb_calc_num_2;
    TextView tb_calc_num_3;
    TextView tb_calc_num_4;
    TextView tb_calc_num_5;
    TextView tb_calc_num_6;
    TextView tb_calc_num_7;
    TextView tb_calc_num_8;
    TextView tb_calc_num_9;
    TextView tb_calc_num_done;
    TextView moneyTv;
    TextView tb_note_cash;


    ImageView goto_show;
    ImageView tb_calc_num_del;
    ImageView tb_note_clear;

    EditText total_note;

    //计算器
    private boolean isDot;
    private String num = "0";
    private String dotNum = ".00";
    private final int MAX_NUM = 9999999;
    private final int DOT_NUM = 2;
    private int count = 0;

    // 数据库
    MyHelper myHelper;

    final CountActivity thisActivity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
        init();
    }

    public void init(){
        // 初始化
        click_leibie = findViewById(R.id.click_leibie);
        total_leibie = findViewById(R.id.total_leibie);
        tb_note_date = findViewById(R.id.tb_note_date);
        total_time = findViewById(R.id.total_time);
        goto_show = findViewById(R.id.goto_show);
        tb_note_cash = findViewById(R.id.tb_note_cash);
        total_money = findViewById(R.id.total_money);
        total_note = findViewById(R.id.total_note);

        // 计算器
        tb_calc_num_dot = findViewById(R.id.tb_calc_num_dot);
        tb_calc_num_0 = findViewById(R.id.tb_calc_num_0);
        tb_calc_num_1 = findViewById(R.id.tb_calc_num_1);
        tb_calc_num_2 = findViewById(R.id.tb_calc_num_2);
        tb_calc_num_3 = findViewById(R.id.tb_calc_num_3);
        tb_calc_num_4 = findViewById(R.id.tb_calc_num_4);
        tb_calc_num_5 = findViewById(R.id.tb_calc_num_5);
        tb_calc_num_6 = findViewById(R.id.tb_calc_num_6);
        tb_calc_num_7 = findViewById(R.id.tb_calc_num_7);
        tb_calc_num_8 = findViewById(R.id.tb_calc_num_8);
        tb_calc_num_9 = findViewById(R.id.tb_calc_num_9);
        tb_calc_num_del = findViewById(R.id.tb_calc_num_del);
        tb_calc_num_done = findViewById(R.id.tb_calc_num_done);
        moneyTv = findViewById(R.id.tb_note_money);
        tb_note_clear = findViewById(R.id.tb_note_clear);

        myHelper = new MyHelper(this);// 初始化数据库加载


        // 添加监视器
        click_leibie.setOnClickListener(this);
        tb_note_date.setOnClickListener(this);
        goto_show.setOnClickListener(this);
        tb_calc_num_dot.setOnClickListener(this);
        tb_calc_num_0.setOnClickListener(this);
        tb_calc_num_1.setOnClickListener(this);
        tb_calc_num_2.setOnClickListener(this);
        tb_calc_num_3.setOnClickListener(this);
        tb_calc_num_4.setOnClickListener(this);
        tb_calc_num_5.setOnClickListener(this);
        tb_calc_num_6.setOnClickListener(this);
        tb_calc_num_7.setOnClickListener(this);
        tb_calc_num_8.setOnClickListener(this);
        tb_calc_num_9.setOnClickListener(this);
        tb_calc_num_del.setOnClickListener(this);
        tb_calc_num_done.setOnClickListener(this);
        moneyTv.setOnClickListener(this);
        tb_note_clear.setOnClickListener(this);
        tb_note_cash.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String times;
        String type;
        String node;
        String money;
        SQLiteDatabase db;// 创建数据库
        ContentValues values;

        switch (v.getId()){
            case R.id.tb_note_date:
                Date date=new Date();
                SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                total_time.setText(formatter.format(date));
                break;
            case R.id.click_leibie:
                System.out.println("asd");
                // 对话框架
                final String[] str = new String[]{"饮食", "学习", "购物", "出行","其它"};

                new AlertDialog.Builder(thisActivity)
                        .setTitle("请选择消费类别")
                        .setIcon(R.mipmap.ic_launcher)
                        .setSingleChoiceItems(str, 4,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        total_leibie.setText(str[which]);
                                    }
                                })
                        .setPositiveButton("确定",null)
                        .show();
                break;
            case R.id.goto_show:
                Intent intent = new Intent(thisActivity, ShowActivity.class);
                thisActivity.startActivity(intent);
                break;
            case R.id.tb_note_cash:
                total_money.setText(moneyTv.getText());
                // 测试读数据库数据
//                db = myHelper.getReadableDatabase();
//                Cursor cursor = db.query("information",null,null,null,null,null,null);
//
//                System.out.println("sadsa");
//                while(cursor.moveToNext()){
//                    System.out.println(cursor.getInt(0)+ cursor.getString(1)+ cursor.getString(2)+ cursor.getInt(3)+cursor.getString(4));
//                }
//                cursor.close();
//                db.close();
                break;
            case R.id.tb_calc_num_done://确定
                // 添加数据
                times = (String) total_time.getText();
                type = (String) total_leibie.getText();
                node = total_note.getText().toString();
                money = (String) total_money.getText();

                db = myHelper.getWritableDatabase();// 写数据库
                values = new ContentValues();
                values.put("type", type);
                values.put("time", times);
                values.put("money", money);
                values.put("node", node);
                long information = db.insert("information", null, values); // 插入数据
                if (information>0)
                    Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.tb_calc_num_1:
                calcMoney(1);
                break;
            case R.id.tb_calc_num_2:
                calcMoney(2);
                break;
            case R.id.tb_calc_num_3:
                calcMoney(3);
                break;
            case R.id.tb_calc_num_4:
                calcMoney(4);
                break;
            case R.id.tb_calc_num_5:
                calcMoney(5);
                break;
            case R.id.tb_calc_num_6:
                calcMoney(6);
                break;
            case R.id.tb_calc_num_7:
                calcMoney(7);
                break;
            case R.id.tb_calc_num_8:
                calcMoney(8);
                break;
            case R.id.tb_calc_num_9:
                calcMoney(9);
                break;
            case R.id.tb_calc_num_0:
                calcMoney(0);
                break;
            case R.id.tb_calc_num_dot:
                if (dotNum.equals(".00")){
                    isDot = true;
                    dotNum = ".";
                }
                moneyTv.setText(num + dotNum);
                break;
            case R.id.tb_note_clear://清空
                num = "0";
                count = 0;
                dotNum = ".00";
                isDot = false;
                moneyTv.setText("0.00");
                break;
            case R.id.tb_calc_num_del://删除
                if (isDot){
                    if (count > 0){
                        dotNum = dotNum.substring(0, dotNum.length() - 1);
                        count--;
                    }
                    if (count == 0){
                        isDot = false;
                        dotNum = ".00";
                    }
                    moneyTv.setText(num  + dotNum);
                }else {
                    if (num.length() > 0)
                        num = num.substring(0, num.length() - 1);
                    if (num.length() == 0)
                        num = "0";
                    moneyTv.setText(num + dotNum);
                }
                break;
        }
    }

    /**
     * 计算器记数方法
     * @param money
     */
    private void calcMoney(int money) {
        if (num.equals("0") && money == 0)
            return;
        if (isDot) {
            if (count < DOT_NUM) {
                count++;
                dotNum += money;
                moneyTv.setText(num + dotNum);
            }
        }else if (Integer.parseInt(num) < MAX_NUM) {
            if (num.equals("0"))
                num = "";
            num += money;
            moneyTv.setText(num + dotNum);
        }
    }

    /**
     * 创建SQLite数据库
     */
    static class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context) {
            super(context, "shop.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table information(id integer primary key autoincrement, type varchar(20), time varchar(20), money varchar(20), node varchar(20))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
