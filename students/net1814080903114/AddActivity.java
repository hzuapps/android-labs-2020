package edu.hzuapps.androidlabs;

import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.studentapp.until.DatabaseHelper;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText course_name,teacher_name,class_name,phone,num;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
    }
    //初始化表单控件
    private void initView(){
        course_name = (EditText)findViewById(R.id.course_name);
        teacher_name = (EditText) findViewById(R.id.teacher_name);
        class_name = (EditText)findViewById(R.id.class_name);
        phone = (EditText)findViewById(R.id.phone);
        num = (EditText)findViewById(R.id.num);
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener((View.OnClickListener)this);
    }
    /**
     * 获取表单数据
     * 将数据添加到数据库
     */

    public void AddCourse(){
        System.out.println("插入数据");
        //获取表单内容
        String className=class_name.getContext().toString();
        String courseName=course_name.getContext().toString();
        String teacherName=teacher_name.getContext().toString();
        String course_Num=num.getContext().toString();
        System.out.println(className);
        DatabaseHelper helper = new DatabaseHelper(AddActivity.this,"course",2);
        //插入数据库
        SQLiteDatabase data = helper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",1);
        contentValues.put("course_name",courseName);
        contentValues.put("teacher_name",teacherName);
        contentValues.put("class_name",className);
        contentValues.put("num",course_Num);
        data.insert("course",null,contentValues);
        data.close();
        //跳转到课程列表
        Intent in = new Intent(AddActivity.this,CourseListActivity.class);
        AddActivity.this.startActivity(in);

        //插入到数据库

    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.submit:
                this.AddCourse();break;
            default :break;
        }
    }

}