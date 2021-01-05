package edu.hzuapps.androidlabs.net1814080903124;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;

public class FindImage {


    public static String[] Sneaker_url;
    public static String[] Clothes_url;
    public static String[] Acc_url;


   public static void get_image(final String url){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> stringArrayList = new ArrayList<String>();
                String jsonText = getImageurl(url);
                if (jsonText != null) {
                    try {
                        JSONArray jsonArr = new JSONArray(jsonText);
                        for (int i=0 ;i<jsonArr.length();i++) {
                            JSONObject jsonObj = (JSONObject) jsonArr.get(i);
                            String imgurl = jsonObj.getString("url");
                            stringArrayList.add(imgurl);
                        }
                        if(url=="http://8.129.108.24/androidImage/Sneaker/SneakerJson.txt")
                        {
                        Sneaker_url = stringArrayList.toArray(new String[stringArrayList.size()]);
                        }
                        else if(url=="http://8.129.108.24/androidImage/Clothes/ClothesJson.txt") {
                            Clothes_url = stringArrayList.toArray(new String[stringArrayList.size()]);
                        }
                        else{
                            Acc_url = stringArrayList.toArray(new String[stringArrayList.size()]);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }


        public static String getImageurl(String gitApi) {
            URL url = null;
            String jsonText = null;
            try {
                url = new URL(gitApi);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Content-Type", "application/json");
                connection.connect();
                BufferedReader reader = new BufferedReader(new
                        InputStreamReader(connection.getInputStream()));
                String lines;
                StringBuffer sb = new StringBuffer("");
                while ((lines = reader.readLine()) != null) {
                    lines = URLDecoder.decode(lines, "utf-8");
                    sb.append(lines);
                }
                System.out.println(sb);
                jsonText = sb.toString();
                reader.close();
                // 断开连接
                connection.disconnect();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonText;
        }
}
