package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CourseActivity extends AppCompatActivity {
    private static final String WEEK="Week";
    private static final String MORNING1="Morning1";
    private static final String MORNING2="Morning2";
    private static final String AFTERNOON1="Afternoon1";
    private static final String AFTERNOON2="Afternoon2";
    private static final String NIGHT="Night";
    String week="";
    Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        Intent intent=getIntent();
        week=intent.getStringExtra("week");
        EditText editText=(EditText)findViewById(R.id.Week);
        editText.setText(week);/* */

    }

    public void change(View view){
        changeImformation();
    }

    public void restart(View view){
        String []texts=getImformation();
        changeEditText(texts);
    }

    public String[] getImformation(){
        SharedPreferences settings = this.getSharedPreferences(
                week, // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //

        String contens[]=new String[6];
        contens[0]= settings.getString(WEEK, "");
        contens[1]= settings.getString(MORNING1, "");
        contens[2]= settings.getString(MORNING2, "");
        contens[3]= settings.getString(AFTERNOON1, "");
        contens[4]= settings.getString(AFTERNOON2, "");
        contens[5]= settings.getString(NIGHT, "");
        return contens;
    }

    public void changeImformation(){
        SharedPreferences settings = this.getSharedPreferences(
                week, // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        //SharedPreferences settings = this.getSharedPreferences(
        //        Context.MODE_PRIVATE); // 不指定ID、使用默认偏好设置（只有一个）
        SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置

        String imformations[]=getText();
        editor.putString(WEEK,imformations[0]);    //  字符串值
        editor.putString(MORNING1 ,imformations[1]);     // 字符串值
        editor.putString(MORNING2,imformations[2]);     // 字符串值
        editor.putString(AFTERNOON1,imformations[3]);     // 字符串值
        editor.putString(AFTERNOON2,imformations[4]);     // 字符串值
        editor.putString(NIGHT,imformations[5]);     // 字符串值
        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[6];
        editTexts[0]=(EditText)findViewById(R.id.Week);
        editTexts[1]=(EditText)findViewById(R.id.Morning1);
        editTexts[2]=(EditText)findViewById(R.id.Morning2);
        editTexts[3]=(EditText)findViewById(R.id.Afternoon1);
        editTexts[4]=(EditText)findViewById(R.id.Afternoon2);
        editTexts[5]=(EditText)findViewById(R.id.Night);
        return editTexts;
    }

    public void changeEditText(String[] imformations){
        EditText []editTexts=getEditText();
        for(int i=0;i<imformations.length;i++) {
            editTexts[i].setText(imformations[i]);
        }
    }

    public String[] getText(){
        EditText []editTexts=getEditText();
        String texts[]=new String[6];
        for(int i=0;i<6;i++){
            texts[i]=editTexts[i].getText().toString();
        }
        return texts;
    }
}
