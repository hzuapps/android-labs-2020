package edu.hzuapps.androidlabs.examples;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class FileStorageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage);

        // 1. 创建一个文件
        File file = new File(this.getFilesDir(),"lab5.txt");
        try {
            file.createNewFile(); // 练习1： 如何确认文件已经创建？
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 练习2： 如何在点击按钮后创建文件？

        // 2. 在文件中写入内容
        try { // Byte
            FileOutputStream fos = this.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
            fos.write("Hello World".getBytes()); // 练习3： 如何确认内容已经写入？
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 练习4： 如何在点击按钮后写入用户输入框填写的文字？

        // 3. 读取文件的内容
        try {
            FileInputStream fis = this.openFileInput(file.getAbsolutePath());
            StringBuilder stringBuilder = new StringBuilder();
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
    }
}
