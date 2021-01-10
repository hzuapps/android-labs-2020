# 实验五：Android存储编程
# 一、实验目标

1. 了解Andoid的存储手段
2. 掌握Android的文件存储
3. 掌握Android的数据库存储

# 二、实验内容

- 根据选题要求使用文件存储

1. 将应用产生的数据保存到文件存储中；
2. 说明使用的文件存储方式：内部 or 外部；
3. 将运行结果截图。

- 应用数据存储可采用数据库存储。

1. 将应用产生的数据存储到数据库中；
2. 将应用运行结果截图。

# 三、实验步骤
```xml
    <EditText
        android:id="@+id/editTextTextPersonName2"
        android:layout_width="80dp"
        android:layout_height="42dp"
        android:ems="10"
        android:gravity="center"
        android:inputType="textPersonName"
        android:text="1"
        app:layout_constraintStart_toStartOf="@+id/textView4"
        app:layout_constraintTop_toBottomOf="@+id/textView4" />

    <EditText
        android:id="@+id/editTextTextPersonName3"
        android:layout_width="80dp"
        android:layout_height="42dp"
        android:ems="10"
        android:gravity="center"
        android:inputType="textPersonName"
        android:text="2"
        app:layout_constraintStart_toStartOf="@+id/editTextTextPersonName2"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName2" />

    <EditText
        android:id="@+id/editTextTextPersonName4"
        android:layout_width="80dp"
        android:layout_height="42dp"
        android:ems="10"
        android:gravity="center"
        android:inputType="textPersonName"
        android:text="3"
        app:layout_constraintStart_toStartOf="@+id/editTextTextPersonName3"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName3" />

    <EditText
        android:id="@+id/editTextTextPersonName5"
        android:layout_width="102dp"
        android:layout_height="42dp"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName2"
        app:layout_constraintTop_toBottomOf="@+id/textView5" />

    <EditText
        android:id="@+id/editTextTextPersonName6"
        android:layout_width="102dp"
        android:layout_height="42dp"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName3"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName5" />

    <EditText
        android:id="@+id/editTextTextPersonName7"
        android:layout_width="102dp"
        android:layout_height="42dp"
        android:ems="10"
        android:inputType="textPersonName"
        app:layout_constraintStart_toEndOf="@+id/editTextTextPersonName4"
        app:layout_constraintTop_toBottomOf="@+id/editTextTextPersonName6" />
```

```java
package edu.hzuapp.androidlabs.net1808081001120;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Storage extends AppCompatActivity{
    private static final String chineseeditText = "chineseeditText";
    private static final String matheditText = "matheditText";
    private static final String englisheditText = "englisheditText";
    private static final String biologyeditText= "biologyeditText";
    private static final String geographyeditText= "geographyeditText";
    private static final String politicseditText= "politicseditText";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1808081001120);
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
        editTexts[0]=(EditText)findViewById(R.id.editTextTextPersonName2);
        editTexts[1]=(EditText)findViewById(R.id.editTextTextPersonName3);
        editTexts[2]=(EditText)findViewById(R.id.editTextTextPersonName4);
        editTexts[3]=(EditText)findViewById(R.id.editTextTextPersonName5);
        editTexts[4]=(EditText)findViewById(R.id.editTextTextPersonName6);
        editTexts[5]=(EditText)findViewById(R.id.editTextTextPersonName7);

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
# 四、实验结果

# 五、实验心得体会
本次实验利用数据库存储，将数据存储在数据库中，并在ListView显示出来。学习了Android的存储手段，熟悉了数据库相关操作的编写。
