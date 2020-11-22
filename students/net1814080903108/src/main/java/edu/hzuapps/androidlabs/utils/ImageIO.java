package edu.hzuapps.androidlabs.utils;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class ImageIO {
    public static boolean saveImage(String imageName, Bitmap image){
        String savePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath()  + imageName + ".png";
        OutputStream fileOut = null;
        File file = new File(savePath);
        try {
            fileOut = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 0, fileOut);
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }finally {
            try {
                if (fileOut != null) {
                    fileOut.flush();
                    fileOut.close();
                }
            } catch (IOException ignored) {}
        }
    }

    public static boolean deleteImage(String imageName){
        String imagePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath() + imageName + ".png";
        File imageFile = new File(imagePath);
        if (imageFile.isFile() && imageFile.exists()) {
            return imageFile.delete();
        }
        return false;
    }

    public static Bitmap getImage(String imageName){
        String savePath = ApplicationGetter.getCurApplication().getFilesDir().getAbsolutePath()  + imageName + ".png";
        Bitmap bitmap = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(savePath);
            bitmap  = BitmapFactory.decodeStream(fis);
            return bitmap;
        } catch (FileNotFoundException e) {
            return null;
        }
        finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ignored) {}
        }
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
