package edu.hzuapp.androidlabs.net1814080903337;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.hzuapp.androidlabs.net1814080903337.dao.StorageDao;


public class RecordActivity extends Activity {
    private EditText text1;        //物品名称
    private EditText text2;        //物品位置
    private EditText text3;        //开启时间
    private EditText text4;       //过期时间
    private Button button1;                //提交信息
    private StorageDao storageDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        // 注册组件
        storageDao=new StorageDao(this);
        text1=(EditText) findViewById(R.id.editText);
        text2=(EditText) findViewById(R.id.editText2);
        text3=(EditText) findViewById(R.id.editText3);
        text4=(EditText) findViewById(R.id.editText4);
        button1=(Button)findViewById(R.id.button5);

        //物品登记
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                String name = text1.getText() + "";
                String location = text2.getText() + "";
                String opendate=text3.getText() +"";
                String overduedate=text4.getText()+"";
                if (name.equals(null) || name == ""
                ) {
                    Toast.makeText(RecordActivity.this, "物品名称不可为空！",
                            Toast.LENGTH_SHORT).show();

                } else  {
                    if (storageDao.dbQueryOneByUsername(name) == null) {
                        storageDao.dbInsert(name,location,opendate,overduedate);
                        Toast.makeText(
                                RecordActivity.this,
                                "登记成功，物品名称：" + name + "物品位置，：" + location
                                        + "，请在"+overduedate+"前使用完毕", Toast.LENGTH_SHORT)
                                .show();
                    } else {
                        Toast.makeText(RecordActivity.this, "该物品已登记，可查看列表或更换其他名称",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
    }*/

}



