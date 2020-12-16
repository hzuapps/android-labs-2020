package edu.hzuapps.androidlabs.myContreller;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import edu.hzuapps.androidlabs.Net1814080903133Activity;
import edu.hzuapps.androidlabs.R;

public class MyListViewAdapter extends BaseAdapter{

    BookManager bookManager;
    Net1814080903133Activity that;

    public MyListViewAdapter( Net1814080903133Activity thisThat){
        that=thisThat;
        bookManager = BookManager.getBookManager();
    }

    @Override
    public int getCount() {
        return bookManager.getSize();
    }

    @Override
    public Object getItem(int position) {
        return bookManager.getItem(position);
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
            view = LayoutInflater.from(that).inflate(R.layout.library_item, null);
            viewHolder = new ViewHolder();
            viewHolder.bookImage = (ImageView) view.findViewById(R.id.bookImage);
            viewHolder.bookName = (TextView) view.findViewById(R.id.bookName);
            viewHolder.author = (TextView) view.findViewById(R.id.author);
            viewHolder.nowChapter = (TextView) view.findViewById(R.id.nowChapter);
            view.findViewById(R.id.libraryCard).setBackgroundResource(R.drawable.library_item_style);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        init(position,viewHolder);
        return view;
    }

    protected void init(int position, ViewHolder viewHolder){
        Book book = bookManager.getItem(position);
        viewHolder.bookImage.setImageResource(MyTools.getResId(book.imageURL,that));
        viewHolder.bookName.setText("书名："+book.bookName);
        viewHolder.author.setText("作者："+book.author);
        viewHolder.nowChapter.setText("阅读进度："+(book.nowChapter+1));
    }
}

class ViewHolder{
    ImageView bookImage;
    TextView bookName;
    TextView author;
    TextView nowChapter;
}

