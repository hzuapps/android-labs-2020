package edu.hzuapps.androidlabs.sec1814080911129;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TaxActivity extends Activity implements View.OnClickListener {
    RadioButton rb1;
    RadioButton rb2;
    TextView tvResult;
    TextView tvResult2;
    EditText txt1;
    EditText txt2;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tax);
        setViews();
        onClick();
    }

    private void onClick() {SharedPreferences preferences=getSharedPreferences("data",MODE_PRIVATE);//从data文件中进行数据读取
        txt2.setText(preferences.getString("身高",""));
        txt1.setText(preferences.getString("体重",""));

    }

    public void setViews() {
        rb1 = (RadioButton) findViewById(R.id.rb1);
        rb2 = (RadioButton) findViewById(R.id.rb2);//判断男女
        tvResult = (TextView) findViewById(R.id.tvResult);
        txt1 = (EditText)findViewById(R.id.edX);
        txt2 = (EditText)findViewById(R.id.edY);

        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double x = Double.parseDouble(txt1.getText().toString());//身高
        double y = Double.parseDouble(txt2.getText().toString());//体重//体重除以身高的平方
        double res;
        String str = "Your BMI is";
        String str2 = "Your last BMI is";

        if(x<=0 || y<=0) {
            tvResult.setText("值异常，不计算");
            return ;
        }
        x = x/100;
        res = y / (x*x);
        String str1 = String.format("%.2f",res);
        str = str + str1;

        if(rb1.isChecked())
            res -= 1;//以女性为标准进行比较
        //仅以女性作为评价标准
        str +=   "体型:";
        if(res < 19)
            str += "过轻";
        else if(res < 24)
            str += "适中";
        else if(res<29)
            str += "超重";
        else if(res<34)
            str += "肥胖";
        else
            str += "严重肥胖";
        tvResult.setText(str);

        SharedPreferences.Editor editor=getSharedPreferences("data",MODE_PRIVATE).edit();//定义一个data文件来进行数据储存
        editor.putString("体重",txt1.getText().toString());
        editor.putString("身高",txt2.getText().toString());
        editor.apply();


    }
    
    



}