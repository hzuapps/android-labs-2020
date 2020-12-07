package edu.hzuapps.androidlabs.net1814080903222.ui.browser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class BrowserViewModel extends ViewModel {
    private final MutableLiveData<ArrayList<BrowseItem>> mList;

    public BrowserViewModel() {
        mList = new MutableLiveData<>(
                new ArrayList<>(Arrays.asList(
                        new BrowseItem("Android", true),
                        new BrowseItem("Download", true),
                        new BrowseItem("test.jpg", false)
                ))
        );
    }

    public LiveData<ArrayList<BrowseItem>> getList() {
        return mList;
    }
}