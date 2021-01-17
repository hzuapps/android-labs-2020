package edu.hzuapp.androidlabs.net1808081001120;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.hzuapp.androidlabs.net1808081001120.dao.FormDao;

public class PersonviewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personview);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FormDao formDao=new FormDao(PersonviewActivity.this);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date=new Date();
                String insertTime=simpleDateFormat.format(date);
                formDao.dbInsert(insertTime);
                Intent i = new Intent(PersonviewActivity.this, HistoryActivity.class);
                startActivity(i);
            }
        });

    }
}