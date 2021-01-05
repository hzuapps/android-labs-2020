package edu.hzuapps.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListviewAdapter extends BaseAdapter {

    ArrayList<ArrayList<String>> studentList;
    Database db;

    MainActivity1 that;
    ListviewAdapter(MainActivity1 t,ArrayList<ArrayList<String>> st,Database DB){
        studentList = st;
        that=t;
        db=DB;
    }

    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int position) {
        return studentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        ViewHolder viewHolder;
        if(convertView==null) {
            view = LayoutInflater.from(that).inflate(R.layout.activity_main1_item, null);
            viewHolder = new ViewHolder();
            viewHolder.xuehao = (TextView) view.findViewById(R.id.xuehao);
            viewHolder.xingming = (TextView) view.findViewById(R.id.xingming);
            viewHolder.banji = (TextView) view.findViewById(R.id.banji);
            viewHolder.deleteBtn = (Button) view.findViewById(R.id.deleteBtn);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        init(position,viewHolder);
        return view;
    }

    protected void init(final int position, ViewHolder viewHolder){
        final ArrayList<String> temp =  studentList.get(position);
        viewHolder.xuehao.setText("学号："+temp.get(0));
        viewHolder.xingming.setText("姓名："+temp.get(1));
        viewHolder.banji.setText("班级："+temp.get(2));
        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentList.remove(position);
                notifyDataSetChanged();
                db.delete(temp.get(0));
            }
        });
    }
}

class ViewHolder{
    TextView xuehao;
    TextView xingming;
    TextView banji;
    Button deleteBtn;
}
