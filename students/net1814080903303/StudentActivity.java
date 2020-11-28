package edu.hzuapps.androidlabs.net1814080903303;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.myapplication.R;

public class StudentActivity extends AppCompatActivity {
    private static final String ID = "id";
    private static final String AGE = "age";
    private static final String MALE = "is_male";
    private static final String BANK = "bank_savings";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final Spinner spinner2 = findViewById(R.id.spinner2);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.resion,R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        SharedPreferences settings = this.getSharedPreferences(
                "MY_SETTINGS", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        String id = settings.getString(ID, "");
        EditText editText = (EditText) findViewById(R.id.stu_editText1);
        editText.setText(id);
    }
       public void setview(View view){
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
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
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.setText(id);
       }

       public void delect (View view){
           EditText editText = (EditText) findViewById(R.id.stu_editText1);
           editText.setText(" ");
       }
}
