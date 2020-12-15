package edu.hzuapps.androidlabs.sec1814080911128;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Sec1814080911128Activity extends AppCompatActivity {

    private LinearLayout loading;
    private ListView lvNews;
    private List<NewsInfos>

    @Override
    protected void onCreate(Budle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Map<String,String> userInfo = NewSaveAccount.getUserInfo(this);
        if ((userInfo!=null)){
            user.setText(userInfo.get("user"));
            password.setText(userInfo.get("password"));
        }
        fillData();
    }
    private void initView() {
		//控件的初始化
        user = (EditText)findViewById(R.id.et_number);
        password = (EditText)findViewById(R.id.et_password);
        button = (Button) findViewById(R.id.btn_login);
        //2.设置按钮点击事件
        button.setOnClickListener(this);
        loading = (L)
    }
    @Override
    public void onClick(View v) {
        //1.点击获取账号密码
        String  s_user = user.getText().toString().trim();
        String  s_password = password.getText().toString().trim();
        //2.检查用户名和密码是否为空
        if (TextUtils.isEmpty(s_user)){
            Toast.makeText(this,"请输入账号",Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(s_password)){
            Toast.makeText(this,"请输入密码",Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG).show();

        //3.保存用户信息
        //I/O流的方法
        boolean isSaveSuccess = NewSaveAccount.saveUserInfo(this,s_user,s_password);
        if (isSaveSuccess){
            Toast.makeText(this,"保存成功",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"保存失败",Toast.LENGTH_LONG).show();
        }
    }
    private void fillData() { }
    //ListView适配器
    private class NewsAdapter extends BaseAdapter {
        //listview的item数
        @Override
        public int getCount() {
            return newsInfos.size();
        }

        //条目对象
        @Override
        public Object getItem(int position) {
            return null;
        }

        //条目id
        @Override
        public long getItemId(int position) {
            return 0;
        }
    }
}