package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyViewActivity extends AppCompatActivity {

    private Button returnmainview;
    private Button edituser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);

        returnmainview = findViewById(R.id.returnmainview);
        edituser = findViewById(R.id.edituser);

        returnmainview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyViewActivity.this, Net1814080903226Activity.class);
                startActivity(intent);
            }
        });

        final MyViewActivity thisActivity = this;

        edituser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thisActivity.editUser();
            }
        });

    }

    @Override
    protected void onResume() {
        final MyViewActivity thisActivity = this;
        thisActivity.showUser();
        super.onResume();
    }

    // 修改个人信息
    private void editUser() {
        String user_name = ((EditText) findViewById(R.id.user_name)).getText().toString();
        String user_qq = ((EditText) findViewById(R.id.user_qq)).getText().toString();
        String sex = ((EditText) findViewById(R.id.sex)).getText().toString();
        String address = ((EditText) findViewById(R.id.address)).getText().toString();
        String phone = ((EditText) findViewById(R.id.phone)).getText().toString();

        // 插入新记录
        ContentValues user = new ContentValues();
        user.put(ContentProviderOfMyView.USERNAME, user_name);
        user.put(ContentProviderOfMyView.QQ, user_qq);
        user.put(ContentProviderOfMyView.ADDRESS, address);
        user.put(ContentProviderOfMyView.SEX, sex);
        user.put(ContentProviderOfMyView.PHONE, phone);

        Uri uri = getContentResolver() // 执行插入操作
                .insert(ContentProviderOfMyView.CONTENT_URI, user);

        Toast.makeText(getBaseContext(), //
                "修改成功! \n" + uri.toString(), Toast.LENGTH_SHORT).show();
    }

    // 显示用户信息
    private void showUser() {
        Cursor c = getContentResolver() // 执行查询
                .query(ContentProviderOfMyView.CONTENT_URI, null, null, null, null);
        if (c.moveToLast()) {
            String user_name = "";
            String user_qq = "";
            String sex = "";
            String address = "";
            String phone = "";
            user_name = c.getString(c.getColumnIndex(ContentProviderOfMyView.USERNAME));
            user_qq = c.getString(c.getColumnIndex(ContentProviderOfMyView.QQ));
            sex = c.getString(c.getColumnIndex(ContentProviderOfMyView.SEX));
            address = c.getString(c.getColumnIndex(ContentProviderOfMyView.ADDRESS));
            phone = c.getString(c.getColumnIndex(ContentProviderOfMyView.PHONE));
            Toast.makeText(this,user_qq,Toast.LENGTH_SHORT).show();
            Toast.makeText(this,user_name,Toast.LENGTH_SHORT).show();
            if (user_name.equals("")){
                user_name = "请输入姓名:";
            }
            if (user_qq.equals("")){
                user_qq = "请输入qq:";
            }
            if (sex.equals("")){
                sex = "请输入性别:";
            }
            if (address.equals("")){
                address = "请输入地址:";
            }
            if (phone.equals("")){
                phone = "请输入电话:";
            }
            // 显示在界面上
            this.showUserInfo(user_name, user_qq, sex, address, phone);
        }

    }

    private void showUserInfo(String user_name, String user_qq, String sex, String address, String phone) {
        ((EditText) findViewById(R.id.user_name)).setText(user_name);
        ((EditText) findViewById(R.id.user_qq)).setText(user_qq);
        ((EditText) findViewById(R.id.sex)).setText(sex);
        ((EditText) findViewById(R.id.address)).setText(address);
        ((EditText) findViewById(R.id.phone)).setText(phone);
    }


}