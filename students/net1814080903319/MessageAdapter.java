package edu.hzuapps.androidlabs.net1814080903319;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//适配器
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageInnerHolder> {
    private final List<Message> messageList;
    private final Context context;
    //private final Bitmap bitmap=getBitmap();

    public MessageAdapter(List<Message> MessageList, Context context) {
        this.context=context;
        this.messageList=MessageList;
    }

    @NonNull
    @Override
    public MessageInnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_inner,parent,false);
        MessageInnerHolder messageInnerHolder=new MessageInnerHolder(view);
        return messageInnerHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageInnerHolder holder, int position) {
        Message message=messageList.get(position);

        holder.singer.setText(message.getSinger());
        holder.singname.setText(message.getSingname());
        holder.fangshi.setText(message.getFangshi());

    }


    @Override
    public int getItemCount() {
        if (messageList.size()>0) {
            return messageList.size();
        }
        return 0;
    }

    public class MessageInnerHolder extends RecyclerView.ViewHolder {

        private final View view;
        private final TextView singname;
        private final TextView singer;
        private final TextView fangshi;


        public MessageInnerHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView.findViewById(R.id.fengexian);
            singer = itemView.findViewById(R.id.singer);
            singname = itemView.findViewById(R.id.singname);
            fangshi = itemView.findViewById(R.id.fangshi);

        }
    }
}
