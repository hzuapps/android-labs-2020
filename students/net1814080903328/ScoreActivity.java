package edu.hzuapps.androidlabs.net1814080903328;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;

import edu.hzuapps.androidlabs.net1814080903328.databinding.ActivityMain2Binding;

public class ScoreActivity extends AppCompatActivity {

    MyViewModel myViewModel;
    NavController controller;
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        //这是新插入的代码
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding = DataBindingUtil.setContentView( this,R.layout.activity_score);
        myViewModel = ViewModelProviders.of(this).get(MyViewModel.class);
        TextView tv = (TextView)findViewById(R.id.textView2);
        TextView tv1 = (TextView)findViewById(R.id.textView5);
        Intent intent = getIntent();
        String data = intent.getStringExtra("editText");
        String data1 = intent.getStringExtra("editText2");
        tv.setText(data);
        tv1.setText(data1);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }
}