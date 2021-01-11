package edu.hzuapp.androidlabs.net1814080903323activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TipsResultActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsresult);
        FileInputStream fis = null;
        byte[] buffer = null;
        try {
            fis = openFileInput("login");
            buffer = new byte[fis.available()];

            fis.read(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            TextView text1TV = (TextView) findViewById(R.id.textView1);
            String data = new String(buffer);
            String text1 = data.split(" ")[0];
            text1TV.setText("小技巧："+text1);





        }


    }
}
