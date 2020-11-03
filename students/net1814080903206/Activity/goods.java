package com.example.net1814080903206activity;

import android.app.AlertDialog;
import android.widget.AlphabetIndexer;
import android.widget.Toast;
import android.graphics.*;
public class goods {
    public static Bitmap[] have_choose=new Bitmap[3];
    public static  String[] goods_price=new String[3];
    public Bitmap[] show_goods()
    {
        return have_choose;
    }
    public String[] show_price()
    {
        return goods_price;
    }
    public void get_goods(Bitmap goods,String price)
    {
        for(int i=0;i<2;i++)
        {
           if(have_choose[i]==null && have_choose[i+1]!=null)
           {
               have_choose[i]=have_choose[i+1];
               have_choose[i+1]=null;
           }
           if(i<1 && have_choose[i]==null && have_choose[i+2]!=null)
           {
               have_choose[i]=have_choose[i+2];
               have_choose[i+2]=null;
           }
        }
        for(int i=0;i<3;i++)
        {
            if(have_choose[i]==goods) {
                break;
            }
            else if(have_choose[i]==null)
            {
                have_choose[i]=goods;
                goods_price[i]=price;
                break;
            }
        }
    }
}
