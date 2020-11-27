package edu.hzuapps.androidlabs.myContreller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.myView.Info;
import edu.hzuapps.androidlabs.myView.readFragment;

public class readViewpagerAdapter extends FragmentStateAdapter {

    Book book;
    Info info;

    public readViewpagerAdapter(@NonNull FragmentActivity fragmentActivity,Book book) {
        super(fragmentActivity);
        this.book=book;
        info = new Info(book.getChapter());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        创建Bundle
        Bundle args = new Bundle();
//        绑定book对象参数
        try {
            String a = book.getText(position);
            info.set(a,book.getInitState(),position);
        } catch (IOException e) {
            e.printStackTrace();
        }
        args.putSerializable("info",info);
//        创建新画面
        readFragment newFragment = new readFragment();
//        传递参数
        newFragment.setArguments(args);
        book.setNowChapter(position);
        return newFragment;
    }

    @Override
    public int getItemCount() {
        if (book.getInitState()){
            return book.getPagerNUm();
        }else {
            return book.getChaLength();
        }
    }
}
