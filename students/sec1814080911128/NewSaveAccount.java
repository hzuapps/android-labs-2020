package edu.hzuapps.androidlabs.sec1814080911128;


import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NewSaveAccount {
    //保存账号和密码到data.txt
    public static  boolean saveUserInfo(Context context,String user,String password){
        try {
            //1.通过上下文获取文件输出流
            FileOutputStream fos = context.openFileOutput("data.txt",context.MODE_APPEND);
            //2.把数据写到文件中
            fos.write((user+":"+password).getBytes());
            fos.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static Map<String,String> getUserInfo(Context context){
        String content = "";
        try {
            FileInputStream fis = context.openFileInput("data,txt");
            byte[]  buffer = new byte[fis.available()];
            fis.read(buffer);
            Map<String,String> userMap = new HashMap<String, String>();
            content = new String(buffer);
            String[] infos = content.split(":");
            userMap.put("user",infos[0]);
            userMap.put("password",infos[1]);
            fis.close();
            return userMap;
        } catch (IOException e ) {
            return  null;
        }
    }
}