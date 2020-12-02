package com.example.thefirst;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import com.example.thefirst.component.*;
import com.example.thefirst.constant.transmission;
import com.example.thefirst.model.DownloadModel;
import com.example.thefirst.pool.DownloadPool;

public class Net1814080903107Activity extends AppCompatActivity implements transmission {
    int startPoint=0;
    private NetworkInit networkInit;
    private ScrollView scrollView;
    private LinearLayout scrollLin;
    private Button seache;//搜索按钮
    private EditText editText;//搜索框

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        init();
        networkInit =new NetworkInit();

        editText=findViewById(R.id.editTextTextPersonName);
        seache=findViewById(R.id.buttonSeache);
        scrollView=findViewById(R.id.scrollView);
        scrollLin=findViewById(R.id.scrollLin);

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN :
                    break;
                case MotionEvent.ACTION_MOVE :
                    break;
                case MotionEvent.ACTION_UP :
                    if(scrollView.getChildAt(0).getMeasuredHeight()<=scrollView.getScrollY()+scrollView.getHeight()){
                        loadData();
                    }
                    break;
            }
            return false;
            }
        });
        //加载商店
        loadData();
    }
    public void init(){
        new DownloadPool(this).start();
    }
    public void seache(View v){
        final String kedWord=editText.getText().toString();
        Thread updateLin=new Thread(){
          @Override
          public void run(){
              try{
                  Socket socket=new Socket(networkInit.getsIP(), networkInit.getsPort());
                  DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                  DataInputStream dis=new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                  dos.writeInt(SELECT_STORE);//服务类型
                  dos.writeUTF(kedWord);
                  dos.flush();
                  int retNum=dis.readInt();
                  Net1814080903107Activity.this.runOnUiThread(new Runnable() {
                      @Override
                      public void run() {
                          scrollLin.removeAllViews();
                      }
                  });
                  Log.d("*Net seache","will add "+retNum+" Lin");
                  for(int i=0;i<retNum;i++){
                      final String storeName=dis.readUTF();
                      final String introduce=dis.readUTF();
                      final String bitmapName=dis.readUTF();
                      Net1814080903107Activity.this.runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              MyMeunLinearLayout myMeunLinearLayout =new MyMeunLinearLayout(scrollLin.getContext());
                              myMeunLinearLayout.setStoreName(storeName);
                              myMeunLinearLayout.setIntroduction(introduce);
                              scrollLin.addView(myMeunLinearLayout);
                              DownloadPool.queue.add(new DownloadModel(myMeunLinearLayout.getImageView(), IMAGEVIEW,bitmapName));
                              myMeunLinearLayout.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent newPage=new Intent(Net1814080903107Activity.this,StoreActivity.class);
                                      MyMeunLinearLayout m=(MyMeunLinearLayout)v;
                                      int ID=m.getStoreID();
                                      newPage.putExtra("storeID",ID);
                                      startActivity(newPage);
                                  }
                              });
                          }
                      });
                      Log.d("*Net seache","create Lin success\n");
                  }
                if(socket!=null)
                    socket.close();
              }catch (Exception ex){
                  Log.e("Net sea error",ex.getMessage()+"\n");
              }
          }
        };
        updateLin.start();
    }
    //加载商店
    //
    public void loadData(){
        LoadStoreThread ld=new LoadStoreThread(this,scrollLin);
        ld.start();
    }

    public NetworkInit getNetworkInit(){
        return networkInit;
    }
    public LinearLayout getScrollLin(){
        return scrollLin;
    }
    public void clickStore(View v){
        Intent newPage=new Intent(Net1814080903107Activity.this,StoreActivity.class);
        LinearLayout l1=(LinearLayout)v;
        LinearLayout l2=(LinearLayout)l1.getChildAt(1);
        CharSequence title=((TextView)(l2.getChildAt(0))).getText();
        newPage.putExtra("title",title);
        newPage.putExtra("id",((MyMeunLinearLayout)(v)).getId());
        startActivity(newPage);
    }
}