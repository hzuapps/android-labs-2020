package edu.hzuapp.androidlabs.net1814080903337;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.hzuapp.androidlabs.net1814080903337.dao.StorageDao;
import edu.hzuapp.androidlabs.net1814080903337.model.Storage;


public class SeekResult extends Activity {

    private StorageDao storageDao;
    private LinearLayout linearLayout1;

    //返回按钮
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_result);

        // 注册组件
        storageDao = new StorageDao(this);
        back = (Button) findViewById(R.id.button3);
        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        //求出用户的数量，并且显示
        int storageSize = storageDao.dbGetUserSize();
        TextView textView1 = new TextView(this);
        textView1.setText("共有" + storageSize + "个物品");
        textView1.setTextSize(24);
        linearLayout1.addView(textView1, 1);//添加的textView1放到activity_table.xml中tag=1的View那个位置
        if (storageSize > 0) {
            ArrayList<Storage> storagesList = storageDao.dbQueryOneByUsername();//查出表中的所有用户放到一个ArrayList中
            TableLayout tableLayout1 = new TableLayout(this);//新建一个表格布局
            tableLayout1.setStretchAllColumns(true);//自动宽度，使表格在横向占据100%
            //打印表头
            TableRow tableRow = new TableRow(this);//新建一行

            TextView textView = new TextView(this);//新建一个TextView
            textView.setTextSize(24);//设置字体
            textView.setText("物品名称");
            tableRow.addView(textView);//放到行中，自动增加一个单元格

            textView = new TextView(this);
            textView.setTextSize(24);
            textView.setText("物品位置");
            tableRow.addView(textView);

//            textView = new TextView(this);
//            textView.setTextSize(24);
//            textView.setText("开启时间");
//            tableRow.addView(textView);
//
//            textView = new TextView(this);
//            textView.setTextSize(24);
//            textView.setText("过期时间");
//            tableRow.addView(textView);

            // 新建的行TableRow添加到表格TableLayout之中
            tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            //打印用户信息
            for (int i = 0; i < storageSize; i++) {
                Storage storage = storagesList.get(i);
                // 一个用户占据一行
                tableRow = new TableRow(this);

                textView = new TextView(this);
                textView.setTextSize(18);
                textView.setText(storage.getName());
                tableRow.addView(textView);

                textView = new TextView(this);
                textView.setTextSize(18);
                textView.setText(storage.getLocation());
                tableRow.addView(textView);

//                textView = new TextView(this);
//                textView.setTextSize(18);
//                textView.setText(storage.getOpendate());
//                tableRow.addView(textView);
//
//                textView = new TextView(this);
//                textView.setTextSize(18);
//                textView.setText(storage.getOverduedate());
//                tableRow.addView(textView);

                Button button = new Button(this);
                button.setText("删除");
                button.setTextSize(18);
                button.setId(storage.getId());//设置按钮的id就是用户的id
                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        storageDao.dbDeleteUser(view.getId());//这样可以获取按钮的id
                        finish();
                        Intent intent = new Intent(SeekResult.this,
                                SeekResult.class);
                        startActivity(intent);
                        Toast.makeText(SeekResult.this, "删除成功！",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                tableRow.addView(button);//将这个按钮添加到这行中
                // 新建的TableRow添加到TableLayout
                tableLayout1.addView(tableRow, new TableLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

            }
            linearLayout1.addView(tableLayout1, 2);//把这个表格放到activity_table.xml中tag=2的View那个位置
        }
        //返回MainActivity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
                Intent intent = new Intent(SeekResult.this, SeekActivity.class);
                startActivity(intent);
            }
        });
    }
        // 对物理按钮的监听
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            switch (keyCode) {
                case android.view.KeyEvent.KEYCODE_BACK:
                    finish();// 关闭这个Activity。
                    Intent intent = new Intent(SeekResult.this, RecordActivity.class);
                    startActivity(intent);
                    break;
            }
            return super.onKeyDown(keyCode, event);
        }




    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_result);
    }*/
}

