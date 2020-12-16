package edu.hzuapps.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    TextView[][] lattices = new TextView[8][8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initBoard();
    }

    private void initBoard(){
       LinearLayout board = (LinearLayout)findViewById(R.id.board);
        for(int i=0;i<8;i++){
           LinearLayout row = new LinearLayout(this);
           row.setOrientation(LinearLayout.HORIZONTAL);
            row.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,0,1));
           for(int j=0;j<8;j++){
               lattices[i][j] = new TextView(this);
               lattices[i][j].setText(String.valueOf(i+":"+j));
               lattices[i][j].setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT,1));
               lattices[i][j].setBackgroundResource(R.drawable.sharp);
               row.addView(lattices[i][j]);
           }
           board.addView(row);
       }
    }
}