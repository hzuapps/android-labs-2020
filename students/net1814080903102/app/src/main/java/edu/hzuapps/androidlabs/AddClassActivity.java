package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class AddClassActivity extends AppCompatActivity {
    ClassArray classArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addclass);

        final AddClassActivity thisActivity = this;

        Button addbutton = (Button) findViewById(R.id.addCourse);
        addbutton.setOnClickListener(new View.OnClickListener(){//匿名类
            @Override
            public void onClick(View v){//打开
                addCourse();
                Intent intent = new Intent(thisActivity, Net1814080903102Activity.class);
                thisActivity.startActivity(intent);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.courseDay);
        //数据
        ArrayList data_list = new ArrayList<String>();
        for(int i=0;i<7;i++){
            data_list.add(getDayName(i));
        }
        //适配器
        ArrayAdapter<String> arr_adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data_list);
        //设置样式
        arr_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //加载适配器
        spinner.setAdapter(arr_adapter);
    }

    private String getDayName(int day)
    {
        switch (day){
            case 0:return "周一";
            case 1:return "周二";
            case 2:return "周三";
            case 3:return "周四";
            case 4:return "周五";
            case 5:return "周六";
            case 6:return "周日";
        }
        return null;
    }
    private String getDayNum(String day){
        switch (day){
            case "周一":return "0";
            case "周二":return "1";
            case "周三":return "2";
            case "周四":return "3";
            case "周五":return "4";
            case "周六":return "5";
            case "周日":return "6";
        }
        return null;
    }


    private void addCourse(){
        classArray = new ClassArray(JsonIO.get("course.json"));
        Course course = getCourse();
        classArray.add(Integer.valueOf(course.courseDay),Integer.valueOf(course.courseNumber),course);
        JsonIO.save(classArray.toJsonObject(),"course.json");
    }

    private Course getCourse(){
        Course course = new Course();
        course.courseName = ((EditText)findViewById(R.id.courseName)).getText().toString();
        course.courseRoom = ((EditText)findViewById(R.id.courseRoom)).getText().toString();
        course.courseDay = getDayNum((String)((Spinner)findViewById(R.id.courseDay)).getSelectedItem());
        course.courseNumber = ((EditText)findViewById(R.id.courseNumber)).getText().toString();
        course.courseStartWeek = ((EditText)findViewById(R.id.startWeek)).getText().toString();
        course.courseEndWeek = ((EditText)findViewById(R.id.endWeek)).getText().toString();
        course.courseOdd = ((EditText)findViewById(R.id.courseOdd)).getText().toString();
        return course;
    }
}