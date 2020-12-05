package edu.hzuapp.androidlabs.net1814080903141;

import android.content.ContentValues;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class RecordActivity extends AppCompatActivity {

    private Button btnclear;
    private Button btncheck;
    private StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        btncheck = findViewById(R.id.btncheak);
        btnclear=findViewById(R.id.btnclear);

        final RecordActivity thisActivity = this;


        btncheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisActivity.showRecord();
            }
        });
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisActivity.clearRecord();
            }
        });
    }
    private void showRecord() {
        sb =new  StringBuilder();
        // 插入新记录
        Cursor cursor=getContentResolver().query(ContentProviderOfRecords.CONTENT_URI,null,null,null,null);

        if (cursor.moveToFirst()){
            do {
                int gscore=cursor.getInt(cursor.getColumnIndex(ContentProviderOfRecords.SCORE));
                int gbest=cursor.getInt(cursor.getColumnIndex(ContentProviderOfRecords.BEST));
                sb.append("Score:"+gscore+"     "+"Best:"+gbest+"\n");
                ((TextView) findViewById(R.id.trecord)).setText(sb);
            }while ((cursor.moveToNext()));

        }
        cursor.close();
    }
    private void clearRecord(){
        getContentResolver().delete(ContentProviderOfRecords.CONTENT_URI,null,null);
        Toast.makeText(getBaseContext(), //
                "删除成功! \n" + sb.toString(), Toast.LENGTH_LONG).show();
        ((TextView) findViewById(R.id.trecord)).setText("");

    }


}
