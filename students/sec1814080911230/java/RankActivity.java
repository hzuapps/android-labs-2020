package edu.hzuapps.androidlabs.sec1814080911230;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class RankActivity extends AppCompatActivity {

    private TextView Player1;
    private TextView mark1;
    private Button sx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Player1=(TextView)findViewById(R.id.Player1);
        mark1=(TextView)findViewById(R.id.mark1);
        sx=(Button)findViewById(R.id.sx);

        sx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readSaveText();
            }
        });
    }

    private void readSaveText(){

        try {
            InputStream is1=openFileInput("Player");
            byte[] bytes1=new byte[is1.available()];
            is1.read(bytes1);
            is1.close();

            InputStream is2=openFileInput("mark");
            byte[] bytes2=new byte[is2.available()];
            is2.read(bytes2);
            is2.close();

            String str1=new String(bytes1,"utf-8");
            Player1.setText(str1);
            String str2=new String(bytes2,"utf-8");
            mark1.setText(str2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
