package edu.hzuapps.androidlabs.net1814080903218;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.net1814080903218.dao.ReasonDao;
import edu.hzuapps.androidlabs.net1814080903218.dao.SportDao;
import edu.hzuapps.androidlabs.net1814080903218.database.AppDatabase;
import edu.hzuapps.androidlabs.net1814080903218.entity.Reason;
import edu.hzuapps.androidlabs.net1814080903218.entity.Sport;

public class ReasonActivity extends AppCompatActivity {
    private AppDatabase db;
    private ReasonDao reasonDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reason);
        final ReasonActivity _this = this;
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app").allowMainThreadQueries().build();
        reasonDao = db.getReasonDao();
        final EditText timeText = (EditText)findViewById(R.id.time);
        final EditText reasonText = (EditText)findViewById(R.id.reason);
        Button sub = findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = timeText.getText().toString();
                String reason = reasonText.getText().toString();
                Reason reasonData = new Reason(time,reason);
                reasonDao.insert(reasonData);
                Intent intent=new Intent(_this,Net1814080903218Activity.class);
                startActivity(intent);
            }
        });
    }
}