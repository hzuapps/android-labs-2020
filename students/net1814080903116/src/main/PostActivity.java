package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
            FileInputStream fis=null;
            byte[] buffer=null;
            try {
                fis=openFileInput("login");
                buffer=new  byte[fis.available()];
                fis.read(buffer);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if(fis!=null){
                    try {
                        fis.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
            TextView nameTV=(TextView)findViewById(R.id.nameTV);
            TextView idTV=(TextView)findViewById(R.id.idTV);

            String data=new String(buffer);
            String name=data.split(" ")[0];
            String id=data.split(" ")[1];

            nameTV.setText(name+"：");
            idTV.setText("  "+id);

        }
    }
