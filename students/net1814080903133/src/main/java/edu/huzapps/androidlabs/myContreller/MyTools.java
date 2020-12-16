package edu.hzuapps.androidlabs.myContreller;

import android.content.Context;
import android.content.res.Resources;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyTools {

    static String text0,text1,text2,text3,text4;

//    通过String获取drawable资源
    public static int getResId(String name, Context context){
        Resources r = context.getResources();
        int id = r.getIdentifier(name,"drawable",context.getPackageName());
        return id;
    }

//    通过String获取到Access资源
    public static BufferedReader getBUffStream(String URL, Context context) throws IOException {
        return new BufferedReader(new InputStreamReader(context.getAssets().open(URL)));
    }
}
