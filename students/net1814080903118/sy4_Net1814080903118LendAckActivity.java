package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Net1814080903118LendAckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_1814080903118_lend_ack);

        SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
        String lendid=sharedPreferences.getString("lendid","111111");
        EditText cdbId2=(EditText)findViewById(R.id.cdbId2);
        cdbId2.setText(lendid);
        Button lendAckBtn=(Button)findViewById(R.id.lendAckBtn);
        lendAckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("status", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();//获取编辑器
                //修改lendable标志
                editor.putString("lendable", "true");

                //修改lend开始时间
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
                editor.putString("lendopentime",df.format(new Date()));
                editor.commit();//提交修改

                //跳转页面到Net1814080903118WorkLendActivity
                Intent intent=new Intent();
                intent.setClass(Net1814080903118LendAckActivity.this,Net1814080903118WorkLendActivity.class);
                startActivity(intent);
            }
        });



    }
}