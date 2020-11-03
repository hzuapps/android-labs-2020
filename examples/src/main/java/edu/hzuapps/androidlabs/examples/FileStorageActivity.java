package edu.hzuapps.androidlabs.examples;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FileStorageActivity extends AppCompatActivity {
    private static final String ID = "id";
    private static final String AGE = "age";
    private static final String MALE = "is_male";
    private static final String BANK = "bank_savings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);

        // 1. 创建一个文件
        //File f1 = new File("D:/file.txt");
        //File f2 = new File("D:/", "file.txt");
        File file = new File(this.getFilesDir(),"lab5.txt");
        try {
            file.createNewFile(); // 练习1： 如何确认文件已经创建？
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 练习2： 如何在点击按钮后创建文件？

        // InputStream / OutputStream, Byte (0, 1)
        // Reader / Writer, Char, (A, B)

        EditText text = (EditText) findViewById(R.id.input_to);
        String inputText = text.getText().toString();

        // 2. 在文件中写入内容
        try { // Byte
            FileOutputStream fos = this.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
            fos.write("Hello World".getBytes()); // 练习3： 如何确认内容已经写入？
            // Char
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(inputText);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 练习4： 如何在点击按钮后写入用户输入框填写的文字？

        // 3. 读取文件的内容
        try {
            FileInputStream fis = this.openFileInput(file.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            String result = stringBuilder.toString();
            // 练习5：在控制台输出/打印文件的内容
            // 练习6：在界面上显示文件的内容
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4. 偏好设置：SharedPreferences
        SharedPreferences settings = this.getSharedPreferences(
                "MY_SETTINGS", // 设置的标识、APP可以有多的偏好设置
                Context.MODE_PRIVATE); //
        //SharedPreferences settings = this.getSharedPreferences(
        //        Context.MODE_PRIVATE); // 不指定ID、使用默认偏好设置（只有一个）
        SharedPreferences.Editor editor = settings.edit(); // 开始编辑设置
        editor.putString(ID,"abc");     // 字符串值
        editor.putInt(AGE, 10);          // 整数值
        editor.putBoolean(MALE, true);  // 逻辑值
        editor.putFloat(BANK, 0.1f);     // 浮点数
        // 练习7. 保存用户在界面输入的设置值
        // 提示：string = ((EditText) findViewById(R.id.input_to)).getText().toString()
        editor.commit(); // 保存
        String id = settings.getString(ID, "");
        int age = settings.getInt(AGE, 0);
        boolean isMale = settings.getBoolean(MALE, false);
        float bankSavings = settings.getFloat(BANK, 0.0f);
        // 练习8. 攷设置值显示在用户界面上
        // 提示：((EditText) findViewById(R.id.input_to)).setText("");

    }
}
