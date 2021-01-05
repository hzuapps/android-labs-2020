package edu.hzuapps.androidlabs.net1814080903215;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class PersonalHomeActivity extends AppCompatActivity {

    private TextView text;
    private EditText edit;
    String filename = "222.txt";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_home);

        Button btn2 = (Button)findViewById(R.id.button3);
        final PersonalHomeActivity thisActivity3 = this;
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity3,UpDownloadActivity.class);
                thisActivity3.startActivity(intent);
            }
        });

        Button btn3 = (Button)findViewById(R.id.button2);
        final PersonalHomeActivity thisActivity2 = this;
        btn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(thisActivity2,MainActivity.class);
                thisActivity2.startActivity(intent);
            }
        });

        text = (TextView) findViewById(R.id.textView3);
        edit = (EditText) findViewById(R.id.edit);

        Button btn5 = (Button)findViewById(R.id.button5);
        final PersonalHomeActivity thisActivity5 = this;
        btn5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = getApplicationContext().openFileOutput(filename, MODE_APPEND);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                PrintStream printStream = new PrintStream(fileOutputStream);
                printStream.println(edit.getText().toString());
            }
        });

        Button btn6 = (Button)findViewById(R.id.button6);
        final PersonalHomeActivity thisActivity6 = this;
        btn6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                FileInputStream fileInputStream = null;
                try {
                    fileInputStream = openFileInput(filename);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(fileInputStream));
                String temp="";
                while (true){
                    try {
                        if (!((temp=bufferedReader.readLine())!=null)) break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    text.append("\n"+temp);
                }
            }
        });

    }
}