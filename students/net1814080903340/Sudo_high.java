package edu.hzuapps.net1814080903340activity;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.core.content.ContextCompat;

/**
 * Created by jobs on 2016/11/4.
 */

public class Sudo_high extends View {
    private String STR = "010008570607050009052170000"
            + "001003706070000040803700900" + "000017260100020407024300090";
    private Context mContext;
    private float width;
    private float height;
    // 用一个 三维数组 存放已经对应的 x y 已经有的数据
    private int usedArray[][][] = new int[9][9][];
    // 用 Button 数组将按键记录下来
    private Button bt[] = new Button[9];



    public Sudo_high(Context context) {
        super(context);
        mContext = context;
        getUsedArray();
    }


    // 计算对应的 x y 已有的数据
    public int[] computerXAndYUsed(int x, int y) {
        int used[] = new int[9];

        // 查找横轴 (X)
        for (int i = 0; i < 9; i++) {
            int point = getValue(i, y);
            if (point != 0) {
                used[point - 1] = point;
            }
        }

        // 查找纵轴 (Y)
        for (int i = 0; i < 9; i++) {
            int point = getValue(x, i);
            if (point != 0) {
                used[point - 1] = point;
            }
        }

        // 查找网格
        // 计算出 x y 在网格中的最初位置
        int xStart = (x / 3) * 3;
        int yStart = (y / 3) * 3;

        for (int i = xStart; i < xStart + 3; i++) {
            for (int j = yStart; j < yStart + 3; j++) {
                int point = getValue(i, j);
                if (point != 0) {
                    used[point -1] = point;
                }
            }
        }
        return used;
    }

    // 得到所有 x y 已有的数据
    public void getUsedArray() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                usedArray[i][j] = computerXAndYUsed(i, j);
            }
        }
    }

    // 进行修改
    public void setSTR(int x, int y, char c) {
        // 得到 x y 的长度
        int index = y * 9 + x;
        String reSTR = STR.substring(0, index);
        reSTR += c;
        reSTR += STR.substring(index + 1, STR.length());
        STR = reSTR;
    }

    // 进行重新绘图
    public void reDraw() {
        // 进行数据刷新
        getUsedArray();
        invalidate();
    }

    // 得到对应 x y 的值
    public int getValue(int x, int y) {
        return STR.charAt(y * 9 + x) - '0';
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        // 得到 九宫格 的高度和宽度
        width = w / 9f;
        height = h / 9f;
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();

        //消除锯齿一样的边缘
        paint.setAntiAlias(true);

        // 先画一个空心的矩形 作为外背景
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ContextCompat.getColor(mContext, R.color.top2));
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);

        // 再继续画9条横轴 纵轴
        for (int i = 0; i < 9; i++) {
            paint.setColor(ContextCompat.getColor(mContext, R.color.back));

            // 横轴
            canvas.drawLine(0, i * height, getWidth(), i * height, paint);
            // 纵轴
            canvas.drawLine(i * width, 0, i * width, getHeight(), paint);

            //进行条纹加深
            paint.setColor(ContextCompat.getColor(mContext, R.color.top1));

            // 横轴
            canvas.drawLine(0, i * height + 3, getWidth(), i * height + 3, paint);
            // 纵轴
            canvas.drawLine(i * width + 3, 0, i * width + 3, getHeight(), paint);

            //将目前的 九宫格 分为 3 块
            if (i % 3 == 0) {
                paint.setColor(ContextCompat.getColor(mContext, R.color.top2));
                // 横轴
                canvas.drawLine(0, i * height + 3, getWidth(), i * height + 3, paint);
                // 纵轴
                canvas.drawLine(i * width + 3, 0, i * width + 3, getHeight(), paint);
            }
        }

        //进行 写入 数字操作 9 * 9

        //Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize((float) (height * 0.75));
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float x = width / 2;
        float y = height / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2;



        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int point = getValue(j, i);
                if (point != 0) {
                    canvas.drawText(String.valueOf(point), j * width + x, i * height + y, paint);
                }
            }
        }
        super.onDraw(canvas);
    }

    public int[] getUsedToArray(int x, int y) {
        return usedArray[x][y];
    }

    // 重写 触摸 事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            final int x = (int) (event.getX() / width);
            final int y = (int) (event.getY() / height);
            if (getValue(x, y) == 0) {
                int used[] = getUsedToArray(x, y);

                // 出现对话框，提供用户可添选数据
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                final AlertDialog dialog = builder.create();
                View item = LayoutInflater.from(mContext).inflate(R.layout.activity_easy, null);
                findAllBt(item);

                // 将对应的 x y 上已经出现的数字进行屏蔽
                for (int i = 0; i < 9; i++) {
                    if (used[i] != 0) {
                        bt[i].setVisibility(View.INVISIBLE);
                    }
                }
                // 设置点击事件
                for (int i = 0; i < 9; i++) {
                    final char t = (char) (i + 1 + '0');
                    bt[i].setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            setSTR(x, y, t);
                            reDraw();
                            dialog.dismiss();
                        }
                    });
                }

                dialog.setView(item);
                dialog.setTitle("请选择数字");
                dialog.setCancelable(true);
                dialog.show();
            }
        }

        return super.onTouchEvent(event);
    }

    // 查找所有的 Button
    public void findAllBt(View view) {
        bt[0] = (Button) view.findViewById(R.id.bt1);
        bt[1] = (Button) view.findViewById(R.id.bt2);
        bt[2] = (Button) view.findViewById(R.id.bt3);
        bt[3] = (Button) view.findViewById(R.id.bt4);
        bt[4] = (Button) view.findViewById(R.id.bt5);
        bt[5] = (Button) view.findViewById(R.id.bt6);
        bt[6] = (Button) view.findViewById(R.id.bt7);
        bt[7] = (Button) view.findViewById(R.id.bt8);
        bt[8] = (Button) view.findViewById(R.id.bt9);
    }
}
