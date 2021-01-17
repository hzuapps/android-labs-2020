package edu.hzuapps.androidlabs.net181408903241;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button bt1,bt2;
    EditText MaWd;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button button_tiao1 = (Button) findViewById(R.id.button1);
        final MainActivity thisActivity1 = this;
        button_tiao1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent1 = new Intent(thisActivity1, MarkActivity.class);
                MainActivity.this.startActivity(Intent1);
            }
        });
        Button button_tiao2 = (Button) findViewById(R.id.button2);
        final MainActivity thisActivity2 = this;
        button_tiao2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent Intent2 = new Intent(thisActivity2, SerachActivity.class);
                MainActivity.this.startActivity(Intent2);
            }
        });

    }
    public void btonClick (View view) throws IOException {
        String mawd = MaWd.getText().toString();
        String fileName = null;
        FileOutputStream fileOutputStream = openFileOutput(fileName,Context.MODE_PRIVATE);
        fileOutputStream.write((mawd).getBytes());
        if(fileOutputStream !=null){
            fileOutputStream.close();
        }
        Context context;
        Toast.makeText(this,"登陆成功",Toast.LENGTH_LONG);
    }
  /*  public void btClick(View view) throws IOException {
                FileInputStream fileInputStream = openFileInput(fileName);
        byte[] input = new byte[fileInputStream.available()];
        while(fileInputStream.read(input)!=-1){
            String str = new String(input);
            String[] s =str.split("  ");
        textView.setText("标记单词是："+s[0]);
        if(fileInputStream !=null){
            fileInputStream.close();
        }
    }*/
}
