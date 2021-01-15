package com.lzy.verticalslideview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.verticalslideview.R;
import com.lzy.widget.vertical.ObservableView;


public class Fragment_View extends Fragment implements ObservableView {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.fragment_view, null);
        return view;
    }

    @Override
    public boolean isTop() {
        return true;
    }

    @Override
    public boolean isBottom() {
        return true;
    }

    @Override
    public void goTop() {
    }
}


