package edu.hzuapps.androidlabs.net1814080903130;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.*;
import androidx.appcompat.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Chat extends AppCompatActivity {
    TextView textView11;
    EditText ettp2;
    Button button2;
    Socket socket1;
    PrintWriter cout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        textView11=findViewById(R.id.textView11);
        ettp2=findViewById(R.id.ettp2);
        button2=findViewById(R.id.button2);

        Toolbar toolbar2=findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new fs().start();
            }
        });

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    CServer();
                    SClient();
                }
                catch (IOException e) {
                    System.out.println(e);
                }
            }
        };
        new Thread() {
            public void run() {
                Looper.prepare();
                new Handler().post(runnable);
                Looper.loop();
            }
        }.start();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                try {
                    cout.close();
                    socket1.close();
                    System.out.println("聊天服务已关闭");
                }
                catch (IOException e) {
                    System.out.println(e);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    finishAfterTransition();
                }
                break;
        }
        return true;
    }

    public void CServer() throws IOException
    {
        System.out.print("正在等待连接，请勿操作\n");
        new c_server().start();
    }

    public void SClient() throws IOException {
        new s_client().start();
    }

    class fs extends Thread{
        public void run(){
            try {
                cout=new PrintWriter(socket1.getOutputStream(),true);
                cout.println(ettp2.getText());
                textView11.append("我："+ettp2.getText()+"\n");
                ettp2.setText("");
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    class c_server extends Thread{
        public void run(){
            try {
                ServerSocket server=new ServerSocket(8080);
                Socket client=server.accept();
                String line="服务器已启动"+"\n";
                textView11.append(line);
                System.out.println("服务器已启动\n");
                while(true){
                    BufferedReader br=new BufferedReader(new InputStreamReader(client.getInputStream()));
                    while((line=br.readLine())!=null){
                        System.out.println("服务器接收："+line);
                    }
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    class s_client extends Thread{
        public void run(){
            try {
                socket1=new Socket("10.3.208.180",8080);
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
