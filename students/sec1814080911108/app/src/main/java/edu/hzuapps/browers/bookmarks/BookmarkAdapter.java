package edu.hzuapps.browers.bookmarks;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import edu.hzuapps.browers.R;

/**
 * Created by lanying on 2020/11/17
 */
public class BookmarkAdapter extends ArrayAdapter {
    private final int resourceId;
    public BookmarkAdapter(Context context, int textViewResourceId, List<Bookmark> obj){
        super(context,textViewResourceId,obj);
        this.resourceId = textViewResourceId;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Bookmark bookmark = (Bookmark) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView bookmarkImage = (ImageView) view.findViewById(R.id.bookmark_icon);
        TextView bookmarkTitle = (TextView) view.findViewById(R.id.bookmark_title);
        bookmarkImage.setImageResource(bookmark.getImageId());
        bookmarkTitle.setText(bookmark.getTitle());
//        return super.getView(position, convertView, parent);
        return view;
    }
}
