package edu.hzuapps.androidlabs.net1814080903130;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.*;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.ui.*;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Net1814080903130Activity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    TextView textView1;
    TextView textView8;
    EditText ettp;
    EditText ettp2;
    Button button;
    SQLiteDatabase db;
    String dbn="chat";
    String tbn="grxx";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Net1814080903130Activity t=this;
        textView1=findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(t, Chat.class);
                t.startActivity(intent);
            }
        });

        try {
            db=openOrCreateDatabase(dbn, Context.MODE_PRIVATE, null);
            button= this.<Button>findViewById(R.id.button);
            String ct="CREATE TABLE IF NOT EXISTS " + tbn + "(yh CHAR(8) not null primary key," + "qm VARCHAR(100) not null)";
            db.execSQL(ct);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView8 = (TextView) findViewById(R.id.textView8);
                    ettp=findViewById(R.id.ettp);
                    ettp2=findViewById(R.id.ettp2);
                    String n=ettp.getText().toString();
                    String q=ettp2.getText().toString();
                    String a=null;
                    addData(n,q);
                    Cursor cs=db.rawQuery("SELECT * FROM " + tbn, null);
                    if(cs.moveToFirst()){
                        a="用户信息：\n"+"用户名："+cs.getString(0)+"\t"+"个性签名："+cs.getString(1)+"\n";
                    }
                    while (cs.moveToNext()){
                        a+="用户名："+cs.getString(0)+"\t"+"个性签名："+cs.getString(1)+"\n";
                    }
                    textView8.setText(a);
                    db.close();
                }
            });
        }
        catch (Exception e){
            System.out.println(e);
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();}
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow).setDrawerLayout(drawer).build();
    }

    private void addData(String yh,String qm){
        ContentValues cv=new ContentValues(2);
        cv.put(" yh",yh);
        cv.put(" qm",qm);
        db.insert(tbn,null,cv);
    }

    private void Drop(){
        String s="DROP TABLE "+tbn;
        db.execSQL(s);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}