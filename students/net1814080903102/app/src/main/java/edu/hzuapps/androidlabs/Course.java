package edu.hzuapps.androidlabs;

import org.json.JSONException;
import org.json.JSONObject;

public class Course{
    public String courseName;
    public String courseRoom;
    public String courseDay;
    public String courseNumber;
    public String courseStartWeek;
    public String courseEndWeek;
    public String courseOdd;

    public Course(){}

    public Course(JSONObject json){
        try {
            this.courseName = json.getString("courseName");
            this.courseRoom = json.getString("courseRoom");
            this.courseDay = json.getString("courseDay");
            this.courseNumber = json.getString("courseNumber");
            this.courseStartWeek = json.getString("courseStartWeek");
            this.courseEndWeek = json.getString("courseEndWeek");
            this.courseOdd = json.getString("courseOdd");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public JSONObject toJSONObject(){
        JSONObject json = new JSONObject();
        try {
            json.put("courseName",courseName);
            json.put("courseRoom",courseRoom);
            json.put("courseDay",courseDay);
            json.put("courseNumber",courseNumber);
            json.put("courseStartWeek",courseStartWeek);
            json.put("courseEndWeek",courseEndWeek);
            json.put("courseOdd",courseOdd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
