package com.example.thefirst.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class MyFoodLinearLayout extends LinearLayout{
    private int foodID;
    private String foodName;
    private int price;
    private String introduction;
    private Bitmap foodBitmap;

    private Context context;
    private ImageView i1;
    private LinearLayout l2;
    private TextView t1;
    private Button b1;
    private TextView t2;
    private TextView t3;
    public MyFoodLinearLayout(Context context) { super(context); this.context=context;init();}
    public MyFoodLinearLayout(Context context, @Nullable AttributeSet attrs) { super(context, attrs);this.context=context; init();}
    public MyFoodLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) { super(context, attrs, defStyleAttr); this.context=context;init();}
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyFoodLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) { super(context, attrs, defStyleAttr, defStyleRes); this.context=context;init();}

    public ImageView getImageView(){return i1;}
    public void init(){
        i1=new ImageView(MyFoodLinearLayout.this.getContext());
        l2=new LinearLayout(MyFoodLinearLayout.this.getContext());
        t1=new TextView(l2.getContext());
        b1=new Button(l2.getContext());
        t2=new TextView(l2.getContext());
        t3=new TextView(l2.getContext());

        MyFoodLinearLayout.this.setOrientation(LinearLayout.HORIZONTAL);//行布局
        MyFoodLinearLayout.this.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,300));

        i1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,2));
        i1.setScaleType(ImageView.ScaleType.FIT_XY);

        l2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,1));
        l2.setOrientation(LinearLayout.VERTICAL);

        t1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,2));

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });

        t2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,2));
        t3.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,2));
        l2.addView(t1);
        l2.addView(b1);
        l2.addView(t2);
        l2.addView(t3);
        MyFoodLinearLayout.this.addView(i1);
        MyFoodLinearLayout.this.addView(l2);
    }

    public MyFoodLinearLayout setFoodID(int foodID) {
        this.foodID = foodID;
        return this;
    }

    public MyFoodLinearLayout setFoodName(String foodName) {
        this.foodName = foodName;
        t1.setText(foodName);
        return this;

    }

    public MyFoodLinearLayout setPrice(int price) {
        this.price = price;
        t3.setText(Integer.toString(price));
        return this;
    }

    public MyFoodLinearLayout setIntroduction(String introduction) {
        this.introduction = introduction;
        t2.setText(introduction);
        return this;

    }

    public MyFoodLinearLayout setFoodBitmap(Bitmap foodBitmap) {
        this.foodBitmap = foodBitmap;
        return this;

    }

    public int getFoodID() {
        return foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public int getPrice() {
        return price;
    }

    public String getIntroduction() {
        return introduction;
    }

    public Bitmap getFoodBitmap() {
        return foodBitmap;
    }
}
