# 实验四
## 一、实验目标 #

1. 掌握Android网络访问方法；
2. 理解XML和JSON表示数据的方法。

## 二、实验内容 #

1. 在个人目录中创建一个表示数据的XML或JSON文件；
2. 数据文件代码提交之后从GitHub获取文件URL；
3. 在应用中通过网络编程访问GitHub的数据文件；
4. 在应用中解析并显示文件所包含的数据；
5. 将应用运行结果截图。

## 三、实验步骤 #

1. JsonParse.java
```java
package edu.hzuapps.androidlabs.sec1814080911128;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParse {
    public static List<NewsInfo> getNewsInfo(String json) {
        //使用gson库解析JSON数据
        Gson gson = new Gson();
        //创建一个TypeToken的匿名子类对象，并调用对象的getType()方法
        Type listType = new TypeToken<List<NewsInfo>>() {
        }.getType();
        //把获取到的信息集合存到newsInfos中
        List<NewsInfo> newsInfos = gson.fromJson(json, listType);
        return newsInfos;
    }
}
```
2. Sec1814080911128Activity.java
```java
private void fillData() {

	//创建AsyncHttpClient实例
	AsyncHttpClient client = new AsyncHttpClient();
	//使用GET方式请求
	client.get("http://172.17.24.35:8080/NewsInfo.json", new AsyncHttpResponseHandler() {
		@Override
		public void onSuccess(int i, org.apache.http.Header[] headers, byte[] bytes) {
			//请求成功

			try {
				String json = new String(bytes, "utf-8");
				newsInfos = JsonParse.getNewsInfo(json);
				if (newsInfos == null) {
					Toast.makeText(MainActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
				} else {
					//更新界面
					loading.setVisibility(View.INVISIBLE);
					lvNews.setAdapter(new NewsAdapter());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		@Override
		public void onFailure(int i, org.apache.http.Header[] headers, byte[] bytes, Throwable throwable) {
		}
	});
}
```
3. NewSaveAccount实现保存账号和密码
```java
package edu.hzuapps.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user;
    private EditText password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.初始化view
        initView();
        //2.若用户保存了信息，进行数据回写
        //I/O流方法
        Map<String,String> userInfo = NewSaveAccount.getUserInfo(this);
        if ((userInfo!=null)){
            user.setText(userInfo.get("user"));
            password.setText(userInfo.get("password"));
        }
    }

    private void initView() {
        //控件的初始化
        user = (EditText)findViewById(R.id.et_number);
        password = (EditText)findViewById(R.id.et_password);
        button = (Button) findViewById(R.id.btn_login);
        //2.设置按钮点击事件
        button.setOnClickListener(this);
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
}
```
## 四、实验结果 #

![运行结果](https://github.com/Jadore147258369/android-labs-2020/blob/master/students/sec1814080911128/lab/lab6.png)
## 五、实验心得 #
通过本次实验，掌握Android网络访问方法，理解XML和JSON表示数据的方法。