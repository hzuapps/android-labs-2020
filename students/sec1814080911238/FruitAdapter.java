package edu.hzuapps.androidlabs.sec1814080911238;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View fruitView;
        TextView fruitImage;
        TextView fruitName;
        Button deleteBtn;

        public ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = view.findViewById(R.id.textView1);
            fruitName = view.findViewById(R.id.textView2);
            deleteBtn = view.findViewById(R.id.button);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取SharePreferences(参数1：文件名，参数2：模式)
//                SharedPreferences sp = getSharedPreferences ("localData",MODE_PRIVATE);
                //获取Editor对象
//                SharedPreferences.Editor editor = sp.edit ();
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);     

                Toast.makeText(view.getContext(), fruit.getName(), Toast.LENGTH_SHORT).show();

            }
        });
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setText(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

}
