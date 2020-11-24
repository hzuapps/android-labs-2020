package hzu.android.labs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditHomework extends AppCompatActivity {

    private static final String chineseeditText = "chineseeditText";
    private static final String matheditText = "matheditText";
    private static final String englisheditText = "englisheditText";
    private static final String biologyeditText= "biologyeditText";
    private static final String geographyeditText= "geographyeditText";
    private static final String politicseditText= "politicseditText";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_homework);
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
        contens[0]= settings.getString(chineseeditText, "");
        contens[1]= settings.getString(matheditText, "");
        contens[2]= settings.getString(englisheditText, "");
        contens[3]= settings.getString(biologyeditText, "");
        contens[4]= settings.getString(geographyeditText, "");
        contens[5]= settings.getString(politicseditText, "");
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
        editor.putString(chineseeditText,imformations[0]);     // 字符串值
        editor.putString(matheditText ,imformations[1]);     // 字符串值
        editor.putString(englisheditText,imformations[2]);     // 字符串值
        editor.putString(biologyeditText,imformations[3]);     // 字符串值
        editor.putString(geographyeditText,imformations[4]);     // 字符串值
        editor.putString(politicseditText,imformations[5]);     // 字符串值


        editor.commit(); // 保存

    }

    public EditText[] getEditText(){
        EditText editTexts[]=new EditText[7];
        editTexts[0]=(EditText)findViewById(R.id.chineseeditText);
        editTexts[1]=(EditText)findViewById(R.id.matheditText);
        editTexts[2]=(EditText)findViewById(R.id.englisheditText);
        editTexts[3]=(EditText)findViewById(R.id.biologyeditText);
        editTexts[4]=(EditText)findViewById(R.id.geographyeditText);
        editTexts[5]=(EditText)findViewById(R.id.politicseditText);

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