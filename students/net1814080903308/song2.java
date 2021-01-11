package edu.hzuapps.androidlabs.net1814080903308;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class song2 extends Fragment {
    private View zj;

    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        zj = inflater.inflate(R.layout.song2, null);
        ImageView listView = zj.findViewById(R.id.lv);
        return zj;

    }
}
