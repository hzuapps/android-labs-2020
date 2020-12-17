package edu.hzuapps.androidlabs.sec1814080911243;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InforAdapter extends BaseAdapter {
    private List<Pet_circleActivity.UserInfo> mUserInfos = new ArrayList<>();

    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public InforAdapter(Context context, List<Pet_circleActivity.UserInfo> userInfos) {
        mContext = context;
        mUserInfos = userInfos;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mUserInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //返回一个视图
        convertView = mLayoutInflater.inflate(R.layout.reminders_activity, null);//解析为一个视图
        TextView nameTextView = convertView.findViewById(R.id.name_text_view);

        ImageView imageView = convertView.findViewById(R.id.avatar_image_view);
        //和数据之间进行绑定
        nameTextView.setText(mUserInfos.get(position).getUserName());

        imageView.setImageResource(R.drawable.quanyi);
        return convertView;
    }

    public void refresData(List<Pet_circleActivity.UserInfo> userInfos) {
        mUserInfos = userInfos;
        notifyDataSetChanged();//刷新数据
    }
}