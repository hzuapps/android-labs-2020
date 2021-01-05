package edu.hzuapps;


import edu.hzuapps.dao.*;
import edu.hzuapps.model.*;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class WriteActivity extends Activity {


    private EditText editTextB2;
    private Button buttonB1;
    private EditText editTextB3;

    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        // 注册组件
        userDao = new UserDao(this);

        editTextB2 = (EditText) findViewById(R.id.EditWrite1);

        buttonB1 = (Button) findViewById(R.id.buttonWrite);
        editTextB3 = (EditText) findViewById(R.id.EditWriteMood);



        buttonB1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {


                String text = editTextB2.getText() + "";
                String mood = editTextB3.getText() + "";

                if(text != "" && mood != "")
                {
                    userDao.dbInsert(text,mood);
                    Intent intent = new Intent(WriteActivity.this,
                            ReadActivity.class);
                    startActivity(intent);
                }
                else
                {Toast.makeText(
                        WriteActivity.this,
                        "请输入完整信息" , Toast.LENGTH_SHORT)
                        .show();}



            }
        });


    }

}