package edu.hzuapps.androidlabs.net1814080903113.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import edu.hzuapps.androidlabs.net1814080903113.R;
import edu.hzuapps.androidlabs.net1814080903113.beans.MainItemBean;


public class MainViewAdapter2 extends RecyclerView.Adapter<MainViewAdapter2.InnerHolder> {

    private final List<MainItemBean> aData;
    private MainViewAdapter2.OnItemClickListener mmOnItemClickListener;

    public MainViewAdapter2(List<MainItemBean> data){
        this.aData = data;
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(parent.getContext(), R.layout.item_main_viewlist1_1, null);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewAdapter2.InnerHolder holderr, int position) {
        holderr.setData(aData.get(position),position);
    }

    @Override
    public int getItemCount() {
        if (aData != null) {
            return aData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(MainViewAdapter2.OnItemClickListener listener) {
        this.mmOnItemClickListener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView maquanum;
        private final TextView maquaachi;
        private int mPosition;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            maquanum = (TextView) itemView.findViewById(R.id.aqua_num);
            maquaachi = (TextView) itemView.findViewById(R.id.aqua_achievement);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mmOnItemClickListener != null){
                        mmOnItemClickListener.onItemClick(mPosition);
                    }
                }
            });
        }

        public void setData(MainItemBean mainitembean,int position) {

            this.mPosition = position;
            maquanum.setText(mainitembean.vaquanum);
            maquaachi.setText(mainitembean.vaquaachi);
        }
    }
}
