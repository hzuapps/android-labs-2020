package com.example.thefirst.component;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.thefirst.LoadStoreThread;
import com.example.thefirst.Net1814080903107Activity;
import com.example.thefirst.R;

public class FoodFragment extends Fragment {
    private Net1814080903107Activity net1814080903107Activity;
    protected MyScrollView myScrollView;
    protected LinearLayout linearLayout;
    protected LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    public FoodFragment(Net1814080903107Activity n){
        this.net1814080903107Activity=n;
    }

    public LinearLayout getLinearLayout(){
        return linearLayout;
    } 
    @CallSuper
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
    }
    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.scrollview,null);
        myScrollView=view.findViewById(R.id.sv);
        linearLayout=view.findViewById(R.id.lv);
        myScrollView.setBackgroundColor(Color.BLACK);
        linearLayout.setBackgroundColor(Color.WHITE);
        myScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN :
                        break;
                    case MotionEvent.ACTION_MOVE :
                        break;
                    case MotionEvent.ACTION_UP :
                        if(myScrollView.getChildAt(0).getMeasuredHeight()<=myScrollView.getScrollY()+myScrollView.getHeight()){
                            LoadStoreThread ld=new LoadStoreThread(net1814080903107Activity,linearLayout);
                            ld.start();
                        }
                        break;
                }
                return false;
            }
        });
        LoadStoreThread ld=new LoadStoreThread(net1814080903107Activity,linearLayout);
        ld.start();
        return view;
    }
    public void clean(){
        linearLayout.removeAllViews();
    }
}
