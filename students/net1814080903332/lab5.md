# 实验五
## 1.实验目标
1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储
## 2.实验内容
1. 将应用产生的数据保存到偏好设置中；
2. 说明使用的偏好设置存储方式；
3. 将运行结果截图。
## 3.实验步骤

``` xml
    <EditText
        android:id="@+id/editTextTextPersonName"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="例如：惠州"
        android:textColor="#8AABBD"
        android:textSize="14sp"
        app:layout_constraintStart_toEndOf="@+id/textView"
        app:layout_constraintTop_toTopOf="@+id/textView" />

    <EditText
        android:id="@+id/editTextTextPersonName2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:clickable="true"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="（时间选择器）"
        android:textColor="#8AABBD"
        android:textSize="14sp"
        app:layout_constraintStart_toEndOf="@+id/textView3"
        app:layout_constraintTop_toTopOf="@+id/textView3" />

    <EditText
        android:id="@+id/editTextTextPersonName3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="例如：去红花湖"
        android:textColor="#8AABBD"
        android:textSize="14sp"
        app:layout_constraintStart_toEndOf="@+id/textView4"
        app:layout_constraintTop_toTopOf="@+id/textView4" />

```


```java
package hzu.android.labs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Save extends AppCompatActivity {

    private static final String chineseeditText = "chineseeditText";
    private static final String matheditText = "matheditText";
    private static final String englisheditText = "englisheditText";
    private static final String biologyeditText= "biologyeditText";
    private static final String geographyeditText= "geographyeditText";
    private static final String politicseditText= "politicseditText";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funtion__next);
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
        editTexts[0]=(EditText)findViewById(R.id.editTextTextPersonName);
        editTexts[1]=(EditText)findViewById(R.id.editTextTextPersonName2);
        editTexts[2]=(EditText)findViewById(R.id.editTextTextPersonName3);


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

```
## 4.实验结果

## 5.实验心得
  这次实验的重点是实现前端与后端的交互。前端设计方面因为有图形化界面设计，所以并没有遇到太大的问题。
  但是前后端交互由于在之前的Java课程中已经有所接触，虽然部分语法有所不同，但在思想上差别不大，所以理解起来难度并不大。之前有做过小程序，感觉大同小异，比较容易上手。
