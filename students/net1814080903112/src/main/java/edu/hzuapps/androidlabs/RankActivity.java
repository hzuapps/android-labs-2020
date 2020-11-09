package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class RankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);
        initRankTable();
    }

    private void initRankTable(){
        LinearLayout rankTable = (LinearLayout)findViewById(R.id.rankTable);
        for(int i=0;i<10;i++){
            LinearLayout rankItem = new LinearLayout(this);
            rankItem.setOrientation(LinearLayout.HORIZONTAL);
            TextView textView = new TextView(this);
            textView.setText("第"+(i+1)+"名");
            rankItem.addView(textView);
            rankTable.addView(rankItem);
        }
    }
}