import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button toHistoryScore = (Button)findViewById(R.id.toHistoryScore);
        toHistoryScore.setOnClickListener(new View.OnClickListener() {
                                              @Override
                                              public void onClick(View v) {
                                                  Intent intent = new Intent();
                                                  intent.setClass(GameActivity.this, HistoryScoreActivity.class);
                                                  startActivity(intent);
                                              }
                                          }
        );


    }
}