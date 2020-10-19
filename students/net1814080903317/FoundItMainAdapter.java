package com.example.foundit.controller.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foundit.R;
import com.example.foundit.model.bean.FoundIt;
import com.example.foundit.utils.ToastUtils;

import java.util.List;

/**
 * author: djx
 * created on: 2020/10/19 15:48
 * description:
 */
public class FoundItMainAdapter extends RecyclerView.Adapter<FoundItMainAdapter.FoundItMainInnerHolder> {
    private final List<FoundIt> foundItList;
    private final Context context;
    //private final Bitmap bitmap=getBitmap();

    public FoundItMainAdapter(List<FoundIt> foundItList, Context context) {
        this.context=context;
        this.foundItList=foundItList;
    }

    @NonNull
    @Override
    public FoundItMainInnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item__main_foundit_content,parent,false);
        FoundItMainInnerHolder foundItMainInnerHolder=new FoundItMainInnerHolder(view);
        return foundItMainInnerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoundItMainInnerHolder holder, int position) {
        FoundIt foundIt=foundItList.get(position);
        Drawable drawable=context.getResources().getDrawable(R.drawable.headphoto);
        //设置头像
        holder.headPhotoIv.setImageDrawable(drawable);
        //设置昵称
        holder.nicknameTv.setText(foundIt.getNickname());
        //设置状态
        holder.typeTv.setText(foundIt.getType());
        //设置内容
        holder.contentTv.setText(foundIt.getContent());
        //设置时间
        holder.publicTimeTv.setText(foundIt.getPublicTime());

        //联系TA点击事件......
        holder.connenctionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.makeText(context,"你点击了联系TA");
            }
        });
        //评论的点击事件
        holder.commentIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.makeText(context,"你点击了评论");

            }
        });

    }

    /**
     * 获取Bitmap对象
     * @return
     */
    public  Bitmap getBitmap(){
        Drawable drawable=context.getResources().getDrawable(R.mipmap.headphoto);
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable;
        return bitmapDrawable.getBitmap();
    }
    @Override
    public int getItemCount() {
        if (foundItList.size()>0) {
            return foundItList.size();
        }
        return 0;
    }

    public class FoundItMainInnerHolder extends RecyclerView.ViewHolder {

        private final ImageView headPhotoIv;
        private final TextView nicknameTv;
        private final TextView typeTv;
        private final TextView connenctionTv;
        private final TextView contentTv;
        private final RecyclerView picRecyclerView;
        private final TextView publicTimeTv;
        private final ImageView commentIv;

        public FoundItMainInnerHolder(@NonNull View itemView) {
            super(itemView);
            headPhotoIv = itemView.findViewById(R.id.item_foundit_headphoto_iv);
            nicknameTv = itemView.findViewById(R.id.item_foundit_nickname_tv);
            typeTv = itemView.findViewById(R.id.item_foundit_type_tv);
            connenctionTv = itemView.findViewById(R.id.item_foundit_connectionta_tv);
            contentTv = itemView.findViewById(R.id.item_foundit_content_tv);
            picRecyclerView = itemView.findViewById(R.id.item_foundit_picrecyclerview);
            publicTimeTv = itemView.findViewById(R.id.item_foundit_publictime_tv);
            commentIv = itemView.findViewById(R.id.item_foundit_comment_iv);
        }
    }
}
