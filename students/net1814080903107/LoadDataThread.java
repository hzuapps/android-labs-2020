package com.example.thefirst;
 
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

public class LoadDataThread extends Thread {
    private int type;
    private int startPoint;
    private static final String imageFrom="https://raw.githubusercontent.com/Howard-SSS/android-labs-2020/tree/master/students/net1814080903107/";
    private Net1814080903107Activity m;
    public LoadDataThread(Net1814080903107Activity net1814080903107Activity,int startPoint){
        this.m=net1814080903107Activity;
        this.startPoint=startPoint;
    }
    public Bitmap loadImage(String imageName)throws Exception{
        Bitmap bitmap=null;
        HttpURLConnection conn=null;
        URL url=new URL(imageFrom+imageName);
        conn=(HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5000);
        conn.setRequestMethod("GET");
        if(conn.getResponseCode()==200){
            bitmap=BitmapFactory.decodeStream(conn.getInputStream());
        }
        else if(conn.getResponseCode()==404){
            bitmap=BitmapFactory.decodeResource(m.getResources(),R.drawable.hbw);
        }
        return bitmap;
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
            dos.writeInt(startPoint);
            dos.flush();
            int n=dis.readInt();//更新栏目数量
            System.out.println(123);
            for(int i=0;i<n;i++){
                //...
                Bitmap bitmap =null;
                String storeID=dis.readUTF();
                final String storeName=dis.readUTF();
                String phone=dis.readUTF();
                String address=dis.readUTF();
                final String introduce=dis.readUTF();
                String imageName=dis.readUTF();
                try {
                    bitmap = loadImage(imageName);
                    FileOutputStream fos = m.openFileOutput(imageName, Context.MODE_PRIVATE);
                    //Bitmap转byte[]
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                    byte[] datas = baos.toByteArray();

                    fos.write(datas);
                }catch(Exception ex){Log.e("image",ex.getMessage());}

                Log.w("load","1");
                final Bitmap finalBitmap = bitmap;
                Runnable update=new Runnable(){
                    @Override
                    public void run(){
                        m.getScrollLin().addView(new MyLinearLayout(m).getMeunLin(finalBitmap,storeName,introduce));
                    }
                };
                System.out.println(startPoint);
                m.startPoint+=n;
                //更新UI
                m.runOnUiThread(update);
            }

        }catch (IOException ex){
            Log.e("LoadData"," "+ex.getMessage());
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

