package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.thefirst.component.MyFoodLinearLayout;

import java.net.IDN;
import java.net.Inet4Address;

public class StoreActivity extends AppCompatActivity {
    int startPoint = 0;
    int startPoint1 = 1;
    int startPoint2 = 2;
    private boolean flag=false;
    private ListView listView;
    private TextView storeNameView;
    private int storeID;
    private ScrollView mainView;
    private ScrollView sideView;
    private ScrollView snackView;
    private ScrollView shopCar;
    private LinearLayout mainViewS;
    private LinearLayout sideViewS;
    private LinearLayout snackViewS;
    private LinearLayout shopCarS;
    private Button phoneButton;
    private TextView storeIntroduction;
    private ImageView storeBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        Intent intent=getIntent();
        listView=findViewById(R.id.chooseList);
        storeNameView=findViewById(R.id.storeName);
        mainView=findViewById(R.id.mainView);
        sideView=findViewById(R.id.sideView);
        snackView=findViewById(R.id.snackView);
        shopCar=findViewById(R.id.shopCar);
        mainViewS=findViewById(R.id.mainViewS);
        sideViewS=findViewById(R.id.sideViewS);
        snackViewS=findViewById(R.id.snackViewS);
        shopCarS=findViewById(R.id.shopCarS);

        phoneButton=findViewById(R.id.phoneButton);
        storeIntroduction=findViewById(R.id.storeIntroduction);
        storeBitmap=findViewById(R.id.storeBitmap);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v=null;
                switch (position){
                    case 0:
                        v=mainView;
                        break;
                    case 1:
                        v=sideView;
                        break;
                    case 2:
                        v=snackView;
                        break;
                    case 3:
                        v=shopCar;
                }
                //置顶
                mainView.setVisibility(View.INVISIBLE);
                sideView.setVisibility(View.INVISIBLE);
                snackView.setVisibility(View.INVISIBLE);
                shopCar.setVisibility(View.INVISIBLE);
                v.setVisibility(View.VISIBLE);
            }
        });
        init(intent);
        initListen();
        initShowCarS();
        //初始化商品
        new LoadFoodThread(this,mainViewS, storeID,0,shopCarS).start();
        new LoadFoodThread(this,sideViewS, storeID,1,shopCarS).start();
        new LoadFoodThread(this,snackViewS, storeID,2,shopCarS).start();
    }
    //初始化购物车
    private void initShowCarS(){
        LinearLayout linearLayout=new LinearLayout(shopCarS.getContext());
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        Button buy=new Button(linearLayout.getContext());
        buy.setText("购买");
        Button clear=new Button(linearLayout.getContext());
        clear.setText("清空");
        //跳转页面
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPage=new Intent(StoreActivity.this,ResultActivity.class);
                StoreActivity.this.startActivity(newPage);
            }
        });
        //清除
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoreActivity.this.shopCarS.removeAllViews();
                initShowCarS();
            }
        });
        linearLayout.addView(buy);
        linearLayout.addView(clear);
        shopCarS.addView(linearLayout);
    }
    //滑动监听
    @SuppressLint("ClickableViewAccessibility")
    private void initListen(){

        mainView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN :
                        break;
                    case MotionEvent.ACTION_MOVE :
                        break;
                    case MotionEvent.ACTION_UP :
                        if(mainView.getChildAt(0).getMeasuredHeight()<=mainView.getScrollY()+mainView.getHeight()){
                            new LoadFoodThread(StoreActivity.this,mainViewS,storeID,0,shopCarS).start();
                        }
                        break;
                }
                return false;
            }
        });

        sideView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN :
                        break;
                    case MotionEvent.ACTION_MOVE :
                        break;
                    case MotionEvent.ACTION_UP :
                        if(sideView.getChildAt(0).getMeasuredHeight()<=sideView.getScrollY()+sideView.getHeight()){
                            new LoadFoodThread(StoreActivity.this,sideViewS,storeID,1,shopCarS).start();
                        }
                        break;
                }
                return false;
            }
        });

        snackView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN :
                        break;
                    case MotionEvent.ACTION_MOVE :
                        break;
                    case MotionEvent.ACTION_UP :
                        if(snackView.getChildAt(0).getMeasuredHeight()<=snackView.getScrollY()+snackView.getHeight()){
                            new LoadFoodThread(StoreActivity.this,mainViewS,storeID,2,shopCarS).start();
                        }
                        break;
                }
                return false;
            }
        });

    }
    private void init(final Intent intent){
        storeID=intent.getIntExtra("storeID",0);
        storeNameView.setText(intent.getStringExtra("storeName"));
        phoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse("tel:"+intent.getStringExtra("phone")));
                StoreActivity.this.startActivity(i);
            }
        });
        //address
        storeIntroduction.setText(intent.getStringExtra("introduction"));
        Bundle bdl=intent.getExtras();
        Bitmap bitmap=(Bitmap)bdl.get("storeBitmap");
        storeBitmap.setImageBitmap(bitmap);
    }
    protected void onActivityResult(int reqCode,int resCode,Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (resCode == Activity.RESULT_OK)
            flag=true;
    }

}