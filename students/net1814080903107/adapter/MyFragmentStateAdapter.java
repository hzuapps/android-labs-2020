package com.example.thefirst.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.thefirst.component.FoodFragment;

import java.util.ArrayList;
import java.util.List;

public class MyFragmentStateAdapter extends FragmentStateAdapter {
    List<FoodFragment> list=new ArrayList<>();

    public MyFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public MyFragmentStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public MyFragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public FoodFragment createFragment(int position) {
        return list.get(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void addFragment(FoodFragment fragment){
        list.add(fragment);
    }
}
