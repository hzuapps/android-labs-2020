package edu.hzuapps.androidlabs.sec1814080911214;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import edu.hzuapps.androidlabs.sec1814080911214.R;

public class QueryActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity thisActivity = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        Button btnOpen = (Button) findViewById(R.id.main_btn);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity, sec1814080911214Activity.class);
                thisActivity.startActivity(intent);
                thisActivity.finish();
            }
        });
Drawable drawable = getResources().getDrawable(R.drawable.query);
        drawable.setBounds(0,0,200,200);
        TextView textview = (TextView) findViewById(R.id.textview_01);
        textview.setCompoundDrawables(null,drawable,null,null);
    }
    }
}
protected void loadsdCard() throws IOException {


            // 判断SD卡是否存在
            if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

                // 目录
                File path = new File(PATH);
                // 文件
                File f = new File(PATH + FILENAME);
                FileInputStream fi = new FileInputStream(f);

                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len=fi.read(bytes))!=-1){
                    System.out.print(new String(bytes,0,len));
                }
 btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    loadsdCard();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });