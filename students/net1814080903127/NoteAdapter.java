package edu.hzuapps.androidlabs.net1814080903127;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NoteAdapter extends BaseAdapter {
    private Context context;
    private List<Note> noteList;
    private LayoutInflater layoutInflater;
    private Helper helper;

    public NoteAdapter(Context context,List<Note> noteList){
        this.context=context;
        this.noteList=noteList;
        layoutInflater=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            //每一项的layout
            convertView=layoutInflater.inflate(R.layout.list,null);
            //包装list_item中的项
            helper=new Helper(convertView);
            convertView.setTag(helper);
        }
        else {
            helper= (Helper) convertView.getTag();
        }
        //textBeanList.get(i) 数据库返回的每一项
        helper.title.setText(noteList.get(position).getTitle());
        helper.context.setText(noteList.get(position).getContext());
        helper.date.setText(noteList.get(position).getDate());
        //测试
        if(convertView==null)
        {
            Log.e(null,"适配器返回视图失败");
        }
        if(convertView!=null)
        {
            Log.e(null,"适配器返回视图成功");
        }
        return convertView;
    }
}


class Helper{
    public TextView title;
    public TextView context;
    public TextView date;
    View item;
    public Helper(View view){
        if(view==null){
            throw new IllegalArgumentException("不能为空");
        }
        this.item=view;
        title=view.findViewById(R.id.Text_Title);
        context=view.findViewById(R.id.Context);
        date=view.findViewById(R.id.Date);
    }
}