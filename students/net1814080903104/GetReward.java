package edu.hzuapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GetReward extends AppCompatActivity implements View.OnClickListener{

    DatabaseHelper mySql = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_reward);

         mySql= new DatabaseHelper(this,"Character",null,5);

        Button button_get = (Button) findViewById(R.id.button_get);
        button_get.setOnClickListener((View.OnClickListener) this);
        Button button_return = (Button) findViewById(R.id.button_return);
        button_return.setOnClickListener((View.OnClickListener) this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            //实现返回按钮的跳转
            case R.id.button_return:
                intent = new Intent(GetReward.this, Net1814080903104Activity.class);
                GetReward.this.startActivity(intent);
                break;
            //实现奖励的领取，领取后更新表中的ifget为1，表示已领取，再次点击领取按钮读出ifget=1，提示已领取；
            case R.id.button_get:
                Log.i("btn","btn");
                mySql.getWritableDatabase();
                SQLiteDatabase db = mySql.getWritableDatabase();

                Cursor cursor = db.query("Character",null,null,null,null,null,null);
                while(cursor.moveToFirst()) {
                    Integer name = cursor.getInt(cursor.getColumnIndex("ifget"));
                    if (name == 0) {
                        Toast.makeText(GetReward.this, "领取成功", Toast.LENGTH_SHORT).show();
                        ContentValues values = new ContentValues();
                        values.put("ifget",1);
                        db.update("Character",values,"name=?",new String[]{"钟南"});
                    }
                    else if(name==1){
                        Toast.makeText(GetReward.this, "领取失败，原因：您已经领取过该奖励了！", Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
                cursor.close();
        }
    }
}