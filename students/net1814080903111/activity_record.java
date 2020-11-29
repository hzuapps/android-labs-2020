package edu.hzuapps.androidlabs.myapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class activity_record extends AppCompatActivity implements View.OnClickListener {
    //组件配置
    private Button calendar_last,calendar_next;
    private GridView calendar_gridview;
    //数据配置
    private List<String> dataList = new ArrayList<>();
    private String today;
    private TextView calendar_date;
    private int week,dates;
    private MyAdapter adapter;
    //数据库配置
    static final String db_name = "RecordDB";   //数据库名
    static final String tb_name = "RecordTB";   //数据表名
    SQLiteDatabase db;
    Cursor c;
    private Set recordset;      //放置一个月的签到记录
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        initView();
        //获取当前月份
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date(System.currentTimeMillis());
        today = simpleDateFormat.format(date);
        getData(today);
        checkrecord();
    }
    private void checkrecord(){     //查看数据库，将记录放到Set集合中
        String yearmonth = today.split("-")[0]+today.split("-")[1];
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE,null);  //有则访问 没则创建
        String createTable = "CREATE TABLE IF NOT EXISTS " +
                tb_name +
                "(yearmonth VARCHAR (6) not null," +
                " day VARCHAR (2) not null )" ;
        db.execSQL(createTable);
        c =db.rawQuery("select * from " + tb_name +" where yearmonth LIKE '"+yearmonth+"'",null);
        recordset = new HashSet();
        while(c.moveToNext()){
            //System.out.println(Integer.valueOf(c.getString(1)));
            recordset.add(Integer.valueOf(c.getString(1)));
        }
    }
    private void getData(String today) {
        calendar_date.setText(today);
        today = today + "-01";
        String years = today.split("-")[0];
        String months = today.split("-")[1];
        Log.i("日历", months);
        //获取当前月份日期数
        dates = getmoth(Integer.parseInt(years), Integer.parseInt(months));
        //获取当前月份1号是周几
        week = getweek(today);
        if (week == 1) {
            week = 7;//周日
        } else week = week - 1;
        //获取上一个月份的天数
        int lastdates;
        if (Integer.parseInt(months) == 1) {
            lastdates = getmoth(Integer.parseInt(years) - 1, 12);
        } else {
            lastdates = getmoth(Integer.parseInt(years), Integer.parseInt(months) - 1);
        }

        //获取当前展示的日历界面的数据
        int num = week+dates-1;//当下标从1开始，num为输入月份的最后一个值的下标
        int gridview_size;
        if (num > 35){
            gridview_size = 42;
        }else gridview_size = 35;

        int j = 1, a = 1; //当前月份的各个日期以及下一个月的日期
        int last = lastdates - (week - 2);//第一个单元格的值
        for (int i = 1; i <= gridview_size; i++) {
            if (i < week) {//上月剩余
                dataList.add(String.valueOf(last));
                last++;
            } else if (i <= num) {
                dataList.add(String.valueOf(j));//本月
                j++;
            } else {
                dataList.add(String.valueOf(a));//下月
                a++;
            }
        }
        //渲染数据
       if (adapter == null){
            adapter = new activity_record.MyAdapter(activity_record.this, dataList);
            calendar_gridview.setAdapter(adapter);
        }else adapter.notifyDataSetChanged();
    }
    private int getmoth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);
        int date = calendar.get(Calendar.DATE);
        return date;
    }
    private int getweek(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //1:周日，7：周六
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    private void initView() {       //设置组件
        calendar_last = (Button) findViewById(R.id.calendar_last);
        calendar_next = (Button) findViewById(R.id.calendar_next);
        calendar_gridview = (GridView) findViewById(R.id.calendar_gridview);

        calendar_last.setOnClickListener(this);
        calendar_next.setOnClickListener(this);
        calendar_date = (TextView) findViewById(R.id.calendar_date);
        calendar_date.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calendar_last:
                //上一个月按钮的点击事件
                dataList.clear();
                int years = Integer.parseInt(today.split("-")[0]);
                int months = Integer.parseInt(today.split("-")[1]);
                if (months == 1) {
                    months = 12;
                    years = years - 1;
                    getData(years + "-" + months);
                    today = years + "-" + months;
                } else {
                    months = months - 1;
                    getData(years + "-" + months);
                    today = years + "-" + months;
                }
                break;
            case R.id.calendar_next:
                //下一个月按钮的点击事件
                dataList.clear();
                int years1 = Integer.parseInt(today.split("-")[0]);
                int months1 = Integer.parseInt(today.split("-")[1]);
                if (months1 == 12) {
                    months1 = 1;
                    years1 = years1 + 1;
                    getData(years1 + "-" + months1);
                    today = years1 + "-" + months1;
                } else {
                    months1 = months1 + 1;
                    getData(years1 + "-" + months1);
                    today = years1 + "-" + months1;
                }
                break;
        }
    }
    /*@Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/
    public class MyAdapter extends BaseAdapter
    {
        private LayoutInflater mInflater;
        private Context mContext;
        private List<String> mDatas;

        public MyAdapter(Context context, List<String> mDatas)
        {
            mInflater = LayoutInflater.from(context);
            this.mContext = context;
            this.mDatas = mDatas;
        }

        @Override
        public int getCount()
        {
            return mDatas.size();
        }

        @Override
        public Object getItem(int position)
        {
            return mDatas.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            //checkrecord();
            ViewHolder viewHolder = null;
            if (convertView == null)
            {
                convertView = mInflater.inflate(R.layout.item_nosign, parent,
                        false);
                viewHolder = new ViewHolder();
                viewHolder.mTextView = (TextView) convertView.findViewById(R.id.id_tv_title);
                convertView.setTag(viewHolder);
            } else
            {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mTextView.setText(mDatas.get(position));
            if (position >= week-1 && position < week+dates-1){//判断是当月的日期
                    if (position >= week - 1 && position <= dates + week - 2 && recordset.contains(position + 2 - week))
                        viewHolder.mTextView.setTextColor(Color.RED);//已签到——红色
                    else
                    viewHolder.mTextView.setTextColor(Color.BLACK);//未签到——黑色
            }else {
                viewHolder.mTextView.setTextColor(Color.GRAY);//非本月日期——灰色
            }
            return convertView;
        }

        private final class ViewHolder
        {
            TextView mTextView;
        }

    }

}
