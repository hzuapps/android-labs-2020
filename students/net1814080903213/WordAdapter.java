package com.example.facewords_java;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private final List<Word> mWordList;

    public WordAdapter(List<Word> wordList) {
        mWordList = wordList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_item, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Word word = mWordList.get(position);
        holder.wordImage.setImageResource(word.getImageId());
        holder.wordContent.setText(word.getContent());
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView wordImage;
        TextView wordContent;

        public ViewHolder(View view) {
            super(view);
            wordImage = view.findViewById(R.id.word_image);
            wordContent = view.findViewById(R.id.word_content);
        }
    }

}
