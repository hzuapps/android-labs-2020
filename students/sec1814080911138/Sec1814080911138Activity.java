package edu.hzuapps.androidlabs.Sec1814080911138;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;
public class Sec1814080911138Activity extends AppCompatActivity {

    private List<CostBean> mCostBeanList;
    private DatabaseHelper mDatabaseHelper;
    private CostListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_sec1814080911138);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

        mDatabaseHelper = new DatabaseHelper(this);
        mCostBeanList = new ArrayList<>();
        ListView costList = (ListView) findViewById(R.id.lv_main);

        initCostDate();
        mAdapter = new CostListAdapter(this, mCostBeanList);
        costList.setAdapter(mAdapter);
    }
}
//单击每一个item实现删除功能
costList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
@Override
public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("删除");
        builder.setMessage("是否删除此账单?");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
        mDatabaseHelper.toDelete(mCostBeanList.get(position));
        mCostBeanList.remove(position);
        mAdapter.notifyDataSetChanged();
        }
        });
        builder.setNegativeButton("取消",null);
        builder.create().show();
        }
});
FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        builder.setTitle("新建支出");//dialog的标题
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener(){


public void onClick(DialogInterface dialog,int which){//当点击确定时，
        CostBean costBean=new CostBean();
        costBean.costTitle=title.getText().toString();//将对应的属性输入
        costBean.costMoney=money.getText().toString();
        costBean.costDate=date.getYear()+"-"+(date.getMonth()+1)+"-"+
        date.getDayOfMonth();
        costBean.costDate=date.getYear()+"-";
        if(date.getMonth()+1<10) costBean.costDate+="0";
        costBean.costDate+=(date.getMonth()+1)+"-";
        if(date.getDayOfMonth()<10)costBean.costDate+="0";
        costBean.costDate+=date.getDayOfMonth();


        //当输入为空时提醒
        if("".equals(costBean.costTitle)||"".equals(costBean.costMoney)||"".equals(costBean.costDate))
        {
        Toast.makeText(MainActivity.this,"信息不完整",Toast.LENGTH_SHORT).show();
        return;
        }
        if(costBean.costMoney.length()>4)
        {
        Toast.makeText(MainActivity.this,"金额过大",Toast.LENGTH_SHORT).show();
        return;
        }
        mDatabaseHelper.insertCost(costBean);//将数据插入数据库
        }
        }
        }
        }