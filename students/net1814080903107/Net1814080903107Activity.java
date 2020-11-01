package com.example.thefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Net1814080903107Activity extends AppCompatActivity {
    private MyVariable myVariable;
    private LinearLayout scrollLin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        myVariable =new MyVariable();

        Button seache=findViewById(R.id.buttonSeache);
        scrollLin=findViewById(R.id.scrollLin);
        seache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchIntent=new Intent(Net1814080903107Activity.this, SearchActivity.class);
                startActivity(searchIntent);
            }
        });
        //加载商店
        loadData();
    }
    //加载商店
    public void loadData(){
        LoadDataThread ld=new LoadDataThread(this);
        ld.start();
    }

    public MyVariable getMyVariable(){
        return myVariable;
    }
    public LinearLayout getScrollLin(){
        return scrollLin;
    }
    public void clickStore(View v){
        Intent newPage=new Intent(Net1814080903107Activity.this,StoreActivity.class);
        startActivity(newPage);
    }
    public LinearLayout pullMessage(Bitmap image, String title, String introduce){
        LinearLayout l1=new LinearLayout(Net1814080903107Activity.this);
        ImageView imageView=new ImageView(this);
        LinearLayout l2=new LinearLayout(this);
        TextView t1=new TextView(this);
        TextView t2=new TextView(this);

        l1.setOrientation(LinearLayout.HORIZONTAL);//行布局
        l1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,300));

        imageView.setLayoutParams(new LinearLayout.LayoutParams(6, LinearLayout.LayoutParams.MATCH_PARENT,1));
        imageView.setImageBitmap(image);
        l1.addView(imageView);

        l2.setOrientation(LinearLayout.VERTICAL);//列布局
        l2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT,1));

        t1.setText(title);
        t1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));

        t2.setText(introduce);
        t2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1));
        l2.addView(t1);
        l2.addView(t2);

        l1.addView(l2);
        return l1;
    }
}