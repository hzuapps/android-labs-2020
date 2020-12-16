package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import edu.hzuapps.androidlabs.util.LendFunction;

public class Net1814080903118WorkUnLendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_1814080903118_work_un_lend);

        SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
        String lendable=sharedPreferences.getString("lendable","false");
        if(lendable.equals("false")){
            SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
            editor.putString("lendable", "false");
            editor.commit();//提交修改
        }else{
            Intent intent=new Intent();
            intent.setClass(Net1814080903118WorkUnLendActivity.this,Net1814080903118WorkLendActivity.class);
            startActivity(intent);
        }

        Button navPersonalBtn1=(Button)findViewById(R.id.navPersonalBtn1);
        navPersonalBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Net1814080903118WorkUnLendActivity.this,Net1814080903118PersonalActivity.class);
                startActivity(intent);
            }
        });

        ImageView lendMap=(ImageView)findViewById(R.id.scanWin);
        lendMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lendid= LendFunction.getbinarynumber();//扫描二维码的函数，返回二维码中存储的充电宝编号
                //初始化Lend标志
                SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                editor.putString("lendid", lendid);
                editor.commit();//提交修改

                Intent intent=new Intent();
                intent.setClass(Net1814080903118WorkUnLendActivity.this,Net1814080903118LendAckActivity.class);
                startActivity(intent);
            }
        });


    }
}