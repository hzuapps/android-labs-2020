package edu.hzuapp.androidlabs.net1814080903230;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SetActivity extends AppCompatActivity {
    TextView displayRegion,displaySpeed;
    Button buttonRegion_L,buttonRegion_R;
    Button buttonSpeed_L,buttonSpeed_R;
    static int Rt=1;
    static int St=1;

    public void disR(int Rt){
        if(Rt==0)
            displayRegion.setText("窄");
        else if(Rt==1)
            displayRegion.setText("中");
        else
            displayRegion.setText("宽");
    }

    public void disS(int St){
        if(St==0)
            displaySpeed.setText("慢");
        else if(St==1)
            displaySpeed.setText("中");
        else
            displaySpeed.setText("快");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        displayRegion = findViewById(R.id.textView5);
        buttonRegion_L = findViewById(R.id.button4);
        buttonRegion_R = findViewById(R.id.button5);
        buttonRegion_L.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Rt>0){
                    Rt-=1;
                }
                disR(Rt);
            }
        });
        buttonRegion_R.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(Rt<2){
                    Rt+=1;
                }
                disR(Rt);
            }
        });

        displaySpeed = findViewById(R.id.textView);
        buttonSpeed_L = findViewById(R.id.button6);
        buttonSpeed_R = findViewById(R.id.button7);
        buttonSpeed_L.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(St>0){
                    St-=1;
                }
                disS(St);
            }
        });
        buttonSpeed_R.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(St<2){
                    St+=1;
                }
                disS(St);
            }
        });


        Button btn_back = (Button)findViewById(R.id.button3);
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }
}