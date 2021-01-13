package edu.hzuapps.androidlabs.net1814080903130;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.*;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.*;
import androidx.appcompat.widget.Toolbar;

public class Qm extends AppCompatActivity {
    EditText ettp1;
    TextView tV;
    SQLiteDatabase db1;
    String dbn="chat";
    String tbn="q_m";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qm_bar);

        Toolbar toolbar1=findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ettp1=findViewById(R.id.ettp1);
        ettp1.setText("编辑你的个性签名，展示你的独特态度");

        try {
            db1=openOrCreateDatabase(dbn, Context.MODE_PRIVATE, null);
            String d="DROP TABLE IF EXISTS "+tbn;
            db1.execSQL(d);
            String ct="CREATE TABLE " + tbn + "(i_d CHAR(8) not null primary key," + "qm VARCHAR(100) not null)";
            db1.execSQL(ct);
            addData("0","编辑你的个性签名，展示你的独特态度");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.qm_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                db1.close();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }
                break;
        }
        switch (item.getItemId()){
            case R.id.fb:
                try{
                    String q=ettp1.getText().toString();
                    updateData(q);
                    AlertDialog.Builder builder=new AlertDialog.Builder(Qm.this);
                    builder.setTitle("您的个性签名已发布");
                    builder.setMessage(q);
                    AlertDialog dialog=builder.create();
                    dialog.show();
                }
                catch(Exception e){
                    System.out.println(e);
                }
        }
        return true;
    }

    private void updateData(String qm){
        ContentValues cv=new ContentValues();
        cv.put("qm",qm);
        db1.update(tbn,cv,"i_d=?",new String[]{"0"});
    }

    private void addData(String i_d,String qm){
        ContentValues cv=new ContentValues(2);
        cv.put("i_d",i_d);
        cv.put("qm",qm);
        db1.insert(tbn,null,cv);
    }
}
