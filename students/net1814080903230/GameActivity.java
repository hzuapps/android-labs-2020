package edu.hzuapp.androidlabs.net1814080903230;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import static edu.hzuapp.androidlabs.net1814080903230.Myview.setright;

class Myview extends View {
    public Myview(Context context) {super(context);}
    static int setright;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //定义画笔
        Paint paint1 = new Paint();
        //设置颜色
        paint1.setColor(Color.LTGRAY);
        //设置画笔类型
        paint1.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        //设置颜色
        paint2.setColor(Color.MAGENTA);
        //设置画笔类型
        paint2.setStyle(Paint.Style.FILL);
        //使用画笔在画布上画矩形
        canvas.drawRect(10,1050,1070,1080, paint1);//背景灰条
        //有效区域
        if(SetActivity.Rt==0) {
            setright = 700;
        }
        else if(SetActivity.Rt==1) {
            setright = 750;
        }
        else {
            setright = 800;
        }
        canvas.drawRect(600,1050,setright,1080, paint2);
    }
}

public class GameActivity extends AppCompatActivity {
    private ImageView imageView;
    int sum=0;
    TextView gamerecord,displayScore;
    Button buttonScore;
    int fen = 0;
    int movetime;

    public String read(){
        FileInputStream in=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder();
        try{
            in=openFileInput("ASRS");
            reader=new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=reader.readLine())!=null){
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }
    public void save(int fen){
        String data=Integer.toString(fen);
        FileOutputStream out=null;
        BufferedWriter writer=null;
        try{
            out=openFileOutput("ASRS",Context.MODE_PRIVATE);
            writer =new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (writer!=null){
                    writer.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final float[] aaa = {0};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gamerecord = (TextView) findViewById(R.id.textView7);
        gamerecord.setText("最高分："+read());

        //背景灰条显示
        androidx.constraintlayout.widget.ConstraintLayout constraintLayout = (androidx.constraintlayout.widget.ConstraintLayout) findViewById(R.id.forever);
        constraintLayout.addView(new Myview(this),1);

        if(SetActivity.St==0) {
            movetime = 2500;
        }
        else if(SetActivity.St==1) {
            movetime = 1800;
        }
        else {
            movetime = 1000;
        }

        ImageView myimage = (ImageView)findViewById(R.id.imageView);
        ObjectAnimator translateXAnimation= ObjectAnimator.ofFloat(myimage, "translationX", 0f, 1050f);
        ObjectAnimator translateYAnimation= ObjectAnimator.ofFloat(myimage, "translationY", 1000f, 1000f);
        translateXAnimation.setInterpolator(new LinearInterpolator());
        translateXAnimation.setRepeatMode(ValueAnimator.REVERSE);
        translateXAnimation.setRepeatCount(ValueAnimator.INFINITE);
        translateYAnimation.setRepeatCount(ValueAnimator.INFINITE);

        AnimatorSet set = new AnimatorSet();
        set.setDuration(movetime);
        set.playTogether(translateXAnimation, translateYAnimation);
        set.start();

        translateXAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float imageXPosition = (Float) animation.getAnimatedValue();
                aaa[0] =imageXPosition;
            }
        });

        //结束弹窗
        final AlertDialog dialog;//声明对象
        dialog = new AlertDialog.Builder(this).setTitle("游戏结束")//绑定当前界面窗口，设置标题
                .setMessage("当光标移动到有效区域时点击才能得分哦！")//设置提示信息
                .setIcon(R.mipmap.ic_launcher) //设置图标
                .setPositiveButton("退出",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if(read().equals("")) {
                            save(fen);
                        }
                        if(fen>Integer.parseInt(read())) {
                            save(fen);
                        }
                        finish();
                    }
                })//添加“确定”按钮
                .setNegativeButton("继续",null)//添加“取消”按钮
                .create();//创建对话框

        displayScore = findViewById(R.id.textView6);
        buttonScore = findViewById(R.id.button8);
        buttonScore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if((600 <= aaa[0]) && (aaa[0] <= setright)) {
                    fen += 10;
                }
                else {
                    dialog.show();//显示对话框
                    dialog.setCancelable(false);//点击对话框外区域（及返回键）无效
                }
                displayScore.setText(Integer.toString(fen));
            }
        });
    }
}