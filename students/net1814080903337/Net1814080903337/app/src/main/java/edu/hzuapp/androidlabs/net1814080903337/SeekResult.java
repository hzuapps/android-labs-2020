package edu.hzuapp.androidlabs.net1814080903337;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_result);
        Intent intent = getIntent();
         String name = intent.getStringExtra("data")+"";//将SeekResult的输入数据传过来

        // 注册组件
        storageDao=new StorageDao(this);
        back = (Button) findViewById(R.id.button7);
        t1=(TextView)findViewById(R.id.textView11);
        t2=(TextView)findViewById(R.id.textView12);
        t3=(TextView)findViewById(R.id.textView13);
        t4=(TextView)findViewById(R.id.textView14);

     Storage storage=storageDao.dbQueryOneByUsername(name);
     if (storage!=null){
         t1.setText(name);
         String location =storage.getLocation();
         String opendate =storage.getOpendate();
         String overduedate=storage.getOverduedate();
         t2.setText(location);
         t3.setText(opendate);
         t4.setText(overduedate);
     }else {
         t1.setText(name);
         t2.setText("查无结果");
         t3.setText("查无结果");
         t4.setText("查无结果");
         Toast.makeText(
                 SeekResult.this,
                 "无输入物品，请确定物品名称是否输入正确！", Toast.LENGTH_SHORT)
                 .show();
     }

       //返回SeekActivity
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
                Intent intent = new Intent(SeekResult.this, SeekActivity.class);
                startActivity(intent);
            }
        });
    }
}



