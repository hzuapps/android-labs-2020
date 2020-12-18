package edu.hzuapps.androidlabs.sec1814080911217;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Record_Activity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        String result=null;
        TextView textView=(TextView)findViewById(R.id.t);
        try {
            FileInputStream fis = new FileInputStream(Sec1814080911217Activity.file);
            StringBuilder stringBuilder = new StringBuilder(); // 动态字符串
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            br.close();
            result = stringBuilder.toString();
            textView.setText(result);
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}