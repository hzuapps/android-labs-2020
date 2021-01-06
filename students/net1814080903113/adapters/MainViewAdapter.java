package edu.hzuapps.androidlabs.net1814080903113.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903113.R;
import edu.hzuapps.androidlabs.net1814080903113.beans.MainItemBean;


public class MainViewAdapter extends RecyclerView.Adapter<MainViewAdapter.InnerHolder> {

    private final List<MainItemBean> vData;
    private MainViewAdapter.OnItemClickListener mOnItemClickListener;

    public MainViewAdapter(List<MainItemBean> data){
        this.vData = data;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.item_main_viewlist1, null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewAdapter.InnerHolder holder, int position) {
        holder.setData(vData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (vData != null) {
            return vData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(MainViewAdapter.OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView maquanames;
        private final TextView maquatext;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            maquanames = (TextView) itemView.findViewById(R.id.aqua_names);
            maquatext = (TextView) itemView.findViewById(R.id.aquaname_text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onItemClick(mPosition);
                    }
                }
            });
        }

        public void setData(MainItemBean mainitemBean,int position) {

            this.mPosition = position;
            maquanames.setText(mainitemBean.vaquaname);
            maquatext.setText(mainitemBean.vaquatext);
        }
    }
}
