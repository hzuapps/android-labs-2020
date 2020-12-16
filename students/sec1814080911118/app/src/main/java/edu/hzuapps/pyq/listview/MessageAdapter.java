package edu.hzuapps.pyq.listview;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import edu.hzuapps.pyq.R;
import edu.hzuapps.pyq.listview.Message;

public class MessageAdapter extends ArrayAdapter<Message> {
    private int resourceId;

    // 适配器的构造函数，把要适配的数据传入这里
    public MessageAdapter(Context context, int textViewResourceId, List<Message> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    // convertView 参数用于将之前加载好的布局进行缓存
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Message message=getItem(position); //获取当前项的Fruit实例

        // 加个判断，以免ListView每次滚动时都要重新加载布局，以提高运行效率
        View view;
        ViewHolder viewHolder;
        if (convertView==null){

            // 避免ListView每次滚动时都要重新加载布局，以提高运行效率
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

            // 避免每次调用getView()时都要重新获取控件实例
            viewHolder=new ViewHolder();
            viewHolder.messageName=view.findViewById(R.id.message_content);
            viewHolder.messageImage=view.findViewById(R.id.message_image);

            // 将ViewHolder存储在View中（即将控件的实例存储在其中）
            view.setTag(viewHolder);
        } else{
            view=convertView;
            viewHolder=(ViewHolder) view.getTag();
        }

        // 获取控件实例，并调用set...方法使其显示出来
        viewHolder.messageImage.setImageResource(message.getImageId());
        viewHolder.messageName.setText(message.getName());
        return view;
    }

    // 定义一个内部类，用于对控件的实例进行缓存
    class ViewHolder{
        ImageView messageImage;
        TextView messageName;
    }
}
