package com.example.thefirst;
 
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

import com.example.thefirst.component.MyMeunLinearLayout;
import com.example.thefirst.constant.transmission;
import com.example.thefirst.model.DownloadModel;
import com.example.thefirst.pool.DownloadPool;
import com.google.android.material.tabs.TabLayout;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class LoadStoreThread extends Thread implements transmission {
    private Net1814080903107Activity net1814080903107Activity;
    private LinearLayout linearLayout;
    public LoadStoreThread(Net1814080903107Activity net1814080903107Activity,LinearLayout linearLayout){
        this.net1814080903107Activity=net1814080903107Activity;
        this.linearLayout=linearLayout;
    }
    @Override
    public void run(){
        Socket socket=null;
        DataInputStream dis=null;
        DataOutputStream dos=null;
        try {
            socket=new Socket(transmission.sIP,transmission.sPort);
            dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            dos.writeInt(UPDATE_VIEW);
            dos.writeInt(net1814080903107Activity.startPoint);
            dos.flush();
            final int n=dis.readInt();//更新栏目数量??????
            net1814080903107Activity.startPoint+=n;
            for(int i=0;i<n;i++){
                //...
                final int storeID = dis.readInt();
                final String storeName=dis.readUTF();
                final String phone=dis.readUTF();
                final String address=dis.readUTF();
                final String introduce=dis.readUTF();
                final String storeBitmap=dis.readUTF();
                //更新UI
                net1814080903107Activity.runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        MyMeunLinearLayout myMeunLinearLayout =new MyMeunLinearLayout(linearLayout.getContext());
                        myMeunLinearLayout.
                                setStoreID(storeID).
                                setStoreName(storeName).
                                setPhone(phone).
                                setAddress(address).
                                setIntroduction(introduce).
                                setBitmapName(storeBitmap);
                        linearLayout.addView(myMeunLinearLayout);
                        DownloadPool.queue.add(new DownloadModel(myMeunLinearLayout.getImageView(),IMAGEVIEW,storeBitmap));
                        myMeunLinearLayout.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent newPage=new Intent(net1814080903107Activity,StoreActivity.class);
                                MyMeunLinearLayout m=(MyMeunLinearLayout)v;
                                newPage.putExtra("storeID",m.getStoreID());
                                newPage.putExtra("storeName",m.getStoreName());
                                newPage.putExtra("phone",m.getPhone());
                                newPage.putExtra("address",m.getAddress());
                                newPage.putExtra("introduction",m.getIntroduction());
                                newPage.putExtra("storeBitmap",m.getBitmapName());
                                net1814080903107Activity.startActivity(newPage);
                            }
                        });
                    }
                });
            }
        }catch (IOException ex){
            Log.e("*LoadStore"," "+ex.getMessage());
        }
    }
}
