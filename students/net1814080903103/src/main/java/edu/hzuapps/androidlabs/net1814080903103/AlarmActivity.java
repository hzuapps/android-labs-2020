package edu.hzuapps.androidlabs.net1814080903103;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm2);
            super.onCreate(savedInstanceState);

//显示对话框
            new AlertDialog.Builder(AlarmActivity.this).
                    setTitle("闹钟").//设置标题
                    setMessage("时间到了！").//设置内容
                    setPositiveButton("知道了", new DialogInterface.OnClickListener(){//设置按钮
                public void onClick(DialogInterface dialog, int which) {
                    AlarmActivity.this.finish();//关闭Activity
                }
            }).create().show();
    }
}
