package edu.hzuapps.androidlabs.net1814080903113.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903113.R;
import edu.hzuapps.androidlabs.net1814080903113.beans.ItemBean;

public class ListViewAdapter extends RecyclerView.Adapter<ListViewAdapter.InnerHolder> {

    private final List<ItemBean> mData;
    private OnItemClickListener mOnItemClickListener;

    public ListViewAdapter(List<ItemBean> data){
        this.mData = data;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.item_viewlist, null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.setData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    public class InnerHolder extends RecyclerView.ViewHolder {

        private final ImageView mIcon;
        private final TextView mTitle;
        private final TextView mcontent;
        private final TextView mtime;
        private final TextView mviews;
        private final TextView mwhatdo;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            mIcon = (ImageView) itemView.findViewById(R.id.image_view_list);
            mTitle = (TextView) itemView.findViewById(R.id.text_item_title);
            mcontent = (TextView) itemView.findViewById(R.id.text_item_content);
            mtime = (TextView) itemView.findViewById(R.id.text_item_time);
            mviews = (TextView) itemView.findViewById(R.id.text_item_views);
            mwhatdo = (TextView) itemView.findViewById(R.id.text_item_whatdo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(mPosition);
                    }
                }
            });
        }

        public void setData(ItemBean itemBean,int position) {

            this.mPosition = position;
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);
            mcontent.setText(itemBean.content);
            mtime.setText(itemBean.times);
            mviews.setText(itemBean.views);
            mwhatdo.setText(itemBean.whatdo);
        }
    }
}
