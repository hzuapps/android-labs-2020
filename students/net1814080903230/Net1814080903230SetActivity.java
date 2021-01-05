package com.example.example2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Net1814080903230SetActivity extends AppCompatActivity {
    TextView displayRegion,displaySpeed;
    Button buttonRegion_L,buttonRegion_R;
    Button buttonSpeed_L,buttonSpeed_R;
    int Rt=1,St=1;

 /*   public void iv_1(View view){
        displayRegion=(TextView)findViewById(R.id.textView5);
        int num1 = Integer.parseInt(displayRegion.getText().toString());
        if(num1>1){
            num1-=1;
        }

        displayRegion.setText(Integer.toString(num1));

    }
    public void iv_2(View view){
        displayRegion=(TextView)findViewById(R.id.textView5);
        int num1 = Integer.parseInt(displayRegion.getText().toString());
        if(num1<999){
            num1+=1;
        }

        displayRegion.setText(Integer.toString(num1));

    }*/
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

        /*buttonRegion_L.setOnClickListener(new View.OnClickListener(){


        int Rtarget=1;
        public void iv_1(View view){
            displayRegion=(TextView)findViewById(R.id.textView5);
            Rtarget=Integer.parseInt(displayRegion.getText().toString());
            if(Rtarget>0){
                Rtarget-=1;
            }

            displayRegion.setText(Integer.toString(Rtarget));

        }
        public void iv_2(View view){
            displayRegion=(TextView)findViewById(R.id.textView5);
            Rtarget=Integer.parseInt(displayRegion.getText().toString());
            if(Rtarget<2){
                Rtarget+=1;
            }

            displayRegion.setText(Integer.toString(Rtarget));

        }
    });*/


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
        final Net1814080903230SetActivity thisActivity = this;
        btn_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(thisActivity,Net1814080903230MainActivity.class);
                thisActivity.startActivity(intent);
            }
        });
    }
}