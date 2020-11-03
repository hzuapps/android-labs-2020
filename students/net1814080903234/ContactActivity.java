package edu.hzuapp.androidlabs.net1814080903234;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private List<CharSequence> eduList = null;
    private ArrayAdapter<CharSequence> eduAdapter = null;
    private Spinner eduSpinner= null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        final Activity thisActivity = this;

        Button btnMian = (Button) findViewById(R.id.con1);
        btnMian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Net1814080903234Activity.class);
                thisActivity.startActivity(intent);
            }
        });

        //找到Spinner控件
        eduSpinner = (Spinner)super.findViewById(R.id.yuyan);
        eduSpinner.setPrompt("请选择您需要的语言:");
        eduList = new ArrayList<CharSequence>();
        eduList.add("英语");
        eduList.add("中文");
        eduList.add("日语");
        eduList.add("其他");
        eduAdapter = new ArrayAdapter<CharSequence>(this,android.R.layout.simple_spinner_item,eduList);
        eduAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eduSpinner.setAdapter(eduAdapter);
    }
}
