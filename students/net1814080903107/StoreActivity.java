package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.net.IDN;
import java.net.Inet4Address;

public class StoreActivity extends AppCompatActivity {
    int startPoint =0;
    private boolean flag=false;
    private ListView listView;
    private TextView storeNameView;
    private int storeID;
    private LinearLayout mainView;
    private LinearLayout sideView;
    private LinearLayout snackView;
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
        mainView=findViewById(R.id.mainVIewS);
        sideView=findViewById(R.id.sideVIewS);
        snackView=findViewById(R.id.snackVIewS);
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
                }
                //置顶
                mainView.setVisibility(View.INVISIBLE);
                sideView.setVisibility(View.INVISIBLE);
                snackView.setVisibility(View.INVISIBLE);
                v.setVisibility(View.VISIBLE);
            }
        });
        init(intent);
        new LoadFoodThread(this,mainView, storeID).start();
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
        Bitmap bitmap=(Bitmap)bdl.get("storeBitma");
        storeBitmap.setImageBitmap(bitmap);
    }
    protected void onActivityResult(int reqCode,int resCode,Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (resCode == Activity.RESULT_OK)
            flag=true;
    }

}