package com.example.thefirst.model;

import android.view.View;

import java.io.DataInputStream;
import java.net.URL;

public class DownloadModel {
    private View view;
    private int type;
    private String bitmapName;
    public DownloadModel(View view,int type,String name){
        this.view=view;
        this.type=type;
        this.bitmapName=name;
    }

    public View getView() {
        return view;
    }

    public int getType() {
        return type;
    }

    public String getBitmapName() {
        return bitmapName;
    }
}
