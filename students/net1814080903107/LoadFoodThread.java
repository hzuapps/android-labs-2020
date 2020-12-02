package com.example.thefirst;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.thefirst.component.MyFoodLinearLayout;
import com.example.thefirst.component.MyMeunLinearLayout;
import com.example.thefirst.constant.transmission;
import com.example.thefirst.model.DownloadModel;
import com.example.thefirst.pool.DownloadPool;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoadFoodThread extends Thread implements transmission {
    private StoreActivity storeActivity;
    private LinearLayout linearLayout;
    private int storeID;
    public LoadFoodThread(StoreActivity storeActivity,LinearLayout linearLayout,int storeID){
        this.storeActivity=storeActivity;
        this.linearLayout=linearLayout;
        this.storeID=storeID;
    }
    public void run(){
        Socket socket=null;
        DataInputStream dis=null;
        DataOutputStream dos=null;
        try {
            socket=new Socket(transmission.sIP,transmission.sPort);
            dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            dos.writeInt(UPDATE_FOOD);
            dos.writeInt(storeID);
            dos.writeInt(storeActivity.startPoint);
            dos.flush();
            final int n=dis.readInt();//更新栏目数量??????
            storeActivity.startPoint+=n;
            for(int i=0;i<n;i++){
                //...
                final int foodID=dis.readInt();
                final String foodName=dis.readUTF();
                final int price=dis.readInt();
                final String introduce=dis.readUTF();
                final String foodBitmap=dis.readUTF();
                //更新UI
                storeActivity.runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        MyFoodLinearLayout myFoodLinearLayout =new MyFoodLinearLayout(linearLayout.getContext());
                        myFoodLinearLayout.
                                setFoodID(foodID).
                                setFoodName(foodName).
                                setPrice(price).
                                setIntroduction(introduce);
                        linearLayout.addView(myFoodLinearLayout);
                        DownloadPool.queue.add(new DownloadModel(myFoodLinearLayout.getImageView(),IMAGEVIEW,foodBitmap));
                        myFoodLinearLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent newPage=new Intent(storeActivity,ResultActivity.class);
                                MyFoodLinearLayout m=(MyFoodLinearLayout)v;
                                int ID=m.getFoodID();
                                newPage.putExtra("foodID",ID);
                                storeActivity.startActivity(newPage);
                            }
                        });
                    }
                });
            }
            Log.d("*LoadFood","finush");
        }catch (IOException ex){
            Log.e("*LoadFood"," "+ex.getMessage());
        }
    }

}
