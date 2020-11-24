package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Net1814080903102Activity extends AppCompatActivity {

    ClassArray classArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWeekLine();
        initCourseTable();

        final Net1814080903102Activity thisActivity = this;

        Button addbutton = (Button) findViewById(R.id.button_add);
        addbutton.setOnClickListener(new View.OnClickListener(){//匿名类
            @Override
            public void onClick(View v){//打开
                Intent intent = new Intent(thisActivity, AddClassActivity.class);
                thisActivity.startActivity(intent);
            }
        });

        Button setbutton = (Button) findViewById(R.id.button_setting);
        setbutton.setOnClickListener(new View.OnClickListener(){//匿名类
            @Override
            public void onClick(View v){//打开
                Intent intent = new Intent(thisActivity, SettingActivity.class);
                thisActivity.startActivity(intent);
                //thisActivity.startActivityForResult();
            }
        });

    }
    //在weekLine里添加星期框
    private void initWeekLine(){
        LinearLayout weekLine = (LinearLayout)findViewById(R.id.weekLine);
        for(int i=0;i<7;i++)
        {
            TextView day = new TextView(this);
            day.setText(getDayName(i));
            day.setGravity(1);
            day.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));
            day.setBackgroundResource(R.drawable.shape);
            weekLine.addView(day);
        }
    }
    //将i转换为对应星期
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

    private void initCourseTable(){
        classArray = new ClassArray(JsonIO.get("course.json"));
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.classContent);
        for(int i=1;i<=classArray.getMaxSection();i++){
            LinearLayout layout = new LinearLayout(this);
            layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));
            TextView blank = new TextView(this);
            blank.setText(String.valueOf(i));
            blank.setGravity(Gravity.CENTER_VERTICAL);
            blank.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,0.25f));
            layout.addView(blank);
            for(int j=0;j<7;j++){
                TextView textView = new TextView(this);
                textView.setText(classArray.getCourseName(j,i));
                textView.setGravity(1);
                textView.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));
                if(classArray.getCourseName(j,i)==null){
                    textView.setBackgroundColor(1);
                }
                else {textView.setBackgroundResource(R.drawable.courseshape);}
                textView.setGravity(Gravity.CENTER_VERTICAL);
                layout.addView(textView);
            }
            linearLayout.addView(layout);
        }
    }

}

