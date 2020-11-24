package edu.hzuapps.androidlabs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassArray {
    int maxSection=0;
    Map<Integer,Course>[] courseTable = new HashMap[7];

    public ClassArray(JSONObject json){
        for(int i=0;i<7;i++){
            courseTable[i] = new HashMap<Integer, Course>();
        }
        if(json != null){
            try {
                for(int i=0;i<7;i++){
                    JSONObject row = json.getJSONObject(String.valueOf(i));
                    Iterator<String> iterator = row.keys();
                    if(iterator.hasNext()){
                        String key = iterator.next();
                        courseTable[i].put(Integer.valueOf(key),new Course(row.getJSONObject(key)));
                        if(maxSection<Integer.valueOf(key)){
                            maxSection = Integer.valueOf(key);
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String getCourseName(int day,int section){
        Course course = courseTable[day].get(section);
        if(course==null){
            return null;
        }
        return course.courseName;
    }

    public void add(int day,int section,Course course){
        courseTable[day].put(section,course);
    }

    public int getMaxSection(){
        return maxSection;
    }

    public JSONObject toJsonObject(){
        JSONObject table = new JSONObject();
        try{
            for(int i=0;i<7;i++){
                JSONObject row = new JSONObject();
                for (Integer courseNum:courseTable[i].keySet()){
                    row.put(courseNum.toString(),courseTable[i].get(courseNum).toJSONObject());
                }
                table.put(String.valueOf(i),row);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return table;
    }



}

