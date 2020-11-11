package edu.hzuapps.androidlabs.net1814080903219;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PhysicalScoreActivity extends AppCompatActivity {

    private ListView listView;
    private Button returnBtn;
    private ImageButton returnImgBtn;

    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;
    private TextView tv5;
    private TextView tv6;
    private TextView tv7;
    private TextView tv8;
    private PhysicalScore physicalScore = new PhysicalScore(172,55,3985,7,218,18,240,10,19,70);

    private BaseAdapter adapter = new BaseAdapter() {
        private LayoutInflater inflater;
        @Override
        public int getCount() {
            return 1;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view;
            inflater = getLayoutInflater();

            if (convertView == null) {
                view = inflater.inflate(R.layout.listview_item,null);
            } else {
                view = convertView;
            }
            tv1 = view.findViewById(R.id.tv1);
            tv2 = view.findViewById(R.id.tv2);
            tv3 = view.findViewById(R.id.tv3);
            tv4 = view.findViewById(R.id.tv4);
            tv5 = view.findViewById(R.id.tv5);
            tv6 = view.findViewById(R.id.tv6);
            tv7 = view.findViewById(R.id.tv7);
            tv8 = view.findViewById(R.id.tv8);

            tv1.setText("身高(cm)："+physicalScore.getHigh());
            tv2.setText("体重(kg)："+physicalScore.getWeight());
            tv3.setText("50米跑(s)："+physicalScore.getRun50Time());
            tv4.setText("立定跳远(cm)："+physicalScore.getJump());
            tv5.setText("坐位体前屈(cm)："+physicalScore.getTouch());
            tv6.setText("1000米跑(s)："+physicalScore.getRun1000Time());
            tv7.setText("引体向上(次)："+physicalScore.getUpCount());
            tv8.setText("总分："+physicalScore.getTotalScore());
            return view;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical_score);

        listView = findViewById(R.id.score_lv);

        listView.setAdapter(adapter);
        returnBtn = this.findViewById(R.id.btn_return);
        returnImgBtn = this.findViewById(R.id.imgbtn_return);

        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        returnImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}