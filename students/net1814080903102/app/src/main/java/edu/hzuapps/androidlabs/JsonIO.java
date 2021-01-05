package edu.hzuapps.androidlabs;

import android.app.Application;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class JsonIO {
    public static void save(JSONObject json,String fileName){
        String jsonText = json.toString();
        String savePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = overrideFile(savePath);
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(jsonText);
            System.out.println(savePath);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject get(String fileName){
        String savePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath() + "/" + fileName;
        File file = openFile(savePath);
        StringBuffer sb = new StringBuffer();
        String str = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while((str = br.readLine()) != null) {
                sb.append(str);
                sb.append("\r\n");
            }
            br.close();
            JSONObject json = new JSONObject(sb.toString());
            return json;
        } catch (Exception e) {
            return null;
        }
    }
    private static File openFile(String path){
        File file = new File(path);
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    private static File overrideFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static class ApplicationGetter{
        public static Application getCurApplication(){
            Application application = null;
            try{
                Class atClass = Class.forName("android.app.ActivityThread");
                Method currentApplicationMethod = atClass.getDeclaredMethod("currentApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class1:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }

            if(application != null)
                return application;

            try{
                Class atClass = Class.forName("android.app.AppGlobals");
                Method currentApplicationMethod = atClass.getDeclaredMethod("getInitialApplication");
                currentApplicationMethod.setAccessible(true);
                application = (Application) currentApplicationMethod.invoke(null);
                Log.d("fw_create","curApp class2:"+application);
            }catch (Exception e){
                Log.d("fw_create","e:"+e.toString());
            }
            return application;
        }
    }

}
