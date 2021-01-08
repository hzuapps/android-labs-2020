package edu.hzuapps.androidlabs.net1814080903237;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SellActivity extends AppCompatActivity{
    Button save,choose;
    EditText name,name1;
    TextView textView;
    String filename="thing_file";
    protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_sell);

            save = findViewById(R.id.save);
            choose = findViewById(R.id.choose);
            name = findViewById(R.id.name);
            name1 = findViewById(R.id.name1);
            textView=findViewById(R.id.textView1);
    }
    public void saveClick(View view) throws IOException {
        String text =name.getText().toString();
        String prise=name1.getText().toString();

        FileOutputStream fileOutputStream = openFileOutput(filename, Context.MODE_APPEND);
        fileOutputStream.write(text.getBytes());
        if(fileOutputStream !=null){
            fileOutputStream.close();
        }
        Toast.makeText(this,"发布成功",Toast.LENGTH_LONG).show();
       /* FileInputStream fileInputStream =openFileInput(filename);
        byte[] input = new byte[fileInputStream.available()];
        while(fileInputStream.read(input)!=-1){
            String str =new String(input);
            textView.setText(str);
        }*/
    }
    public void chooseClick(View view){

    }
}
