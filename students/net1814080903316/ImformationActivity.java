package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ImformationActivity extends AppCompatActivity {
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String SCHOOL = "school";
    private static final String COLLEGE= "college";
    private static final String MAJOR= "major";
    private static final String CLASSNAME= "className";
    private static final String GRADE= "grade";

  /*  EditText idText;
    EditText nameText;
    EditText schoolText;
    EditText majorText;
    EditText collegeText;
    EditText classText;
    EditText gradeText;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imformation);
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

        String contens[]=new String[7];
        contens[0]= settings.getString(ID, "");
        contens[1]= settings.getString(NAME, "");
        contens[2]= settings.getString(SCHOOL, "");
        contens[3]= settings.getString(COLLEGE, "");
        contens[4]= settings.getString(MAJOR, "");
        contens[5]= settings.getString(CLASSNAME, "");
        contens[6]= settings.getString(GRADE, "");
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
        editor.putString(ID,imformations[0]);     // 字符串值
        editor.putString(NAME ,imformations[1]);     // 字符串值
        editor.putString(SCHOOL,imformations[2]);     // 字符串值
        editor.putString(COLLEGE,imformations[3]);     // 字符串值
        editor.putString(MAJOR,imformations[4]);     // 字符串值
        editor.putString(CLASSNAME,imformations[5]);     // 字符串值
        editor.putString(GRADE,imformations[6]);     // 字符串值

        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[7];
        editTexts[0]=(EditText)findViewById(R.id.ID);
        editTexts[1]=(EditText)findViewById(R.id.Name);
        editTexts[2]=(EditText)findViewById(R.id.School);
        editTexts[3]=(EditText)findViewById(R.id.Major);
        editTexts[4]=(EditText)findViewById(R.id.CollegeName);
        editTexts[5]=(EditText)findViewById(R.id.ClassName);
        editTexts[6]=(EditText)findViewById(R.id.Grade);
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
        String texts[]=new String[7];
        for(int i=0;i<7;i++){
            texts[i]=editTexts[i].getText().toString();
        }
        return texts;

    }
}

/*  List<EditText> editTexts=new ArrayList<EditText>();
       editTexts.put("ID",(EditText)findViewById(R.id.ID));
        editTexts.put("Name",(EditText)findViewById(R.id.Name));
        editTexts.put("School",(EditText)findViewById(R.id.School));
        editTexts.put("Major",(EditText)findViewById(R.id.Major));
        editTexts.put("CollegeName",(EditText)findViewById(R.id.CollegeName));
        editTexts.put("ClassName",(EditText)findViewById(R.id.ClassName));
        editTexts.put("Grade",(EditText)findViewById(R.id.Grade));

        editTexts.add((EditText)findViewById(R.id.ID));
        editTexts.add((EditText)findViewById(R.id.Name));
        editTexts.add((EditText)findViewById(R.id.School));
        editTexts.add((EditText)findViewById(R.id.Major));
        editTexts.add((EditText)findViewById(R.id.CollegeName));
        editTexts.add((EditText)findViewById(R.id.ClassName));
        editTexts.add((EditText)findViewById(R.id.Grade));


        EditText idText=findViewById(R.id.ID);
        EditText nameText=findViewById(R.id.Name);
        EditText schoolText=findViewById(R.id.School);
        EditText majorText=findViewById(R.id.Major);
        EditText collegeText=findViewById(R.id.CollegeName);
        EditText classText=findViewById(R.id.ClassName);
        EditText gradeText=findViewById(R.id.Grade);*/