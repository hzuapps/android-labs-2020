package edu.hzuapps.androidlabs.sec1814080911203;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
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
import java.text.SimpleDateFormat;

public class TransferActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        final EditText money=(EditText) findViewById(R.id.input_money);
        final EditText number=(EditText) findViewById(R.id.input_number);
        Button a=(Button) findViewById(R.id.input_numbersure);
        a.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String _money=money.getText().toString();
                String _number=number.getText().toString();
                money.setText(null);
                number.setText(null);
                transfer(_money,getsystime(),_number);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void transfer(String money, String time,String number){
        File file=new File("/storage/emulated/0/","transfer.txt");
        try {
            file.createNewFile();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        try {
            FileOutputStream fileoutputstream =this.openFileOutput(file.getAbsolutePath(), Context.MODE_PRIVATE);
            FileInputStream fileinputstream =this.openFileInput(file.getAbsolutePath());
            StringBuilder stringbuilder = new StringBuilder();
            InputStreamReader inputstreamreader = new InputStreamReader(fileinputstream, StandardCharsets.UTF_8);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
            String read =null;
            while((read =bufferedreader.readLine())!=null){
                stringbuilder.append(read+"\n");
            }
            String result = stringbuilder.toString();
            fileoutputstream.write((time+" "+money+"to"+number).getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getsystime(){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date=sDateFormat.format(new java.util.Date());;
        return date;
    }

}