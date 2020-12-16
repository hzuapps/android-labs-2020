package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class AddDiaryActivity extends AppCompatActivity implements View.OnClickListener {

    Button save_btn = null;
    Button back_btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);

        Button save_btn = (Button)findViewById(R.id.save_btn);
        Button back_btn = (Button)findViewById(R.id.back_btn1);

        save_btn.setOnClickListener((View.OnClickListener) this);
        back_btn.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            //返回到主界面
            case R.id.back_btn1:
                Intent intent = new Intent(AddDiaryActivity.this, Net1814080903125Activity.class);
                AddDiaryActivity.this.startActivity(intent);
                break;
             //保存日记
            case R.id.save_btn:
                AlertDialog alertDialog2 = new AlertDialog.Builder(this)
                        .setTitle("是否保存？")
                        .setMessage("")
                        .setIcon(R.mipmap.ic_launcher)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                //点击确定后，将数据保存到数据库
                                EditText title = (EditText)findViewById(R.id.title);
                                EditText content = (EditText)findViewById(R.id.content);

                                DatabaseHelper dbHelper = new DatabaseHelper(AddDiaryActivity.this,"my_diary",null,1);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();

                                ContentValues values = new ContentValues();
                                values.put("title",title.getText().toString());
                                values.put("content",content.getText().toString());

                                db.insert("_diary",null,values);
                                Toast.makeText(AddDiaryActivity.this, "文章保存成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(AddDiaryActivity.this, Net1814080903125Activity.class);
                                AddDiaryActivity.this.startActivity(intent);
                            }
                        }).create();

                alertDialog2.show();

                break;
        }
    }
}