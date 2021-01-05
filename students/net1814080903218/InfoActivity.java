package edu.hzuapps.androidlabs.net1814080903218;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903218.dao.ReasonDao;
import edu.hzuapps.androidlabs.net1814080903218.dao.SportDao;
import edu.hzuapps.androidlabs.net1814080903218.database.AppDatabase;
import edu.hzuapps.androidlabs.net1814080903218.entity.Reason;
import edu.hzuapps.androidlabs.net1814080903218.entity.Sport;

public class InfoActivity extends AppCompatActivity {

    private AppDatabase db;
    private ReasonDao reasonDao;
    private SportDao sportDao;
    private Button clearSport;
    private Button clearReason;
    private TextView sportText;
    private TextView reasonText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //获取组件
        clearSport = findViewById(R.id.clearSport);
        clearReason = findViewById(R.id.clearReason);
        sportText = findViewById(R.id.sportText);
        reasonText = findViewById(R.id.reasonText);

        //获取数据库数据
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app").allowMainThreadQueries().build();
        reasonDao = db.getReasonDao();
        sportDao = db.getSportDao();

        updateView();

        //按钮事件
        clearSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportDao.deleteAll();
                updateView();
            }
        });
        clearReason.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reasonDao.deleteAll();
                updateView();
            }
        });
    }

    //刷新界面
    private void updateView(){
        List<Reason> reasons = this.reasonDao.getAll();
        List<Sport> sports = this.sportDao.getAll();
        StringBuilder sportsb = new StringBuilder();
        for (int i = 0;i < sports.size();i++){
            Sport sport = sports.get(i);
            sportsb.append(sport.getTime()).append(":").append(sport.getSport()).append("\n");
        }
        if ("".equals(sportsb.toString())){
            sportText.setText("无");
        }else{
            sportText.setText(sportsb);
        }
        StringBuilder reasonsb = new StringBuilder();
        for (int i = 0;i < reasons.size();i++){
            Reason reason = reasons.get(i);
            reasonsb.append(reason.getTime()).append(":").append(reason.getReason()).append("\n");
        }
        if ("".equals(reasonsb.toString())){
            reasonText.setText("无");
        }else{
            reasonText.setText(reasonsb);
        }
    }

}