package edu.hzuapps.androidlabs.myView;

import java.io.Serializable;
import java.util.ArrayList;

public class Info implements Serializable {
//    章节文字
    StringBuilder text = new StringBuilder();
//    页数数组
    ArrayList<ArrayList<Integer>> chapter;
//    初始化状态
    Boolean initState;
//    定位
    int position;

    public Info(ArrayList<ArrayList<Integer>> chapter){
        this.chapter=chapter;
    }
    public void set(String text ,Boolean flag,int posit) {
        this.text.replace(0,this.text.length(),text);
        this.initState = flag;
        this.position = posit;
    }
}
