package com.example.facewords_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class SubmitResultActivity extends AppCompatActivity {

    // 声明数据库对象
    Database db;

    String _submitUrlParas;
    List<ListItem> _resultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 获取数据库对象
        db = Database.getInstance(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_result);

        // 接收 Intent 传值
        Intent intent = getIntent();
        String submitUrl = intent.getStringExtra("submitUrl");
        String paras = intent.getStringExtra("paras");

        // 初始化 submit_result_content
        final TextView submitResultContent = findViewById(R.id.submit_result_content);

        // 组合后生成提交的请求地址
        _submitUrlParas = String.format(getResources().getString(R.string.submit_url_paras), submitUrl, paras);

        // 开始请求
        // 实例化RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        // 从提供的URL请求字符串响应
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                _submitUrlParas,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // 解析返回的结果 按 utf-8 编码进行解码
                        String requestResult = new String(
                                response.getBytes(StandardCharsets.ISO_8859_1),
                                StandardCharsets.UTF_8
                        );
                        com.alibaba.fastjson.JSONObject _resultObject = JSON.parseObject(requestResult);
                        String resultStringList = _resultObject.getJSONArray("items")
                                .getJSONObject(0)
                                .getString("words");
                        _resultList = JSON.parseArray(resultStringList, ListItem.class);

                        submitResultContent.setText("The number of words is: " + _resultList.size() + "\n\n");

                        for (ListItem item : _resultList) {
                            submitResultContent.setText(submitResultContent.getText() + item.getSurface() + "　");
                            db.wordDao().insertWords(new Word(item.getBaseform(), R.drawable.ic_search));
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        submitResultContent.setText("That didn't work!");
                    }
                }
        );

        // 将请求添加到RequestQueue
        queue.add(stringRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_submit_result_confirm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.submit_result_confirm:
                // Intent 跳转回 Net1814080903213Activity
                Intent intent = new Intent();
                intent.setClass(this, Net1814080903213Activity.class);
                this.startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}