package com.example.thefirst.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.thefirst.Net1814080903107Activity;

/*
若返回imageView为空，表示没有先getXXXLin
 */
public class MyMeunLinearLayout extends LinearLayout{
    //商店ID或食品ID
    private int storeID;
    private String storeName;
    private String phone;
    private String address;
    private String introduction;
    private String bitmapName;
    private Context context;
    private ImageView i1;
    private LinearLayout l2;
    private TextView t1;
    private TextView t2;
    public MyMeunLinearLayout(Context context) { super(context); this.context=context;init();}
    public MyMeunLinearLayout(Context context, @Nullable AttributeSet attrs) { super(context, attrs);this.context=context; init();}
    public MyMeunLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); this.context=context;init();}
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyMeunLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) { super(context, attrs, defStyleAttr, defStyleRes); this.context=context;init();}

    private void init(){
        i1=new ImageView(MyMeunLinearLayout.this.getContext());
        l2=new LinearLayout(MyMeunLinearLayout.this.getContext());
        t1=new TextView(l2.getContext());
        t2=new TextView(l2.getContext());

        MyMeunLinearLayout.this.setOrientation(LinearLayout.HORIZONTAL);//行布局
        MyMeunLinearLayout.this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,400));

        i1.setLayoutParams(new LinearLayout.LayoutParams(6, LinearLayout.LayoutParams.MATCH_PARENT,1));
        i1.setScaleType(ImageView.ScaleType.FIT_XY);

        l2.setOrientation(LinearLayout.VERTICAL);//列布局
        l2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT,1));

        t1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        t2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        l2.addView(t1);
        l2.addView(t2);

        MyMeunLinearLayout.this.addView(i1);
        MyMeunLinearLayout.this.addView(l2);


    }
    public MyMeunLinearLayout setStoreID(int storeID) {
        this.storeID = storeID;
        return this;
    }
    public MyMeunLinearLayout setStoreName(String storeName){
        t1.setText(storeName);
        this.storeName=storeName;
        return this;
    }
    public MyMeunLinearLayout setIntroduction(String introduction){
        t2.setText(introduction);
        this.introduction=introduction;
        return this;
    }
    public MyMeunLinearLayout setPhone(String phone){
        this.phone=phone;
        return this;
    }
    public MyMeunLinearLayout setAddress(String address){
        this.address=address;
        return this;
    }

    public MyMeunLinearLayout setBitmapName(String bitmapName){
        this.bitmapName=bitmapName;
        return this;
    }
    public String getStoreName() {
        return storeName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getBitmapName() {
        return bitmapName;
    }

    public int getStoreID(){
        return storeID;
    }
    public ImageView getImageView(){return i1;}

}
