package edu.hzuapps.androidlabs.net1814080903113.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.hzuapps.androidlabs.net1814080903113.R;
import models.item_main_viewlist_model;

public class MainViewListAdapter2 extends RecyclerView.Adapter<MainViewListAdapter2.ViewHolder> {

    Context context;
    ArrayList<item_main_viewlist_model> modelArrayList;

    public MainViewListAdapter2(Context context, ArrayList<item_main_viewlist_model> modelArrayList){
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_view_image2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.aquaimage.setImageResource(modelArrayList.get(position).getAquaimage());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView aquaimage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            aquaimage = itemView.findViewById(R.id.aquaimage);
        }
    }
}
