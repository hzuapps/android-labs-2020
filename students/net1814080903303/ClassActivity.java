package edu.hzuapps.androidlabs.net1814080903303;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

public class ClassActivity<adapter> extends AppCompatActivity {

    private static final String ID = "id";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        final Spinner spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.class_name,R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);

        final Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.class_name,R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        final Spinner spinner3 = findViewById(R.id.spinner3);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.class_name,R.layout.support_simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);



        SharedPreferences settings = this.getSharedPreferences(
                "MY_SETTINGS", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        String id = settings.getString(ID, "");
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(id);
    }
    public void setview(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.getText();
        String string = editText.getText().toString();

        SharedPreferences settings = this.getSharedPreferences(
                "MY_SETTINGS", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        //SharedPreferences settings = this.getSharedPreferences(
        //        Context.MODE_PRIVATE); // 不指定ID、使用默认偏好设置（只有一个）
        SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置
        editor.putString(ID,string);     // 字符串值
        editor.commit(); // 保存
    }

    public void backview (View view){
        SharedPreferences settings = this.getSharedPreferences(
                "MY_SETTINGS", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        String id = settings.getString(ID, "");
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(id);
    }

    public void delect (View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText(" ");//一键清除
    }
}

