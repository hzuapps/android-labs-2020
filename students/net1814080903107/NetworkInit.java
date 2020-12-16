package com.example.thefirst;
 
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.example.thefirst.component.*;
import com.example.thefirst.constant.transmission;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class NetworkInit implements transmission {
    private InetAddress inetAddress;
    public NetworkInit(){
        try {
            inetAddress = InetAddress.getByName(sIP);
        }catch (IOException ex){Log.e("..........Net",ex.getMessage());}
    }
    public InetAddress getsIP() {
        return inetAddress;
    }
    public int getsPort() {
        return sPort;
    }
    public static Bitmap loadImage(String imageName){
        Bitmap bitmap=null;
        try {
            HttpURLConnection conn = null;
            URL url = new URL(imageFrom+imageName);
            System.out.println(url.toString());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            }
        }catch (Exception ex){Log.e(".........Net load",ex.getMessage());}
        return bitmap;
    }
}
