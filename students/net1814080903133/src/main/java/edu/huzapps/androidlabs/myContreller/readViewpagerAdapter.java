package edu.hzuapps.androidlabs.myContreller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.myView.readFragment;

public class readViewpagerAdapter extends FragmentStateAdapter {
    int oldPosition;
    static int  id = 0;

    public readViewpagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle args = new Bundle();
        args.putInt("id",position);
        readFragment newFragment = new readFragment();
        newFragment.setArguments(args);
        oldPosition = position;
        return newFragment;
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public void setOldPosition(int oldPosition) {
        this.oldPosition = oldPosition;
    }
}
