package com.example.thefirst.component;
 
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.thefirst.Net1814080903107Activity;
import com.example.thefirst.R;

public class SelectFragment extends FoodFragment {

    public SelectFragment(Net1814080903107Activity n){
        super(n);
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
        return view;
    }
    public void clean(){
        linearLayout.removeAllViews();
    }
}
