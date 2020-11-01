package com.example.thefirst;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class LoadDataThread extends Thread {
    private int type;
    Net1814080903107Activity m;
    public LoadDataThread(Net1814080903107Activity net1814080903107Activity){
        this.m=net1814080903107Activity;
    }
    @Override
    public void run(){
        Socket socket=null;
        DataInputStream dis=null;
        DataOutputStream dos=null;
        try {
            socket=new Socket(m.getMyVariable().getsIP(),m.getMyVariable().getsPort());
            dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            dos.writeInt(1);//服务编号
            dos.flush();
            int n=dis.readInt();//更新栏目数量

            for(int i=0;i<n;i++){
                //...
                Bitmap image = BitmapFactory.decodeFile("C:\\Users\\心里的潇洒情\\Desktop\\1.jpg");
                String title="Error",introduce="Error";
                title=dis.readUTF();
                introduce=dis.readUTF();
                m.getScrollLin().addView(m.pullMessage(image,title,introduce));
            }

        }catch (IOException ex){
            Log.e("ERROR"," "+ex.getMessage());
            //Toast.makeText(m,ex.getMessage(),Toast.LENGTH_SHORT);
        }finally {
            try {
                if (socket!=null)
                    socket.close();
                if (dis != null)
                    dis.close();
                if (dos != null)
                    dos.close();
            }catch (IOException ex){}
        }
    }
}
