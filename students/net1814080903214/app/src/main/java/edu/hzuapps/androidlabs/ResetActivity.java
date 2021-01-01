import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HistoryScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_score);

        Button returnToGame = (Button)findViewById(R.id.returnToGame);
        returnToGame.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent();
                                                intent.setClass(HistoryScoreActivity.this, GameActivity.class);
                                                startActivity(intent);
                                            }
                                        }
        );

        Button returnToMain = (Button)findViewById(R.id.returnToMain);
        returnToMain.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Intent intent = new Intent();
                                                intent.setClass(HistoryScoreActivity.this, Net1814080903106Activity.class);
                                                startActivity(intent);
                                            }
                                        }
        );

    }

}