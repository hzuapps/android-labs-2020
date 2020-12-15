package com.example.thefirst;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyLinearLayout extends LinearLayout{
    //商店ID或食品ID
    private String ID;
    public MyLinearLayout(Context context) {
        super(context);
    }
    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    public String getid(){
        return ID;
    }
    
    public void setid(String ID){
        this.ID=ID;
    }
    public LinearLayout getMeunLin(Bitmap image, String title, String introduce){
        ImageView imageView=new ImageView(getContext());
        LinearLayout l2=new LinearLayout(getContext());
        TextView t1=new TextView(getContext());
        TextView t2=new TextView(getContext());

        this.setOrientation(LinearLayout.HORIZONTAL);//行布局
        this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,300));

        imageView.setLayoutParams(new LinearLayout.LayoutParams(6, LinearLayout.LayoutParams.MATCH_PARENT,1));
        imageView.setImageBitmap(image);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.addView(imageView);

        l2.setOrientation(LinearLayout.VERTICAL);//列布局
        l2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT,1));

        t1.setText(title);
        t1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        t2.setText(introduce);
        t2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        l2.addView(t1);
        l2.addView(t2);

        this.addView(l2);
        return this;
    }
    public LinearLayout getFoodLin(Bitmap bitmap,String foodName,String price){
        ImageView i1=new ImageView(getContext());
        LinearLayout l2=new LinearLayout(getContext());
        l2.setOrientation(LinearLayout.VERTICAL);
        TextView t1=new TextView(l2.getContext());
        Button b1=new Button(l2.getContext());
        TextView t2=new TextView(l2.getContext());

        i1.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,2));
        i1.setScaleType(ImageView.ScaleType.FIT_XY);
        i1.setImageBitmap(bitmap);

        l2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));

        t1.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,3));
        t1.setText(foodName);

        //b1

        t2.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,3));
        t2.setText(price);
        return this;
    }
}