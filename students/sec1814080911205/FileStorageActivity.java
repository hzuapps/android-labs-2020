package edu.hzuapps.androidlabs;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class FileStorageActivity extends AppCompatActivity {
    File file;
    final FileStorageActivity context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_text);

        ((Button)findViewById(R.id.button_save)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                file = new File ("D:/","lab5.txt");//1 this.getFilesDir()获取的是某个应用data/data/files的路径//this.getFilesDir().getParent()获取的是某个应用data/data/的路径
                try{
                    file.createNewFile();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        });

        EditText text_date = (EditText) findViewById(R.id.text_date);
        String input_date = text_date.getText().toString();
        try{
            FileOutputStream fos = context.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
            fos.write("Hello World".getBytes());
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(input_date);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = context.openFileInput(file.getAbsolutePath());
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
            System.out.println(result);
            // 练习6：在界面上显示文件的内容
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
