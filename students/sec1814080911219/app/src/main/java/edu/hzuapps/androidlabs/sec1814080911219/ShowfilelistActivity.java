package edu.hzuapps.androidlabs.sec1814080911219;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ShowfilelistActivity extends AppCompatActivity {

    String massage=null;
    Socket client;
    DataInputStream in;
    DataOutputStream out;
    private Handler handler = null;
    TextView textView=null;
    Button button;
    EditText editText;
    Activity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showfilelist);
        textView=findViewById(R.id.file_list);
        button=findViewById(R.id.download);
        handler = new Handler();
        editText=findViewById(R.id.filename);
        activity=this;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client = new Socket("192.168.43.26", 12345);
                    in = new DataInputStream(client.getInputStream());
                    out = new DataOutputStream(client.getOutputStream());
                    out.writeUTF("1");
                    massage = in.readUTF();
                    handler.post(runnable);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String filename=editText.getText().toString();
                        try {
                            client = new Socket("192.168.43.26", 12345);
                            in = new DataInputStream(client.getInputStream());
                            out = new DataOutputStream(client.getOutputStream());
                            out.writeUTF("3");
                            out.writeUTF(filename);
                            out.writeUTF("admins");
                            String content=in.readUTF();
                            if(content.equals("error")){
                                handler.post(runnable1);
                            }
                            else{
                                File file=new File("/storage/emulated/0/",filename);
                                try {
                                    file.createNewFile();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                FileOutputStream fileOutputStream=new FileOutputStream(file);//获取文件的字符流
                                fileOutputStream.write(content.getBytes());//将输入框内容写入文件
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });



    }
    Runnable runnable = new Runnable() {
        public void run() {
            textView.setText(massage);
        }
    };
    Runnable runnable1=new Runnable() {
        @Override
        public void run() {
            Toast toast=Toast.makeText(activity,"权限不够或文件不存在！",Toast.LENGTH_SHORT);
            toast.show();;
        }
    };


}