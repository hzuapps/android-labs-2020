package edu.hzuapps.androidlabs.net1814080903127;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class AddActivity extends AppCompatActivity{
    private EditText addTitle;
    private EditText addText;
    private Timer addTime;
    private Button save;
    private Bundle bundle;
    private int id=0;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        this.setTitle("便签");
        addText=findViewById(R.id.text);
        addTitle=findViewById(R.id.title);

        Intent intent=this.getIntent();
        bundle=intent.getExtras();
        if(bundle!=null){
            id=bundle.getInt("id");
            if(id!=0){
                addText.setText(bundle.getString("context"));
                addTitle.setText(bundle.getString("title"));
            }

        }

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final String date= simpleDateFormat.format(new Date());

        addTitle=findViewById(R.id.title);
        addText=findViewById(R.id.text);
        save=findViewById(R.id.addText);

        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(AddActivity.this)
                        .setTitle("提示")
                        .setMessage("确定保存？")
                        .setPositiveButton("确定",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String title=addTitle.getText().toString();
                                String text=addText.getText().toString();
                                String time= date;
                                DBHelper db=new DBHelper(AddActivity.this);
                                SQLiteDatabase sqLiteDatabase=db.getReadableDatabase();
                                if(id == 0){
                                    db.adddata(sqLiteDatabase,title,text,time);
                                }else {
                                    //更新数据
                                    db.Update(sqLiteDatabase,id,title,text,time);
                                }


                                Intent intent=new Intent(AddActivity.this,Net1814080903127Activity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create().show();
            }
        });
    }
}
