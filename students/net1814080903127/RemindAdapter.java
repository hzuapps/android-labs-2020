package edu.hzuapps.androidlabs.net1814080903127;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RemindAdapter extends NoteAdapter{

    public RemindAdapter(Context context, List<Note> noteList) {
        super(context, noteList);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            //每一项的layout
            convertView=layoutInflater.inflate(R.layout.list_remind,null);
            //包装list_item中的项
            helper=new Helper(convertView);
            convertView.setTag(helper);
        }
        else {
            helper= (Helper) convertView.getTag();
        }
        helper.title.setText(noteList.get(position).getTitle());
        helper.context.setText(noteList.get(position).getContext());
        helper.date.setText(noteList.get(position).getDate());
        return convertView;
    }
}
