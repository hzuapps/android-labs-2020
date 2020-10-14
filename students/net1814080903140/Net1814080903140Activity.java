package edu.hzuapps.androidlabs.net1814080903140;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.List;

public abstract class Net1814080903140Activity extends AppCompatActivity implements View.OnClickListener{
    ImageView addCitylv,morelv;
    LinearLayout pointLayour;
    RelativeLayout outLayout;
    ViewPager mainVp; //ViewPager的数据源
    List<Fragment>fragmentList;
    List<String>cityList;
    List<ImageView>imgList;
    private int bgNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net1814080903140);
    }
}