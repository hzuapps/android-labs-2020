package edu.hzuapps.androidlabs.net1814080903111;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Check_recordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_record);

        TextView tv_showdate =(TextView) findViewById(R.id.tv_date);

        Calendar calendar = Calendar.getInstance();
        tv_showdate.setText(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1));
    }
}
