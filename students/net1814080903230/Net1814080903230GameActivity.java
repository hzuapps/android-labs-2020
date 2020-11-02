package com.example.example2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

class Myview extends View {
    public Myview(Context context) {super(context);}

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //定义画笔
        Paint paint1 = new Paint();
        //设置颜色
        paint1.setColor(Color.GRAY);
        //设置画笔类型
        paint1.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        //设置颜色
        paint2.setColor(Color.RED);
        //设置画笔类型
        paint2.setStyle(Paint.Style.FILL);
        //使用画笔在画布上画矩形
        canvas.drawRect(10,1050,1070,1080, paint1);
        canvas.drawRect(600,1050,750,1080, paint2);
    }
}

public class Net1814080903230GameActivity extends AppCompatActivity {
    private ImageView imageView;
    int sum=0;
    TextView displayScore;
    Button buttonScore;
    int fen = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) findViewById(R.id.forever);
        constraintLayout.addView(new Myview(this));

        imageView = (ImageView) findViewById(R.id.imageView);
        TranslateAnimation translateAnimation = new TranslateAnimation(0,1050,1000,1000);
        translateAnimation.setDuration(3000);
        translateAnimation.setRepeatMode(TranslateAnimation.REVERSE);
        translateAnimation.setRepeatCount(TranslateAnimation.INFINITE);
        translateAnimation.setZAdjustment(1);
        imageView.startAnimation(translateAnimation);

        displayScore = findViewById(R.id.textView6);
        buttonScore = findViewById(R.id.button8);
        buttonScore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    if(fen<999) {
                        fen += 10;
                    }
                displayScore.setText(Integer.toString(fen));
            }
        });
    }
}