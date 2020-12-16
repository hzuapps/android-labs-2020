package edu.hzuapp.androidlabs.net1814080903225;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;


public class ClockFace extends View {
    private Paint paint;//画笔
    private int mainColor = Color.parseColor("#FF66FF");//画笔颜色
    private float mWidth;//视图宽高
    private float arcRa = 0;//圆半径
    private Double rr = 2 * Math.PI / 60;//2π即360度的圆形分成60份,一秒钟与一分钟
    private Rect textBound = new Rect();//字体被全部包裹的最小的矩形边框

    public ClockFace(Context context) {
        super(context);
        init();
    }

    public ClockFace(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClockFace(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        paint = new Paint();//初始化画笔
        paint.setColor(mainColor);//设置颜色
        paint.setStyle(Paint.Style.STROKE);//设置画笔
        paint.setTextSize(80);//设置字体大小
        paint.setAntiAlias(true); //设置画笔是否平滑
        paint.setStrokeWidth(8);  //设置画笔粗细
        paint.setTypeface(Typeface.create("楷体", Typeface.ITALIC));//字体样式

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;//获得宽度
        arcRa = (float) (mWidth / 2.5);//以最短的一边算出半径
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画圆,通过获取宽高算出最短一边作为直径，坐标原点默认在手机屏幕左上角
        canvas.drawCircle(arcRa + 110, arcRa + 330, arcRa, paint);

        int itime = 12;//长的刻度要显示的数字，这里从12点刻度开始顺时针绘制
        for (int i = 0; i < 60; i++) {///2π圆形分成60份,一秒钟与一分钟,所以要绘制60次,这里是从0到59
            float x1, y1, x2, y2;//刻度的两端的坐标即起始于结束的坐标
            float scale;//每个刻度离圆心的最近端坐标点到圆心的距离
            Double du = rr * i;//当前所占的角度
            Double sinx = Math.sin(du);//该角度的sin值
            Double cosy = Math.cos(du);//该角度的cos值
            x1 = (float) (arcRa + arcRa * sinx);//以默认坐标系通过三角函数算出刻度离圆心最远的端点的x轴坐标
            y1 = (float) (arcRa - arcRa * cosy);//以默认坐标系通过三角函数算出刻度离圆心最远的端点的y轴坐标
            if (i % 5 == 0) {//筛选刻度长度
                scale = 5 * arcRa / 6;//长刻度绘制,刻度离圆心的最近端坐标点到圆心的距离,这里取半径的六分之五的长度,可以通过情况来定

                //绘制长刻度上的数字1~12
                String number = itime + "";//当前数字变为String类型
                itime++;//数字加1
                if (itime > 12) {//如果大于数字12,重置为1
                    itime = 1;
                }
                float numScale = 4 * arcRa / 5;//数字离圆心的距离,这里取半径的五分之四的长度,可以通过情况来定
                float x3 = (float) (arcRa + numScale * sinx);//以默认坐标系通过三角函数算出x轴坐标
                float y3 = (float) (arcRa - numScale * cosy);//以默认坐标系通过三角函数算出x轴坐标
                paint.getTextBounds(number, 0, number.length(), textBound);//获取每个数字被全部包裹的最小的矩形边框数值

                //绘制数字,通过x3,y3根据文字最小包裹矩形边框数值进行绘制点调整
                canvas.drawText(number, x3 - textBound.width() / 2 + 110, y3 + textBound.height() / 2 + 330, paint);

            } else {
                scale = 9 * arcRa / 10;//短刻度绘制,这里取半径的十分之九的长度,可以通过情况来定
            }
            x2 = (float) (arcRa + scale * sinx);//以默认坐标系通过三角函数算出该刻度离圆心最近的端点的x轴坐标
            y2 = (float) (arcRa - scale * cosy);//以默认坐标系通过三角函数算出该刻度离圆心最近的端点的y轴坐标
            canvas.drawLine(x1 + 110, y1 + 330, x2 + 110, y2 + 330, paint);//通过两端点绘制刻度
        }

    }
}
