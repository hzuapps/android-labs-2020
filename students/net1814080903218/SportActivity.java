package edu.hzuapps.androidlabs.net1814080903218;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.hzuapps.androidlabs.net1814080903218.dao.SportDao;
import edu.hzuapps.androidlabs.net1814080903218.database.AppDatabase;
import edu.hzuapps.androidlabs.net1814080903218.entity.Sport;

public class SportActivity extends AppCompatActivity {
    private AppDatabase db;
    private SportDao sportDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        final EditText sportText = (EditText)findViewById(R.id.sport);
        final SportActivity _this = this;
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "app").allowMainThreadQueries().build();
        sportDao = db.getSportDao();
        Button sub = findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sport = sportText.getText().toString();
                Sport sportData = new Sport(sport);
                sportDao.insert(sportData);
                Intent intent=new Intent(_this,Net1814080903218Activity.class);
                startActivity(intent);
            }
        });
    }
}