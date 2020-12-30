package edu.hzuapps.androidlabs.sec1814080911230;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;


public class StartGameActivity extends AppCompatActivity {

    private EditText putword1;
    private EditText putword2;
    private EditText putword3;
    private EditText input1;
    private EditText input2;
    private Button btnSavePlayer;

    public int a = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        btnSavePlayer=(Button)findViewById(R.id.btnSavePlayer);
        putword1 = findViewById(R.id.put1);
        putword2 = findViewById(R.id.put2);
        putword3 = findViewById(R.id.put3);
        input1=(EditText)findViewById(R.id.input1);
        input2=(EditText)findViewById(R.id.input2);

        initEvent();

        btnSavePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCurrentText();
            }
        });
        
    }

    private void onClick() {

        String word1 = putword1.getText().toString();
        String word2 = putword2.getText().toString();
        String word3 = putword3.getText().toString();

        if (word1.equals("Android")) {
            a = a + 1;
        }
        if (word2.equals("Prefect")) {
            a = a + 1;
        }
        if (word3.equals("Subscription")) {
            a = a + 1;
        }
    }

    private void initEvent() {
        findViewById(R.id.queding).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StartGameActivity.this.onClick();
                showDialog();
                a = 0;
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage("您的得分为：" + a);
        builder.setPositiveButton("我知道了",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void saveCurrentText(){
        try {
            OutputStream os=openFileOutput("Player", Context.MODE_PRIVATE);
            os.write(input1.getText().toString().getBytes("utf-8"));
            os.flush();
            os.close();
            OutputStream os2=openFileOutput("mark",Context.MODE_PRIVATE);
            os2.write(input2.getText().toString().getBytes("utf-8"));
            os2.flush();
            os2.close();
            Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
            return;

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}
