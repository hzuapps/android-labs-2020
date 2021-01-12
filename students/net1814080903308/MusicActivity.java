package edu.hzuapps.androidlabs.net1814080903308;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout content;
    private TextView tv1,tv2;
    private FragmentManager fm;
    private FragmentTransaction ft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        content=(FrameLayout)findViewById(R.id.content);

        tv1=(TextView)findViewById(R.id.menu1);
        tv2=(TextView)findViewById(R.id.menu2);

        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);

        fm=getSupportFragmentManager();//若是继承FragmentActivity，fm=getFragmentManger();
        ft=fm.beginTransaction();
        ft.replace(R.id.content,new song1());//默认情况下Fragment1
        ft.commit();
    }
    @Override
    public void onClick(View v){
        ft=fm.beginTransaction();
        switch (v.getId()){
            case R.id.menu1:
                ft.replace(R.id.content,new song1());
                break;
            case R.id.menu2:
                ft.replace(R.id.content,new song2());
                break;
            default:
                break;
        }
        ft.commit();
    }
}

