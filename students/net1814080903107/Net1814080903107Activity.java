package com.example.thefirst;
 
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.thefirst.adapter.MyFragmentStateAdapter;
import com.example.thefirst.component.FoodFragment;
import com.example.thefirst.component.MyMeunLinearLayout;
import com.example.thefirst.component.SelectFragment;
import com.example.thefirst.constant.transmission;
import com.example.thefirst.model.DownloadModel;
import com.example.thefirst.pool.DownloadPool;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class Net1814080903107Activity extends AppCompatActivity implements transmission {
    int startPoint=0;
    private NetworkInit networkInit;
    private Button seache;//搜索按钮
    private EditText editText;//搜索框
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private String[] title={"美食","甜品","饮料","搜索"};
    public MyFragmentStateAdapter myFragmentStateAdapter;
    public SelectFragment sFragment=new SelectFragment(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);
        init();
        networkInit =new NetworkInit();

        editText=findViewById(R.id.editTextTextPersonName);
        seache=findViewById(R.id.buttonSeache);
        tabLayout=findViewById(R.id.tab);
        viewPager2=findViewById(R.id.viewPager2);
        
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
                        loadData(startPoint);
                    }
                    break;
            }
            return false;
            }
        });
        seache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent searchIntent=new Intent(Net1814080903107Activity.this, SearchActivity.class);
            startActivity(searchIntent);
            }
        });
        //加载商店
        loadData(startPoint);
    }
>>>>>>> master

        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> tab.setText(title[position])
        ).attach();

    }
    public void init(){
        new DownloadPool(this).start();
    }
    public void seache(View v){
        final String kedWord=editText.getText().toString();
        if(kedWord==null||kedWord=="")
            return ;
        sFragment.clean();
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
                  Log.d("*Net seache","will add "+retNum+" Lin");
                  for(int i=0;i<retNum;i++){
                      final int storeID = dis.readInt();
                      final String storeName=dis.readUTF();
                      final String phone=dis.readUTF();
                      final String address=dis.readUTF();
                      final String introduce=dis.readUTF();
                      final String storeBitmap=dis.readUTF();
                      Net1814080903107Activity.this.runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              LinearLayout l=sFragment.getLinearLayout();
                              MyMeunLinearLayout myMeunLinearLayout =new MyMeunLinearLayout(l.getContext());
                              myMeunLinearLayout.
                                      setStoreID(storeID).
                                      setStoreName(storeName).
                                      setPhone(phone).
                                      setAddress(address).
                                      setIntroduction(introduce).
                                      setBitmapName(storeBitmap);
                              l.addView(myMeunLinearLayout);
                              DownloadPool.queue.add(new DownloadModel(myMeunLinearLayout.getImageView(), IMAGEVIEW,storeBitmap));
                              myMeunLinearLayout.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Intent newPage=new Intent(Net1814080903107Activity.this,StoreActivity.class);
                                      MyMeunLinearLayout m=(MyMeunLinearLayout)v;
                                      newPage.putExtra("storeID",m.getStoreID());
                                      newPage.putExtra("storeName",m.getStoreName());
                                      newPage.putExtra("phone",m.getPhone());
                                      newPage.putExtra("address",m.getAddress());
                                      newPage.putExtra("introduction",m.getIntroduction());
                                      newPage.putExtra("storeBitmap",m.getBitmapName());
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
}
