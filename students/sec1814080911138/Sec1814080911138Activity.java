package edu.hzuapps.androidlabs.Sec1814080911138;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Sec1814080911138Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        private List<CostBean> mCostBeanList;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec1814080911138);
    }
}
    FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
public void onClick(View view) {
        builder.setTitle("新建支出");//dialog的标题
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {


public void onClick(DialogInterface dialog, int which) {//当点击确定时，
        CostBean costBean = new CostBean();
        costBean.costTitle = title.getText().toString();//将对应的属性输入
        costBean.costMoney = money.getText().toString();
        costBean.costDate = date.getYear() + "-" + (date.getMonth() + 1) + "-" +
        date.getDayOfMonth();
        costBean.costDate = date.getYear()+"-";

        if(date.getMonth()+1<10)costBean.costDate+="0";
        costBean.costDate+=(date.getMonth()+1)+"-";
        if(date.getDayOfMonth()<10)    costBean.costDate+="0";
        costBean.costDate+=date.getDayOfMonth();


        //当输入为空时提醒
        if("".equals(costBean.costTitle) || "".equals(costBean.costMoney) || "".equals(costBean.costDate))
        {
        Toast.makeText(MainActivity.this,"信息不完整",Toast.LENGTH_SHORT).show();
        return;
        }
        if(costBean.costMoney.length()>4)
        {
        Toast.makeText(MainActivity.this,"金额过大",Toast.LENGTH_SHORT).show();
        return;
        }
        builder.setNegativeButton("取消", null);//取消时退出
        builder.create().show();//显示dialog，即自定义的布局
        }
        });
        }

