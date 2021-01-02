package edu.hzuapps.androidlabs.sec1814080911219;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CipheruploadActivity extends AppCompatActivity {
    Button sure;
    String admin,sale,finance,produce,all;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    Socket client;
    DataInputStream in;
    DataOutputStream out;
    Activity activity;
    File file;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cipherupload);
        sure=findViewById(R.id.sure);
        checkBox1=findViewById(R.id.administration);//管理部门
        checkBox2=findViewById(R.id.sale);//销售部门
        checkBox3=findViewById(R.id.finance);//财政部门
        checkBox4=findViewById(R.id.produce);//生产部门
        checkBox5=findViewById(R.id.allstaff);//全体员工
        activity=this;
        handler=new Handler();
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked()){
                    admin="1";
                }
                else
                    admin="0";
                if(checkBox2.isChecked()){
                    sale="1";
                }
                else
                    sale="0";
                if(checkBox3.isChecked()){
                    finance="1";
                }
                else
                    finance="0";
                if(checkBox4.isChecked()){
                    produce="1";
                }
                else
                    produce="0";
                if(checkBox5.isChecked()){
                    all="1";
                }
                else
                    all="0";
                file=new File(Filepath.path);
                new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void run() {
                        try {
                            client = new Socket("192.168.43.26", 12345);
                            in = new DataInputStream(client.getInputStream());
                            out = new DataOutputStream(client.getOutputStream());
                            FileInputStream fileInputStream=new FileInputStream(file);
                            StringBuilder stringBuilder = new StringBuilder();
                            InputStreamReader inputStreamReader =
                                    new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                            BufferedReader br = new BufferedReader(inputStreamReader);
                            String line = null;
                            while ((line = br.readLine()) != null) {
                                stringBuilder.append(line);
                            }
                            String result = stringBuilder.toString();
                            out.writeUTF("2");
                            out.writeUTF(file.getName());
                            out.writeUTF(all);
                            out.writeUTF(produce);
                            out.writeUTF(admin);
                            out.writeUTF(sale);
                            out.writeUTF(finance);
                            out.writeUTF(result);
                            Intent intent=new Intent(activity,Sec1814080911219Activity.class);
                            activity.startActivity(intent);
                            handler.post(runnable);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                }).start();
                Intent intent=new Intent(activity,Sec1814080911219Activity.class);
                activity.startActivity(intent);
            }
        });

    }
    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Toast toast=Toast.makeText(activity,"文件以上传",Toast.LENGTH_SHORT);
            toast.show();
        }
    };
}