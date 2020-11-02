package edu.hzuapps.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.hzuapps.androidlabs.util.LendFunction;

public class Net1814080903118WorkLendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_1814080903118_work_lend);

        //获取充电宝编号
        SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
        String lendid=sharedPreferences.getString("lendid","111111");
        TextView cdbId2=(TextView)findViewById(R.id.cdbId2);
        //设置充电宝编号
        cdbId2.setText(lendid);

        //及时更新已使用时间与需要缴费金额
        new Thread(){
            @Override
            public void run(){
                while(true){
                    //获取lend开始时间
                    SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
                    String opendate=sharedPreferences.getString("lendopentime","12:00");//Hour-Minter
                    String usedate= LendFunction.usetime(opendate);//函数返回以及使用了多少时间
                    TextView usehour=(TextView)findViewById(R.id.usehour);
                    usehour.setText(usedate.split(":")[0].trim());
                    TextView useminter=(TextView)findViewById(R.id.useminter);
                    useminter.setText(usedate.split(":")[1].trim());
                    double muchPayMoney=LendFunction.muchPayMoney(usedate);//函数返回应该缴费金额数
                    TextView muchMoney=(TextView)findViewById(R.id.muchMoney);
                    muchMoney.setText(String.format("%.1f",muchPayMoney));
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();



        Button navPersonalBtn2=(Button)findViewById(R.id.navPersonalBtn2);
        navPersonalBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Net1814080903118WorkLendActivity.this,Net1814080903118PersonalActivity.class);
                startActivity(intent);
            }
        });

        ImageView lendMap=(ImageView)findViewById(R.id.lendMap2);
        lendMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Net1814080903118WorkLendActivity.this,Net1814080903118PayAckActivity.class);
                startActivity(intent);
            }
        });
    }
}