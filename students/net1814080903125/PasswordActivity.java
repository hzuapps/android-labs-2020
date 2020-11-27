package edu.hzuapps.androidlabs.net1814080903125;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity implements View.OnClickListener {

    Button set_btn = null;
    Button back_btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        Button set_btn = (Button)findViewById(R.id.set_btn);
        Button back_btn = (Button)findViewById(R.id.back_btn2);

        set_btn.setOnClickListener((View.OnClickListener) this);
        back_btn.setOnClickListener((View.OnClickListener) this);


        //设置TextView的大小及位置
        Drawable drawable = getResources().getDrawable(R.drawable.lock);
        drawable.setBounds(0,0,1100,700);
        TextView view = findViewById(R.id.lock);
        view.setCompoundDrawables(drawable,null,null,null);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            //实现返回按钮的跳转
            case R.id.back_btn2:
                intent = new Intent(PasswordActivity.this, Net1814080903125Activity.class);
                PasswordActivity.this.startActivity(intent);
                break;
             //实现密码的设置
            case R.id.set_btn:
                EditText id = (EditText)findViewById(R.id.pwd_id);
                EditText pwd = (EditText)findViewById(R.id.pwd);
                String id1 = id.getText().toString();

                ContentValues values = new ContentValues();
                values.put("password",pwd.getText().toString());
                DatabaseHelper dbHelper = new DatabaseHelper(PasswordActivity.this,"my_diary",null,1);
                final SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.update("_diary",values,"id=?",new String[]{id1});
                Toast.makeText(PasswordActivity.this, "密码设置成功！", Toast.LENGTH_LONG)
                        .show();
                PasswordActivity.this.startActivity(intent);
        }
    }
}