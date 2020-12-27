package edu.hzuapp.androidlabs.net1814080903321;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PersonalDetailsActivity extends AppCompatActivity {

    //声明控件
    private EditText etName;
    private EditText etPnum;
    private EditText etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);
        initView();
    }
    private void initView() {
        //关联控件
        etName = findViewById(R.id.et_name);
        etPnum = findViewById(R.id.et_pnum);
        etAddress = findViewById(R.id.et_address);
    }



    public void save(View view) {
        //当内容不为空时
        if(!TextUtils.isEmpty(etName.getText()) && !TextUtils.isEmpty(etPnum.getText()) && !TextUtils.isEmpty(etAddress.getText())){
            FileOutputStream fos = null;
            try {


                //Context中的方法openFileOutput()，获取一个FileOutputStream对象
                fos = openFileOutput("data", Context.MODE_PRIVATE);
                String str = etName.getText().toString().trim() + "#" + etPnum.getText().toString().trim() + "#" + etAddress.getText().toString().trim();
                fos.write(str.getBytes());
                Toast.makeText(getApplicationContext(), "点单成功", Toast.LENGTH_SHORT).show();



            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            Toast.makeText(getApplicationContext(), "请完善信息", Toast.LENGTH_SHORT).show();
        }
    }


    private void read() {
        try{
            //利用Context中的openFileInput()方法获取输入流
            FileInputStream data = openFileInput("data");
            BufferedReader reader = new BufferedReader(new InputStreamReader(data));
            String line = reader.readLine();
            String[] split = line.split("#");
            etName.setText(split[0]);
            etPnum.setText(split[1]);
            etAddress.setText(split[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}