package edu.hzuapps.androidlabs.sec1814080911234;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
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

public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
       Button button1 = (Button) findViewById(R.id.button1);
        final File file = new File("D:/lab5.txt");
        final Activity thisActivity = this;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

            EditText edit1 = (EditText) findViewById(R.id.edit1);
            String inputText = edit1.getText().toString();

        try{
                FileOutputStream fos = this.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
                fos.write("Hello World".getBytes());
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);
                bw.write(inputText);
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }catch (IOException e) {
                e.printStackTrace();
            }
        try{
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
                System.out.println(result);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }


}