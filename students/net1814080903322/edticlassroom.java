package com.example.net1814080903322;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class edticlassroom extends AppCompatActivity {

    private static final String classroomaddresseditText = "classroomaddresseditText";
    private static final String classroomnumbereditText = "classroomnumbereditText";
    private static final String booktimeeditText = "booktimeeditText";
    private static final String applicanteditText= "applicanteditText";
    private static final String PurposeapplicationText= "PurposeapplicationeditText";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edticlassroom);
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
                "MY_IMFORMATION", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //

        String contens[]=new String[6];
        contens[0]= settings.getString(classroomaddresseditText, "");
        contens[1]= settings.getString(classroomnumbereditText, "");
        contens[2]= settings.getString(booktimeeditText, "");
        contens[3]= settings.getString(applicanteditText, "");
        contens[4]= settings.getString(PurposeapplicationText, "");
        return contens;
    }

    public void changeImformation(){
        SharedPreferences settings = this.getSharedPreferences(
                "MY_IMFORMATION", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        //SharedPreferences settings = this.getSharedPreferences(
        //        Context.MODE_PRIVATE); // 不指定ID、使用默认偏好设置（只有一个）
        SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置

        String imformations[]=getText();
        editor.putString(classroomaddresseditText,imformations[0]);     // 字符串值
        editor.putString(classroomnumbereditText ,imformations[1]);     // 字符串值
        editor.putString(booktimeeditText,imformations[2]);     // 字符串值
        editor.putString(applicanteditText,imformations[3]);     // 字符串值
        editor.putString(PurposeapplicationText,imformations[4]);     // 字符串值



        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[7];
        editTexts[0]=(EditText)findViewById(R.id.classroomaddressText);
        editTexts[1]=(EditText)findViewById(R.id.classroomnumbereditText);
        editTexts[2]=(EditText)findViewById(R.id.booktimeeditText);
        editTexts[3]=(EditText)findViewById(R.id.applicanteditText);
        editTexts[4]=(EditText)findViewById(R.id.PurposeapplicationeditText);


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