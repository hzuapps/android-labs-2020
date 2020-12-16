package edu.hzuapps.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final MainActivity2 thisActivity = this;

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisActivity.saveinformation();
            }
        });
    }

    private void saveinformation() {
        String edid = ((EditText) findViewById(R.id.edid)).getText().toString();
        String edname = ((EditText) findViewById(R.id.edname)).getText().toString();
        String edclass = ((EditText) findViewById(R.id.edclass)).getText().toString();

        //插入新记录
        ContentValues information = new ContentValues();
        information.put(Database.ID, edid);
        information.put(Database.NAME, edname);
        information.put(Database.CLASS, edclass);
        try {
            Uri uri = getContentResolver()
                    .insert(Database.CONTENT_URI,information);
            Toast.makeText(getBaseContext(),//
                    "新建成功！\n" + uri.toString(), Toast.LENGTH_LONG).show();

        }catch (SQLException sq){
            Toast.makeText(getBaseContext(),//
                    sq.getMessage()+"该学号已存在", Toast.LENGTH_LONG).show();

        }

        this.showInformationInfo("","","");
    }
    private void showInformationInfo(String edid,String edname,String edclass) {
        ((EditText) findViewById(R.id.edid)).setText(edid);
        ((EditText) findViewById(R.id.edname)).setText(edname);
        ((EditText) findViewById(R.id.edclass)).setText(edclass);
    }

}