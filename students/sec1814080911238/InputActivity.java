package edu.hzuapps.androidlabs.sec1814080911238;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {
    private EditText str01,str02;
    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input_activity);

        final InputActivity thisActivity = this;

        Button btnOpen3 = (Button) findViewById(R.id.button3);
        str01 = findViewById (R.id.editText1);
        str02 = findViewById (R.id.editText2);
        btnOpen3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //获取两个输入框的内容
                String string01 = str01.getText ().toString ();
                String string02 = str02.getText ().toString ();
                //将信息存储到SharePreferences
                if(string01.equals ("") || string02.equals ("")){           //input框验证
                    Toast.makeText (InputActivity.this,"单纯中英文不能为空",Toast.LENGTH_LONG).show ();
                }else {         //入库处理
                    //获取SharePreferences(参数1：文件名，参数2：模式)
                    SharedPreferences sharedPreferences = getSharedPreferences ("localData",MODE_PRIVATE);
                    //获取Editor对象
                    SharedPreferences.Editor editor = sharedPreferences.edit ();
                    //找到localData中最后一条，在最后一条数据后面进行num编号添加
                    boolean flag = true;
                    while (flag) {
                        if(sharedPreferences.contains("English" + num)) {
                            num ++;
                        } else {
                            flag =false;
                        }
                    }
                    //存储信息
                    editor.putString ("English" + num,string01);
                    editor.putString ("China" + num,string02);
                    //提交
                    editor.commit ();
                    num++;
                    str01.setText("");
                    str02.setText("");
                    Toast.makeText (InputActivity.this,"保存成功",Toast.LENGTH_SHORT).show ();
                }
            }
        });
    }

}

