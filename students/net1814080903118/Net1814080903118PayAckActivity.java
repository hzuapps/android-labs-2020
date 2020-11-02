package edu.hzuapps.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.hzuapps.androidlabs.util.LendFunction;

public class Net1814080903118PayAckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_1814080903118_pay_ack);

        //获取充电宝编号
        SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
        String lendid=sharedPreferences.getString("lendid","111111");
        TextView cdbId3=(TextView)findViewById(R.id.cdbId3);
        cdbId3.setText(lendid);//设置充电宝编号
        new Thread(){
            @Override
            public void run(){
                while(true){
                    SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
                    String opendate=sharedPreferences.getString("lendopentime","12:00");//Hour-Minter
                    String usedate=LendFunction.usetime(opendate);//函数返回以及使用了多少时间
                    String []use_hour_minter=usedate.split(":");
                    String usehour=use_hour_minter[0];//已经使用的小时
                    String useminter=use_hour_minter[1];//已经使用的分钟
                    TextView userTimeHour=(TextView)findViewById(R.id.userTimeHour);
                    userTimeHour.setText(usehour);//设置使用小时
                    TextView userTimeMinter=(TextView)findViewById(R.id.userTimeMinter);
                    userTimeMinter.setText(useminter);//设置使用分钟

                    double muchPayMoney= LendFunction.muchPayMoney(usedate);//函数返回应该缴费金额数
                    TextView muchSpyMoney=(TextView)findViewById(R.id.muchSpyMoney);
                    muchSpyMoney.setText(String.format("%.1f",muchPayMoney));
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        Button spyAckBtn=(Button)findViewById(R.id.spyAckBtn);
        spyAckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1.
                //跳出付款小窗口---相关操作在小窗口中进行

                //2.
                //直接在当前页面进行简单处理
                SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                editor.putString("lendable", "false");
                editor.commit();//提交修改
                Intent intent =new Intent();
                intent.setClass(Net1814080903118PayAckActivity.this,Net1814080903118WorkUnLendActivity.class);
                startActivity(intent);
            }
        });

    }
}