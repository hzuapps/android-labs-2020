package edu.hzuapp.androidlabs;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import java.lang.reflect.Method;

public class ScoreSave {
    public static void save(Integer nowScore){
        SharedPreferences scoresSave = ApplicationGetter.getCurApplication().getSharedPreferences("scoresSave", 0);
        SharedPreferences.Editor edit = scoresSave.edit();
        Integer preScore = Integer.valueOf(scoresSave.getString("MaxScore","0"));
        nowScore = preScore>nowScore?preScore:nowScore;
        edit.putString("MaxScore",String.valueOf(nowScore));
        edit.commit();
    }

    public static String load(){
        SharedPreferences scoresSave = ApplicationGetter.getCurApplication().getSharedPreferences("scoresSave", 0);
        SharedPreferences.Editor edit = scoresSave.edit();
        return scoresSave.getString("MaxScore","0");
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
