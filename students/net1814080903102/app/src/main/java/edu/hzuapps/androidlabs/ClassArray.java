package edu.hzuapps.androidlabs;

import java.util.HashMap;
import java.util.Map;

public class ClassArray {
    int maxSection=0;
    Map<Integer,Course>[] courseTable = new HashMap[7];

    ClassArray(){
        for(int i=0;i<7;i++){
            courseTable[i] = new HashMap<Integer, Course>();
        }
    }

    public String getCourseName(int day,int section){
        return courseTable[day].get(section).courseName;
    }

    public void add(int day,int section,String Name){
        Course course = new Course();
        course.courseName = Name;
        if(section>maxSection)maxSection=section;
        courseTable[day].put(section,course);
    }

    public int getMaxSection(){
        return maxSection;
    }
}

class Course{
    public String courseName;

}