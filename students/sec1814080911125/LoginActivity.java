package edu.hzuapps.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private DBOpenHelper mDBOpenHelper;
    private EditText et_User, et_Psw;
    private CheckBox cb_rmbPsw;
    private String userName;
    private SharedPreferences.Editor editor;


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) { //重写OnCreate()方法
        super.onCreate(savedInstanceState); //保存实例状态
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏
        Objects.requireNonNull(getSupportActionBar()).hide();//隐藏标题栏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);//禁止横屏
        setContentView(R.layout.activity_login); //设置视图内容配置文件

        initView();//初始化界面
        mDBOpenHelper = new DBOpenHelper(this); //实例化DBOpenHelper

        SharedPreferences sp = getSharedPreferences("user_mes", MODE_PRIVATE);
        editor = sp.edit();
        if(sp.getBoolean("flag",false)){
            String user_read = sp.getString("user","");
            String psw_read = sp.getString("psw","");
            et_User.setText(user_read);
            et_Psw.setText(psw_read);
        }
    }

    private void initView() {
        //初始化控件
        et_User = findViewById(R.id.et_User);
        et_Psw = findViewById(R.id.et_Psw);
        cb_rmbPsw = findViewById(R.id.cb_rmbPsw);
        Button btn_Login = findViewById(R.id.btn_Login);
        TextView tv_register = findViewById(R.id.tv_Register);
        //设置点击事件监听器
        btn_Login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_Register: //注册
                Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);//跳转到注册界面
                startActivity(intent);
                finish();
                break;
            //登录验证
            case R.id.btn_Login:
                //获取输入数据
                String name = et_User.getText().toString().trim();
                String password = et_Psw.getText().toString().trim();
                //判断输入数据是否为空，若不为空则与数据库中数据进行匹配，匹配成功进行页面跳转
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    ArrayList<User> data = mDBOpenHelper.getAllData();
                    boolean match = false;
                    boolean match2 = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if ((name.equals(user.getName()) && password.equals(user.getPassword()))||
                                (name.equals(user.getPhonenum())&&password.equals(user.getPassword()))) {
                            userName = user.getName();
                            match = true;
                            if(cb_rmbPsw.isChecked()){
                                editor.putBoolean("flag",true);
                                editor.putString("user",user.getName());
                                editor.putString("psw",user.getPassword());
                                editor.apply();
                                match2 = true;
                            }else {
                                editor.putString("user",user.getName());
                                editor.putString("psw","");
                                editor.apply();
                                match2 = false;
                            }
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        if(match2){
                            Toast.makeText(this, "成功记住密码", Toast.LENGTH_SHORT).show();
                            cb_rmbPsw.setChecked(true);
                        }
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Runnable target;
                        //用线程启动
                        Thread thread = new Thread(){
                            @Override
                            public void run(){
                                try {
                                    sleep(2000);//延时2秒
                                    String user_name = userName;
                                    Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);//设置跳转到成功的界面

                                    startActivity(intent1);
                                    finish();
                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                            }
                        };
                        thread.start();//打开线程
                    } else {
                        Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
