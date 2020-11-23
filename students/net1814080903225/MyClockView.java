package edu.hzuapp.androidlabs.net1814080903225;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;
import java.util.Date;

public class MyClockView extends View {
    private Paint paint;//画笔
    private int mainColor = Color.parseColor("#FF66FF");//画笔颜色
    private float mWidth, mHeight;//视图宽高
    private float arcRa = 0;//圆半径
    private Double rr = 2 * Math.PI / 60;//2π即360度的圆形分成60份,一秒钟与一分钟
    private Double rr2 = 2 * Math.PI / 12;//2π圆形分成12份,圆形显示12个小时的刻度
    private PointF secondEndPoint, minuteEndPoint, hourEndPoint;//秒,分,时的坐标点
    private int startSecond, startMinute, startHour;//初始化时秒,分,时获取的系统时间
    private Rect textBound = new Rect();//字体被全部包裹的最小的矩形边框

    public MyClockView(Context context) {
        super(context);
        init();
    }

    public MyClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;//获得宽度
        mHeight = h;//获得高度
        arcRa = (float) (mWidth / 2.5);//以最短的一边算出半径
    }

    public void init() {
        paint = new Paint();//初始化画笔
        paint.setColor(mainColor);//设置颜色
        paint.setStyle(Paint.Style.STROKE);//设置画笔
        paint.setTextSize(80);//设置字体大小
        paint.setAntiAlias(true); //设置画笔是否平滑
        paint.setStrokeWidth(8);  //设置画笔粗细
        paint.setTypeface(Typeface.create("楷体", Typeface.ITALIC));//字体样式
        secondEndPoint = new PointF(arcRa+110, arcRa+330);//初始化坐标点
        hourEndPoint = new PointF(arcRa+110, 0); //初始化怎么发挥作用？
        minuteEndPoint = new PointF(arcRa+110, 0);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //①获取系统时间
        getCurrentTime();

        //②当前时间时分秒分别所占的份数(角度),即为上面rr,rr2所得到的每份的角度乘以获得的时间
        Double secondAngle = rr * startSecond;
        Double minuteAngle = rr * startMinute;
        Double hourAngle = rr2 * startHour;

        //③利用三角函数计算分别计算出,时分秒三针所在的坐标点,坐标原点默认在手机屏幕左上角
        float secondScale = 6 * arcRa / 7;//秒针长度
        float minuteScale = 4 * arcRa / 6;//分针长度
        float hourScale = arcRa / 2;//时针长度
        secondEndPoint.x = (float) (arcRa + secondScale * Math.sin(secondAngle));
        secondEndPoint.y = (float) (arcRa - secondScale * Math.cos(secondAngle));
        minuteEndPoint.x = (float) (arcRa + minuteScale * Math.sin(minuteAngle));
        minuteEndPoint.y = (float) (arcRa - minuteScale * Math.cos(minuteAngle));
        hourEndPoint.x = (float) (arcRa + hourScale * Math.sin(hourAngle));
        hourEndPoint.y = (float) (arcRa - hourScale * Math.cos(hourAngle));

        //⑥绘制时、分、秒针,坐标原点默认在手机屏幕左上角
        canvas.drawLine(arcRa+110, arcRa+330, secondEndPoint.x+110, secondEndPoint.y+330, paint);
        canvas.drawLine(arcRa+110, arcRa+330, minuteEndPoint.x+110, minuteEndPoint.y+330, paint);
        canvas.drawLine(arcRa+110, arcRa+330, hourEndPoint.x+110, hourEndPoint.y+330, paint);
        postInvalidateDelayed(1000);//每秒刷新一次
    }

    private void getCurrentTime() {
        long time = System.currentTimeMillis();//获取时间
        Calendar mCalendar = Calendar.getInstance();
        mCalendar.setTimeInMillis(time);
        startHour = mCalendar.get(Calendar.HOUR);//获取小时,12小时制
        startMinute = mCalendar.get(Calendar.MINUTE);//获取分钟
        startSecond = mCalendar.get(Calendar.SECOND);//获取秒

    }
}
