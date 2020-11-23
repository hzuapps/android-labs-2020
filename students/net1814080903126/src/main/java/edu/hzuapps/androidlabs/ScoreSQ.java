package edu.hzuapps.androidlabs;

import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.PriorityQueue;

public class ScoreSQ {
   public static void save(PriorityQueue<Integer> scores){
       SharedPreferences scoresSave = ApplicationGetter.getCurApplication().getSharedPreferences("scoresSave", 0);
       SharedPreferences.Editor edit = scoresSave.edit();
       Integer score;
       int i=0;
       while ((score = scores.poll())!=null){
           edit.putString(String.valueOf(i++),String.valueOf(score));
       }
       edit.commit();
   }

   public static PriorityQueue<Integer> road(){
       SharedPreferences scoresSave = ApplicationGetter.getCurApplication().getSharedPreferences("scoresSave", 0);
       PriorityQueue<Integer> scores = new PriorityQueue<>();
       for(String rank:scoresSave.getAll().keySet()){
            scores.offer(Integer.valueOf(scoresSave.getString(rank,"")));
       }
       return scores;
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
