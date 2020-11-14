package com.example.thefirst;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Net1814080903107Activity extends AppCompatActivity {
    int startPoint=0;
    private MyVariable myVariable;
    private ScrollView scrollView;
    private LinearLayout scrollLin;
    private Button seache;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);

        myVariable =new MyVariable();

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

    //加载商店
    //
    public void loadData(int startPoint){
        LoadDataThread ld=new LoadDataThread(this,startPoint);
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
        LinearLayout l1=(LinearLayout)v;
        LinearLayout l2=(LinearLayout)l1.getChildAt(1);
        CharSequence title=((TextView)(l2.getChildAt(0))).getText();
        newPage.putExtra("title",title);
        newPage.putExtra("id",((MyLinearLayout)(v)).getid());
        startActivity(newPage);
    }
}